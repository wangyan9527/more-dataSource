package sal.excel.impl;

import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import dal.db1.entity.Excel;
import dal.db1.entity.ExcelFeed;
import dal.db1.entity.ExcelOrder;
import dal.db1.entity.ExcelOrderTeacher;
import dal.db1.entity.ExcelTemp;
import dal.db1.entity.Teacher;
import dal.db1.entity.TeacherScoreRatio;
import dal.db1.mapper.ExcelFeedMapper;
import dal.db1.mapper.ExcelMapper;
import dal.db1.mapper.ExcelOrderMapper;
import dal.db1.mapper.ExcelOrderTeacherMapper;
import dal.db1.mapper.LocalFeedbackMapper;
import dal.db1.mapper.TeacherMapper;
import dal.db1.mapper.TeacherScoreRatioMapper;
import dal.db2.entity.ClassFeedBackDto;
import dal.db2.entity.ClassStageSubjectTeacherDto;
import dal.db2.entity.ClassTeacherFeedbackDto;
import dal.db2.entity.CsstCount;
import dal.db2.entity.CsstDto;
import dal.db2.entity.CsstQuitOrderDto;
import dal.db2.entity.OrderNoDto;
import dal.db2.entity.OrderTeacherDto;
import dal.db2.mapper.CsstMapper;
import dal.db2.mapper.feedback.FeedbackMapper;
import dal.db3.entity.OrderCost;
import dal.db3.mapper.OrderCostMapper;
import entity.feedback.FeedBackClass;
import entity.feedback.Feedback;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import sal.excel.ExcelService;
import sal.excel.dto.TeacherDto;
import sal.feedback.FeedbackService;
import sal.feedback.dto.DoubleTeacherSnapshotDto;
import sal.feedback.dto.FormFeedbackData;
import sal.feedback.dto.SnapShotDto;
import sal.feedback.dto.TeacherLessonTable;
import sal.feedback.dto.WriteInterview;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    LocalFeedbackMapper localFeedbackMapper;

    @Autowired
    FeedbackMapper feedbackMapper;

    @Autowired
    ExcelMapper excelMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    CsstMapper csstMapper;

    @Autowired
    OrderCostMapper orderCostMapper;

    @Autowired
    ExcelFeedMapper excelFeedMapper;

    @Autowired
    private ExcelOrderMapper excelOrderMapper;

    @Autowired
    private ExcelOrderTeacherMapper excelOrderTeacherMapper;

    @Autowired
    private TeacherScoreRatioMapper scoreRatioMapper;

    public static Map<String, List<Long>> stageMap;

    public static Map<String, List<Long>> subjectMap;

    public static Map<String, List<String>> teacherMap;

    public static Map<String, String> teacherNameMap;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void doAndInsertFeedback(Long startFeedbackId, Long endFeedbackId) {
        Long endId = 0l;
        while (startFeedbackId < endFeedbackId) {
            if (endFeedbackId - startFeedbackId <= 100) {
                endId = endFeedbackId;
            } else {
                endId = startFeedbackId + 100;
            }
            List<Feedback> feedbackList = feedbackService.queryListBetweenId(startFeedbackId, endId);
            List<Feedback> needInsertList = Lists.newArrayList();
            for (Feedback feedback : feedbackList) {
                String snapshot = feedback.getSnapshot();
                if (StringUtils.isNotBlank(snapshot)) {
                    SnapShotDto snapShotDto = JSON.parseObject(snapshot, SnapShotDto.class);
                    List<WriteInterview> writeInterviewList = snapShotDto.getWriteInterviewList();
                    if (writeInterviewList != null) {
                        for (WriteInterview w : writeInterviewList) {
                            if (StringUtils.isNotBlank(w.getQuitNum()) && Long.parseLong(w.getQuitNum()) > 0l) {
                                needInsertList.add(feedback);
                                break;
                            }
                        }
                    }
                }
            }
            if (!CollectionUtils.isEmpty(needInsertList)) {
                log.info("insert Batch feedbackList with count={}", needInsertList.size());
                localFeedbackMapper.insertBatch(needInsertList);
            }
            startFeedbackId = endId + 1;
        }
    }

    @Override
    public void doAndInsertExcel(Long startId, Long endId) {
        stageMap = excelMapper.queryStageList().stream().collect(Collectors.groupingBy(p -> p.getName(), Collectors
                .mapping(p -> p.getId(), Collectors.toList())));
        subjectMap = excelMapper.querySubjectList().stream().collect(Collectors.groupingBy(p -> p.getName(),
                Collectors.mapping(p -> p.getId(), Collectors.toList())));
        Long endIdIndex = 0l;
        while (startId <= endId) {
            if (endId - startId <= 100) {
                endIdIndex = endId;
            } else {
                endIdIndex = startId + 100;
            }
            try {
                saveExcel(startId, endIdIndex);
            } catch(Exception e) {
                log.info("error with startId={}, endId={}", startId, endIdIndex, e);
            }

            startId = endIdIndex + 1;
        }

    }

    @Override
    public void checkTeacher() {

    }

    @Override
    public void checkStageId() {
        List<Excel> excelList = excelMapper.queryStageId0();
        Set<Long> feedbackIds = excelList.stream().map(p -> p.getFeedBackId()).collect(Collectors.toSet());
        List<Feedback> feedBackList = localFeedbackMapper.queryListByIds(feedbackIds);
        Map<Long, Feedback> feedbackMap = feedBackList.stream().collect(Collectors.toMap(p -> p.getId(), Function.identity()));
        List<ClassFeedBackDto> classFeedBackDtoList = feedbackMapper.queryClassFeedbackListById(feedbackIds);
        Map<Long, List<ClassFeedBackDto>> classFeedDtoMap = classFeedBackDtoList.stream().collect(Collectors
                .groupingBy(p -> p.getFeedbackId()));
        for (Excel excel : excelList) {
            Long feedbackId = excel.getFeedBackId();
            Feedback feedback = feedbackMap.get(feedbackId);
            String snapshot = feedback.getSnapshot();
            if (StringUtils.isNotBlank(snapshot)) {
                SnapShotDto snapShotDto = JSON.parseObject(snapshot, SnapShotDto.class);
                List<WriteInterview> writeInterviewList = snapShotDto.getWriteInterviewList();
                if (writeInterviewList != null) {
                    for (WriteInterview w : writeInterviewList) {
                        if (StringUtils.isNotBlank(w.getQuitNum()) && Long.parseLong(w.getQuitNum()) > 0l) {
                            String stageName = "";
                            Integer batchNum = 0;
                            for (int i = 0; i < w.getStageName().length(); i++) {
                                if (w.getStageName().charAt(i) >= 48 && w.getStageName().charAt(i) <= 57) {
                                    if (i == w.getStageName().length() - 1) {
                                        batchNum = Integer.valueOf(w.getStageName().charAt(i));
                                    } else {
                                        batchNum = Integer.valueOf(w.getStageName().substring(i));
                                    }
                                } else {
                                    stageName += w.getStageName().charAt(i);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void doAndInsertFeedback1(Long startId, Long endId) {
        stageMap = excelMapper.queryStageList().stream().collect(Collectors.groupingBy(p -> p.getName(), Collectors
                .mapping(p -> p.getId(), Collectors.toList())));
        subjectMap = excelMapper.querySubjectList().stream().collect(Collectors.groupingBy(p -> p.getName(),
                Collectors.mapping(p -> p.getId(), Collectors.toList())));
        teacherMap = teacherMapper.getAll().stream().collect(Collectors.groupingBy(p -> p.getChineseName(), Collectors.mapping(p -> p.getStaffNo(), Collectors.toList())));

        Long endIdIndex = 0l;
        while (startId <= endId) {
            if (endId - startId <= 100) {
                endIdIndex = endId;
            } else {
                endIdIndex = startId + 100;
            }
            try {
                doSomeFeedback(startId, endIdIndex, stageMap, subjectMap, teacherMap);
            } catch(Exception e) {
                log.error("startId={}, endId={}", startId, endIdIndex, e);
            }
            startId = endIdIndex + 1;
        }


    }

    @Override
    public void doAndGetTeacherNo(Long startId, Long endId) {
        teacherNameMap = teacherMapper.getAll().stream().collect(Collectors.toMap(p -> p.getStaffNo(), p -> p.getChineseName()));
        Long endIdIndex = 0l;
        while (startId <= endId) {
            if (endId - startId <= 50) {
                endIdIndex = endId;
            } else {
                endIdIndex = startId + 50;
            }
            getAndSaveTeacherNoName(startId, endIdIndex, teacherNameMap);
            startId = endIdIndex + 1;
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void getAndSaveTeacherNoName(Long startId, Long endId, Map<String, String> teacherNoMap) {
        Set<String> scoreSet = Sets.newHashSet("录入", "通过", "已通过", "已录用");
        List<ExcelOrder> excelOrderList = excelOrderMapper.queryList(startId, endId);
        log.info("startId={}, endId={}, count={}", startId, endId, excelOrderList.size());
        if (CollectionUtils.isEmpty(excelOrderList)) {
            return;
        }
        Set<String> orderNos = excelOrderList.stream().map(p -> p.getOrderNo() + "_" + p.getOrderGoodsId()).collect(Collectors.toSet());
        List<OrderTeacherDto> list = csstMapper.queryOrderTeacherList(orderNos);
        Map<String, Set<String>> orderTeacherMap = list.stream().collect(Collectors.groupingBy(p -> p.getOrderNo(), Collectors.mapping(p -> p.getTeacherNo(), Collectors.toSet())));
        List<ExcelOrderTeacher> insertIntoList = Lists.newArrayList();
        for (ExcelOrder eo : excelOrderList) {
            String oldOrderNo = eo.getOrderNo();
            Long orderGoodsId = eo.getOrderGoodsId();
            String orderNo = oldOrderNo + "_" + orderGoodsId;
            Set<String> teacherNos = orderTeacherMap.getOrDefault(orderNo, Sets.newHashSet());
            if (CollectionUtils.isEmpty(teacherNos)) {
                ExcelOrderTeacher excelOrderTeacher = new ExcelOrderTeacher();
                BeanUtils.copyProperties(eo, excelOrderTeacher);
                if (scoreSet.contains(eo.getScore())) {
                    excelOrderTeacher.setOrderTag((byte) 1);
                } else {
                    excelOrderTeacher.setOrderTag((byte) 2);
                }
                excelOrderTeacher.setTeacherNo("");
                excelOrderTeacher.setTeacherName("");
                insertIntoList.add(excelOrderTeacher);

            } else if (teacherNos.size() > 0) {
                for (String teacherNo : teacherNos) {
                    String teacherName = teacherNoMap.getOrDefault(teacherNo, "");
                    ExcelOrderTeacher excelOrderTeacher = new ExcelOrderTeacher();
                    BeanUtils.copyProperties(eo, excelOrderTeacher);
                    if (scoreSet.contains(eo.getScore())) {
                        excelOrderTeacher.setOrderTag((byte) 1);
                    } else {
                        excelOrderTeacher.setOrderTag((byte) 2);
                    }
                    excelOrderTeacher.setTeacherNo(teacherNo);
                    excelOrderTeacher.setTeacherName(teacherName);
                    insertIntoList.add(excelOrderTeacher);
                }
            }

        }

        if (!CollectionUtils.isEmpty(insertIntoList)) {
            excelOrderTeacherMapper.insertBatch(insertIntoList);
            log.info("insert with startId={}, endId={}, count={}", startId, endId, insertIntoList.size());
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void buildTeacherScoreRatio(Long startId, Long endId) {
        log.info("start build teacher score ratio with startId={}, endId={}", startId, endId);
        Map<Long, String> stageNameMap = excelMapper.queryStageList().stream().collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));
        Map<Long, String> subjectNameMap = excelMapper.querySubjectList().stream().collect(Collectors.toMap(p -> p.getId(), p -> p.getName()));
        Map<String, String> teacherMap = teacherMapper.getAll().stream().collect(Collectors.toMap(p -> p.getStaffNo(), p -> p.getChineseName()));

        Long endIdIndex = 0l;
        while (startId <= endId) {
            if (endId - startId <= 100) {
                endIdIndex = endId;
            } else {
                endIdIndex = startId + 100;
            }
            buildTeacherScoreRatio(startId, endIdIndex, stageNameMap, subjectNameMap, teacherMap);
            startId = endIdIndex + 1;
        }
    }

    private void buildTeacherScoreRatio(Long startId, Long endId, Map<Long, String> stageNameMap, Map<Long, String> subjectNameMap, Map<String, String> teacherMap) {
        log.info("startId={} endId={}", startId, endId);
        List<ClassTeacherFeedbackDto> feedbackDtoList = feedbackMapper.queryFeedbackList(startId, endId);
        if (!CollectionUtils.isEmpty(feedbackDtoList)) {
            buildTeacherScoreRatio(stageNameMap, subjectNameMap, teacherMap, feedbackDtoList);
        }
    }

    private void buildTeacherScoreRatio(Map<Long,String> stageNameMap, Map<Long,String> subjectNameMap, Map<String,String> teacherMap, List<ClassTeacherFeedbackDto> feedbackDtoList) {
        List<TeacherScoreRatio> needInsertList = Lists.newArrayList();
        for (ClassTeacherFeedbackDto dto : feedbackDtoList) {
            TeacherScoreRatio insertDto = convertToTeacherScoreRatio(dto);
            String teacherName = teacherMap.get(dto.getTeacherStaffNo());
            String stageName = stageNameMap.getOrDefault(dto.getStageId(), "");
            String subjectName = subjectNameMap.getOrDefault(dto.getSubjectId(), "");
            int surveyNum = dto.getSurveyNum();
            int realNum = dto.getRealNum();
            String snapshot = dto.getSnapshot();
            if (dto.getFeedbackNo().startsWith("FD")) {// 双师
                buildDoubleTeacherSnapshot(snapshot, insertDto, dto);
            } else if (dto.getFeedbackNo().startsWith("F")) {// 面授
                buildFace2FaceSnapshot(snapshot, surveyNum, realNum, dto, insertDto, teacherName, stageName, subjectName);
            }
            if (surveyNum > 0 && realNum > 0) {
                if (surveyNum >= realNum) {
                    insertDto.setScoreRatio(100);
                } else {
                    insertDto.setScoreRatio((int)(((double)surveyNum / (double)realNum) * 100));
                }
                insertDto.setRealNum(realNum);
                insertDto.setSurveyNum(surveyNum);
            } else {
                insertDto.setScoreRatio(0);
                insertDto.setSurveyNum(surveyNum > 0 ? surveyNum : 0);
                insertDto.setRealNum(realNum > 0 ? realNum : 0);
            }
            needInsertList.add(insertDto);
        }
        if (!CollectionUtils.isEmpty(needInsertList)) {
            scoreRatioMapper.insertBatch(needInsertList);
            log.info("insertCount={}", needInsertList.size());
        }
    }

    private TeacherScoreRatio convertToTeacherScoreRatio(ClassTeacherFeedbackDto dto) {
        TeacherScoreRatio result = new TeacherScoreRatio();
        result.setCsstId(dto.getCsstId());
        result.setFeedbackNo(dto.getFeedbackNo());
        result.setClassId(dto.getClassId());
        result.setClassNo(dto.getClassNo());
        result.setTeacherStaffNo(dto.getTeacherStaffNo());
        result.setTeacherType(dto.getTeacherType().byteValue());
        result.setStageId(dto.getStageId());
        result.setSubjectId(dto.getSubjectId());
        result.setBatchNum(dto.getBatchNum());
        result.setBranchId(dto.getBranchId());
        result.setSubsectorsId(dto.getSubsectorsId());
        result.setCourseType(dto.getCourseType().byteValue());
        result.setBuId(dto.getBuId());
        result.setQuitNum(0);
        result.setExamWay(dto.getExamWay());
        result.setExamType(dto.getExamType());
        result.setLessonDate(dto.getLessonDate());
        result.setScore(dto.getScore());
        return result;
    }

    private void buildDoubleTeacherSnapshot(String snapshot, TeacherScoreRatio insertDto, ClassTeacherFeedbackDto dto) {
        List<TeacherLessonTable> teacherDateList = null;
        try {
            DoubleTeacherSnapshotDto snapShotDto = JSON.parseObject(snapshot, DoubleTeacherSnapshotDto.class);
            if (snapShotDto != null) {
                FormFeedbackData formFeedbackData = snapShotDto.getFormFeedbackData();
                if (formFeedbackData != null) {
                    teacherDateList = formFeedbackData.getTeacherData();
                }
            }
        } catch(JSONException e) {
            log.error("json error");
        }
        if (teacherDateList != null) {
            for (TeacherLessonTable teacherData : teacherDateList) {
                if (teacherData.getTeacher() != null && dto.getTeacherStaffNo().equals(teacherData.getTeacher().getId())) {
                    if (teacherData.getScore() < 10) {
                        insertDto.setScore(teacherData.getScore() * 100);
                    } else {
                        insertDto.setScore(teacherData.getScore());
                    }
                    teacherData.setQuitNum(teacherData.getQuitNum());
                }
            }
        }
    }

    /**
     * 解析面授反馈的snapshot
     *
     * @param snapshot
     * @param surveyNum
     * @param realNum
     * @param insertDto
     * @param teacherName
     * @param stageName
     * @param subjectName
     */
    private void buildFace2FaceSnapshot(String snapshot, int surveyNum, int realNum, ClassTeacherFeedbackDto dto,
                                        TeacherScoreRatio insertDto, String teacherName, String stageName, String subjectName) {
        List<WriteInterview> writeInterviewList = null;
        try {
            SnapShotDto snapShotDto = JSON.parseObject(snapshot, SnapShotDto.class);
            writeInterviewList = snapShotDto.getWriteInterviewList();
        } catch(JSONException e) {
            log.error("json error");
        }
        if (writeInterviewList != null) {
            for (WriteInterview w : writeInterviewList) {
                if (w.getTeacher() != null && w.getTeacher().equals(teacherName) && w.getStageName().equals(stageName + (dto.getBatchNum() > 0 ? dto.getBatchNum() :""))
                        && subjectName.equals(w.getSubject()) && w.getTeacherType() != null && Integer.valueOf(w.getTeacherType()) == dto.getTeacherType()) {
                    if (StringUtils.isNotBlank(w.getQuitNum())) {
                        insertDto.setQuitNum(Integer.valueOf(w.getQuitNum()));
                    } else {
                        insertDto.setQuitNum(0);
                    }
                    if (StringUtils.isNotBlank(w.getSurveyNum())) {
                        surveyNum = Integer.valueOf(w.getSurveyNum());
                    }
                    if (StringUtils.isNotBlank(w.getRealNum())) {
                        realNum = Integer.valueOf(w.getRealNum());
                    }
                    if (StringUtils.isNotBlank(w.getScore())) {
                        Double score = Double.valueOf(w.getScore());
                        if (score < 10) {
                            insertDto.setScore((int) (score * 100));
                        } else {
                            insertDto.setScore(score.intValue());
                        }
                    }
                    break;
                }
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void doSomeFeedback(Long startId, Long endId, Map<String, List<Long>> stageMap, Map<String, List<Long>> subjectMap, Map<String, List<String>> teacherMap) {
        List<FeedBackClass> feedbackList = feedbackMapper.querySomeFeedBack(startId, endId);
        log.info("feedbackCount = {}", feedbackList.size());
        List<ExcelFeed> insertList = Lists.newArrayList();
        for (FeedBackClass feedback : feedbackList) {
            String snapshot = feedback.getSnapshot();
            if (StringUtils.isNotBlank(snapshot)) {
                SnapShotDto snapShotDto = JSON.parseObject(snapshot, SnapShotDto.class);
                List<WriteInterview> writeInterviewList = snapShotDto.getWriteInterviewList();
                if (writeInterviewList != null) {
                    for (WriteInterview w : writeInterviewList) {
                        String stageName = "";
                        Integer batchNum = 0;
                        for (int i = 0; i < w.getStageName().length(); i++) {
                            if (w.getStageName().charAt(i) >= 48 && w.getStageName().charAt(i) <= 57) {
                                if (i == w.getStageName().length() - 1) {
                                    batchNum = Integer.valueOf(w.getStageName().charAt(i) - 48);
                                } else {
                                    batchNum = Integer.valueOf(w.getStageName().substring(i));
                                }
                            } else {
                                stageName += w.getStageName().charAt(i);
                            }
                        }
                        List<Long> stageIdList = stageMap.getOrDefault(stageName, Lists.newArrayList());
                        List<Long> subjectIdList = subjectMap.getOrDefault(w.getSubject(), Lists.newArrayList());
                        if (!stageIdList.contains(feedback.getStageId()) || !subjectIdList.contains(feedback.getSubjectId())) {
                            continue;
                        }
                        ExcelFeed excelFeed = new ExcelFeed();
                        excelFeed.setFeedBackNo(feedback.getFeedbackNo());
                        excelFeed.setClassNo(feedback.getClassNo());
                        excelFeed.setClassName(feedback.getClassName());
                        excelFeed.setBuId(feedback.getBuId());
                        excelFeed.setExamType(feedback.getExamType());
                        excelFeed.setBranchId(feedback.getBranchId());
                        excelFeed.setSubsectorsId(feedback.getSubsectorsId());
                        excelFeed.setClassId(feedback.getClassId());
                        excelFeed.setRoom("");
                        excelFeed.setTeacherName(checkAndGet(w.getTeacher()));
                        if (excelFeed.getTeacherName().equals("")) {
                            continue;
                        }
                        String teacherTypeName = checkAndGet(w.getTeacherTypeName());
                        if (!"".equals(teacherTypeName)) {
                            excelFeed.setTeacherType(teacherTypeName);
                        } else if (StringUtils.isNotBlank(w.getTeacherType())) {
                            excelFeed.setTeacherType(w.getTeacherType().equals("1") ? "主讲" : "助教");
                        } else {
                            excelFeed.setTeacherType("");
                        }

                        excelFeed.setStage(checkAndGet(w.getStageName()));
                        excelFeed.setSubject(checkAndGet(w.getSubject()));
                        excelFeed.setGoodsnos(checkAndGet(snapShotDto.getAllGoodsNos()));
                        excelFeed.setStartTime(w.getStartTime());
                        excelFeed.setEndTime(w.getEndTime());
                        Integer duration = 0;
                        if (StringUtils.isNotBlank(w.getHours())) {
                            duration = Integer.valueOf(w.getHours());
                        }
                        excelFeed.setDuration(duration / 60 + "时" + duration % 60 + "分");
                        excelFeed.setAccident((checkAndGet(w.getTrouble()).equals("1") ? "是" : "否"));
                        excelFeed.setRealNum((checkAndGet(w.getRealNum()).equals("") ? 0 : Integer.valueOf(w.getRealNum())));
                        excelFeed.setScore(checkAndGet(w.getScore()));
                        excelFeed.setSurveyNum(checkAndGet(w.getSurveyNum()).equals("") ? 0 : Integer.valueOf(w.getSurveyNum()));
                        excelFeed.setStageId(feedback.getStageId());
                        excelFeed.setSubjectId(feedback.getSubjectId());
                        excelFeed.setStudentNum(0);
                        excelFeed.setBatchNum(batchNum);
                        insertList.add(excelFeed);
                    }
                }
            }
        }
        // 根据老师姓名查询老师工号
        Set<ClassStageSubjectTeacherDto> cssbIds = Sets.newHashSet();
        List<String> teacherNameList = insertList.stream().map(p -> p.getTeacherName()).sorted().collect(Collectors.toList());


        for (ExcelFeed excelFeed : insertList) {
            String teacherName = excelFeed.getTeacherName();
            List<String> staffNoList = teacherMap.getOrDefault(teacherName, Lists.newArrayList());
            if (staffNoList.size() == 1) {
                cssbIds.add(new ClassStageSubjectTeacherDto(excelFeed.getClassId(), excelFeed.getStageId(), excelFeed.getSubjectId(),
                        excelFeed.getBatchNum(), staffNoList.get(0)));
            } else if (staffNoList.size() > 0) {
                List<String> lessonTeacherNoList = csstMapper.queryTeacherNoByCssbId(excelFeed.getClassId(), excelFeed.getStageId(), excelFeed.getSubjectId(),
                        excelFeed.getBatchNum());
                forea1 :
                for (String staffNo : staffNoList) {
                    for (String teacherNo : lessonTeacherNoList) {
                        if (staffNo.equals(teacherNo)) {
                            cssbIds.add(new ClassStageSubjectTeacherDto(excelFeed.getClassId(), excelFeed.getStageId(), excelFeed.getSubjectId(),
                                    excelFeed.getBatchNum(), teacherNo));
                            break forea1;
                        }
                    }
                }
            }
        }
        List<CsstCount> csstCountList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(cssbIds)) {
            csstCountList = csstMapper.querySomeOrder(cssbIds);
        }

        Map<String, List<String>> csstOrderMap = csstCountList.stream().collect(Collectors.groupingBy(p -> p.getClassId() + "_" + p.getStageId() + "_" + p.getSubjectId() + "_" + p.getBatchNum(), Collectors.mapping(p -> p.getOldOrderNo(), Collectors.toList())));
        Set<String> oldOrderNos = csstCountList.stream().map(p -> p.getOldOrderNo()).collect(Collectors.toSet());
        List<OrderCost> orderCostList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(oldOrderNos)) {
            orderCostList = orderCostMapper.queryOrderCost(oldOrderNos);
        }
        Map<String, Long> orderCostMap = orderCostList.stream().collect(Collectors.toMap(p -> p.getOrderNo(), p -> p.getCost()));
        for (ExcelFeed item : insertList) {
            String key = item.getClassId() + "_" + item.getStageId() +"_" + item.getSubjectId() + "_" + item.getBatchNum();
            List<String> orderNoList = csstOrderMap.getOrDefault(key, Lists.newArrayList());
            for (String orderNo : orderNoList) {
                if (orderCostMap.getOrDefault(orderNo, 0l) > 10000000 && item.getStudentNum() < item.getRealNum()) {
                    item.setStudentNum(item.getStudentNum() + 1);
                }
            }
        }
        if (!CollectionUtils.isEmpty(insertList)) {
            excelFeedMapper.insertBatch(insertList);
        }
        log.info("startId={}, endId={}, insertCount={}", startId, endId, insertList.size());

    }

    private String checkAndGet(String param) {
        return StringUtils.isNoneBlank(param)? param : "";
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void saveExcel(Long startId, Long endId) {
        List<Feedback> feedbackList = localFeedbackMapper.queryList(startId, endId);
        if (!CollectionUtils.isEmpty(feedbackList)) {
            List<TeacherDto> teacherDtoList = Lists.newArrayList();
            Set<String> teacherNames = Sets.newHashSet();
            for (Feedback feedback : feedbackList) {
                String snapshot = feedback.getSnapshot();
                if (StringUtils.isNotBlank(snapshot)) {
                    SnapShotDto snapShotDto = JSON.parseObject(snapshot, SnapShotDto.class);
                    List<WriteInterview> writeInterviewList = snapShotDto.getWriteInterviewList();
                    if (writeInterviewList != null) {
                        for (WriteInterview w : writeInterviewList) {
                            if (StringUtils.isNotBlank(w.getQuitNum()) && Long.parseLong(w.getQuitNum()) > 0l) {
                                TeacherDto teacherDto = new TeacherDto();
                                teacherDto.setFeedbackId(feedback.getId());
                                teacherDto.buildDetailWithWriteInterview(w);
                                if (StringUtils.isNotBlank(w.getTeacher())) {
                                    teacherNames.add(w.getTeacher());
                                }
                                String stageName = "";
                                Integer batchNum = 0;
                                for (int i = 0; i < w.getStageName().length(); i++) {
                                    if (w.getStageName().charAt(i) >= 48 && w.getStageName().charAt(i) <= 57) {
                                        if (i == w.getStageName().length() - 1) {
                                            batchNum = Integer.valueOf(w.getStageName().charAt(i) - 48);
                                        } else {
                                            batchNum = Integer.valueOf(w.getStageName().substring(i));
                                        }
                                    } else {
                                        stageName += w.getStageName().charAt(i);
                                    }
                                }

                                List<Long> stageId = stageMap.getOrDefault(stageName, Lists.newArrayList());
                                List<Long> subjectId = subjectMap.getOrDefault(w.getSubject(), Lists.newArrayList());
                                teacherDto.setStageIdList(stageId);
                                teacherDto.setSubjectIdList(subjectId);
                                teacherDto.setBatchNum(batchNum);
                                teacherDtoList.add(teacherDto);
                            }
                        }
                    }
                }
            }
            if (!CollectionUtils.isEmpty(teacherDtoList)) {
                log.info("get Teacher startId={}, endId={}, count={}", startId, endId, teacherDtoList.size());
                Set<Long> feedBackIds = teacherDtoList.stream().map(p -> p.getFeedbackId()).collect(Collectors.toSet());
                // 查询班级
                List<ClassFeedBackDto> classFeedBackDtoList = feedbackMapper.queryClassFeedbackListById(feedBackIds);
                Map<Long, List<ClassFeedBackDto>> classFeedDtoMap = classFeedBackDtoList.stream().collect(Collectors
                        .groupingBy(p -> p.getFeedbackId()));
                Map<String, List<Teacher>> teacherMap = Maps.newHashMap();
                if (!CollectionUtils.isEmpty(teacherNames)) {
                    // 查询老师工号
                    List<Teacher> teacherList = teacherMapper.queryByNameList(teacherNames);
                    teacherMap = teacherList.stream().collect(Collectors.groupingBy(p -> p.getChineseName()));
                }
                Map<Long, List<ClassStageSubjectTeacherDto>> cssIdMap = Maps.newHashMap();
                Map<Long, List<ClassStageSubjectTeacherDto>> cssIdMap1 = Maps.newHashMap();
                for (TeacherDto teacherDto : teacherDtoList) {
                    List<ClassStageSubjectTeacherDto> classStageSubjectTeacherDtoList = cssIdMap.getOrDefault
                            (teacherDto.getFeedbackId(), Lists.newArrayList());
                    List<Long> stageIdList = teacherDto.getStageIdList();
                    List<Long> subjectIdList = teacherDto.getSubjectIdList();
                    List<ClassFeedBackDto> classList = classFeedDtoMap.getOrDefault(teacherDto.getFeedbackId(), Lists
                            .newArrayList());
                    Long stageId = 0l;
                    Long subjectId = 0l;
                    for (ClassFeedBackDto dto : classList) {
                        if (stageIdList.contains(dto.getStageId())) {
                            stageId = dto.getStageId();
                        }
                        if (subjectIdList.contains(dto.getSubjectId())) {
                            subjectId = dto.getSubjectId();
                        }
                    }
                    teacherDto.setStageId(stageId);
                    teacherDto.setSubjectId(subjectId);
                    classStageSubjectTeacherDtoList.add(new ClassStageSubjectTeacherDto(0l, stageId, subjectId, teacherDto.getBatchNum()));
                    cssIdMap.put(teacherDto.getFeedbackId(), classStageSubjectTeacherDtoList);
                    List<Teacher> teacher = teacherMap.getOrDefault(teacherDto.getTeacherName(), Lists.newArrayList());
                    if (teacher.size() == 1) {
                        teacherDto.setTeacherNo(teacher.get(0).getStaffNo());
                        teacherDto.setTeacherUnitId(teacher.get(0).getTeacherUnitId());
                    } else if (teacher.size() > 1) {
                        teacherDto.setTeacherNoList(teacher.stream().map(p -> p.getStaffNo()).collect(Collectors.toList()));
                        List<ClassStageSubjectTeacherDto> cssId1List = cssIdMap1.getOrDefault(teacherDto.getFeedbackId(), Lists.newArrayList());
                        cssId1List.add(new ClassStageSubjectTeacherDto(0l, stageId, subjectId, teacherDto.getBatchNum()));
                        cssIdMap1.put(teacherDto.getFeedbackId(), cssId1List);
                    } else {
                        teacherDto.setTeacherNo("");
                        teacherDto.setTeacherUnitId(0l);
                    }
                }

                // 查询退班订单
                List<ClassStageSubjectTeacherDto> cssIdList = Lists.newArrayList();
                // 多个老师
                List<ClassStageSubjectTeacherDto> cssId1List = Lists.newArrayList();

                for (ClassFeedBackDto dto : classFeedBackDtoList) {
                    List<ClassStageSubjectTeacherDto> csstList = cssIdMap.getOrDefault(dto.getFeedbackId(), Lists
                            .newArrayList());
                    for (ClassStageSubjectTeacherDto classStageSubjectTeacherDto : csstList) {
                        classStageSubjectTeacherDto.setClassId(dto.getClassId());
                    }
                    cssIdList.addAll(csstList);

                    List<ClassStageSubjectTeacherDto> csst1List = cssIdMap1.getOrDefault(dto.getFeedbackId(), Lists
                            .newArrayList());
                    for (ClassStageSubjectTeacherDto classStageSubjectTeacherDto : csst1List) {
                        classStageSubjectTeacherDto.setClassId(dto.getClassId());
                    }
                    cssId1List.addAll(csst1List);
                }
                // 退班订单
                Map<String, List<String>> quitOrderNoMap = Maps.newHashMap();
                if (!CollectionUtils.isEmpty(cssIdList)) {
                    List<CsstQuitOrderDto> quitDtoList = csstMapper.queryQuitOrderNo(cssIdList);
                    Map<String, List<CsstQuitOrderDto>> quitDtoMap = quitDtoList.stream()
                            .collect(Collectors.groupingBy(p -> p.getClassId() + "_" + p.getStageId() + "_" + p
                                    .getSubjectId() + "_" + p.getBatchNum()));
                    for (String cssb : quitDtoMap.keySet()) {
                        List<CsstQuitOrderDto> list = quitDtoMap.getOrDefault(cssb, Lists.newArrayList());
                        Map<String, List<Integer>> operatorTypeMap = list.stream().collect(Collectors.groupingBy(p ->
                                p.getOldOrderNo(), Collectors.mapping(p -> p.getOperatorType(), Collectors.toList())));
                        for (String oldOrderNo : operatorTypeMap.keySet()) {
                            List<Integer> operatorType = operatorTypeMap.getOrDefault(oldOrderNo, Lists.newArrayList());
                            Integer quitCount = 0;
                            Integer deleteQuit = 0;
                            for (Integer op : operatorType) {
                                if (op == 2) {
                                    quitCount++;
                                } else {
                                    deleteQuit++;
                                }
                            }
                            if (quitCount > deleteQuit) {
                                List<String> quitOrderNoList = quitOrderNoMap.getOrDefault(cssb, Lists.newArrayList());
                                quitOrderNoList.add(oldOrderNo);
                                quitOrderNoMap.put(cssb, quitOrderNoList);
                            }
                        }
                    }
                }

                // 老师编号
                Map<String, List<String>> teacherNoMap = Maps.newHashMap();
                if (!CollectionUtils.isEmpty(cssId1List)) {
                    List<CsstDto> csstDtos = csstMapper.queryTeacherNo(cssId1List);
                    teacherNoMap = csstDtos.stream().collect(Collectors.groupingBy(p -> p.getClassId() + "_" + p.getStageId() + "_" + p
                            .getSubjectId() + "_" + p.getBatchNum(), Collectors.mapping(p -> p.getTeacherNo(), Collectors.toList())));
                    
                }

                List<ExcelTemp> needInsertList = Lists.newArrayList();
                for (TeacherDto dto : teacherDtoList) {
                    List<ClassFeedBackDto> classList = classFeedDtoMap.getOrDefault(dto.getFeedbackId(), Lists
                            .newArrayList());
                    if (CollectionUtils.isEmpty(classList)) {
                        log.info("feedbackId ={} 查询不到", dto.getFeedbackId());
                        continue;
                    }
                    String cssb = classList.get(0).getClassId() + "_" + dto.getStageId() + "_" + dto.getSubjectId() +
                            "_" + dto.getBatchNum();
                    List<String> quitOrderNoList = quitOrderNoMap.getOrDefault(cssb, Lists.newArrayList());
                    List<String> teacherNoList = teacherNoMap.getOrDefault(cssb, Lists.newArrayList());
                    needInsertList.addAll(build(quitOrderNoList, dto, classList.get(0), teacherNoList));
                }
                if (!CollectionUtils.isEmpty(needInsertList)) {
                    excelMapper.insertBatchTemp(needInsertList);
                }


            }


        }
    }

    private Collection<? extends ExcelTemp> build(List<String> quitOrderNoList, TeacherDto dto, ClassFeedBackDto
            classFeedBackDto, List<String> teacherNoList) {
        List<ExcelTemp> result = Lists.newArrayList();
        for (String oldOrderNo : quitOrderNoList) {
            ExcelTemp excel = new ExcelTemp();
            excel.setOrderNo(oldOrderNo);
            result.add(excel);
        }
        if (CollectionUtils.isEmpty(result)) {
            ExcelTemp excel = new ExcelTemp();
            excel.setOrderNo("");
            result.add(excel);
        }
        result.forEach(excel -> {
            excel.setFeedBackId(dto.getFeedbackId());
            excel.setBuId(classFeedBackDto.getBuId());
            excel.setBranchId(classFeedBackDto.getBranchId());
            excel.setClassNo(classFeedBackDto.getClassNo());
            excel.setClassName(classFeedBackDto.getClassName());
            excel.setStageId(dto.getStageId());
            excel.setStage(dto.getStageName());
            excel.setSubject(dto.getSubjectName());
            excel.setSubjectId(dto.getSubjectId());
            boolean haveStaffNo = false;
            if (StringUtils.isNotBlank(dto.getTeacherNo())) {
                excel.setStaffNo(dto.getTeacherNo());
                haveStaffNo = true;
            } else if (!CollectionUtils.isEmpty(dto.getTeacherNoList())) {
                for (String staffNo : dto.getTeacherNoList()) {
                    if (teacherNoList.contains(staffNo)) {
                        excel.setStaffNo(staffNo);
                        haveStaffNo = true;
                        break;
                    }
                }
            }
            if (!haveStaffNo) {
                excel.setStaffNo("");
            }

            excel.setTeacherType(dto.getTeacherType());
            excel.setTeacherName(dto.getTeacherName());
            excel.setStudentNum(dto.getStudentNum());
            excel.setStartTime(dto.getStartTime());
            excel.setEndTime(dto.getEndTime());
            excel.setDuration(dto.getDuration());
            excel.setScore(dto.getScore());
            excel.setQuitNum(dto.getQuitNum());
            excel.setAccident(dto.getTrouble());
            excel.setQuitReason("");
        });
        return result;
    }
}

package dal.db1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "excel_feed")
public class ExcelFeed {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 反馈编号
     */
    @Column(name = "FEED_BACK_NO")
    private String feedBackNo;

    private Long classId;

    private Long stageId;

    private Long subjectId;

    private Integer batchNum;

    private Integer tType;

    /**
     * 班级编号
     */
    @Column(name = "CLASS_NO")
    private String classNo;

    /**
     * 班级名称
     */
    @Column(name = "CLASS_NAME")
    private String className;

    /**
     * 事业部id
     */
    @Column(name = "BU_ID")
    private Long buId;

    /**
     * 考试类型
     */
    @Column(name = "EXAM_TYPE")
    private String examType;

    /**
     * 分校
     */
    @Column(name = "BRANCH_ID")
    private Long branchId;

    /**
     * 分部
     */
    @Column(name = "SUBSECTORS_ID")
    private Long subsectorsId;

    /**
     * 上课地点
     */
    @Column(name = "ROOM")
    private String room;

    /**
     * 老师姓名
     */
    @Column(name = "teacher_name")
    private String teacherName;

    /**
     * 主讲；助教
     */
    @Column(name = "TEACHER_TYPE")
    private String teacherType;

    /**
     * 阶段名称
     */
    @Column(name = "STAGE")
    private String stage;

    /**
     * 科目名称
     */
    @Column(name = "SUBJECT")
    private String subject;

    /**
     * 商品编码
     */
    @Column(name = "goodsNos")
    private String goodsnos;

    /**
     * 开始时间
     */
    @Column(name = "START_TIME")
    private String startTime;

    /**
     * 结课时间
     */
    @Column(name = "END_TIME")
    private String endTime;

    /**
     * 授课小时数
     */
    @Column(name = "DURATION")
    private String duration;

    /**
     * 是否事故
     */
    @Column(name = "ACCIDENT")
    private String accident;

    @Column(name = "SURVEY_NUM")
    private Integer surveyNum;

    /**
     * 分数
     */
    @Column(name = "SCORE")
    private String score;

    /**
     * 上课人数
     */
    @Column(name = "STUDENT_NUM")
    private Integer studentNum;

    /**
     * 到场人数
     */
    @Column(name = "REAL_NUM")
    private Integer realNum;

    /**
     * 获取自增ID
     *
     * @return ID - 自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增ID
     *
     * @param id 自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取反馈编号
     *
     * @return FEED_BACK_NO - 反馈编号
     */
    public String getFeedBackNo() {
        return feedBackNo;
    }

    /**
     * 设置反馈编号
     *
     * @param feedBackNo 反馈编号
     */
    public void setFeedBackNo(String feedBackNo) {
        this.feedBackNo = feedBackNo;
    }

    /**
     * 获取班级编号
     *
     * @return CLASS_NO - 班级编号
     */
    public String getClassNo() {
        return classNo;
    }

    /**
     * 设置班级编号
     *
     * @param classNo 班级编号
     */
    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    /**
     * 获取班级名称
     *
     * @return CLASS_NAME - 班级名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置班级名称
     *
     * @param className 班级名称
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取事业部id
     *
     * @return BU_ID - 事业部id
     */
    public Long getBuId() {
        return buId;
    }

    /**
     * 设置事业部id
     *
     * @param buId 事业部id
     */
    public void setBuId(Long buId) {
        this.buId = buId;
    }

    /**
     * 获取考试类型
     *
     * @return EXAM_TYPE - 考试类型
     */
    public String getExamType() {
        return examType;
    }

    /**
     * 设置考试类型
     *
     * @param examType 考试类型
     */
    public void setExamType(String examType) {
        this.examType = examType;
    }

    /**
     * 获取分校
     *
     * @return BRANCH_ID - 分校
     */
    public Long getBranchId() {
        return branchId;
    }

    /**
     * 设置分校
     *
     * @param branchId 分校
     */
    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    /**
     * 获取分部
     *
     * @return SUBSECTORS_ID - 分部
     */
    public Long getSubsectorsId() {
        return subsectorsId;
    }

    /**
     * 设置分部
     *
     * @param subsectorsId 分部
     */
    public void setSubsectorsId(Long subsectorsId) {
        this.subsectorsId = subsectorsId;
    }

    /**
     * 获取上课地点
     *
     * @return ROOM - 上课地点
     */
    public String getRoom() {
        return room;
    }

    /**
     * 设置上课地点
     *
     * @param room 上课地点
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * 获取老师姓名
     *
     * @return teacher_name - 老师姓名
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * 设置老师姓名
     *
     * @param teacherName 老师姓名
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * 获取主讲；助教
     *
     * @return TEACHER_TYPE - 主讲；助教
     */
    public String getTeacherType() {
        return teacherType;
    }

    /**
     * 设置主讲；助教
     *
     * @param teacherType 主讲；助教
     */
    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }

    /**
     * 获取阶段名称
     *
     * @return STAGE - 阶段名称
     */
    public String getStage() {
        return stage;
    }

    /**
     * 设置阶段名称
     *
     * @param stage 阶段名称
     */
    public void setStage(String stage) {
        this.stage = stage;
    }

    /**
     * 获取科目名称
     *
     * @return SUBJECT - 科目名称
     */
    public String getSubject() {
        return subject;
    }

    /**
     * 设置科目名称
     *
     * @param subject 科目名称
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * 获取商品编码
     *
     * @return goodsNos - 商品编码
     */
    public String getGoodsnos() {
        return goodsnos;
    }

    /**
     * 设置商品编码
     *
     * @param goodsnos 商品编码
     */
    public void setGoodsnos(String goodsnos) {
        this.goodsnos = goodsnos;
    }

    /**
     * 获取开始时间
     *
     * @return START_TIME - 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结课时间
     *
     * @return END_TIME - 结课时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结课时间
     *
     * @param endTime 结课时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取授课小时数
     *
     * @return DURATION - 授课小时数
     */
    public String getDuration() {
        return duration;
    }

    /**
     * 设置授课小时数
     *
     * @param duration 授课小时数
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * 获取是否事故
     *
     * @return ACCIDENT - 是否事故
     */
    public String getAccident() {
        return accident;
    }

    /**
     * 设置是否事故
     *
     * @param accident 是否事故
     */
    public void setAccident(String accident) {
        this.accident = accident;
    }

    /**
     * @return SURVEY_NUM
     */
    public Integer getSurveyNum() {
        return surveyNum;
    }

    /**
     * @param surveyNum
     */
    public void setSurveyNum(Integer surveyNum) {
        this.surveyNum = surveyNum;
    }

    /**
     * 获取分数
     *
     * @return SCORE - 分数
     */
    public String getScore() {
        return score;
    }

    /**
     * 设置分数
     *
     * @param score 分数
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * 获取上课人数
     *
     * @return STUDENT_NUM - 上课人数
     */
    public Integer getStudentNum() {
        return studentNum;
    }

    /**
     * 设置上课人数
     *
     * @param studentNum 上课人数
     */
    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    /**
     * 获取到场人数
     *
     * @return REAL_NUM - 到场人数
     */
    public Integer getRealNum() {
        return realNum;
    }

    /**
     * 设置到场人数
     *
     * @param realNum 到场人数
     */
    public void setRealNum(Integer realNum) {
        this.realNum = realNum;
    }
}
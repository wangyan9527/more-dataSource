package dal.db1.mapper;

import dal.db1.entity.TeacherScoreRatio;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TeacherScoreRatioMapper extends Mapper<TeacherScoreRatio> {

    /**
     * 批量插入
     *
     * @param insertList
     */
    void insertBatch(List<TeacherScoreRatio> insertList);

    /**
     * 通过查询class_stage_subject_teacher,feed_back等表直接进行插入
     * 过滤掉csst中score=0,surveyNum和realNum小于0的数据
     */
    void insertBatchSelect();

}
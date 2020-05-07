package dal.db2.mapper.feedback;

import dal.db2.entity.ClassFeedBackDto;
import dal.db2.entity.ClassTeacherFeedbackDto;
import entity.feedback.FeedBackClass;
import entity.feedback.Feedback;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Collection;
import java.util.List;

public interface FeedbackMapper extends Mapper<Feedback> {

    Feedback queryById(Long id);

    List<Feedback> queryListByStartAndEndId(@Param("startId")Long startId, @Param("endId") Long endId);

    List<ClassFeedBackDto> queryClassFeedbackListById(Collection<Long> feedbackList);

    List<FeedBackClass> querySomeFeedBack(@Param("startId") Long startId, @Param("endId") Long endId);

    List<ClassTeacherFeedbackDto> queryFeedbackList(@Param("startId") Long startId, @Param("endId") Long endId);
}

package dal.db1.mapper;

import entity.feedback.Feedback;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Collection;
import java.util.List;

public interface LocalFeedbackMapper extends Mapper<Feedback> {

    void insertBatch(List<Feedback> feedbackList);

    List<Feedback> queryList(@Param("startId") Long startId, @Param("endId") Long endId);

    List<Feedback> queryListByIds(Collection<Long> feedbackIdList);
}

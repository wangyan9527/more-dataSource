package sal.feedback.impl;

import entity.feedback.Feedback;
import dal.db2.mapper.feedback.FeedbackMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sal.feedback.FeedbackService;

import java.util.List;

@Slf4j
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public Feedback queryById(Long feedbackId) {
        log.info("query feedback by id={}", feedbackId);
        return feedbackMapper.queryById(feedbackId);
    }

    @Override
    public List<Feedback> queryListBetweenId(Long startId, Long endId) {
        log.info("query feedbackList between startId={}, endId={}", startId, endId);

        return feedbackMapper.queryListByStartAndEndId(startId, endId);
    }
}

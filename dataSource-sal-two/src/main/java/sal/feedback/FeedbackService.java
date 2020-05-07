package sal.feedback;

import entity.feedback.Feedback;

import java.util.Collection;
import java.util.List;

public interface FeedbackService {

    Feedback queryById(Long feedbackId);

    List<Feedback> queryListBetweenId(Long startId, Long endId);


}

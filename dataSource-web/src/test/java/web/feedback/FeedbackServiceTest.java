package web.feedback;

import entity.feedback.Feedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sal.feedback.FeedbackService;
import web.WebApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = WebApplication.class)
public class FeedbackServiceTest {

    @Autowired
    private FeedbackService feedbackService;

    @Test
    public void testQueryFeedbackById() {
        Feedback feedback = feedbackService.queryById(319l);
        System.out.println("result = " + feedback);
    }

}

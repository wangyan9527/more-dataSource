package sal.feedback.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FormFeedbackData {

    List<TeacherLessonTable> teacherData;

    List<TripData> tripData;

    String suggest;

    String remark;

    String feedbackNo;

    String lessonNo;

    Date feedbackTime;

}

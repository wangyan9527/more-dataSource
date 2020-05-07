package sal.feedback.dto;

import lombok.Data;

/**
 * 双师主讲反馈,snapshot实体
 */
@Data
public class DoubleTeacherSnapshotDto {

    FormFeedbackData formFeedbackData;

    AssisTeacherData assisTeacherData;

}

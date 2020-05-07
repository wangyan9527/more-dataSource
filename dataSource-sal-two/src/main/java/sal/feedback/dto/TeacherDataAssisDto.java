package sal.feedback.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TeacherDataAssisDto {

    List<String> studentDeviceNames;

    String lessonTableNo;

    Long stageId;

    String stageName;

    Long subjectId;

    String subjectName;

    Integer batchNum;

    String teacherStaffName;

    Long classId;

    String classNo;

    Date startTime;

    Date endTime;

    Integer teachDuration;

    Integer applyNum;

    Integer quitNum;

    Integer realNum;

    Integer surveyNum;

    List<String> lessonDateStrList;

    Integer score;
}

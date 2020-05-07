package dal.db2.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ClassTeacherFeedbackDto {

    private Long csstId;

    private String feedbackNo;

    private Long classId;

    private String classNo;

    private String teacherStaffNo;

    private Integer teacherType;

    private Long stageId;

    private Long subjectId;

    private Integer batchNum;

    private Long branchId;

    private Long subsectorsId;

    private Integer courseType;

    private Long buId;

    private Integer surveyNum;

    private Integer realNum;

    private String examWay;

    private String examType;

    private Integer score;

    private Date lessonDate;

    private String snapshot;

}

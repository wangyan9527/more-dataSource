package dal.db2.entity;

import lombok.Data;

@Data
public class ClassFeedBackDto {

    private Long feedbackId;

    private Long classId;

    private String classNo;

    private String className;

    private Long stageId;

    private Long subjectId;

    private Integer batchNum;

    private String teacherNo;

    private Long buId;

    private Long branchId;
}

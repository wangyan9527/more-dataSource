package entity.feedback;

import lombok.Data;

@Data
public class FeedBackClass {

    private Long id;

    private String feedbackNo;

    private Long classId;

    private Long stageId;

    private String classNo;

    private String className;

    private Long buId;

    private String examType;

    private Long branchId;

    private Long subsectorsId;

    private Long subjectId;

    private Integer batchNum;

    private String snapshot;
}

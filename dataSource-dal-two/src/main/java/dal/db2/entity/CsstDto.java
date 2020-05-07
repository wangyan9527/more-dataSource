package dal.db2.entity;

import lombok.Data;

@Data
public class CsstDto {

    private Long classId;

    private Long stageId;

    private Long subjectId;

    private Integer batchNum;

    private String teacherNo;
}

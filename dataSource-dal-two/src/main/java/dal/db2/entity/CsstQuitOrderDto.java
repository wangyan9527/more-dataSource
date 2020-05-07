package dal.db2.entity;

import lombok.Data;

@Data
public class CsstQuitOrderDto {

    private Long classId;

    private Long stageId;

    private Long subjectId;

    private Integer batchNum;

    private String oldOrderNo;

    private Integer operatorType;

}

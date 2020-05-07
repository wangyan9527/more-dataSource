package dal.db2.entity;

import lombok.Data;

@Data
public class OrderTeacherDto {

    private String oldOrderNo;

    private String orderNo;

    private Long orderGoodsId;

    private String teacherNo;
}

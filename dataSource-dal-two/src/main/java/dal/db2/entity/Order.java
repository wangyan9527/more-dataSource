package dal.db2.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private Long id;

    private Long goodsId;

    private String userName;

    private Date createTime;

    private Date updateTime;
}

package dal.db1.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Goods {

    private Long id;

    private String name;

    private Long price;

    private Byte idDel;

    private Date createTime;

    private Date updateTime;

}

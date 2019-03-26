package common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsOrderDto implements Serializable {

    private static final long serialVersionUID = -297378596081206343L;

    private Long goodsId;

    private String goodsName;

    private Long goodsPrice;

    private Long orderId;

    private String userName;



}

package sal.feedback.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsDurationDto implements Serializable {
    private static final long serialVersionUID = -7203791397623858053L;

    /**
     * 商品编号
     */
    private String goodsNo;

    /**
     * 上课时长(分钟数)
     */
    private Integer duration;
}

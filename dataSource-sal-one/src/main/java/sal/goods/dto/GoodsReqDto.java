package sal.goods.dto;

import com.google.common.base.Preconditions;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
public class GoodsReqDto implements Serializable {

    private static final long serialVersionUID = -8581350422522727905L;

    private String goodsName;

    private Long price;

    public void validate() {
        Preconditions.checkArgument(StringUtils.isNotBlank(goodsName), "goodsName is blank!");
        Preconditions.checkArgument(price != null, "price is null!");
    }
}

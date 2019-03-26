package sal.order;

import common.dto.GoodsOrderDto;

import java.util.List;

public interface OrderService {

    Long insertOrder(Long goodsId, String userName);

    List<GoodsOrderDto> queryGoodsOrderListByUserName(String userName);

}

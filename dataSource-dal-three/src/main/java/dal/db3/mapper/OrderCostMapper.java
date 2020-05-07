package dal.db3.mapper;

import dal.db3.entity.OrderCost;
import tk.mybatis.mapper.common.Mapper;

import java.util.Collection;
import java.util.List;

public interface OrderCostMapper extends Mapper<OrderCost> {

    List<OrderCost> queryOrderCost(Collection<String> orderNos);

}

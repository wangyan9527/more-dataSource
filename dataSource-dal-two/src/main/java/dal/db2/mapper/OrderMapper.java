package dal.db2.mapper;

import dal.db2.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    int insertOne(Order order);

    List<Order> selectByGoodsId(Long goodsId);

    List<Order> queryOrderListByUserName(String userName);

}

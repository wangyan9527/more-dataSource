package sal.order.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import common.dto.GoodsOrderDto;
import dal.db1.entity.Goods;
import dal.db1.mapper.GoodsMapper;
import dal.db2.entity.Order;
import dal.db2.mapper.OrderMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import sal.order.OrderService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long insertOrder(Long goodsId, String userName) {
        Preconditions.checkArgument(goodsId != null, "goodsId is null!");
        Preconditions.checkArgument(StringUtils.isNotBlank(userName), "userName is blank!");
        Order order = new Order();
        Goods goods = goodsMapper.selectById(goodsId);
        Preconditions.checkArgument(goods != null, "商品不存在!");
        order.setGoodsId(goodsId);
        order.setUserName(userName);
        orderMapper.insertOne(order);
        return order.getId();
    }

    @Override
    public List<GoodsOrderDto> queryGoodsOrderListByUserName(String userName) {
        if (StringUtils.isBlank(userName)) {
            return Lists.newArrayList();
        }
        List<Order> orderList = orderMapper.queryOrderListByUserName(userName);
        if (CollectionUtils.isEmpty(orderList)) {
            return Lists.newArrayList();
        }
        Set<Long> goodsIds = orderList.stream().map(p -> p.getId()).collect(Collectors.toSet());
        List<Goods> goodsList = goodsMapper.selectByIds(goodsIds);
        Map<Long, Goods> goodsIdMap = goodsList.stream().collect(Collectors.toMap(p -> p.getId(), Function.identity()));
        List<GoodsOrderDto> result = Lists.newArrayList();
        for (Order order : orderList) {
            Long goodsId = order.getGoodsId();
            Goods goods = goodsIdMap.get(goodsId);
            GoodsOrderDto dto = new GoodsOrderDto();
            dto.setGoodsId(goods.getId());
            dto.setGoodsName(goods.getName());
            dto.setGoodsPrice(goods.getPrice());
            dto.setOrderId(order.getId());
            dto.setUserName(order.getUserName());
            result.add(dto);
        }
        return result;
    }
}

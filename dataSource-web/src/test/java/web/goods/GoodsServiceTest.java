package web.goods;

import common.dto.GoodsOrderDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sal.goods.GoodsService;
import sal.goods.dto.GoodsReqDto;
import sal.order.OrderService;
import web.WebApplication;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = WebApplication.class)
public class GoodsServiceTest {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Test
    public void testInsert() {
        GoodsReqDto reqDto = new GoodsReqDto();
        reqDto.setGoodsName("测试商品名称1");
        reqDto.setPrice(500l);
        Long goodsId = goodsService.insertGoods(reqDto);
        System.out.println(goodsId);
    }

    @Test
    public void testOrderInsert() {
        Long id = orderService.insertOrder(2l, "炎仔");
        System.out.println(id);
    }

    @Test
    public void testQueryOrderByUser() {
        List<GoodsOrderDto> result = orderService.queryGoodsOrderListByUserName("炎");
        System.out.println(result);
    }



}

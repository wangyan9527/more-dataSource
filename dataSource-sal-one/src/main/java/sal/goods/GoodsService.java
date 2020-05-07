package sal.goods;

import dal.db1.entity.Goods;
import sal.goods.dto.GoodsReqDto;

import java.io.IOException;
import java.util.List;

public interface GoodsService {

    Long insertGoods(GoodsReqDto param);

    List<Goods> getGoodsListByName(String name);

    /**
     *
     * 测试事务
     */
    void testTransactional();

    void queryAndInsertPost() throws IOException, InterruptedException;

    void queryAndInsertTeacher() throws InterruptedException;

}

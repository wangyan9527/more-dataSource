package sal.goods;

import dal.db1.entity.Goods;
import sal.goods.dto.GoodsReqDto;

import java.util.List;

public interface GoodsService {

    Long insertGoods(GoodsReqDto param);

    List<Goods> getGoodsListByName(String name);

}

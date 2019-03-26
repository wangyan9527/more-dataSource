package dal.db1.mapper;

import dal.db1.entity.Goods;

import java.util.Collection;
import java.util.List;

public interface GoodsMapper {

    int insertOne(Goods goods);

    Goods selectById(Long goodsId);

    List<Goods> selectGoodsListByGoodsName(String goodsName);

    List<Goods> selectByIds(Collection<Long> goodsIds);

}

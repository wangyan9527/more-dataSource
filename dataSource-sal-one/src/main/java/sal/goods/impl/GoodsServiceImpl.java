package sal.goods.impl;

import com.google.common.collect.Lists;
import dal.db1.entity.Goods;
import dal.db1.mapper.GoodsMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sal.goods.GoodsService;
import sal.goods.dto.GoodsReqDto;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Long insertGoods(GoodsReqDto param) {
        param.validate();
        Goods goods = new Goods();
        goods.setName(param.getGoodsName());
        goods.setPrice(param.getPrice());
        goodsMapper.insertOne(goods);
        return goods.getId();
    }

    @Override
    public List<Goods> getGoodsListByName(String name) {
        if (StringUtils.isBlank(name)) {
            return Lists.newArrayList();
        }
        return goodsMapper.selectGoodsListByGoodsName(name);
    }
}

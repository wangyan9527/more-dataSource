package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sal.goods.GoodsService;
import sal.goods.dto.GoodsReqDto;
import web.dto.Result;
import web.dto.ResultUtils;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/save.json")
    public Result saveGoods(@RequestBody GoodsReqDto reqDto) {
        return ResultUtils.buildResult(goodsService.insertGoods(reqDto));
    }



}

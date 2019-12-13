package com.qrsx.springboot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.service.GoodsInfoService;
 
@RestController
//RestController使用的效果是将方法返回的对象直接在浏览器上展示成json格式，
public class GoodsInfoController {
	@Autowired GoodsInfoService goodsInfoService;
    @GetMapping("/vague")
    public List<GoodsInfo> vague(String goods_name){
        return goodsInfoService.vague(goods_name);
    }

}




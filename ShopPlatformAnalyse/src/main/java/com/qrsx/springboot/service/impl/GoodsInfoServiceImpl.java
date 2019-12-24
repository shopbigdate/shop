package com.qrsx.springboot.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrsx.springboot.mapper.GoodsInfoMapper;
import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.pojo.GoodsPicture;
import com.qrsx.springboot.pojo.ShoppingCar;
import com.qrsx.springboot.service.GoodsInfoService;

/**
 * @ClassName:  GoodsInfoImpl   
 * @Description:商品详情业务层实现
 * @date:   2019年12月11日 下午4:44:41   
 */
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

	@Autowired
	GoodsInfoMapper goodsInfoMapper;

	//获取商品详情
	@Override
	public GoodsInfo getOneGoodsInfo(Integer goods_id) {
		return goodsInfoMapper.getOneGoodsInfo(goods_id);
	}

	//获取商品详情的图片信息
	@Override
	public List<GoodsPicture> getOneGoodsPicture(Integer goods_id) {
		return goodsInfoMapper.getOneGoodsPicture(goods_id);
	}

	//创建购物车表
	@Override
	public Integer createShoppingCar(ShoppingCar shoppingcar) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("goods_id", shoppingcar.getGoods_id());
		map.put("goods_number", shoppingcar.getGoods_number());
		map.put("user_id", shoppingcar.getUser_id());
		goodsInfoMapper.createShoppingCar(map);
		return map.get("result");
	}

	//主页搜索vague
	@Override
	public List<GoodsInfo> vague(String goods_name) {
		return goodsInfoMapper.vague(goods_name);
	}

	//全部查找
	@Override
	public List<GoodsInfo> search() {
		return goodsInfoMapper.search();
	}

}

package com.qrsx.springboot.service;

import java.util.List;

import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.pojo.GoodsPicture;
import com.qrsx.springboot.pojo.ShoppingCar;

/**
 * @ClassName:  GoodsInfoService   
 * @Description:  商品详情业务层接口
 * @author: 姜振楠
 * @date:   2019年12月11日 下午4:36:30   
 */
public interface GoodsInfoService {

	//获取单个商品的详细信息
	GoodsInfo getOneGoodsInfo(Integer goods_id);

	//获取商品的图片地址
	List<GoodsPicture> getOneGoodsPicture(Integer goods_id);

	//创建购物车表
	Integer createShoppingCar(ShoppingCar shoppingcar);

	//主页搜索
	List<GoodsInfo> vague(String goods_name);

	//全部查找
	List<GoodsInfo> search();

}

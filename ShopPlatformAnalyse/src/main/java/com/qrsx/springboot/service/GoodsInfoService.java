package com.qrsx.springboot.service;

import java.util.List;

import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.pojo.GoodsPicture;
import com.qrsx.springboot.pojo.ShoppingCar;

/**
 * 
 * @ClassName:  GoodsInfoService   
 * @Description:  商品详情业务层接口
 * @author: 姜振楠
 * @date:   2019年12月11日 下午4:36:30   
 *     
 */
public interface GoodsInfoService {

	GoodsInfo getOneGoodsInfo(Integer goods_id);

	List<GoodsPicture> getOneGoodsPicture(Integer goods_id);

	Integer createShoppingCar(ShoppingCar shoppingcar);

	//主页搜索vague
	List<GoodsInfo> vague(String goods_name);
	//全部查找
	List<GoodsInfo> search();

}

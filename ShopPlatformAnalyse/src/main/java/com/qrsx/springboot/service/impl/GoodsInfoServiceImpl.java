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
 * 
 * @ClassName:  GoodsInfoImpl   
 * @Description:商品详情业务层实现
 * @date:   2019年12月11日 下午4:44:41   
 *     
 */
@Service
public class GoodsInfoServiceImpl implements GoodsInfoService {

	@Autowired
	GoodsInfoMapper goodsInfoMapper;

	/**
	 * 
	 * <p>Title: getOneGoodsInfo</p>   
	 * <p>Description: 获取商品详情  </p>
	 * @param goods_id
	 * @return   
	 * @see com.qrsx.springboot.service.GoodsInfoService#getOneGoodsInfo(java.lang.Integer)
	 */
	@Override
	public GoodsInfo getOneGoodsInfo(Integer goods_id) {
		return goodsInfoMapper.getOneGoodsInfo(goods_id);
	}

	/**
	 * 
	 * <p>Title: getOneGoodsPicture</p>   
	 * <p>Description: 获取商品详情的图片信息</p>   
	 * @param goods_id
	 * @return   
	 * @see com.qrsx.springboot.service.GoodsInfoService#getOneGoodsPicture(java.lang.Integer)
	 */
	@Override
	public List<GoodsPicture> getOneGoodsPicture(Integer goods_id) {
		return goodsInfoMapper.getOneGoodsPicture(goods_id);
	}

	/**
	 * 
	 * <p>Title: createShoppingCar</p>   
	 * <p>Description: 创建购物车表</p>   
	 * @param goods_id
	 * @param goods_number
	 * @param user_id
	 * @return   
	 * @see com.qrsx.springboot.service.GoodsInfoService#createShoppingCar(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Integer createShoppingCar(ShoppingCar shoppingcar) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("goods_id", shoppingcar.getGoods_id());
		map.put("goods_number", shoppingcar.getGoods_number());
		map.put("user_id", shoppingcar.getUser_id());
		goodsInfoMapper.createShoppingCar(map);
		return map.get("result");
	}

	@Override
	public List<GoodsInfo> vague(String goods_name) {
		//主页搜索vague
		return goodsInfoMapper.vague(goods_name);
	}
	@Override
	public List<Goods_Info> search() {
		return goods_info_Mapper.search();
	}

}

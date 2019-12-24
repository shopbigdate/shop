package com.qrsx.springboot.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.pojo.GoodsPicture;

/**
 * 
 * @ClassName:  GoodsInfoMapper   
 * @Description:商品详情页的Mapper层
 * @author: 姜振楠
 * @date:   2019年12月11日 下午4:20:10   
 *     
 */
@Mapper
public interface GoodsInfoMapper {
	
	//获取单个商品的详细信息
	GoodsInfo getOneGoodsInfo(@Param("goods_id") Integer goods_id);

	//获取商品的图片地址
	List<GoodsPicture> getOneGoodsPicture(@Param("goods_id") Integer goods_id);

	//创建购物车表
	HashMap createShoppingCar(HashMap<String, Integer> map);

	//主页搜索
	List<GoodsInfo> vague(String goods_name);

	//全部查找
	List<GoodsInfo> search();
}

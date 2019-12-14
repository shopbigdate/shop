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
 * @Description:商品详情页的Mapper层，用于定义方法
 * @author: 姜振楠
 * @date:   2019年12月11日 下午4:20:10   
 *     
 */
@Mapper
public interface GoodsInfoMapper {
	GoodsInfo getOneGoodsInfo(@Param("goods_id") Integer goods_id);

	List<GoodsPicture> getOneGoodsPicture(@Param("goods_id") Integer goods_id);

	HashMap createShoppingCar(HashMap<String, Integer> map);

	//主页搜索vague
	List<GoodsInfo> vague(String goods_name);

	//全部查找
	List<GoodsInfo> search();
}

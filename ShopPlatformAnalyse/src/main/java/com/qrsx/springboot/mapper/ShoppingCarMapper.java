package com.qrsx.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qrsx.springboot.pojo.ShoppingCar;

/**
 * @ClassName:  ShoppingCarMapper   
 * @Description:购物车dao层实现
 * @author cjl  
 * @date 2019年12月10日    
 */
@Mapper
public interface ShoppingCarMapper {
	//根据用户id展示自己购物车信息
	public List<ShoppingCar> getAllShoppingCarInfo(Integer user_id);

	//删除购物车商品时修改商品状态
	public void deletegoods_id(Integer goods_id);
}

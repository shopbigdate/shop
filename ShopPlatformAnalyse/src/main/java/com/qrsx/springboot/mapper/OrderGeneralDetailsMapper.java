package com.qrsx.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qrsx.springboot.pojo.OrderList;

/**
 * @ClassName:  OrderGeneralDetailsMapper   
 * @Description:购物车结算接口
 * @author cjl 
 * @date 2019年12月11日   
 */
@Mapper
public interface OrderGeneralDetailsMapper {
	//用户id获取用户信息
	List<OrderList> user_iddetial(Integer user_id);

	//购物车id清空已选商品
	void shoppingcardeleteselected(Integer shopping_car_id);
}

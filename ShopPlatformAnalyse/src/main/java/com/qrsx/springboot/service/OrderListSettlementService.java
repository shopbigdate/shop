package com.qrsx.springboot.service;

import java.util.List;

import com.qrsx.springboot.pojo.OrderList;

/**
 * @ClassName:  OrderListSettlementService   
 * @Description:购物车结算业务层实现
 * @date:   2019年12月11日   
 * @author cjl
 */
public interface OrderListSettlementService {
	//用户id获取详细用户信息
	List<OrderList> user_iddetial(Integer user_id);

	//购物车id清空已选商品
	void shoppingcardeleteselected(Integer shopping_car_id);
}

package com.qrsx.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrsx.springboot.mapper.OrderGeneralDetailsMapper;
import com.qrsx.springboot.pojo.OrderList;
import com.qrsx.springboot.service.OrderListSettlementService;

/**
 * @ClassName:  OrderListSettlementServiceImpl   
 * @Description:购物车结算业务层实现
 * @author cjl  
 * @date 2019年12月11日    
 */
@Service
public class OrderListSettlementServiceImpl implements OrderListSettlementService {

	@Autowired
	OrderGeneralDetailsMapper orderGeneralDetailsMapper;

	//用户id获取用户信息
	@Override
	public List<OrderList> user_iddetial(Integer user_id) {
		return orderGeneralDetailsMapper.user_iddetial(user_id);
	}

	//购物车id清空已选商品
	@Override
	public void shoppingcardeleteselected(Integer shopping_car_id) {
		orderGeneralDetailsMapper.shoppingcardeleteselected(shopping_car_id);
	}

}

package com.qrsx.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qrsx.springboot.mapper.OrderMapper;
import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.pojo.OrderDetail;
import com.qrsx.springboot.pojo.OrderInfo;
import com.qrsx.springboot.service.OrderService;

/**
 * @ClassName:  OrderServiceImpl   
 * @Description:订单页面业务层实现
 * @author llx  
 * @date 2019年12月9日    
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderMapper orderMapper;

	//使用事务管理，插入到订单信息表和订单详情表
	@Override
	//加上注解@Transactional,就可以指定这个类需要受Spring的事务管理
	@Transactional
	public void addOrder(OrderInfo orderInfo, List<OrderDetail> orderDetail) {
		orderMapper.addOrderInfo(orderInfo);
		orderMapper.addOrderDetail(orderDetail);
	}

	//更新订单状态
	@Override
	public void updateOrderInfo(OrderInfo orderInfo) {
		orderMapper.updateOrderInfo(orderInfo);
	}

	//获取商品信息
	@Override
	public GoodsInfo selectgoods(Integer goods_id) {
		return orderMapper.selectgoods(goods_id);
	}

}

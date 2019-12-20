/**  
* <p>Title: OrderServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.qst.com</p>  
* @author llx  
* @date 2019年12月9日  
* @version 1.0  
*/
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
* <p>Title: OrderServiceImpl</p>  
* <p>Description: 订单页面的操作</p>  
* @author llx  
* @date 2019年12月9日  
*/
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderMapper orderMapper;

	/**
	 * <p>Title: addOrder</p>
	 * <p>Description: 使用事务管理，插入到订单信息表和订单详情表</p>
	 * @param orderInfo
	 * @param orderDetail
	 * @see com.qrsx.springboot.service.OrderService#addOrder(com.qrsx.springboot.pojo.OrderInfo, java.util.List)
	 */
	@Override
	//加上注解@Transactional,就可以指定这个类需要受Spring的事务管理
	@Transactional
	public void addOrder(OrderInfo orderInfo, List<OrderDetail> orderDetail) {
		orderMapper.addOrderInfo(orderInfo);
		orderMapper.addOrderDetail(orderDetail);
	}

	/** (non-Javadoc)  
	 * <p>Title: updateOrderInfo</p>  
	 * <p>Description:更新订单状态 </p>  
	 * @param orderInfo  
	 * @see com.qrsx.springboot.service.OrderService#updateOrderInfo(com.qrsx.springboot.pojo.OrderInfo) 
	 */
	@Override
	public void updateOrderInfo(OrderInfo orderInfo) {
		orderMapper.updateOrderInfo(orderInfo);
	}

	/* (non-Javadoc)  
	 * <p>Title: selectgoods</p>  
	 * <p>Description: 获取商品信息</p>  
	 * @param goods_id  
	 * @see com.qrsx.springboot.service.OrderService#selectgoods(java.lang.Integer)  
	 */
	@Override
	public GoodsInfo selectgoods(Integer goods_id) {
		return orderMapper.selectgoods(goods_id);
	}

}

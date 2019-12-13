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

import com.qrsx.springboot.mapper.OrderMapper;
import com.qrsx.springboot.pojo.OrderDetail;
import com.qrsx.springboot.pojo.OrderInfo;
import com.qrsx.springboot.service.OrderService;

/**  
* <p>Title: OrderServiceImpl</p>  
* <p>Description: </p>  
* @author llx  
* @date 2019年12月9日  
*/
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderMapper orderMapper;

	/* (non-Javadoc)  
	 * <p>Title: addOrderInfo</p>  
	 * <p>Description: </p>  
	 * @param orderInfo  
	 * @see com.qrsx.springboot.service.OrderService#addOrderInfo(com.qrsx.springboot.pojo.OrderInfo) 
	 */
	@Override
	public void addOrderInfo(OrderInfo orderInfo) {
		orderMapper.addOrderInfo(orderInfo);
	}

	/* (non-Javadoc)  
	 * <p>Title: addOrderDetail</p>  
	 * <p>Description: </p>  
	 * @param orderDetail  
	 * @see com.qrsx.springboot.service.OrderService#addOrderDetail(com.qrsx.springboot.pojo.OrderDetail) 
	 */
	@Override
	public void addOrderDetail(List<OrderDetail> orderDetail) {
		orderMapper.addOrderDetail(orderDetail);
	}

	/* (non-Javadoc)  
	 * <p>Title: updateOrderInfo</p>  
	 * <p>Description: </p>  
	 * @param orderInfo  
	 * @see com.qrsx.springboot.service.OrderService#updateOrderInfo(com.qrsx.springboot.pojo.OrderInfo) 
	 */
	@Override
	public void updateOrderInfo(OrderInfo orderInfo) {
		orderMapper.updateOrderInfo(orderInfo);
	}

}

/**  
* <p>Title: OrderService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.qst.com</p>  
* @author llx  
* @date 2019年12月9日  
* @version 1.0  
*/
package com.qrsx.springboot.service;

import java.util.List;

import com.qrsx.springboot.pojo.OrderDetail;
import com.qrsx.springboot.pojo.OrderInfo;

/**  
* <p>Title: OrderService</p>  
* <p>Description: </p>  
* @author llx  
* @date 2019年12月9日  
*/
public interface OrderService {
	void addOrderInfo(OrderInfo orderInfo);

	void addOrderDetail(List<OrderDetail> orderDetail);

	void updateOrderInfo(OrderInfo orderInfo);
}

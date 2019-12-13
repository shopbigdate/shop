/**  
* <p>Title: OrderInfoMapper.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.qst.com</p>  
* @author llx  
* @date 2019年12月10日  
* @version 1.0  
*/
package com.qrsx.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qrsx.springboot.pojo.OrderDetail;
import com.qrsx.springboot.pojo.OrderInfo;

/**  
* <p>Title: OrderInfoMapper</p>  
* <p>Description: </p>  
* @author llx  
* @date 2019年12月10日  
*/
@Mapper
public interface OrderMapper {
	void addOrderInfo(OrderInfo orderInfo);

	void addOrderDetail(List<OrderDetail> orderDetail);

	void updateOrderInfo(OrderInfo orderInfo);
}

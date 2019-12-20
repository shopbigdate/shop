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

import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.pojo.OrderDetail;
import com.qrsx.springboot.pojo.OrderInfo;

/**  
* <p>Title: OrderService</p>  
* <p>Description: 订单页面的操作</p>  
* @author llx  
* @date 2019年12月9日  
*/
public interface OrderService {

	/**
	 * <p>Title: addOrder</p>
	 * <p>Description: 使用事务管理，插入到订单信息表和订单详情表</p>
	 * @param orderInfo
	 * @param orderDetail
	 * @see com.qrsx.springboot.service.OrderService#addOrder(com.qrsx.springboot.pojo.OrderInfo, java.util.List)
	 */
	void updateOrderInfo(OrderInfo orderInfo);

	/** (non-Javadoc)  
	 * <p>Title: updateOrderInfo</p>  
	 * <p>Description:更新订单状态 </p>  
	 * @param orderInfo  
	 * @see com.qrsx.springboot.service.OrderService#updateOrderInfo(com.qrsx.springboot.pojo.OrderInfo) 
	 */
	void addOrder(OrderInfo orderInfo, List<OrderDetail> orderDetail);

	/** (non-Javadoc)  
	 * <p>Title: updateOrderInfo</p>  
	 * <p>Description:获取商品信息的服务接口 </p>  
	 * @param orderInfo  
	 * @see com.qrsx.springboot.service.OrderService#updateOrderInfo(com.qrsx.springboot.pojo.OrderInfo) 
	 */
	GoodsInfo selectgoods(Integer goods_id);
}

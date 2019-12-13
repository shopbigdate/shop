/**  
* <p>Title: OrderListSettlementService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author cjl 
* @date 2019年12月11日  
* @version 1.0  
*/
package com.qrsx.springboot.service;

import java.util.List;

import com.qrsx.springboot.pojo.OrderDetail;
import com.qrsx.springboot.pojo.UserInfo;

/**  
* <p>Title: OrderListSettlementService</p>  
* <p>Description: </p>  
* @author cjl  
* @date 2019年12月11日  
*/
public interface OrderListSettlementService {
	//购物车商品
	public List<OrderDetail> search();

	//用户id获取详细用户信息
	public List<UserInfo> user_iddetial(Integer user_id);
}

/**  
* <p>Title: OrderListSettlementServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author cjl 
* @date 2019年12月11日  
* @version 1.0  
*/
package com.qrsx.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrsx.springboot.mapper.OrderGeneralDetailsMapper;
import com.qrsx.springboot.pojo.OrderList;
import com.qrsx.springboot.service.OrderListSettlementService;

/**  
* <p>Title: OrderListSettlementServiceImpl</p>  
* <p>Description: </p>  
* @author cjl  
* @date 2019年12月11日  
*/
@Service
public class OrderListSettlementServiceImpl implements OrderListSettlementService {

	@Autowired
	OrderGeneralDetailsMapper orderGeneralDetailsMapper;

	/* (non-Javadoc)  
	 * <p>Title: user_iddetial</p>  
	 * <p>Description: 用户id获取用户信息</p>  
	 * @param user_id
	 * @return  
	 * @see com.qrsx.springboot.service.OrderListSettlementService#user_iddetial(java.lang.Integer)  
	 */
	@Override
	public List<OrderList> user_iddetial(Integer user_id) {
		return orderGeneralDetailsMapper.user_iddetial(user_id);
	}

	/* (non-Javadoc)  
	 * <p>Title: shoppingcardeleteselected</p>  
	 * <p>Description: </p>  
	 * @param shopping_car_id  
	 * @see com.qrsx.springboot.service.OrderListSettlementService#shoppingcardeleteselected(java.lang.Integer)  
	 */
	@Override
	public void shoppingcardeleteselected(Integer shopping_car_id) {
		// TODO Auto-generated method stub
		orderGeneralDetailsMapper.shoppingcardeleteselected(shopping_car_id);
	}

}

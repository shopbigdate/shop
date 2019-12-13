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
import com.qrsx.springboot.pojo.OrderDetail;
import com.qrsx.springboot.pojo.UserInfo;
import com.qrsx.springboot.service.OrderListSettlementService;

/**  
* <p>Title: OrderListSettlementServiceImpl</p>  
* <p>Description: </p>  
* @author cjl  
* @date 2019年12月11日  
*/
@Service
public class OrderListSettlementServiceImpl implements OrderListSettlementService{

	@Autowired OrderGeneralDetailsMapper orderGeneralDetailsMapper;
	/* (non-Javadoc)  
	 * <p>Title: search</p>  
	 * <p>Description: 总的商品展示</p>  
	 * @return  
	 * @see com.qrsx.springboot.service.OrderListSettlementService#search()  
	 */
	@Override
	public List<OrderDetail> search() {
		// TODO Auto-generated method stub
		return orderGeneralDetailsMapper.search();
	}
	/* (non-Javadoc)  
	 * <p>Title: detial</p>  
	 * <p>Description: </p>  
	 * @param gn
	 * @return  
	 * @see com.qrsx.springboot.service.OrderListSettlementService#detial(java.lang.Double)  
	 */
	@Override
	public List<OrderDetail> detial(Double gn) {
		// TODO Auto-generated method stub
		return orderGeneralDetailsMapper.detial(gn);
	}
	/* (non-Javadoc)  
	 * <p>Title: user_iddetial</p>  
	 * <p>Description: 用户id获取用户信息</p>  
	 * @param user_id
	 * @return  
	 * @see com.qrsx.springboot.service.OrderListSettlementService#user_iddetial(java.lang.Integer)  
	 */
	@Override
	public List<UserInfo> user_iddetial(Integer user_id) {
		// TODO Auto-generated method stub
		return orderGeneralDetailsMapper.user_iddetial( user_id);
	}
	
}

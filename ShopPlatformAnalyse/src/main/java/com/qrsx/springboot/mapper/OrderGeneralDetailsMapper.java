/**  
* <p>Title: OrderGeneralDetailsMapper.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author cjl 
* @date 2019年12月11日  
* @version 1.0  
*/
package com.qrsx.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qrsx.springboot.pojo.OrderDetail;
import com.qrsx.springboot.pojo.OrderList;
import com.qrsx.springboot.pojo.UserInfo;

/**  
* <p>Title: OrderGeneralDetailsMapper</p>  
* <p>Description: </p>  
* @author cjl  
* @date 2019年12月11日  
*/
@Mapper
public interface OrderGeneralDetailsMapper {
	//
	List<OrderDetail> search();

	//用户购物车商品
	List<OrderDetail> detial(Double gn);

	//用户id获取用户信息
	List<OrderList> user_iddetial(Integer user_id);
}

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
* <p>Description: 购物车结算接口</p>  
* @author cjl  
* @date 2019年12月11日  
*/
@Mapper
public interface OrderGeneralDetailsMapper {
	//用户id获取用户信息
	List<OrderList> user_iddetial(Integer user_id);
	
	//购物车id清空已选商品
	void shoppingcardeleteselected(Integer shopping_car_id);
}

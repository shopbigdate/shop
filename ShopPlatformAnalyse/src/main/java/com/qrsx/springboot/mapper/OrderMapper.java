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
* <p>Description:订单Dao层 </p>  
* @author llx  
* @date 2019年12月10日  
*/
@Mapper
public interface OrderMapper {
	//插入到订单信息表
	void addOrderInfo(OrderInfo orderInfo);

	//插入到订单详情表
	void addOrderDetail(List<OrderDetail> orderDetail);

	//更新订单状态
	void updateOrderInfo(OrderInfo orderInfo);
	
	//获取商品信息
	GoodsInfo selectgoods(Integer goods_id);
}

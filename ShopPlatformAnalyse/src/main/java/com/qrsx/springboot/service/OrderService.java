package com.qrsx.springboot.service;

import java.util.List;

import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.pojo.OrderDetail;
import com.qrsx.springboot.pojo.OrderInfo;

/**
 * @ClassName:  OrderService   
 * @Description:订单页面业务层实现
 * @author llx  
 * @date 2019年12月9日   
 */
public interface OrderService {

	//使用事务管理，插入到订单信息表和订单详情表
	void updateOrderInfo(OrderInfo orderInfo);

	//更新订单状态
	void addOrder(OrderInfo orderInfo, List<OrderDetail> orderDetail);

	//获取商品信息的服务接口
	GoodsInfo selectgoods(Integer goods_id);
}

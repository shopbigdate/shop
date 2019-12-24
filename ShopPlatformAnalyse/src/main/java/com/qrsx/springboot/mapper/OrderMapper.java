package com.qrsx.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.pojo.OrderDetail;
import com.qrsx.springboot.pojo.OrderInfo;

/**
 * @ClassName:  OrderMapper   
 * @Description:订单页面dao层实现
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

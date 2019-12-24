package com.qrsx.springboot.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.pojo.OrderDetail;
import com.qrsx.springboot.pojo.OrderInfo;
import com.qrsx.springboot.pojo.OrderList;
import com.qrsx.springboot.service.GoodsInfoService;
import com.qrsx.springboot.service.OrderService;
import com.qrsx.springboot.util.GetOrderId;

/**
 * @ClassName:  OrderController   
 * @Description:订单页面controller层实现
 * @date:   2019年12月11日 下午4:44:41   
 */
@RestController
public class OrderController {
	//自动连接到Service Bean
	@Autowired
	OrderService orderService;

	@Autowired
	GoodsInfoService goodsInfoService;

	@Autowired
	HttpServletRequest request;

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);

	//接收购物车存到session中的orderList数据
	@RequestMapping(value = "/getOrders", method = RequestMethod.POST)
	public OrderList getOrderList() {
		HttpSession session = request.getSession();
		OrderList orderList = (OrderList) session.getAttribute("orderList");
		return orderList;
	}

	//接收下单后的orderlist数据
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public void orderAdd(@RequestBody OrderList orderList) {
		//orderInfo
		OrderInfo orderInfo = null;
		//生成当前时间
		Date d = new Date();
		//orderId所需要的时间格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		//订单创建时间和修改时间所需要的时间格式
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderId = new GetOrderId().getId(sdf, d, orderList.getUser_id());
		HttpSession session = request.getSession();
		//清空订单信息
		session.setAttribute("orderList", null);
		session.setAttribute("orderId", orderId);
		orderInfo = new OrderInfo(orderId, orderList.getUser_id(), orderList.getConsignee_name(),
				orderList.getOrder_sum(), orderList.getOrder_status(), Timestamp.valueOf(sdf2.format(d)),
				Timestamp.valueOf(sdf2.format(d)));

		//orderDetail
		int i = 0;
		for (OrderDetail o : orderList.getOrderDetail()) {
			o.setOrder_id(orderInfo.getOrder_id());
			o.setGoods_id(orderList.getOrderDetail().get(i).getGoods_id());
			o.setGoods_number(orderList.getOrderDetail().get(i).getGoods_number());
			Double goods_price = goodsInfoService.getOneGoodsInfo(o.getGoods_id()).getGoods_price();
			o.setGoods_sum(goods_price * o.getGoods_number());

			GoodsInfo goodsinfo = orderService.selectgoods(orderList.getOrderDetail().get(i).getGoods_id());
			//统计热门商品
			log.warn("hot_goods," + orderList.getOrderDetail().get(i).getGoods_id() + "," + goodsinfo.getGoods_name()
					+ "," + goodsinfo.getGoods_category() + ",1" + ",0" + ",0000-00-00 00:00:00" + ",0" + ",0");
			i++;
		}
		//使用事务管理，插入到订单信息表和订单详情表
		orderService.addOrder(orderInfo, orderList.getOrderDetail());
	}

	//在前端确认支付后，跳到这里进行修改orderInfo表的状态和时间
	@RequestMapping(value = "/updateOrders", method = RequestMethod.POST)
	public void orderUpdate(@RequestBody OrderList orderList) {
		OrderInfo orderInfo = null;
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String id = (String) request.getSession().getAttribute("orderId");
		orderInfo = new OrderInfo(id, orderList.getUser_id(), orderList.getConsignee_name(), orderList.getOrder_sum(),
				orderList.getOrder_status(), Timestamp.valueOf(sdf2.format(d)), Timestamp.valueOf(sdf2.format(d)));
		//统计订单信息
		log.warn("order," + orderInfo.getOrder_id() + ",0" + ",0" + ",0," + orderInfo.getOrder_sum() + ","
				+ orderInfo.getOrder_status() + "," + orderInfo.getUpdate_time() + "," + orderInfo.getConsignee_name());
		//更新订单状态，点击立即下单，订单状态为1；点击确认支付，订单状态为2；点击取消支付，订单状态为3。
		orderService.updateOrderInfo(orderInfo);
	}

}

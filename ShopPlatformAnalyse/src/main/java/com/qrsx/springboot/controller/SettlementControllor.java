package com.qrsx.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qrsx.springboot.pojo.OrderList;
import com.qrsx.springboot.pojo.ShoppingCar;
import com.qrsx.springboot.pojo.UserInfo;
import com.qrsx.springboot.service.OrderListSettlementService;

/**
 * @ClassName:  SettlementControllor   
 * @Description:购物车结算controller层实现
 * @date:   2019年12月11日 下午4:44:41   
 * @author cjl  
 */
@RestController
@RequestMapping("/SettlementControllor")
public class SettlementControllor {
	@Autowired
	OrderListSettlementService orderListSettlementService;
	@Autowired
	HttpServletRequest request;

	//结算购物车打包数据给订单详细
	@RequestMapping(value = "/OrderDetial", method = RequestMethod.POST)
	public OrderList shoppingcar_orderdetial(@RequestBody OrderList orderList) {
		HttpSession session = request.getSession();
		UserInfo us = (UserInfo) session.getAttribute("UserInfo");
		orderList.setUser_id(us.getUserId());
		orderList.setOrder_status("1");
		//收货人姓名默认为自己
		orderList.setConsignee_name(us.getUserName());
		orderList.setUser_phone(us.getUserPhone());
		orderList.setUser_address(us.getUserAddress());
		session.setAttribute("orderList", orderList);
		return orderList;
	}

	//通过shoppingid清空已选数据
	@RequestMapping(value = "/Delete_Selected", method = RequestMethod.POST)
	public void shoppingcar_delete_selected(@RequestBody ShoppingCar shoppingCar) {
		orderListSettlementService.shoppingcardeleteselected(shoppingCar.getShopping_car_id());
	}

}

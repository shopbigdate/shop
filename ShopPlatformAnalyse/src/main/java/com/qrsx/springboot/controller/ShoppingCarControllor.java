package com.qrsx.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qrsx.springboot.pojo.ShoppingCar;
import com.qrsx.springboot.pojo.UserInfo;
import com.qrsx.springboot.service.ShoppingCarService;

/**
 * @ClassName:  ShoppingCarControllor   
 * @Description:购物车controller层实现
 * @author cjl
 * @date 2019年12月10日 
 */
@RestController
@RequestMapping("/ShoppingCarControllor")
public class ShoppingCarControllor {
	@Autowired
	ShoppingCarService shoppingCarService;

	@Autowired
	HttpServletRequest request;

	//根据用户id展示自己购物车信息
	@RequestMapping(value = "/getAllShoppingCarInfo", method = RequestMethod.POST)
	public List<ShoppingCar> getAllShoppingCarInfo() {
		HttpSession session = request.getSession();
		UserInfo us = (UserInfo) session.getAttribute("UserInfo");
		if (us == null) {
			return null;
		} else {
			return shoppingCarService.getAllShoppingCarInfo(us.getUserId());
		}
	}

	//删除购物车商品时修改商品状态
	@RequestMapping(value = "/deletegoods_id", method = RequestMethod.POST)
	public void object(@RequestBody ShoppingCar shoppingCar) {
		shoppingCar.getGoods_id();
		shoppingCarService.deletegoods_id(shoppingCar.getGoods_id());
	}
}

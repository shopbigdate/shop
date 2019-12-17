/**  
* <p>Title: SettlementControllor.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author cjl 
* @date 2019年12月11日  
* @version 1.0  
*/
package com.qrsx.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.qrsx.springboot.pojo.OrderDetail;
import com.qrsx.springboot.pojo.OrderList;
import com.qrsx.springboot.pojo.UserInfo;
import com.qrsx.springboot.service.OrderListSettlementService;

/**
 * <p>
 * Title: SettlementControllor
 * </p>
 * <p>
 * Description: 结算购物车控制
 * </p>
 * 
 * @author cjl
 * @date 2019年12月11日
 */
@RestController
@RequestMapping("/SettlementControllor")
public class SettlementControllor {
	@Autowired
	OrderListSettlementService orderListSettlementService;
	@Autowired
	HttpServletRequest request;
	/**
	 * 
	 * <p>
	 * Title: search
	 * </p>
	 * <p>
	 * Description:
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@GetMapping("/liusuan1")
	public List<OrderDetail> search() {
		return orderListSettlementService.search();
	}
	/**
	 * 
	 * <p>
	 * Title: object
	 * </p>
	 * <p>
	 * Description: 结算购物车打包数据给订单详细
	 * </p>
	 * 
	 * @param orderList
	 * @return
	 */
	@RequestMapping(value = "/OrderDetial", method = RequestMethod.POST)
	public OrderList shoppingcar_orderdetial(@RequestBody OrderList orderList) {
		HttpSession session = request.getSession();
		UserInfo us = (UserInfo) session.getAttribute("UserInfo");
		//List<OrderList> orderlist2=orderListSettlementService.user_iddetial(us.getUserId());
		
		orderList.setUser_id(us.getUserId());
		orderList.setOrder_status("1");
		orderList.setConsignee_name(us.getUserName());
		orderList.setUser_phone(us.getUserPhone());
		orderList.setUser_address(us.getUserAddress());
	
//      session.setAttribute("consignee_name", "jiyang");
//		session.setAttribute("order_status", "1");
//		//session里有UserInfo
//		String orderstatus = session.getAttribute("order_status").toString();
//      String consigneename = session.getAttribute("consignee_name").toString();
//		UserInfo us = (UserInfo) session.getAttribute("UserInfo");
//		orderList.setUser_id(us.getUserId());
//		orderList.setOrder_status(orderstatus);
//		orderList.setConsignee_name(consigneename);
//		orderList.setUser_phone(us.getUserPhone());
//		orderList.setUser_address(us.getUserAddress());
        session.setAttribute("orderList", orderList);

		return orderList;
	}
}

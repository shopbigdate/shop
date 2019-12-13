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
import com.qrsx.springboot.service.OrderListSettlementService;


/**  
* <p>Title: SettlementControllor</p>  
* <p>Description:
* 结算购物车控制
*  </p>  
* @author cjl  
* @date 2019年12月11日  
*/
@RestController
@RequestMapping("/aa")
public class SettlementControllor {
	@Autowired OrderListSettlementService orderListSettlementService;
	@Autowired HttpServletRequest request;

	/**
	 * 
	 * <p>Title: search</p>  
	 * <p>Description:
	 * 
	 *  </p>  
	 * @return
	 */
    @GetMapping("/liusuan1")
    public List<OrderDetail> search(){
        return orderListSettlementService.search();
    }

    /**
     * 
     * <p>Title: object</p>  
     * <p>Description:
     *  结算购物车打包数据给订单详细
     * </p>  
     * @param orderList
     * @return
     */
    @RequestMapping(value="/liusuan2", method = RequestMethod.POST)
    //List<OrderDetail>
    public OrderList object (@RequestBody OrderList orderList){ 	
//    	System.out.print(orderList.getOrder_sum()+"liusuan");
//    	System.out.print(orderList.getOrderDetail()+"cjldd");
//    	System.out.print("==============================");
    	HttpSession session = request.getSession();
    	session.setAttribute("user_id",1);
    	session.setAttribute("consignee_name","jiyang");
    	session.setAttribute("order_status",1);
    	
    	session.setAttribute("user_phone","1231321");
    	session.setAttribute("user_adress","adsdas");
    	
    	Integer userid=(Integer) session.getAttribute("user_id");
    	Integer orderstatus=(Integer) session.getAttribute("order_status");
    	String consigneename=session.getAttribute("consignee_name").toString();
    	String userphone=session.getAttribute("user_phone").toString();
    	String useradress=session.getAttribute("user_adress").toString();
    	
    	orderList.setUser_id(userid);
    	orderList.setConsignee_name(consigneename);
    	orderList.setUser_phone(userphone);
    	orderList.setUser_address(useradress);
    	
    	System.out.print(orderList);
    	System.out.print(orderList.getUser_address());
    	
    	session.setAttribute("orderList",orderList);
    	
		return  orderList;
    }

        
//    @RequestMapping(value ="/orders", method = RequestMethod.POST)
//    public void orderAdd(@RequestBody OrderList orderList){
//		//orderInfo
//		OrderInfo orderInfo = null;
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String orderId = sdf.format(d)+"-"+orderList.getUser_id();
//		HttpSession session = request.getSession();
//		session.setAttribute("orderId", orderId);
//		orderInfo=new OrderInfo(orderId,orderList.getUser_id(),
//				orderList.getConsignee_name(),orderList.getOrder_sum(),
//				orderList.getOrder_status(),Timestamp.valueOf(sdf2.format(d)),Timestamp.valueOf(sdf2.format(d)));
//		orderService.addOrderInfo(orderInfo);
//		
//		//orderDetail
//		List<OrderDetail> orderDetail = null;
//		int i = 0;
//		for(OrderDetail o : orderList.getOrderDetail()) {
//			o.setOrder_id(orderInfo.getOrder_id());
//			o.setGoods_id(orderList.getOrderDetail().get(i).getGoods_id());
//			o.setGoods_number(orderList.getOrderDetail().get(i).getGoods_number());
//			Double goods_price =  goodsInfoService.getOneGoodsInfo(o.getGoods_id()).getGoods_price();
//			o.setGoods_sum(goods_price*o.getGoods_number());
//			orderService.addOrderDetail(o);
//			i++;
//		}
//    }


}

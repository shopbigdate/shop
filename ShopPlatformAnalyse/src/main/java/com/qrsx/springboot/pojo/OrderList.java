/**  
* <p>Title: OrderList.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.qst.com</p>  
* @author llx  
* @date 2019年12月10日  
* @version 1.0  
*/
package com.qrsx.springboot.pojo;

import java.util.List;

/**  
* <p>Title: OrderList</p>  
* <p>Description: 用来接收前端传来的json数据的一个pojo类，未和数据库对应</p>  
* @author llx  
* @date 2019年12月10日  
*/
public class OrderList {
	//订单详情
	private List<OrderDetail> orderDetail;
	//用户编号
	private Integer user_id;
	//订单合计金额
	private Double order_sum;
	//收货人姓名
	private String consignee_name;
	//订单状态
	private String order_status;
	//   1
	//用户手机
	private String user_phone;
	//收货地址
	private String user_address;

	public Double getOrder_sum() {
		return order_sum;
	}

	public void setOrder_sum(Double order_sum) {
		this.order_sum = order_sum;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getConsignee_name() {
		return consignee_name;
	}

	public void setConsignee_name(String consignee_name) {
		this.consignee_name = consignee_name;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public OrderList(List<OrderDetail> orderDetail, Integer user_id, Double order_sum, String consignee_name,
			String order_status, String user_phone, String user_address) {
		super();
		this.orderDetail = orderDetail;
		this.user_id = user_id;
		this.order_sum = order_sum;
		this.consignee_name = consignee_name;
		this.order_status = order_status;
		this.user_phone = user_phone;
		this.user_address = user_address;
	}

	public OrderList() {
		super();
	}

}

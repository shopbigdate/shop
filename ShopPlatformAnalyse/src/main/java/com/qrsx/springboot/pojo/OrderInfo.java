/**  
* <p>Title: OrderInfo.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.qst.com</p>  
* @author llx  
* @date 2019年12月9日  
* @version 1.0  
*/
package com.qrsx.springboot.pojo;

import java.sql.Timestamp;

/**  
* <p>Title: OrderInfo</p>  
* <p>Description:订单信息表 ，和数据库对应</p>  
* @author llx  
* @date 2019年12月9日  
*/
public class OrderInfo {
	//订单编号
	private String order_id;
	//用户编号
	private Integer user_id;
	//收货人姓名
	private String consignee_name;
	//订单合订金额
	private Double order_sum;
	//订单状态
	private String order_status;
	//订单创建时间
	private Timestamp create_time;
	//订单状态修改时间
	private Timestamp update_time;

	public OrderInfo() {
		super();
	}

	public OrderInfo(String order_id, Integer user_id, String consignee_name, Double order_sum, String order_status,
			Timestamp create_time, Timestamp update_time) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.consignee_name = consignee_name;
		this.order_sum = order_sum;
		this.order_status = order_status;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
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

	public Double getOrder_sum() {
		return order_sum;
	}

	public void setOrder_sum(Double order_sum) {
		this.order_sum = order_sum;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "OrderInfo [order_id=" + order_id + ", user_id=" + user_id + ", consignee_name=" + consignee_name
				+ ", order_sum=" + order_sum + ", order_status=" + order_status + ", create_time=" + create_time
				+ ", update_time=" + update_time + "]";
	}

}

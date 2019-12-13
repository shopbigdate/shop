/**  
* <p>Title: OrderDetail.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.qst.com</p>  
* @author llx  
* @date 2019年12月9日  
* @version 1.0  
*/  
package com.qrsx.springboot.pojo;
/**  
* <p>Title: OrderDetail</p>  
* <p>Description:订单详情表的pojo类，和数据库对应 </p>  
* @author llx  
* @date 2019年12月9日  
*/
public class OrderDetail {
	//订单编号
	private String order_id;
	//商品编号
	private Integer goods_id;
	//购买数量
	private Integer goods_number;
	//商品总金额
	private Double goods_sum;
	//商品名称
	private String goods_name;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(Integer goods_number) {
		this.goods_number = goods_number;
	}
	public Double getGoods_sum() {
		return goods_sum;
	}
	public void setGoods_sum(Double goods_sum) {
		this.goods_sum = goods_sum;
	}
	
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	@Override
	public String toString() {
		return "OrderDetail [order_id=" + order_id + ", goods_id=" + goods_id + ", goods_number=" + goods_number
				+ ", goods_sum=" + goods_sum + "]";
	}	
	
}

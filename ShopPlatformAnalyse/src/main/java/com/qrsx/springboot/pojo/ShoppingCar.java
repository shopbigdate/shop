/**  
* <p>Title: ShoppingCar.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author cjl 
* @date 2019年12月10日  
* @version 1.0  
*/  
package com.qrsx.springboot.pojo;

/**  
* <p>Title: ShoppingCar</p>  
* <p>Description: 购物车商品属性</p>  
* @author cjl  
* @date 2019年12月10日  
*/

public class ShoppingCar {
	private int shopping_car_id;
	private int goods_id;
	private String goods_name;
	private Double goods_price;
	private Integer goods_number;
	private boolean isbuy;
	private int isshow;
	
	public int getIsshow() {
		return isshow;
	}
	public void setIsshow(int isshow) {
		this.isshow = isshow;
	}
	public int getShopping_car_id() {
		return shopping_car_id;
	}
	public void setShopping_car_id(int shopping_car_id) {
		this.shopping_car_id = shopping_car_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public Double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
	}
	public Integer getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(Integer goods_number) {
		this.goods_number = goods_number;
	}
	public boolean isIsbuy() {
		return isbuy;
	}
	public void setIsbuy(boolean isbuy) {
		this.isbuy = isbuy;
	}
	public ShoppingCar(int shopping_car_id, String goods_name, Double goods_price, Integer goods_number,
			boolean isbuy) {
		super();
		this.shopping_car_id = shopping_car_id;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.goods_number = goods_number;
		this.isbuy = isbuy;
	}
	public ShoppingCar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	
	
//private int shopping_car_id;
//private int user_id;
//private int goods_id;
//private int goods_number;
//private boolean isbuy;
//
//public int getShopping_car_id() {
//	return shopping_car_id;
//}
//public void setShopping_car_id(int shopping_car_id) {
//	this.shopping_car_id = shopping_car_id;
//}
//public int getUser_id() {
//	return user_id;
//}
//public void setUser_id(int user_id) {
//	this.user_id = user_id;
//}
//public int getGoods_id() {
//	return goods_id;
//}
//public void setGoods_id(int goods_id) {
//	this.goods_id = goods_id;
//}
//public int getGoods_number() {
//	return goods_number;
//}
//public void setGoods_number(int goods_number) {
//	this.goods_number = goods_number;
//}
//@Override
//public String toString() {
//	return "Shopping_Car [shopping_car_id=" + shopping_car_id + ", user_id=" + user_id + ", goods_id=" + goods_id
//			+ ", goods_number=" + goods_number + "]";
//}
//public Shopping_Car(int shopping_car_id, int user_id, int goods_id, int goods_number) {
//	super();
//	this.shopping_car_id = shopping_car_id;
//	this.user_id = user_id;
//	this.goods_id = goods_id;
//	this.goods_number = goods_number;
//}
//public Shopping_Car() {
//	super();
//	// TODO Auto-generated constructor stub
//}
//public boolean isIsbuy() {
//	return isbuy;
//}
//public void setIsbuy(boolean isbuy) {
//	this.isbuy = isbuy;
//}




}

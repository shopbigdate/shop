package com.qrsx.springboot.pojo;

/**
 * 
 * @ClassName:  ShoppingCar   
 * @Description:购物车表的pojo类   
 * @author: 姜振楠
 * @date:   2019年12月11日 下午4:26:10   
 *     
 */
public class ShoppingCar {
	//购物车id
	private Integer shopping_car_id;
	//用户id
	private Integer user_id;
	//商品id
	private Integer goods_id;
	//商品名
	private String goods_name;
	//商品价格
	private Double goods_price;
	//商品数量
	private Integer goods_number;
	//选中selected状态
	private Boolean isbuy;
	//购物车商品展示状态
	private Integer isshow;

	//getset方法
	public Integer getShopping_car_id() {
		return shopping_car_id;
	}

	public void setShopping_car_id(Integer shopping_car_id) {
		this.shopping_car_id = shopping_car_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
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

	public Boolean getIsbuy() {
		return isbuy;
	}

	public void setIsbuy(Boolean isbuy) {
		this.isbuy = isbuy;
	}

	public Integer getIsshow() {
		return isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}
}

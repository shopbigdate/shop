package com.qrsx.springboot.pojo;

/**
 * 
 * @ClassName:  GoodsInfo   
 * @Description:商品详情表
 * @author: 姜振楠
 * @date:   2019年12月11日 下午4:24:37   
 *     
 */
public class GoodsInfo {
	//商品id
	private Integer goods_id;
	//商品名
	private String goods_name;
	//商品价格
	private Double goods_price;
	//商品库存
	private Integer goods_store;
	//商品详情
	private String goods_detail;
	//商店名
	private String goods_shop;
	//商品种类
	private String goods_category;

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

	public Integer getGoods_store() {
		return goods_store;
	}

	public void setGoods_store(Integer goods_store) {
		this.goods_store = goods_store;
	}

	public String getGoods_detail() {
		return goods_detail;
	}

	public void setGoods_detail(String goods_detail) {
		this.goods_detail = goods_detail;
	}

	public String getGoods_shop() {
		return goods_shop;
	}

	public void setGoods_shop(String goods_shop) {
		this.goods_shop = goods_shop;
	}

	public String getGoods_category() {
		return goods_category;
	}

	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}

}

package com.qrsx.springboot.pojo;

/**
 * 
 * @ClassName:  GoodsPicture   
 * @Description:商品图片表
 * @author: 姜振楠
 * @date:   2019年12月11日 下午4:25:36   
 *     
 */
public class GoodsPicture {
	//商品照片id
	private Integer picture_id;
	//商品id
	private Integer goods_id;
	//商品照片地址
	private String picture_path;

	public Integer getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(Integer picture_id) {
		this.picture_id = picture_id;
	}

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public String getPicture_path() {
		return picture_path;
	}

	public void setPicture_path(String picture_path) {
		this.picture_path = picture_path;
	}

}

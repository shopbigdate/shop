package com.qrsx.springboot.pojo;

/**
 * 
 * @ClassName:  GoodsPicture   
 * @Description:商品图片的pojo类
 * @author: 姜振楠
 * @date:   2019年12月11日 下午4:25:36   
 *     
 */
public class GoodsPicture {
	private Integer picture_id;
	private Integer goods_id;
	private String picture_path;
	/**  
	 * @Title:  getPicture_id <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getPicture_id() {
		return picture_id;
	}
	/**  
	 * @Title:  setPicture_id <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setPicture_id(Integer picture_id) {
		this.picture_id = picture_id;
	}
	/**  
	 * @Title:  getGoods_id <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getGoods_id() {
		return goods_id;
	}
	/**  
	 * @Title:  setGoods_id <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	/**  
	 * @Title:  getPicture_path <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public String getPicture_path() {
		return picture_path;
	}
	/**  
	 * @Title:  setPicture_path <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setPicture_path(String picture_path) {
		this.picture_path = picture_path;
	}
	public GoodsPicture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoodsPicture(Integer picture_id, Integer goods_id, String picture_path) {
		super();
		this.picture_id = picture_id;
		this.goods_id = goods_id;
		this.picture_path = picture_path;
	}
	

	

}

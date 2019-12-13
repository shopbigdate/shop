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
	private Integer user_id;
	private Integer goods_id;
	private Integer goods_number;
	private Integer isbuy;
	private Integer isshow;

	/**  
	 * @Title:  getIsbuy <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getIsbuy() {
		return isbuy;
	}

	/**  
	 * @Title:  setIsbuy <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setIsbuy(Integer isbuy) {
		this.isbuy = isbuy;
	}

	/**  
	 * @Title:  getIsshow <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getIsshow() {
		return isshow;
	}

	/**  
	 * @Title:  setIsshow <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	/**  
	 * @Title:  getUser_id <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getUser_id() {
		return user_id;
	}

	/**  
	 * @Title:  setUser_id <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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
	 * @Title:  getGoods_number <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getGoods_number() {
		return goods_number;
	}

	/**  
	 * @Title:  setGoods_number <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setGoods_number(Integer goods_number) {
		this.goods_number = goods_number;
	}

	public ShoppingCar() {
		super();
	}

	public ShoppingCar(Integer user_id, Integer goods_id, Integer goods_number, Integer isbuy, Integer isshow) {
		super();
		this.user_id = user_id;
		this.goods_id = goods_id;
		this.goods_number = goods_number;
		this.isbuy = isbuy;
		this.isshow = isshow;
	}

}

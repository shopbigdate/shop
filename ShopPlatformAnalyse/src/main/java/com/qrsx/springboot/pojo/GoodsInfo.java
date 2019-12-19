package com.qrsx.springboot.pojo;

/**
 * 
 * @ClassName:  GoodsInfo   
 * @Description:商品详情的pojo类
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
	 * @Title:  getGoods_name <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getGoods_name() {
		return goods_name;
	}

	/**  
	 * @Title:  setGoods_name <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	/**  
	 * @Title:  getGoods_price <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Double <BR>  
	 */
	public Double getGoods_price() {
		return goods_price;
	}

	/**  
	 * @Title:  setGoods_price <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Double <BR>  
	 */
	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
	}

	/**  
	 * @Title:  getGoods_store <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getGoods_store() {
		return goods_store;
	}

	/**  
	 * @Title:  setGoods_store <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setGoods_store(Integer goods_store) {
		this.goods_store = goods_store;
	}

	/**  
	 * @Title:  getGoods_detail <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getGoods_detail() {
		return goods_detail;
	}

	/**  
	 * @Title:  setGoods_detail <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setGoods_detail(String goods_detail) {
		this.goods_detail = goods_detail;
	}

	/**  
	 * @Title:  getGoods_shop <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getGoods_shop() {
		return goods_shop;
	}

	/**  
	 * @Title:  setGoods_shop <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setGoods_shop(String goods_shop) {
		this.goods_shop = goods_shop;
	}

	/**  
	 * @Title:  getGoods_category <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getGoods_category() {
		return goods_category;
	}

	/**  
	 * @Title:  setGoods_category <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}

	public GoodsInfo() {
		super();
	}

	public GoodsInfo(Integer goods_id, String goods_name, Double goods_price, Integer goods_store, String goods_detail,
			String goods_shop, String goods_category) {
		super();
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.goods_store = goods_store;
		this.goods_detail = goods_detail;
		this.goods_shop = goods_shop;
		this.goods_category = goods_category;
	}

}

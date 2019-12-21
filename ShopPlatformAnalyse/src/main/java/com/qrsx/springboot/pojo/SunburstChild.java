package com.qrsx.springboot.pojo;

/**   
 * @ClassName:  SunburstChild   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 姜振楠
 * @date:   2019年12月20日 下午7:25:20   
 *     
 * @Copyright: 2019 www.tydic.com Inc. All rights reserved. 
 * 注意：本内容仅限于自己传阅，禁止外泄以及用于其他的商业目 
 */
public class SunburstChild {
	private String name;
	private Integer value;
	/**  
	 * @Title:  getName <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public String getName() {
		return name;
	}
	/**  
	 * @Title:  setName <BR>  
	 * @Description: please write your description <BR>  
	 * @return: String <BR>  
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**  
	 * @Title:  getValue <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public Integer getValue() {
		return value;
	}
	/**  
	 * @Title:  setValue <BR>  
	 * @Description: please write your description <BR>  
	 * @return: Integer <BR>  
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
	public SunburstChild(String name, Integer value) {
		super();
		this.name = name;
		this.value = value;
	}
	public SunburstChild() {
		super();
	
	}
	

}

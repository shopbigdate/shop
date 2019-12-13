/**  
* <p>Title: Shopping_Car_Service.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author cjl 
* @date 2019年12月10日  
* @version 1.0  
*/  
package com.qrsx.springboot.service;

import java.util.List;

import com.qrsx.springboot.pojo.ShoppingCar;


/**  
* <p>Title: Shopping_Car_Service</p>  
* <p>Description: </p>  
* @author cjl  
* @date 2019年12月10日  
*/

public interface ShoppingCarService {
	public List<ShoppingCar> search();
	public List<ShoppingCar> getAllShoppingCarInfo(Integer user_id);
	public void deletegoods_id(Integer goods_id);
}

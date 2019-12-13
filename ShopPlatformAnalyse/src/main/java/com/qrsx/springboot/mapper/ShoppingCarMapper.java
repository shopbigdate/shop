/**  
* <p>Title: Shopping_Car_Mapper.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author cjl 
* @date 2019年12月10日  
* @version 1.0  
*/  
package com.qrsx.springboot.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qrsx.springboot.pojo.ShoppingCar;

/**  
* <p>Title: Shopping_Car_Mapper</p>  
* <p>Description: </p>  
* @author cjl  
* @date 2019年12月10日  
*/
@Mapper
public interface ShoppingCarMapper {
	public List<ShoppingCar> search();
	public List<ShoppingCar> getAllShoppingCarInfo(Integer user_id);
	public void deletegoods_id(Integer goods_id);
}

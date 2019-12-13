/**  
* <p>Title: Shopping_Car_Controllor.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author cjl 
* @date 2019年12月10日  
* @version 1.0  
*/
package com.qrsx.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qrsx.springboot.pojo.ShoppingCar;
import com.qrsx.springboot.service.ShoppingCarService;

/**  
* <p>Title: Shopping_Car_Controllor</p>  
* <p>Description: 
* 购物车控制
* </p>  
* @author cjl  
* @date 2019年12月10日  
*/
@RestController
@RequestMapping("/ShoppingCarControllor")
public class ShoppingCarControllor {
	@Autowired
	ShoppingCarService shoppingCarService;

	/**
	 * 
	 * <p>Title: search</p>  
	 * <p>Description: 
	 * 购物车商品展示
	 * </p>  
	 * @return
	 */
	@GetMapping("/searchshoppingcar")
	public List<ShoppingCar> search() {
		return shoppingCarService.search();
	}

	/**
	 * 
	 * <p>Title: getAllShoppingCarInfo</p>  
	 * <p>Description: 
	 * 根据用户id展示自己购物车信息
	 * </p>  
	 * @param user_id
	 * @return
	 */
	@GetMapping("/getAllShoppingCarInfo")
	public List<ShoppingCar> getAllShoppingCarInfo(@RequestParam("user_id") Integer user_id) {
		return shoppingCarService.getAllShoppingCarInfo(user_id);
	}

	/**
	 * 
	 * <p>Title: object</p>  
	 * <p>Description: 
	 * 删除购物车商品时修改商品状态
	 * </p>  
	 * @param shoppingCar
	 */
	@RequestMapping(value = "/deletegoods_id", method = RequestMethod.POST)
	//List<OrderDetail>
	public void object(@RequestBody ShoppingCar shoppingCar) {
		shoppingCar.getGoods_id();
		System.out.print(shoppingCar.getGoods_id() + "dasjldk");
		shoppingCarService.deletegoods_id(shoppingCar.getGoods_id());
	}
}

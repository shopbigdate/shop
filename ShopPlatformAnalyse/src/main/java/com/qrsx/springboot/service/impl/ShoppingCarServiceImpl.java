/**  
* <p>Title: Shopping_Car_ServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author cjl 
* @date 2019年12月10日  
* @version 1.0  
*/
package com.qrsx.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrsx.springboot.mapper.ShoppingCarMapper;
import com.qrsx.springboot.pojo.ShoppingCar;
import com.qrsx.springboot.service.ShoppingCarService;

/**  
* <p>Title: Shopping_Car_ServiceImpl</p>  
* <p>Description: 购物车服务层接口实现</p>  
* @author cjl  
* @date 2019年12月10日  
*/
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
	@Autowired
	ShoppingCarMapper shoppingCarMapper;

	/* (non-Javadoc)  
	 * <p>Title: getAllShoppingCarInfo</p>  
	 * <p>Description: 根据用户id展示自己购物车信息</p>  
	 * @param user_id
	 * @return  
	 * @see com.qrsx.springboot.service.Shopping_Car_Service#getAllShoppingCarInfo(java.lang.Integer)  
	 */
	@Override
	public List<ShoppingCar> getAllShoppingCarInfo(Integer user_id) {
		return shoppingCarMapper.getAllShoppingCarInfo(user_id);
	}

	/* (non-Javadoc)  
	 * <p>Title: deletegoods_id</p>  
	 * <p>Description: 删除购物车商品时修改商品状态</p>  
	 * @param goods_id  
	 * @see com.qrsx.springboot.service.ShoppingCarService#deletegoods_id(java.lang.Integer)  
	 */
	@Override
	public void deletegoods_id(Integer goods_id) {
		shoppingCarMapper.deletegoods_id(goods_id);
	}

}

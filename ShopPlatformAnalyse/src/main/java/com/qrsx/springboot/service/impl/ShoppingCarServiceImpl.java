package com.qrsx.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrsx.springboot.mapper.ShoppingCarMapper;
import com.qrsx.springboot.pojo.ShoppingCar;
import com.qrsx.springboot.service.ShoppingCarService;

/**
 * @ClassName:  ShoppingCarServiceImpl   
 * @Description:购物车业务层实现
 * @author cjl  
 * @date 2019年12月10日 
 */
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
	@Autowired
	ShoppingCarMapper shoppingCarMapper;

	//根据用户id展示自己购物车信息
	@Override
	public List<ShoppingCar> getAllShoppingCarInfo(Integer user_id) {
		return shoppingCarMapper.getAllShoppingCarInfo(user_id);
	}

	//删除购物车商品时修改商品状态
	@Override
	public void deletegoods_id(Integer goods_id) {
		shoppingCarMapper.deletegoods_id(goods_id);
	}

}

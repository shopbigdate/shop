package com.qrsx.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.pojo.GoodsPicture;
import com.qrsx.springboot.pojo.ShoppingCar;
import com.qrsx.springboot.service.GoodsInfoService;

/**
 * 
 * @ClassName:  GoodsController   
 * @Description:商品详情的控制层
 * @author: 姜振楠
 * @date:   2019年12月11日 下午4:17:40   
 *     
 */
//RestController使用的效果是将方法返回的对象直接在浏览器上展示成json格式
@RestController
public class GoodsInfoController {
	@Autowired
	GoodsInfoService goodsInfoService;

	@GetMapping("/vague")
	public List<GoodsInfo> vague(String goods_name) {
		return goodsInfoService.vague(goods_name);
	}

	/**
	 * 
	 * @Title: getOneGoodsInfo   
	 * @Description: 获取商品信息
	 * @param: @param goods_info
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: GoodsInfo      
	 * @throws
	 */
	@RequestMapping(value = "/goodsinfo", method = RequestMethod.POST)
	public GoodsInfo getOneGoodsInfo(@RequestBody GoodsInfo goods_info) throws Exception {
		return goodsInfoService.getOneGoodsInfo(goods_info.getGoods_id());
	}

	/**
	 * 
	 * @Title: getOneGoodsPicture   
	 * @Description: 获取商品的图片信息   
	 * @param: @param goods_picture
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<GoodsPicture>      
	 * @throws
	 */
	@RequestMapping(value = "/goodspicture", method = RequestMethod.POST)
	public List<GoodsPicture> getOneGoodsPicture(@RequestBody GoodsPicture goods_picture) throws Exception {
		return goodsInfoService.getOneGoodsPicture(goods_picture.getGoods_id());
	}

	/**
	 * 
	 * @Title: createShoppingCar   
	 * @Description: 创建或修改购物车表的信息   
	 * @param: @param shopping_car
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: Integer      
	 * @throws
	 */
	@RequestMapping(value = "/createShoppingCar", method = RequestMethod.POST)
	public Integer createShoppingCar(@RequestBody ShoppingCar shopping_car) throws Exception {
		return goodsInfoService.createShoppingCar(shopping_car);
	}

}

package com.qrsx.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qrsx.springboot.pojo.GoodsInfo;
import com.qrsx.springboot.pojo.GoodsPicture;
import com.qrsx.springboot.pojo.ShoppingCar;
import com.qrsx.springboot.pojo.UserInfo;
import com.qrsx.springboot.service.GoodsInfoService;

/**
 * @ClassName:  GoodsController   
 * @Description:商品详情的控制层
 * @author: 姜振楠
 * @date:   2019年12月11日 下午4:17:40   
 */
//RestController使用的效果是将方法返回的对象直接在浏览器上展示成json格式
@RestController
@RequestMapping("goods")
public class GoodsInfoController {
	@Autowired
	GoodsInfoService goodsInfoService;

	//全部查找
	@GetMapping("/search")
	public List<GoodsInfo> search() {
		return goodsInfoService.search();
	}

	//主页搜索
	@GetMapping("/vague")
	public List<GoodsInfo> vague(String goods_name) {
		return goodsInfoService.vague(goods_name);
	}

	//获取商品信息
	@RequestMapping(value = "/goodsinfo", method = RequestMethod.POST)
	public GoodsInfo getOneGoodsInfo(@RequestBody GoodsInfo goods_info) throws Exception {
		return goodsInfoService.getOneGoodsInfo(goods_info.getGoods_id());
	}

	//获取商品的图片信息 
	@RequestMapping(value = "/goodspicture", method = RequestMethod.POST)
	public List<GoodsPicture> getOneGoodsPicture(@RequestBody GoodsPicture goods_picture) throws Exception {
		return goodsInfoService.getOneGoodsPicture(goods_picture.getGoods_id());
	}

	//创建或修改购物车表的信息
	@RequestMapping(value = "/createShoppingCar", method = RequestMethod.POST)
	public Integer createShoppingCar(@RequestBody ShoppingCar shopping_car) throws Exception {
		return goodsInfoService.createShoppingCar(shopping_car);
	}

	//添加购物车未登录提示
	@RequestMapping(value = "/getUserSession")
	public UserInfo getUserSession(HttpSession session) throws Exception {
		return (UserInfo) session.getAttribute("UserInfo");
	}

	//若已登录显示用户名
	@RequestMapping(value = "/getUserName")
	public String getUserName(HttpSession session) throws Exception {
		UserInfo userinfo = (UserInfo) session.getAttribute("UserInfo");
		return userinfo == null ? "" : userinfo.getUserName();
	}
}

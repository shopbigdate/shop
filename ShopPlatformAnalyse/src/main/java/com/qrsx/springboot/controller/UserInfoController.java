package com.qrsx.springboot.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qrsx.springboot.pojo.UserInfo;
import com.qrsx.springboot.service.UserInfoService;
import com.qrsx.springboot.util.Md5Util;

/**
 * @ClassName: UserInfoController
 * @Description:用户信息controller层实现
 * @author zsd
 * @date 2019年12月11日
 */
@RestController
@RequestMapping("user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	//登录
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Boolean login(@RequestBody UserInfo userInfo, HttpSession session) {
		//使用MD5对密码加密
		String pass = null;
		try {
			pass = Md5Util.encoderByMd5(userInfo.getUserPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		userInfo.setUserPassword(pass);
		//验证用户名和密码，并当活跃状态为0时，修改活跃状态为1。
		UserInfo userInfo1 = userInfoService.userLogin(userInfo);
		if (userInfo1 != null) {
			session.setAttribute("UserInfo", userInfo1);
			return true;
		}
		return false;
	}

	//退出登录，修改登录状态为0。
	@RequestMapping("logout")
	public void loginout(HttpSession session, Integer userId) {
		userInfoService.logOut(userId);
		session.setAttribute("UserInfo", null);
	}

	//注册方法，添加数据到数据库，添加成功后返回1，否则返回0
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Integer register(@RequestBody UserInfo userInfo) {
		try {
			userInfo.setUserPassword(Md5Util.encoderByMd5(userInfo.getUserPassword()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return userInfoService.insertUser(userInfo);
	}

	//查找用户名，查看用户名在数据库中是否存在
	@RequestMapping(value = "/select", method = RequestMethod.POST)
	public boolean selectUserName(@RequestBody UserInfo userInfo) {
		String result = userInfoService.selectUser(userInfo.getUserName());
		return result == null ? true : false;
	}
}

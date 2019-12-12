package com.qrsx.springboot.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qrsx.springboot.pojo.UserInfo;
import com.qrsx.springboot.service.UserInfoService;
import com.qrsx.springboot.util.Md5Util;

/**
 * 
 * @ClassName: UserInfoController
 * @author zsd
 * @date 2019年12月11日
 *
 */
@RestController
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	//登录
	@RequestMapping("login")
	public Boolean login(@RequestBody UserInfo userInfo, HttpSession session) {
		//使用MD5对密码加密
		String pass = null;
		try {
			pass = Md5Util.EncoderByMd5(userInfo.getUserPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		userInfo.setUserPassword(pass);
		//验证用户名和密码，并修改状态
		UserInfo userInfo1 = userInfoService.userLogin(userInfo);
		if (userInfo1 != null) {
			session.setAttribute("UserInfo", userInfo1);
			return true;
		}
		return false;
	}
}

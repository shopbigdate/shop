package com.qrsx.springboot.service;

import com.qrsx.springboot.pojo.UserInfo;

/**
 * 
 * @ClassName: UserInfoService
 * @author zsd
 * @date 2019年12月11日
 *
 */
public interface UserInfoService {
	//登录，验证用户名和密码，并修改状态
	UserInfo userLogin(UserInfo userInfo);
}

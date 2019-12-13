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

	/**
	 *  @author: Yuyang Lu
	 *  @Date:  下午 7:35
	 *  @Description: 方法：添加用户信息
	 */
	public Integer insertUser(UserInfo userInfo);

	/**
	 *  @author: Yuyang Lu
	 *  @Date:  下午 7:37
	 *  @Description: 方法：查找用户名
	 */
	public String selectUser(String userName);
}

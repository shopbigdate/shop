package com.qrsx.springboot.service;

import com.qrsx.springboot.pojo.UserInfo;

/**
 * @ClassName: UserInfoService
 * @Description:用户信息业务层实现
 * @author zsd
 * @date 2019年12月11日
 */
public interface UserInfoService {
	//登录，验证用户名和密码，并当活跃状态为0时，修改活跃状态为1。
	UserInfo userLogin(UserInfo userInfo);

	//退出登录，修改登录状态为0。
	void logOut(Integer userId);

	/**
	 *  @author: Yuyang Lu
	 *  @Date:  下午 7:35
	 *  @Description: 方法：添加用户信息
	 */
	Integer insertUser(UserInfo userInfo);

	/**
	 *  @author: Yuyang Lu
	 *  @Date:  下午 7:37
	 *  @Description: 方法：查找用户名
	 */
	String selectUser(String userName);
}

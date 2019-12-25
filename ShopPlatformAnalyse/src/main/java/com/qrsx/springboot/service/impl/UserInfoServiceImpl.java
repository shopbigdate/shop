package com.qrsx.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qrsx.springboot.mapper.UserInfoMapper;
import com.qrsx.springboot.pojo.UserInfo;
import com.qrsx.springboot.service.UserInfoService;

/**
 * 
 * @ClassName: UserInfoServiceImpl
 * @Description:用户信息业务层实现
 * @author zsd
 * @date 2019年12月11日
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	private static final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	//登录，验证用户名和密码，并当活跃状态为0时，修改活跃状态为1。
	@Override
	//加上注解@Transactional,就可以指定这个类需要受Spring的事务管理
	@Transactional
	public UserInfo userLogin(UserInfo userInfo) {
		UserInfo userInfo1 = userInfoMapper.checkPassword(userInfo);

		if (userInfo1 != null) {
			userInfoMapper.updateLoginStatus1(userInfo1.getUserId());
			if (userInfo1.getActiveStatus().equals("0")) {
				userInfoMapper.updateActiveStatus1(userInfo1.getUserId());
				//写入log4j日志，使用error级别来和离线日志的warn级别来做区分。
				log.error(userInfo1.getUserId().toString());
			}
		}
		return userInfo1;
	}

	//退出登录，修改登录状态为0。
	@Override
	public void logOut(Integer userId) {
		userInfoMapper.logOut(userId);
	}

	//添加用户信息
	@Override
	public Integer insertUser(UserInfo userInfo) {
		return userInfoMapper.insertUser(userInfo);
	}

	//根据用户名查询用户是否存在
	@Override
	public String selectUser(String userName) {
		return userInfoMapper.selectUser(userName);
	}

}

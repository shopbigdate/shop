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
				//写入log4j日志
				log.warn(userInfo1.getUserId().toString());
			}
		}
		return userInfo1;
	}

	//退出登录，修改登录状态为0。
	@Override
	public void logOut(Integer userId) {
		userInfoMapper.logOut(userId);
	}

	@Override
	public Integer insertUser(UserInfo userInfo) {
		return userInfoMapper.insertUser(userInfo);
	}

	@Override
	public String selectUser(String userName) {
		return userInfoMapper.selectUser(userName);
	}

}

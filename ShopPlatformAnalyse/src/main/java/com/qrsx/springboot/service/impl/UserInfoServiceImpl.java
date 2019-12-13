package com.qrsx.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	//登录，验证用户名和密码，并修改状态
	@Override
	public UserInfo userLogin(UserInfo userInfo) {
		UserInfo userInfo1 = userInfoMapper.checkPassword(userInfo);
		if (userInfo1 != null) {
			userInfoMapper.updateStatus(userInfo1.getUserId());
		}
		return userInfo1;
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

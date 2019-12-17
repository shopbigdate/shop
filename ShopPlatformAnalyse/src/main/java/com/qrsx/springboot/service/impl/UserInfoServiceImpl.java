package com.qrsx.springboot.service.impl;

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

	//private static final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	//登录，验证用户名和密码，并当活跃状态为0时，修改活跃状态为1。
	@Override
	//加上注解@Transactional,就可以指定这个类需要受Spring的事务管理
	@Transactional
	public UserInfo userLogin(UserInfo userInfo) {
		UserInfo userInfo1 = userInfoMapper.checkPassword(userInfo);
		if (userInfo1 != null && userInfo1.getActiveStatus().equals("0")) {
			userInfoMapper.updateStatus(userInfo1.getUserId());
			//log.warn(userInfo1.getUserId() + " " + userInfo1.getUserName() + " 1");
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

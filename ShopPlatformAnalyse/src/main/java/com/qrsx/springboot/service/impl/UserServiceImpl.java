package com.qrsx.springboot.service.impl;
import com.qrsx.springboot.mapper.UserMapper;
import com.qrsx.springboot.pojo.UserInfo;
import com.qrsx.springboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer insertUser(UserInfo userInfo) {
        return userMapper.insertUser(userInfo);
    }

    @Override
    public String selectUser(String userName) {
        return userMapper.selectUser(userName);
    }
}

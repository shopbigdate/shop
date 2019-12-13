package com.qrsx.springboot.service;

import com.qrsx.springboot.pojo.UserInfo;

/**
 *  @author: Yuyang Lu
 *  @Date:  下午 7:34
 *  @Description: Service层 方法接口
 */
public interface UserService {
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

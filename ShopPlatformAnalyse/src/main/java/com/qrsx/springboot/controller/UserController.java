package com.qrsx.springboot.controller;

import Decoder.BASE64Encoder;
import com.qrsx.springboot.pojo.UserInfo;
import com.qrsx.springboot.service.UserService;
import com.qrsx.springboot.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 *  @author: Yuyang Lu
 *  @Date:  下午 7:26
 *  @Description: Controller控制层
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    Md5Util md5Util = new Md5Util();
    /**
    * @Description 注册方法，添加数据到数据库
    * @Author  Yuyang Lu
    * @Date   2019/12/12 0012 下午 7:26
    * @Param
    * @Return int 添加成功后返回1,，否则返回0
    * @Exception  try catch捕捉加密异常
    */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Integer register(@RequestBody UserInfo userInfo){
        try {
            userInfo.setUserPassword(md5Util.encoderByMd5(userInfo.getUserPassword()));
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return userService.insertUser(userInfo);
    }
    /**
    * @Description 查找用户名，查看用户名在数据库中是否存在
    * @Author  Yuyang Lu
    * @Date   2019/12/12 0012 下午 7:28
    * @Param
    * @Return  boolean：true && false
    * @Exception
    */
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public boolean selectUserName(@RequestBody UserInfo userInfo){
        String result = userService.selectUser(userInfo.getUserName());
        return result==null ? true : false;
    }
}

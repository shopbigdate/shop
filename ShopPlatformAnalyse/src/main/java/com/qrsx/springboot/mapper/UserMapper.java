package com.qrsx.springboot.mapper;


import com.qrsx.springboot.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 *  @author: Yuyang Lu
 *  @Date:  下午 7:31
 *  @Description: Mapper接口
 */
@Mapper
public interface UserMapper {
    /**
     *  @author: Yuyang Lu
     *  @Date:  下午 7:33
     *  @Description: 添加用户信息
     */
    public Integer insertUser(UserInfo userInfo);
    /**
     *  @author: Yuyang Lu
     *  @Date:  下午 7:34
     *  @Description: 查找用户名
     */
    public String selectUser(String userName);
}

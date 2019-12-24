package com.qrsx.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.qrsx.springboot.pojo.UserInfo;

/**
 * 
 * @ClassName: UserInfoMapper
 * @Description:用户信息dao层实现
 * @author zsd
 * @date 2019年12月11日
 *
 */
@Mapper
public interface UserInfoMapper {
	//登录，验证用户名和密码，并修改状态
	UserInfo checkPassword(UserInfo userInfo);

	//退出登录，修改登录状态为0。
	void logOut(Integer userId);

	//修改登录状态为1
	int updateLoginStatus1(int userId);

	//修改活跃状态为1
	int updateActiveStatus1(int userId);

	/**
	 *  @author: Yuyang Lu
	 *  @Date:  下午 7:33
	 *  @Description: 添加用户信息
	 */
	public Integer insertUser(UserInfo userInfo);

	/**
	 *  @author: Yuyang Lu
	 *  @Date:  下午 7:34
	 *  @Description: 根据用户名查询用户是否存在
	 */
	public String selectUser(String userName);
}

package com.summer.graduate.service;

import com.summer.graduate.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
	//登录
	public User getUserByNameAngPassw(String username, String password);

	//注册
	void createUser(@Param("username") String username,
	                @Param("password") String password);

	//根据用户名查找用户，用于管理员查找用户或者用户注册时检查用户名是否存在
	User getUserByUsername(@Param("username") String username);

	//修改用户资料
	void updateUser(@Param("username") String username,
	                @Param("password") String password);

	//用于管理员管理用户，获取所有用户或者根据用户名查找用户
	List<User> getUsers(@Param("username") String username);

	//升会员或降会员
	void upgradeOrDowngrade(String username, Integer type);
}

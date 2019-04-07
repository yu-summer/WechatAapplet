package com.summer.graduate.dao;

import com.summer.graduate.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
	User getUserByNameAngPasw(@Param("username") String username,
	                                 @Param("password") String password);

	void createUser(@Param("username") String username,
	                @Param("password") String password,
	                @Param("address") String address);

	User getUserByUsername(@Param("username") String username);

	void updateUser(@Param("username") String username,
	                @Param("password") String password,
	                @Param("address") String address);

	List<User> getUsers(@Param("username") String username);

	void upgradeOrDowngrade(@Param("username") String username, @Param("type") Integer type);
}

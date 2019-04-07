package com.summer.graduate.service.impl;

import com.summer.graduate.dao.UserDao;
import com.summer.graduate.entities.User;
import com.summer.graduate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName com.summer.graduate.service.impl.UserServiceImpl
 * @Description TODO
 * @Author summer
 * @Date 2019/3/8 15:38
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserByNameAngPassw(String username, String password) {
		return userDao.getUserByNameAngPasw(username, password);
	}

	@Override
	public void createUser(String username, String password, String address) {
		userDao.createUser(username, password, address);
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public void updateUser(String username, String password, String address) {
		userDao.updateUser(username, password, address);
	}

	@Override
	public List<User> getUsers(String username) {
		return userDao.getUsers(username);
	}

	@Override
	public void upgradeOrDowngrade(String username, Integer type) {
		userDao.upgradeOrDowngrade(username, type);
	}
}

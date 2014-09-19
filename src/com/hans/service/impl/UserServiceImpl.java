package com.hans.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hans.dao.UserDao;
import com.hans.model.User;
import com.hans.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int save(User user) {
		userDao.save(user);
		return 0;
	}

}

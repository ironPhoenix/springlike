package com.hans.service.impl;

import com.hans.dao.UserDao;
import com.hans.model.User;
import com.hans.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int save(User user) {
		userDao.save(user);
		return 0;
	}

}

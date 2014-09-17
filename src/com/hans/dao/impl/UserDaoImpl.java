package com.hans.dao.impl;

import com.hans.dao.UserDao;
import com.hans.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public int save(User user) {
		System.out.println("user save into DB " + user.getName());
		return 0;
	}

}

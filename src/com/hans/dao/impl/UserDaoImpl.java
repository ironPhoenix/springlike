package com.hans.dao.impl;

import org.springframework.stereotype.Component;

import com.hans.dao.UserDao;
import com.hans.model.User;

@Component
public class UserDaoImpl implements UserDao {

	private int userId = 12;

	@Override
	public int save(User user) {
		System.out.println("user save into DB " + user.getName() + "userID"
				+ userId);
		userId++;
		return 0;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}

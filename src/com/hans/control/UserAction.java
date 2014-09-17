package com.hans.control;

import com.hans.model.User;
import com.hans.service.UserService;
import com.hans.spring.ClassPathXmlApplicationContext;

public class UserAction {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext();
		UserService userService = (UserService) cpxac.getBean("userService");
		User user = new User();
		user.setName("hans");
		user.setPassword("hansjason");
		userService.save(user);
	}
}

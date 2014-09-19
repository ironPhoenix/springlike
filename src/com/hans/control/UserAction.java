package com.hans.control;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hans.model.User;
import com.hans.service.UserService;

public class UserAction {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext(
				"beans.xml");
		UserService userService = (UserService) cpxac.getBean("userService");
		User user = new User();
		user.setName("hans");
		user.setPassword("hansjason");
		userService.save(user);
	}
}

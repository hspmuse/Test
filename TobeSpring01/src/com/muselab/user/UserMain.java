package com.muselab.user;

import java.sql.SQLException;

public class UserMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		UserDao dao = new UserDao();
		
		User user = new User();
		
		user.setId("sphong");
		user.setName("호호");
		user.setPassword("aaa");
		
		dao.add(user);
		
		System.out.println(user.getId() + " register sucess!!");
		
		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		
		
	}
}

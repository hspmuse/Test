package com.muselab.user;

import java.sql.SQLException;

public class UserMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		NUserDao ndao = new NUserDao();
		
		User user = new User();
		
		user.setId("sphong12");
		user.setName("호호");
		user.setPassword("aaa");
		
		ndao.add(user);
		
		System.out.println(user.getId() + " register sucess!!");
		
		User user2 = ndao.get(user.getId());
		
		System.out.println(user2.getName());
		
		
	}
}

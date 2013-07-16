package com.muselab.user;

import java.sql.SQLException;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ConnectionMaker connectionMaker = new NConnectionMaker();
		
		UserDao dao = new UserDao(connectionMaker);
		
		User user = new User();
		
		user.setId("sphong12232");
		user.setName("호호");
		user.setPassword("aaa");
		
		dao.add(user);
		
		System.out.println(user.getId() + " register sucess!!");
		
		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		
		
	}
}

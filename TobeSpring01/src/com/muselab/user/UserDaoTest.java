package com.muselab.user;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//ConnectionMaker connectionMaker = new DConnectionMaker();
		//UserDao dao = new UserDao(connectionMaker);
		//UserDao dao = new DaoFactory().userDao();

		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		
		user.setId("sphong11");
		user.setName("호호");
		user.setPassword("aaa");
		
		dao.add(user);
		
		System.out.println(user.getId() + " register sucess!!");
		
		User user2 = dao.get(user.getId());
		
		System.out.println(user2.getName());
		
		
	}
}

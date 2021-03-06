package com.muselab.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	
	@Bean
	public UserDao userDao() {
//		ConnectionMaker connectionMaker = new DConnectionMaker();
//		UserDao userDao = new UserDao(connectionMaker);
//		return userDao;
		return new UserDao(connectionMaker());
	}
	
//	public AccountDao accountDao() {
//		
//		return new AccountDao(connectionMaker());
//	}

	@Bean
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
	
}

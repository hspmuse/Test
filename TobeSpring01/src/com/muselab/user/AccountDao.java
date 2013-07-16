package com.muselab.user;

public class AccountDao {

	private ConnectionMaker connectionMaker;
	
	public AccountDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
}

package com.muselab.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {
	
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection c = DriverManager.getConnection("jdbc:sqlite:\\D:\\Muselab\\sqlite\\testdb");
		
		return c;
	}

}

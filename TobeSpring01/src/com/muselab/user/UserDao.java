package com.muselab.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		
		//Class.forName("org.sqlite.JDBC");
		//Connection c = DriverManager.getConnection("jdbc:sqlite:\\D:\\Muselab\\sqlite\\testdb");
		Connection c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values (?,?,?)");
		
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
		
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		
		//Class.forName("org.sqlite.JDBC");
		//Connection c = DriverManager.getConnection("jdbc:sqlite:\\D:\\Muselab\\sqlite\\testdb");
		Connection c = connectionMaker.makeConnection();
		
		PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		
		return user;
		
	}
	
//	private Connection getConnection() throws ClassNotFoundException, SQLException {
//		
//		Class.forName("org.sqlite.JDBC");
//		Connection c = DriverManager.getConnection("jdbc:sqlite:\\D:\\Muselab\\sqlite\\testdb");
//		
//		return c;
//	}
	
//	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
	
}

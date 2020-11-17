package cs6359.utdcart.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cs6359.utdcart.entity.User;

public class DBMgr {
	
	private static DBMgr instance = new DBMgr();

	private final String url = "jdbc:mysql://localhost:3306/utdcart";
	private final String username = "root";
	private final String password = "root";
	

	private Statement stmt = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection connection = null;

	private final String insertUserSQL = "INSERT INTO `utdcart`.`user` (username, firstName, lastName, email, password, type) VALUES (?, ?, ?, ?, ?, ?)";
	
	
	public DBMgr() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	private Connection createConnection() {
		
		try {
			connection = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Successful");
			
		}catch (SQLException e) {
			System.out.println("ERROR: Unable to connect to Database");
		}
		return connection;
	}
	
	public static Connection getConnection() {
		return instance.createConnection();
		
	}

	public void insertUser(User user) throws Exception{
		
		try {
			connection = DBMgr.getConnection();
			stmt = connection.createStatement();
			ps = connection.prepareStatement(insertUserSQL);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getUserType());
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}}

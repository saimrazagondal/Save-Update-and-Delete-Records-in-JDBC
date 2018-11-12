package lab6.lab6;

import java.sql.*;

public class Connector {

	//variables
	private String url, username, password;
	//Connection instance
	private Connection connection;
	
	
	//Constructor
	public Connector(Configuration config) throws SQLException{
		url = config.getUrl(); 
		username = config.getUsername();
		password = config.getPassword();
		
		//debugging
		//System.out.println("Connector class: " + url + username + password);
		
		//make connection
		try {
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!"); 
		} 
		catch (SQLException e) { 
			throw new IllegalStateException("Cannot connect the database!", e); }
	}
	
	
	//Getters
	//Getter for connection
	public Connection getConnection(){
		return connection;
	}
	
	
}

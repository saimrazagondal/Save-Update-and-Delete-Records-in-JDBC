package lab6.lab6;

import java.sql.*;
import java.util.*;

public class Handler {

	//Person person = new Person();
	
	//Connection instance
	Connection connection;

	//Scanner variable for input from user
	Scanner scan = new Scanner(System.in);
	
		
	//Constructor - creates object of connector class
	//returns a connection to the database in the connection variable
	public Handler(Configuration config) throws SQLException{
		
		Connector connect = new Connector(config);
		connection = connect.getConnection();		//connection established
	}

	
	//method to save the person record in the database
	public void save(Person person) throws SQLException{
		try{
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO person(name, fatherName, organization, mobile) VALUES (?, ?, ?, ?)");
			stmt.setString(1, person.getName());
			stmt.setString(2, person.getFatherName());
			stmt.setString(3, person.getOrganization());
			stmt.setString(4, person.getMobile());
			stmt.executeUpdate(); 
			System.out.println("Successfull entry!");
		} catch (SQLException e) {e.printStackTrace();}
	}
	
	//method to update an existing record given id of the person
	public void update(int personid) throws SQLException{

        PreparedStatement statement = connection.prepareStatement("update person set name = ?, fathername = ?, organization = ?, mobile = ? where id = ?");
        System.out.println("Please enter updated details  of person!");
        System.out.println("Name: ");
        statement.setString(1, scan.nextLine());
        System.out.println("Father Name: ");
        statement.setString(2, scan.nextLine());
        System.out.println("Organization: ");
        statement.setString(3, scan.nextLine());
        System.out.println("Mobile Number: ");
        statement.setString(4, scan.nextLine());
        statement.setInt(5, personid);
        System.out.println(statement.executeUpdate() + " record updated");
	}
	
	//method to delete a record given id of person
	public void delete(int personId) throws SQLException{
		
		PreparedStatement statement = connection.prepareStatement("delete from person where id = ?");
        statement.setInt(1, personId);
        statement.executeUpdate();
        System.out.println("Record deleted!");
	
	}
	
	//method to get info of a record using id
	public void get(int personId) throws SQLException{
	
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
        statement.setInt(1, personId);
        ResultSet resultSet = statement.executeQuery();

        resultSet.next();
        System.out.println();
        System.out.println("ID: " + resultSet.getInt(1));
        System.out.println("Name: " + resultSet.getString(2));
        System.out.println("Father Name: " + resultSet.getString(3));
        System.out.println("Organization: " + resultSet.getString(4));
        System.out.println("Mobile: " + resultSet.getString(5));
        
        System.out.println();
	}
	
	
	
}

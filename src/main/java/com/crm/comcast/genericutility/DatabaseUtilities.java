package com.crm.comcast.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author PAWAN
 *
 */
public class DatabaseUtilities {
	Connection connection;
	ResultSet result;
	
	
public void loadAndConnectDB() {
	try {
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref); 
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}

/**
 * 
 * @param query
 * @return the resultset of the select query
 */
public ResultSet createAndExecuteQuery(String query) {
	try {
	Statement statement = connection.createStatement();
	ResultSet result = statement.executeQuery(query);
	}
	catch(Exception e) {
		e.printStackTrace();
			}
return result;
}

public void closeDB() throws SQLException {
		connection.close();
		}	
}
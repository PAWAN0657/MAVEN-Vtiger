package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class sample_nonselect_query {
public static void main(String[] args) throws SQLException {
	//step1: load/register the driver for specific database
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		//step2: connect to db
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
		
		//step3: create/issue sql statement
		Statement stat = con.createStatement();
		
		//step4: execute the query
		  int result = stat.executeUpdate("insert into student values(3,'sumit','kumar','sumit564@gmail.com')");
		if (result==1) {
			System.out.println("student is succesfully created");			
		}
		
		//step5: close the connection
		con.close();
		}
}

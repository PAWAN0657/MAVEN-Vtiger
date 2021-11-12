package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class sample_non_select_query_try_catch_realtime_jdbc_code {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			
		//step1: load/register the driver for specific database
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			
			//step2: connect to db
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
			
			//step3: create/issue sql statement
			Statement stat = con.createStatement();
			
			//step4: execute the query
			  int result = stat.executeUpdate("insert into student values(4,'sourav','sharma','sourav165@gmail.com')");
			if (result==1) {
				System.out.println("student is succesfully created");			
			}
		} catch (Exception e) {
			System.err.println("student not created");
		}finally {
			con.close();
			System.out.println("%%%%%%%%%%database-closed%%%%%%%%%%");
			}
	}
}


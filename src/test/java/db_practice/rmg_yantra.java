package db_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;

public class rmg_yantra {
@Test
public void rmg_Yantra() throws SQLException {
Reporter.log("project is created",true);
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(11,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://localhost:8084/");
	driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
	driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[.='Sign in']")).click();
    driver.findElement(By.xpath("//a[.='Projects']")).click();	
    //driver.findElement(By.xpath("//span[.='Create Project']")).click();
    //driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("PAWAN");
    //driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("KUMAR");
    ////WebElement lbx = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
    //Select s=new Select(lbx);
    ///s.selectByIndex(1);
    ////driver.findElement(By.xpath("//input[@type='submit']")).submit();
    
    Connection con=null;
	try {
		
		//step1: load/register the driver for specific database
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	//step2: connect to db
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	
	//step3: create/issue sql statement
	Statement stat = con.createStatement();
	
	//step4: execute the query
	ResultSet set = stat.executeQuery("select * from project");
	while (set.next()) {
		String name = set.getString(4);
		if (name.equals("PAWAN")) { 
		System.err.println("CREATED");	
		}
	}
	} catch (Exception e) {
		System.err.println("not created");
			}
	finally {
		
	//step5: close the connection
	con.close();
	}
driver.close();
}
}

package com.crm.comcast.genericutility;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.comcast.PomRepositoryLib.Login;
import com.crm.comcast.PomRepositoryLib.SignOut;

public class BaseAnnotationsClass {
	public JavaUtility jutil=new JavaUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public FileUtility futil=new FileUtility();
	public ExcelUtility eutil=new ExcelUtility();
	public DatabaseUtilities dbutil=new DatabaseUtilities();
	public WebDriver driver=null;
	@BeforeSuite(groups={"Smoke Test","Regression Test"})
	public void beforesuite() {
		System.out.println("======CONNECT DATABASE======");
		dbutil.loadAndConnectDB();
	}
//@Parameters(value="browser")	
@BeforeClass(groups={"Smoke Test","Regression Test"})
public void beforeclass() throws IOException {
	System.out.println("========LAUNCH BROWSER======");
	String browser = futil.getproperty_keyvalue("BROWSER");
	String url = futil.getproperty_keyvalue("URL");
	if (browser.equalsIgnoreCase("CHROME")) {
		driver=new ChromeDriver();	
	}
	else if(browser.equalsIgnoreCase("FIREFOX")) {
		driver=new FirefoxDriver();
	} else if(browser.equalsIgnoreCase("IE")) {
		driver=new InternetExplorerDriver();
	}
	wutil.implicitwait(driver);
	driver.get(url);
}

@BeforeMethod(groups={"Smoke Test","Regression Test"})
public void beforemethod() throws IOException {
	System.out.println("=======LOGIN ======");
	String usn = futil.getproperty_keyvalue("USERNAME");
	String pwd = futil.getproperty_keyvalue("PASSWORD");
	Login login=new Login(driver);
	login.loginToApp(usn,pwd);
	}

@AfterMethod(groups={"Smoke Test","Regression Test"})
public void aftermethod() {
System.out.println("=======LOG OUT======");
SignOut signout=new SignOut(driver);
	wutil.mouseOver(driver,signout.getAdministrator());
	signout.signOut();
}

@AfterClass(groups={"Smoke Test","Regression Test"})
public void afterclass() {
System.out.println("========CLOSE BROWSER======");
	driver.close();
}

@AfterSuite(groups={"Smoke Test","Regression Test"})
public void afteresuite() throws SQLException {
	System.out.println("======DISCONNECT DATABASE======");
	dbutil.closeDB();
}
}
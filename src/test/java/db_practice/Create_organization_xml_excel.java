package db_practice;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class Create_organization_xml_excel {
@Test
public void read_data_from_xml(XmlTest xml) throws EncryptedDocumentException, IOException {
	
	JavaUtility jutil=new JavaUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	int randomnum = jutil.getRandomNumber();
	
	String browser = xml.getParameter("Browser");
	String url = xml.getParameter("Url");
	String username = xml.getParameter("Username");
	String password = xml.getParameter("Password");
	
	ExcelUtility e=new ExcelUtility();
	
	String orgname = e.get_excel_data("ORGANIZATION",4,2)+" "+randomnum;
	
	WebDriver driver=null;
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
driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
driver.findElement(By.id("submitButton")).submit();
driver.findElement(By.partialLinkText("Organizations")).click();
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
driver.findElement(By.name("button")).click();
String Headername = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]")).getText();

if (Headername.contains(orgname)) {
	System.out.println("organization created");
}
else
	System.out.println("organization not created");

WebElement target = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
wutil.mouseOver(driver, target);
driver.findElement(By.linkText("Sign Out")).click();
driver.close();
}
}
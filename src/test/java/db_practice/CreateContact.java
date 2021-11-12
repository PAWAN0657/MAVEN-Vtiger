package db_practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class CreateContact {
	@Test
public void create_contact() throws IOException {
	JavaUtility jutil=new JavaUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	int randomnum = jutil.getRandomNumber();
	FileUtility f=new FileUtility();
	String browser = f.getproperty_keyvalue("BROWSER");
	String url = f.getproperty_keyvalue("URL");
	String username = f.getproperty_keyvalue("USERNAME");
	String password = f.getproperty_keyvalue("PASSWORD");
	
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
WebElement element = driver.findElement(By.linkText("Contacts"));
wutil.explicitwait(driver,element);
element.click();
driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
driver.findElement(By.name("firstname")).sendKeys(e.get_excel_data("ORGANIZATION", 1,5));
driver.findElement(By.name("lastname")).sendKeys(e.get_excel_data("ORGANIZATION", 1,4));
driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
wutil.switchto_window(driver,"Accounts&action");
driver.findElement(By.xpath("//input[@type='text']")).sendKeys(orgname);
driver.findElement(By.xpath("//input[@name='search']")).click();
driver.findElement(By.linkText(orgname)).click();
wutil.switchto_window(driver,"Contacts");
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
String expname = driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]")).getText();
if (expname.contains(e.get_excel_data("ORGANIZATION", 1,4))) {
	System.out.println("contact created");
}
else
	System.out.println("contact not created");
WebElement eleemnt1 = driver.findElement(By.xpath("(//td[@class='small'])[2]"));
wutil.mouseOver(driver, eleemnt1);
driver.findElement(By.linkText("Sign Out")).click();
}
}

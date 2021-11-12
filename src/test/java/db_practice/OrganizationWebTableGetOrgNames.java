package db_practice;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.PomRepositoryLib.Home;
import com.crm.comcast.PomRepositoryLib.Login;
import com.crm.comcast.genericutility.FileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class OrganizationWebTableGetOrgNames {
	WebDriver driver;
	@Test
	public void orgwebtable() throws IOException {
		FileUtility futil=new FileUtility();
		String username = futil.getproperty_keyvalue("USERNAME");
		String password = futil.getproperty_keyvalue("PASSWORD");
		String url = futil.getproperty_keyvalue("URL");
		String browser = futil.getproperty_keyvalue("BROWSER");
		
		if (browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("firefox")){
			
			driver=new FirefoxDriver();
		}
		
		else
			System.out.println("no browser launched");
		
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.implicitwait(driver);
		driver.get(url);
		Login login=new Login(driver);
		login.loginToApp(username, password);
		
		Home home=new Home(driver);
		home.getOrganizationLnk().click();;
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		
	for (int i = 1; i <list.size(); i++) {
		System.out.println(list.get(i).getText());
}
}
}
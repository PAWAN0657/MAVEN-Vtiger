package db_practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTripFutureDate {
	@Test
	public void bookTicket() throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(11,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//li[@data-cy='account']")).click();
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	driver.findElement(By.xpath("//span[.='From']")).click();
	driver.findElement(By.xpath("//p[contains(text(),'Mumbai, India')]")).click();
	
	driver.findElement(By.xpath("//span[.='To']")).click();
	driver.findElement(By.xpath("//p[contains(text(),'Chennai, India')]")).click();
	
	driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[1]")).click();
	driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	driver.findElement(By.xpath("//div[@aria-label='Thu Dec 02 2021']")).click();
	driver.findElement(By.xpath("//a[.='Search']")).click();
	}
}

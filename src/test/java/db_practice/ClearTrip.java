package db_practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClearTrip {
	@Test
	public void bookTicket() throws InterruptedException {
		Date dateref= new Date();
		String currentdate = dateref.toString();
		System.out.println(currentdate);
		String[] a=currentdate.split(" ");
		String date=(a[0]+" "+a[1]+" "+a[2]+" "+a[5]);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(11,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.cleartrip.com/");
	driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[1]")).click();
	driver.findElement(By.xpath("//p[contains(text(),'Mumbai, IN - Chatrapati Shivaji Airport (BOM)')]")).click();
	driver.findElement(By.xpath("(//input[@placeholder='Any worldwide city or airport'])[2]")).click();
	driver.findElement(By.xpath("//p[contains(text(),'Goa, IN - Dabolim Airport (GOI)')]")).click();
	driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']")).click();
	driver.findElement(By.xpath("//div[@aria-label='"+date+"']")).click();
	driver.findElement(By.xpath("(//div[@class='col flex flex-middle'])[5]")).click();
	}
}
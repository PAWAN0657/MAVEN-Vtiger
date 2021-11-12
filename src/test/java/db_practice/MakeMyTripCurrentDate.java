package db_practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MakeMyTripCurrentDate {
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
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.xpath("//li[@data-cy='account']")).click();
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	driver.findElement(By.xpath("//span[.='From']")).click();
	driver.findElement(By.xpath("//p[contains(text(),'Mumbai, India')]")).click();
	
	driver.findElement(By.xpath("//span[.='To']")).click();
	driver.findElement(By.xpath("//p[contains(text(),'Chennai, India')]")).click();
	
	driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[1]")).click();
	driver.findElement(By.xpath("//div[@aria-label='"+date+"']")).click();
	driver.findElement(By.xpath("//a[.='Search']")).click();
	}
}

package com.crm.comcast.PomRepositoryLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class Organization {
	
	public Organization(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchtextbox;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchnowbtn;
	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")	
    private WebElement createorgbtn;
	
	public WebElement getCreateOrgBtn() {
		return createorgbtn;
		}

	public void selectorg(WebDriver driver,String orgname) {
		searchtextbox.sendKeys(orgname);
		searchnowbtn.click();
		driver.findElement(By.linkText(orgname)).click();
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.switchto_window(driver,"Contacts");
	}
}


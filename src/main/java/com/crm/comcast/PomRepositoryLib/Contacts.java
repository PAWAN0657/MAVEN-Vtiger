package com.crm.comcast.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createcontact;
		
	public Contacts(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getcreatecontactbtn() {
		return createcontact;
	}
	}
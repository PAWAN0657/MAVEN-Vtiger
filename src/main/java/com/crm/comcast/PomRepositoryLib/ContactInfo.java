package com.crm.comcast.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfo {

	@FindBy(xpath="//span[contains(text(),'Contact Information')]")
	private WebElement contactsuccesfullmsg;
	
	public ContactInfo(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getcontactsuccesfullmsg() {
		return contactsuccesfullmsg;
		
	}
}

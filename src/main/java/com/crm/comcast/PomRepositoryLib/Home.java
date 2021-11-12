package com.crm.comcast.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {	
	public Home(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="Contacts")
	private WebElement getcontactlnk; 
	
	@FindBy(partialLinkText="Organizations")
	private WebElement organizationlnk;
	
	public WebElement getContactLnk() {
		return getcontactlnk;
				}

public WebElement getOrganizationLnk() {
	return organizationlnk;
}
}
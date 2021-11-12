package com.crm.comcast.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	
	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryinfo;
	
	public WebElement getIndustryinfo() {
		return industryinfo;
	}

	public WebElement getAcctypeinfo() {
		return acctypeinfo;
	}

	@FindBy(id="mouseArea_Type")
	private WebElement acctypeinfo;
	
@FindBy(xpath="//span[contains(text(),'Organization Information')]")
private WebElement succesfulmsg;

public WebElement getSuccesfulmsg() {
	return succesfulmsg;
}
}

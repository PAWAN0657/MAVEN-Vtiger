package com.crm.comcast.PomRepositoryLib;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.comcast.genericutility.WebDriverUtility;

public class CreateNewOrganization {
	public CreateNewOrganization(WebDriver driver){
	PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgnameedit;
	
	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(name="accounttype")
	private WebElement acctype;
	
	@FindBy(name="button")
	private WebElement savebtn;

	public void CreateOrg(String orgname)
	{
		orgnameedit.sendKeys(orgname);
		savebtn.click();
		}
	
	public void CreateOrgwithindustrytype(String orgname,String industrydata,String acctypedata) throws EncryptedDocumentException, IOException {
		orgnameedit.sendKeys(orgname);
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.select(industry,industrydata);
		wutil.select(acctype,acctypedata);
		savebtn.click();
}
}

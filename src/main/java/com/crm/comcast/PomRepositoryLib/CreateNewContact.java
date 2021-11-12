package com.crm.comcast.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	
	@FindBy(name="firstname")
	private  WebElement firstnametextbox ; 
	
	@FindBy(name="lastname")
	private WebElement lastnametxtbox;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectorgnamebtn;
	
	
	public CreateNewContact(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement firstnametextbox () {
		return firstnametextbox ;
	}
	
	public WebElement lastnametxtbox() {
		return lastnametxtbox ;
	}
	
	public WebElement selectorgnamebtn() {
		return selectorgnamebtn ;
	}
	
	public WebElement savebutton() {
		return savebutton;
	}
	}	

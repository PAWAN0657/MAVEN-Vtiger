package com.crm.comcast.PomRepositoryLib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
@FindBy(name="user_name")
	private WebElement username;

@FindBy(name="user_password")
	private WebElement passwordname;

@FindBy(id="submitButton")	
private WebElement loginbutton;

public Login(WebDriver driver) {
PageFactory.initElements(driver,this);
}

public WebElement getUsername() {
return username;
}

public WebElement getPasswordname() {
return passwordname;
}

public WebElement getLoginButton() {
return loginbutton;
}

public void loginUsn(String usn) throws IOException{
	username.sendKeys(usn);
	}

public void loginPwd(String pwd) throws IOException {
	passwordname.sendKeys(pwd);
}

	public void loginBtn() throws IOException {
		loginbutton.click();
		}

	public void loginToApp() {
	username.sendKeys("admin");
	passwordname.sendKeys("admin");
	loginbutton.click();
	}

public void loginToApp(String Username,String Password) {
	username.sendKeys(Username);
	passwordname.sendKeys(Password);
	loginbutton.click();
}
}

package com.crm.comcast.ContactTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.crm.comcast.PomRepositoryLib.ContactInfo;
import com.crm.comcast.PomRepositoryLib.Contacts;
import com.crm.comcast.PomRepositoryLib.CreateNewContact;
import com.crm.comcast.PomRepositoryLib.CreateNewOrganization;
import com.crm.comcast.PomRepositoryLib.Home;
import com.crm.comcast.PomRepositoryLib.Organization;
import com.crm.comcast.PomRepositoryLib.OrganizationInfo;
import com.crm.comcast.genericutility.BaseAnnotationsClass;

public class CreateContactTest extends BaseAnnotationsClass {
	@Test(groups = "Smoke Test")
public void create_contact_test() throws IOException {

int randomnum = jutil.getRandomNumber();
//get data from excel sheet	
String firstname = eutil.get_excel_data("ORGANIZATION", 1,5);
String lastname = eutil.get_excel_data("ORGANIZATION", 1,4)+" "+randomnum;
	
//navigate to contact link
Home home=new Home(driver);

WebElement element =home.getContactLnk();
wutil.explicitwait(driver,element);
element.click();

//navigate to create contact
Contacts contact=new Contacts(driver);
contact.getcreatecontactbtn().click();

//create new contact with firstname and lastname
CreateNewContact createnewcontact=new CreateNewContact(driver);
createnewcontact.firstnametextbox().sendKeys(firstname);
createnewcontact.lastnametxtbox().sendKeys(lastname);

//save contact
createnewcontact.savebutton().click();
ContactInfo contactinfo=new  ContactInfo(driver);
String expname = contactinfo.getcontactsuccesfullmsg().getText();

//verify
if (expname.contains(eutil.get_excel_data("ORGANIZATION", 1,4))) {
	System.out.println("contact created");
}
else
	System.out.println("contact not created");
}
	@Test(groups="Regression Test")
	public void create_contact_with_organization_test() throws IOException {
		int randomnum = jutil.getRandomNumber();
		
		//get data from excel sheet	
		String orgname = eutil.get_excel_data("ORGANIZATION",4,2)+" "+randomnum;
		//navigate to organization link
		Home home=new Home(driver);
		home.getOrganizationLnk().click();

		//navigate to create organization
		Organization organization=new Organization(driver);
		organization.getCreateOrgBtn().click();

		//create organization 
		CreateNewOrganization createorg=new CreateNewOrganization(driver);
		createorg.CreateOrg(orgname);

		OrganizationInfo orginfo=new OrganizationInfo(driver);
		String Headername = orginfo.getSuccesfulmsg().getText();
		
		//verify orgname
		if (Headername.contains(orgname)) {
			System.out.println("organization created");
		}
		else
			System.out.println("organization not created");

		//navigate to contact link
		
		WebElement element =home.getContactLnk();
		wutil.explicitwait(driver,element);
		element.click();

		//navigate to create contact
		Contacts contact=new Contacts(driver);
		contact.getcreatecontactbtn().click();

		//create new contact with organization
		CreateNewContact createnewcontact=new CreateNewContact(driver);
        createnewcontact.firstnametextbox().sendKeys(eutil.get_excel_data("ORGANIZATION", 1,5));
		createnewcontact.lastnametxtbox().sendKeys(eutil.get_excel_data("ORGANIZATION", 1,4));
		createnewcontact.selectorgnamebtn().click();

		wutil.switchto_window(driver,"Accounts&action");

		organization.selectorg(driver, orgname);
		createnewcontact.savebutton().click();

		ContactInfo contactinfo=new  ContactInfo(driver);
		String expname = contactinfo.getcontactsuccesfullmsg().getText();

		if (expname.contains(eutil.get_excel_data("ORGANIZATION", 1,4))) {
			System.out.println("contact created");
		}
		else
			System.out.println("contact not created");
}
	}

package com.crm.comcast.OrganizationTest;

import java.io.IOException;
import org.testng.annotations.Test;
import com.crm.comcast.PomRepositoryLib.CreateNewOrganization;
import com.crm.comcast.PomRepositoryLib.Home;
import com.crm.comcast.PomRepositoryLib.Organization;
import com.crm.comcast.PomRepositoryLib.OrganizationInfo;
import com.crm.comcast.genericutility.BaseAnnotationsClass;

public class CreateOrgTest extends BaseAnnotationsClass {
	@Test
	public void createorgtest() throws IOException{
		
		int randomnum = jutil.getRandomNumber();
		String orgname = eutil.get_excel_data("ORGANIZATION",4,2 )+" "+randomnum;
	
	Home home=new Home(driver);
	home.getOrganizationLnk().click();
	
	Organization org=new Organization(driver);
	org.getCreateOrgBtn().click();
	
	CreateNewOrganization createorg=new CreateNewOrganization(driver);
	createorg.CreateOrg(orgname);
	
	OrganizationInfo orginfo=new OrganizationInfo(driver);
	String Headername = orginfo.getSuccesfulmsg().getText();
	if (Headername.contains(orgname)) {
		System.out.println("organization created");
	}
	else
		System.out.println("organization not created");
	}
	
	@Test
	public void create_org_industry_type_test() throws IOException{
		int randomnum = jutil.getRandomNumber();
		String orgname = eutil.get_excel_data("ORGANIZATION",4,2)+" "+randomnum;
		
	Home home=new Home(driver);
	home.getOrganizationLnk().click();
	
	Organization org=new Organization(driver);
	org.getCreateOrgBtn().click();
	
	String industry = eutil.get_excel_data("ORGANIZATION",4,3);
	String acctype = eutil.get_excel_data("ORGANIZATION",4,4);
	
	CreateNewOrganization createorg=new CreateNewOrganization(driver);
	createorg.CreateOrgwithindustrytype(orgname,industry,acctype);
	
	OrganizationInfo orginfo=new OrganizationInfo(driver);
	String actualindustryinfo = orginfo.getIndustryinfo().getText();
	String actualtypeinfo = orginfo.getAcctypeinfo().getText();
	
	if(industry.contains(actualindustryinfo) && acctype.contains(actualtypeinfo)){
	System.out.println("organization created with industrytype");
	}
	else
		System.out.println("organization not created with industrytype");
		
	String Headername = orginfo.getSuccesfulmsg().getText();
	if (Headername.contains(orgname)) {
		System.out.println("organization created");
	}
	else
		System.out.println("organization not created");
	}
}
	
	
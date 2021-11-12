package com.crm.comcast.ContactTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class SampleClass{
	
@Test(retryAnalyzer=com.crm.comcast.genericutility.RetryAnalyser.class)
public void sampletest() {
		Reporter.log("creating org", true);
		Assert.fail();
}
}
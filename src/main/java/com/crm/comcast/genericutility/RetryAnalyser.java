package com.crm.comcast.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	int retrycount=4;
	int count=0;
	
	public boolean retry(ITestResult result) {
	while(count<retrycount) {
		count++;
		return true;
	}
	return false;
	}
}

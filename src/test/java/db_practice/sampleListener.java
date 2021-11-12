package db_practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnotationsClass;
@Listeners(com.crm.comcast.genericutility.listenerImplementation.class)
public class sampleListener extends BaseAnnotationsClass {
	@Test
	public void sample() {
Reporter.log("sample listener", true);
Assert.fail();
	}
}
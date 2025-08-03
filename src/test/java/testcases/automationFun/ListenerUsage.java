package testcases.automationFun;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class ListenerUsage {

	@Test
	public void samplemethod1() {
		Reporter.log("Inside the Sample method 1");
	}

	@Test
	public void samplemethod2() {
		Reporter.log("Inside the Sample method 2");
	}

	@Test
	public void samplemethod3() {
		Reporter.log("Inside the Sample method 3");
	}

	@Test
	public void samplemethod4() {
		Reporter.log("Inside the Sample method 4");
	}

	@Test
	public void samplemethod5() {
		Reporter.log("Inside the Sample method 5");
		Assert.assertEquals(3,2);
	}

	@Ignore
	@Test
	public void samplemethod6() {		
		Reporter.log("Inside the Sample method 6");
		Reporter.log("Sample 6", 1);
	}
}

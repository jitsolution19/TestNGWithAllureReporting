package testcases.automationFun;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

public class LoopingExecution {

	@Ignore
	@Test
	public void method1() {
		System.out.println("Method1");
		Reporter.log("Executing Method1");
	}

	@Test(threadPoolSize = 2)
	public void method2() {
		System.out.println("Method2");
		Reporter.log("Executing Method2");
		Verify.verify(true);
		Assert.assertEquals("Jitendra", "expected");
		Reporter.getCurrentTestResult();
	}

	@Test(invocationCount = 3)
	public void method3() {
		System.out.println("Method3");
		Reporter.log("Executing Method3");
	}

	@Test(dataProvider = "input")
	public void method4(String FirstName, String LastName) {
		System.out.println("Your name is : " + FirstName + " " + LastName);
		Reporter.log("Your name is : " + FirstName + " " + LastName);
		Reporter.getOutput();
		Reporter.log(FirstName, true);
	}

	@DataProvider(name = "input")
	public Object[][] inputmethod() {
		return new Object[][] { { "Jitendra", "Gupta" }, { "Akansha", "Gupta" } };

	}
}

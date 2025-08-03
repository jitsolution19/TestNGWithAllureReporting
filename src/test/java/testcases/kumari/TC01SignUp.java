package testcases.kumari;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.kumari.KumariHomePage;

public class TC01SignUp extends BaseTest {

	@Test
	@Description("Validate User is able to Sign up from the popup Window")
	@Severity(SeverityLevel.MINOR)
	@Owner("Jeetendra Gupta")
	public void SignupWebsitefromPopup() {
		KumariHomePage page = new KumariHomePage(driver);
		Assert.assertEquals(page.validatePopupWindow(),true);
	}
}

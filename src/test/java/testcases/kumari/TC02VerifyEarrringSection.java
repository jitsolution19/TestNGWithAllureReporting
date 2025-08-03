package testcases.kumari;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.kumari.KumariHomePage;

public class TC02VerifyEarrringSection extends BaseTest {
	

	@Test
	@Description("Verify User Can close the Pop up Window")
	@Severity(SeverityLevel.MINOR)
	@Owner("Jeetendra Gupta")
	public void launchWebsite() {
		KumariHomePage page = new KumariHomePage(driver);
		Assert.assertEquals(page.closeSingupPopup(), true);
	}

	@Test
	@Description("Validate Earrings menu is present in the TOP Nav bar")
	public void verifyearrringInTopNavBar() {
		KumariHomePage page = new KumariHomePage(driver);
		Assert.assertEquals(page.closeSingupPopup(), true);
		Assert.assertEquals(page.getmenufromTopNavBar("Earrings"), "EARRINGS");
	}

	@Test
	@Description("Validate Sub Menu from Shop By Style")
	public void getsubmenuUnderShopByStyle() {
		List<String> input = Arrays.asList("Bali","Drops & Danglers","Studs & Tops","Statement Earrings","Jhumkas","Earcuff","Sui Dhaga");
		KumariHomePage page = new KumariHomePage(driver);	
		Assert.assertEquals(page.closeSingupPopup(), true);
		List<String>output=page.getsubmenufromTopNavBar();
		Assert.assertEquals(input.containsAll(output), true);
		
	}

	public void getsubmenuUnderShiopByMaterial() {

	}

	public void navigateToEarringsPage() {

	}

	public void verifysortBy() {

	}

	public void validateproductByPriceFilter() {

	}

}

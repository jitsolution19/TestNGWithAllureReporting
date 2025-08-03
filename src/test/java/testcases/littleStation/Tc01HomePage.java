package testcases.littleStation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import pages.littleStation.LittleStationHomePage;
import utilities.CaptureScreenshot;

public class Tc01HomePage extends BaseTest {

	@Test
	@Description("Test the Title of the Website")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Jeetendra Gupta")
	@Link(name = "Website", url = "https://littlestation.in/")
	@Issue("AUTH-123")
	@TmsLink("TMS-456")
	public void launchApplciation() {
		LittleStationHomePage home = new LittleStationHomePage(driver);
		home.getheader();
	}

	@Test
	public void validateLink() {
		String actualText = driver.findElement(By.xpath(".//p[@class='wp-block-site-tagline has-small-font-size']"))
				.getText();
		System.out.println(actualText);
		Assert.assertEquals("Little Treasures, Big Smiles!", actualText);
		CaptureScreenshot.takescreenshot(driver, "font validation");
	}
}

package testcases.automationFun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebSitetitleValidation {

	@Test()
	public void titlevalidation() {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://housing.com/");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Property | Real Estate | Buy/Sale/Rent | Property Site India");
		driver.quit();
	}
}

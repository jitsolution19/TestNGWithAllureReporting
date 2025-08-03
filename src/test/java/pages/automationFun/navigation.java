package pages.automationFun;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class navigation {

	protected WebDriver driver = new FirefoxDriver();

	@BeforeMethod
	public void Application_Launch() {
		Reporter.log("----------- Application Launch Browser ::: -----------------", true);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.jetblue.com/#/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector("span.foreground-sprite")).click();
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3.ng-binding.ng-scope")));
		Reporter.log("Application Title :: " + driver.getTitle(), true);
	}

	@AfterMethod
	public void CloseApplication() {
//		driver.quit();
		Reporter.log("----------- Application Closed-----------------", true);
	}
}

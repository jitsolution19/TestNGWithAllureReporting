package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.qameta.allure.Step;
import utilities.CaptureScreenshot;

public class BaseTest {
	public static WebDriver driver = null;
	private String currentApplication = "littleStation";

	@BeforeMethod
	public void setup() {
//		settingChrome();
		chromedriverSetup();
		deleteCookies();
		launchbrowser(new CaptureScreenshot().getapplicationurl(currentApplication));
	}

	@Step("Setting the Chrome Browser for Testing")
	public void settingChrome() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options);
	}

	public void chromedriverSetup() {
		driver = new ChromeDriver();
	}

	@Step("Delete the Cookies and Maximize the Browser")
	public void deleteCookies() {
//		new CaptureScreenshot();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Step("Launch the Application Url")
	public void launchbrowser(String url) {
		driver.get(url);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}
}

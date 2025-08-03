package testcases.automationFun;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchOption {

	WebDriver actiondriver;

	@FindBy(xpath = ".//span[contains(@class,'label')]")
	private List<WebElement> ChooseOption;

	@FindBy(xpath = ".//span[@class='city-select-name']")
	private List<WebElement> cityOption;

	@FindBy(xpath = ".//h1[@class='search-header']/div")
	private WebElement verificationheader;

	@FindBy(xpath = "//span[@class='new-search-text']")
	private WebElement DiscoverlocalitiesLink;

	@FindBy(xpath = ".//div[@class='mw-locality-tabs']/div")
	private List<WebElement> localityPurposetab;

	@FindBy(xpath = ".//div[@class='mw-list-container']/a")
	private List<WebElement> localityPricelink;

	@Test()
	public void LaunchApplication() throws Exception {
		System.out.println("Launch Application");
		System.setProperty("webdriver.chrome.driver", "B:\\Automation\\software\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://housing.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		actiondriver = driver;
		PageFactory.initElements(driver, this);

		selectvalue(ChooseOption, "buy");
		System.out.println("Clicked on Buy");
		Thread.sleep(3000);
		selectvalue(cityOption, "Pune");
		System.out.println("Clicked on Pune");
		System.out.println(verificationheader.getText());
		Thread.sleep(5000);
		selectvalue(localityPurposetab, "INVESTMENT HOTSPOTS");
		Thread.sleep(5000);

		if (localityPricelink.get(0).isEnabled()) {
			Iterator<WebElement> pricevalue = localityPricelink.iterator();
			while (pricevalue.hasNext()) {
				System.out.println("Price value are as :: " + pricevalue.next().getText());
			}
		}

	}

	public void selectvalue(List<WebElement> Options, String selectvalue) {
		if (Options.get(0).isEnabled()) {
			Iterator<WebElement> itrcity = Options.iterator();
			while (itrcity.hasNext()) {
				WebElement cityselection = itrcity.next();
				System.out.println("WebElement value :: " + cityselection.getText());
				if (cityselection.getText().matches(selectvalue)) {
					System.out.println("Selected Value ::" + cityselection.getText());
					try {
						if (cityselection.getText().matches("INVESTMENT HOTSPOTS")) {
							JavascriptExecutor jse = (JavascriptExecutor) actiondriver;
							jse.executeScript("arguments[0].scrollIntoView()", cityselection);
							jse.executeScript("arguments[0].click()", cityselection);

						} else {
							cityselection.click();
						}

					} catch (Exception e) {
						System.out.println(e);
					}
					break;
				}
			}
		}

	}
}

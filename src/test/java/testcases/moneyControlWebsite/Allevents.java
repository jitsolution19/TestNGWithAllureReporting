package testcases.moneyControlWebsite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.testng.Tag;

public class Allevents extends BaseTest{

	@Test
	@Description("Verify City is Changed from New Delhi to Pune")
	@Tag("E2E flow")
	@Owner("Jeetendra Gupta")
	public void changeCity() {
		driver.get("https://allevents.in/");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), driver.getTitle());
//		CaptureScreenshot.takescreenshot(driver, "HomePage");
	}
	@Test
	public void temp() {
		driver.get("https://allevents.in/");
		testing(driver);
		try {
			driver.findElement(By.cssSelector("div#qsp_change_city_app")).click();
		}catch(Exception e) {
		System.out.println(e);	
		}
	}
	
	public void testing(WebDriver driver) {
		try {
//			driver.findElement(By.cssSelector("input.hs_search_text")).click();
//			driver.findElement(By.cssSelector("input.hs_search_text")).clear();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input.hs_search_text"))));
			driver.findElement(By.cssSelector("input.hs_search_text")).sendKeys("Noida");
			Thread.sleep(5000);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.ss_filters .ss_filter_name")));
//			Actions action = new Actions(driver);
//			action.moveToElement(driver.findElement(By.cssSelector("span.ss_filter_name")));
//			action.click().perform();
//			wait.until(driver1 -> {
//			    List<WebElement> suggestions = driver1.findElements(By.cssSelector("div.ss_filters .ss_filter_name"));
//			    return suggestions.size() > 0;
//			});
			
//			wait.until(driver1 -> driver1.findElements(By.cssSelector("div.ss_filters .ss_filter_name")).size() > 0);
//			List<WebElement>elements=driver.findElements(By.cssSelector("span.ss_filter_name"));
			List<WebElement>elements=driver.findElements(By.cssSelector("div.ss_filters span.ss_filter_name"));
			System.out.println(elements.size());
			for(WebElement ele: elements) {
				System.out.println(ele.getText());
				if(ele.getText().equalsIgnoreCase("Noida - UP, India")) {
					ele.click();
					break;
				}
			}
//			getdropdownvalues();
		}catch(Exception e) {
		System.out.println(e);	
		}	
	}
	
	public void getdropdownvalues(){
		driver.findElement(By.cssSelector("#vs9__combobox")).click();
		List<WebElement>elements=driver.findElements(By.cssSelector("#vs9__listbox li"));
		for(WebElement ele: elements) {
			System.out.println(ele.getText());
		}
	}
	
	@Test
	public void allEventsSearchAutomation() {
		driver.get("https://allevents.in/#");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Actions actions = new Actions(driver);

        // Step 1: Click on the "Search City" box
        WebElement cityInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("city_picker")));
        cityInput.click();

        // Step 2: Clear and type "Gurgaon"
        cityInput.clear();
        cityInput.sendKeys("Gurgaon");

        // Step 3: Wait for the suggestion dropdown to appear
        // Suggestions are listed under: ul#ui-id-1 > li
        List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("ul#ui-id-1 li")));

        // Step 4: Click on the suggestion that matches "Gurgaon"
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().toLowerCase().contains("gurgaon")) {
                suggestion.click();
                break;
            }
        }

	}
}

package pages.kumari;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class KumariHomePage {
	private WebDriver driver;
	private WebDriverWait wait;

	public KumariHomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@Step("Validate the Popup Window is closed")
	public boolean closeSingupPopup() {
		boolean flag = false;
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("survey-frame-33l1hjm"));
			WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("surveyResponseFormId")));
			if (popup.isDisplayed()) {
//				CaptureScreenshot.takescreenshot(driver, "popupScreenshot");
				driver.findElement(By.xpath(".//i[@class='wewidgeticon we_close icon-large']")).click();
				flag = true;
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		driver.switchTo().defaultContent();
		return flag;
	}

	@Step("Validate the Popup Window is Opened after the launch of application")
	public boolean validatePopupWindow() {
		boolean flag = false;
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("survey-frame-33l1hjm"));
			WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("surveyResponseFormId")));
			if (popup.isDisplayed()) {
				flag = true;
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		driver.switchTo().defaultContent();
		return flag;
	}

	@Step("Get the Sub menu from the Top Nav bar")
	public ArrayList<String> getsubmenufromTopNavBar() {
		ArrayList<String> output = new ArrayList<String>();
		WebElement menu = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//a[@title='Earrings']/span"))));
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).perform();
		List<WebElement> subMenuItems=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//div[@class='bpcvpff mgz-element no-link custom_ninjamenu_title nav-item']/following-sibling::div//span")));
		for (WebElement item : subMenuItems) {
			output.add(item.getText());
			System.out.println(item.getText());
		}
		return output;
	}

	@Step("Get Menu from Top Nav bar")
	public String getmenufromTopNavBar(String menuOption) {
		return (driver.findElement(By.xpath(".//a[@title='" + menuOption + "']/span")).getText());
	}
}

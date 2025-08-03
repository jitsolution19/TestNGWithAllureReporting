package testcases.automationFun;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.automationFun.City_Selection;

public class DomesticBookingRoundTrip extends BaseTest{

	

	@Test
	public void RoundTrip() {
		City_Selection obj = new City_Selection();
		Reporter.log("----- Click on RoundTrip  ------- ", true);
		By ReturnBook = By.xpath("//label[@for='jbBookerItinRT']/span[@class='labeltextholder ng-binding']");
		driver.findElement(ReturnBook).click();
		String text = driver.findElement(ReturnBook).getText();
		System.out.println(text);
		Reporter.log("Click on RoundTrip  ::: Success", true);
		try {
			obj.city_selection(driver);
			Reporter.log("Selection of City ::: Success", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Reporter.log("Selection of City ::: Fail", true);
			e.printStackTrace();
		}

		// date input

		driver.findElement(By.id("jbBookerCalendarDepart")).clear();
		driver.findElement(By.id("jbBookerCalendarDepart")).click();
		driver.findElement(By.id("jbBookerCalendarDepart")).sendKeys("05-23-2017");
		Reporter.log("Departure Date Seleted ::: Success", true);
		driver.findElement(By.id("jbBookerCalendarReturn")).clear();
		driver.findElement(By.id("jbBookerCalendarReturn")).click();
		driver.findElement(By.id("jbBookerCalendarReturn")).sendKeys("05-27-2017");
		Reporter.log("Return Date Seleted ::: Success", true);
		driver.findElement(By.xpath("//input[@class='piejs']")).click();
//		wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headBlock_0")));
		System.out.println(driver.findElement(By.id("headBlock_0")).getText());
		Reporter.log("Search Flight Operation ::: Success", true);

		List<WebElement> element = driver.findElements(By.xpath("//td[@class='selectedTab']/descendant::span"));

		System.out.println("Size of the Element :::: " + element.size());
		System.out.println("Background color ::: " + element.get(0).getCssValue("background"));
		Iterator<WebElement> itr = element.iterator();
		while (itr.hasNext()) {
			WebElement value = itr.next();
			System.out.println("Value ::: " + value.getText());

		}

		By Price = By.xpath("//table[@id='AIR_SEARCH_RESULT_CONTEXT_ID0']/descendant::div[@class='colPrice']/label");
		List<WebElement> price = driver.findElements(Price);
		System.out.println("Number of Price Found ::: " + price.size());
		Iterator<WebElement> Price_count = price.iterator();
		while (Price_count.hasNext()) {
			WebElement valuation = Price_count.next();
			System.out.println("Price of tickets ::: " + valuation.getText());

		}

		By NumberofRow = By.xpath("//table[@id='AIR_SEARCH_RESULT_CONTEXT_ID0']/descendant::tbody/tr");
		List<WebElement> RowNumber = driver.findElements(NumberofRow);
		System.out.println("Number of Row Found ::: " + RowNumber.size());
		Iterator<WebElement> Row_count = RowNumber.iterator();
		while (Row_count.hasNext()) {
			WebElement rowvalue = Row_count.next();
			System.out.print("Ticket Information ::: " + rowvalue.getText() + " || ");
			System.out.println();
		}

		By Timing = By.xpath("//table[@id='AIR_SEARCH_RESULT_CONTEXT_ID0']/descendant::tbody//td[@class='colDepart']");
		List<WebElement> timing_element = driver.findElements(Timing);
		Iterator<WebElement> timing_count = timing_element.iterator();
		while (timing_count.hasNext()) {
			WebElement timing_value = timing_count.next();
			WebElement Dep_timing = timing_value.findElement(By.xpath("//div[@class='time']"));
			System.out.println("Ticket Information ::: " + Dep_timing.getText());

			if (Dep_timing.getText().matches("6:59 AM")) {
				Reporter.log("Departure timing is matching ", true);
				WebElement temp = Dep_timing.findElement(By.xpath("/ancestor::*//td[@class='colDepart']"));
				List<WebElement> exactPrice = temp
						.findElements(By.xpath("//following-sibling::td//div[@class='colPrice']/label"));
				System.out.println("Exact Price Size ::: " + exactPrice.size());
				System.out.println("Exact Price ::: " + exactPrice.get(0).getText());
				System.out.println("Exact Price ::: " + exactPrice.get(1).getText());
				System.out.println("Exact Price ::: " + exactPrice.get(2).getText());
			}
		}

//		element.get(0).findElement(By.xpath("//span[@class='wcag-offscreen']")).getText();
//		System.out.println(element.get(0).findElement(By.xpath("//span[@class='wcag-offscreen']")).getText());
//		System.out.println(element.get(1).findElement(By.xpath("//span[@class='wcag-offscreen']")).getText());
	}

}

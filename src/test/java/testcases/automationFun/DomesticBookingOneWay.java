package testcases.automationFun;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;

public class DomesticBookingOneWay extends BaseTest  {

	@Test
	public void searchflight_Domestic_Oneway() throws Exception
	{
		driver.navigate().to("https://www.jetblue.com/#/");
		By OneWay_Button = By.xpath("//label[@for='jbBookerItinOW']/span[@class='labeltextholder ng-binding']");
		driver.findElement(OneWay_Button).click();
		String Oneway = driver.findElement(OneWay_Button).getText();
		
		System.out.println("One Way : ::"+Oneway);
		
		// Departure_City
		driver.findElement(By.id("jbBookerDepart")).clear();
		driver.findElement(By.id("jbBookerDepart")).click();		
		driver.findElement(By.id("jbBookerDepart")).sendKeys("JFK");
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='airport_list']/li"))); 
		By Departure_City = By.xpath("//ul[@class='airport_list']/li");
		List <WebElement> CityList = driver.findElements(Departure_City);
		int numberofCity = CityList.size();
		System.out.println("Number of City ::: "+numberofCity);
		
		for(int i =0; i<numberofCity;i++)
		{
			System.out.println("Recommended City ::: "+CityList.get(i).getText());
			if (CityList.get(i).getText().trim().matches("New York, NY (JFK)"))
			{
				CityList.get(i).click();				
			}
		}
		
		Thread.sleep(5000);
		// Arrival City 
		
		driver.findElement(By.id("jbBookerArrive")).clear();
		driver.findElement(By.id("jbBookerArrive")).click();		
		driver.findElement(By.id("jbBookerArrive")).sendKeys("BOS");
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='airport_list']/li")));
		
		By Arrival_City = By.xpath("//ul[@class='airport_list']/li");
//		Select arr_city = new Select(driver.findElement(Arrival_City));
//		arr_city.selectByVisibleText("Boston, MA (BOS)");
		
		List <WebElement> Arrival_CityList = driver.findElements(Arrival_City);
		
		int Arrival_numberofCity = Arrival_CityList.size();
		System.out.println("Number of City ::: "+Arrival_numberofCity);
		
		for(int i =0; i<Arrival_numberofCity;i++)
		{
			System.out.println("Recommended City ::: "+Arrival_CityList.get(i).getText());
			if (Arrival_CityList.get(i).getText().trim().matches("Boston, MA (BOS)"))
			{
				Arrival_CityList.get(i).click();
			}
		}
		
		
		driver.findElement(By.id("jbBookerCalendarDepart")).clear();
		driver.findElement(By.id("jbBookerCalendarDepart")).click();
		driver.findElement(By.id("jbBookerCalendarDepart")).sendKeys("05-23-2017");
//		By Calender = By.xpath("//button[@class='input-group-btn cal-btn cal-btn-depart btn-default jbbkr-foreground-sprite-depart jbbkr-calendar-depart']");
//		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@class='piejs']")).click();
//		wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headBlock_0")));
		System.out.println(driver.findElement(By.id("headBlock_0")).getText());
		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='piejs']")));
		
//		WebElement element = driver.findElement(By.xpath("//input[@class='piejs']"));
		
		
//		// Configure the Action
//		Actions action = new Actions(driver);
//
//		//Focus to element
//		action.moveToElement(element).perform();
//
//		// To click on the element
//		action.moveToElement(element).click().perform();
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", element);
//		
//		((JavascriptExecutor) driver).executeScript("handleSubmit($event)");
//		((JavascriptExecutor) driver).executeScript("document.getelementsbyclassname('piejs')[0].click()");
		
	}
		
}

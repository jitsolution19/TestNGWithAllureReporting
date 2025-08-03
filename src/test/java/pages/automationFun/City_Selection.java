package pages.automationFun;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class City_Selection {

	
	public void city_selection(WebDriver driver) throws Exception
	{
		driver.findElement(By.id("jbBookerDepart")).clear();
		driver.findElement(By.id("jbBookerDepart")).click();		
		driver.findElement(By.id("jbBookerDepart")).sendKeys("JFK");
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
		
		By Arrival_City = By.xpath("//ul[@class='airport_list']/li");		
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
		
	}

}

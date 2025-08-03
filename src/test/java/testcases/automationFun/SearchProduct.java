package testcases.automationFun;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.automationFun.CitySelection;
import pages.automationFun.SearchFreshVegetables;

public class SearchProduct {

	@Test()
	public void launchbrowserandsearchproduct() throws Exception
	{
		System.out.println("Launch Application");
		System.setProperty("webdriver.chrome.driver", "B:\\Automation\\software\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		CitySelection objcity= new CitySelection(driver);
		objcity.selectCity("Pune", "411014");
		
		String MainProduct[] = {"Snacks & Branded Foods","Fruits & Vegetables","Fruits & Vegetables","Fruits & Vegetables"};
		String Product[] = {"Indian Mithai","Herbs & Seasonings","Fresh Vegetables","Fresh Fruits"};
		SearchFreshVegetables veg = new SearchFreshVegetables(driver);
		int counter =0;
		while(counter<4)
		{
			veg.searchdrowdownfromcatergory(MainProduct[counter], Product[counter]);	
			counter++;
		}
		driver.quit();
		
	}
}

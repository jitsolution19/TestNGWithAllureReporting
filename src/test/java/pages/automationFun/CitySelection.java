package pages.automationFun;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CitySelection {
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='cityWidget']//input")
	private WebElement CitySelectionAlert;
	
	@FindBy(xpath=".//*[@qa='cityDD']")
	private WebElement CitySelectiondropdown;
	
	@FindBy(xpath=".//*[@qa='cityDD']//div")
	private List<WebElement> cityList;
	
	@FindBy(xpath=".//button[@qa='continueBtn']")
	private WebElement ContinueButton;	
	
	@FindBy(xpath=".//*[@id='areaselect']")
	private WebElement areaInputbox;
	

	public CitySelection(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void selectCity(String deliverycity,String pincode) throws Exception
	{
		CitySelectionAlert.click();
		CitySelectiondropdown.click();		
		System.out.println("City List "+cityList.size());
		Iterator<WebElement> city= cityList.iterator();
		while(city.hasNext())
		{
			WebElement tempCity= city.next();
			if(tempCity.isDisplayed()&&tempCity.isEnabled()&&tempCity.getText().matches(deliverycity))
			{
				System.out.println(tempCity.getText());	
				tempCity.click();
				break;
			}
						
		}
		
		areaInputbox.clear();
		areaInputbox.sendKeys(pincode);
		ContinueButton.click();
		Thread.sleep(2000);
	}
}

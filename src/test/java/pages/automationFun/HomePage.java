package pages.automationFun;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(id = "ResBuyTab")
	WebElement BuyTab;

	@FindBy(id = "ResRentTab")
	WebElement RentTab;

	@FindBy(id = "NpTab")
	WebElement ProjectsTab;

	@FindBy(id = "ComTab")
	WebElement CommericalTab;
	
	@FindBy(id = "DealerTab")
	WebElement DealersTab;
	
	@FindBy(id = "keyword")
	WebElement SearchBar;
	
	@FindBy(id = "submit_query")
	WebElement SearchButton;
	
	@FindBy(id = "city-list")
	WebElement CityListSelector;
	
	@FindBy(id = "map_submit_query")
	WebElement MapSearchButton;
	
	@FindBy(id = "hmcontainer")
	WebElement ThreeDashLine;
	
	@FindBy(id = "login")
	WebElement Login_registerTab;

}

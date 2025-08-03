package pages.automationFun;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFreshVegetables {
	private WebDriver driver;	
	@FindBy(id = "navBarMegaNav")
	private WebElement dropdown;

	@FindBy(linkText = "Fresh Vegetables")
	private WebElement FreshVegetables_Link;
	
	@FindBy(xpath=".//*[@id='navBarMegaNav']/li")
	private List<WebElement> Mainmenuoptionsh;
	
	@FindBy(xpath="//ul[@class='nav nav-pills nav-stacked']//a")
	private List<WebElement> subcat;
	
	@FindBy(xpath=".//*[@ng-bind='vm.selectedProduct.p_desc']")
	private List<WebElement> ProductName;
	
	@FindBy(xpath=".//*[@data-bind='label']")
	private List<WebElement> productlabel;
	
	 @FindBy(xpath="//div[@class='items']/div//h4")
	 private List<WebElement> pricetag;
	 
	 @FindBy(xpath=".//ul[@class='dropdown-menu']")
	 private WebElement dropdownName;
	 
	 @FindBy(xpath=".//a[contains(text(),'Shop by Category')]")
	 private WebElement CategoryName;
	 
	 @FindBy(xpath=".//span[@ng-bind='vm.screen_name']")
	 private WebElement ProductScreenName;
	 
	public SearchFreshVegetables(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchdrowdownfromcatergory(String MainProduct,String Product) throws Exception
	{
		System.out.println(dropdownName.getText());
		CategoryName.click();
		Thread.sleep(3000);
		try {
			Iterator<WebElement> Mainmenuoptions = Mainmenuoptionsh.iterator();
			while (Mainmenuoptions.hasNext()) {
				WebElement navbarmenu = Mainmenuoptions.next();
				if (navbarmenu.isDisplayed() && navbarmenu.isEnabled() && navbarmenu.getText().matches(MainProduct)) {
					Actions action = new Actions(driver);
					action.moveToElement(navbarmenu);
					action.build().perform();
					break;
				}

			}
			Iterator<WebElement> subcatnumber = subcat.iterator();
			while (subcatnumber.hasNext()) {
				WebElement subcatitems = subcatnumber.next();
				if (subcatitems.isDisplayed() && subcatitems.isEnabled() && subcatitems.getText().matches(Product)) {
					System.out.println(subcatitems.getText());
					subcatitems.click();
					break;
				}
			}

			productinfo();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void productinfo() throws Exception {
		Thread.sleep(5000);
		System.out.println(ProductScreenName.getText());
		Iterator<WebElement> Product = ProductName.iterator();
		Iterator<WebElement> label = productlabel.iterator();
		Iterator<WebElement> price = pricetag.iterator();

		while (Product.hasNext()) {
			try {
				System.out.println("Product Name  :: " + Product.next().getText());
				System.out.println("Product Label :: " + label.next().getText());
				System.out.println("Product Price :: " + price.next().getText());
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}

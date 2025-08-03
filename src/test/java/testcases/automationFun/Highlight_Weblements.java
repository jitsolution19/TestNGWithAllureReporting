package testcases.automationFun;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

public class Highlight_Weblements {

	public static void highlightElement(WebElement element) throws Exception {
		for (int i = 0; i < 5; i++) {
			WrapsDriver wrappedElement = (WrapsDriver) element;
			JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
			driver.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,
					"color: green; border: 5px solid red;");
			Thread.sleep(500);
			driver.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "");
		}
	}
}
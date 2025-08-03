package utilities;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

public class CaptureScreenshot {

	public static void takescreenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String source = screenshot.getScreenshotAs(OutputType.BASE64);
		byte[] decodedImg = Base64.getDecoder().decode(source);
		Allure.addAttachment(screenshotName, new ByteArrayInputStream(decodedImg));
	}

	public String getapplicationurl(String applciationName) {
		String url = null;
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("application.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		switch (applciationName) {
		case "trident":
			url = prop.getProperty("tridenturl");
			break;
		case "littleStation":
			url = prop.getProperty("littleStationUrl");
			break;
		case "kumari":
			url = prop.getProperty("kumariurl");
			break;
		default:
			url = "Incorrect selection";
		}
		return url;

	}
}

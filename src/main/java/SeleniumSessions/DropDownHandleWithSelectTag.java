package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandleWithSelectTag {

	static WebDriver driver;

	public static void main(String[] args) {
		
		//drop down-- html  tag --> select
		//Select class in Selenium
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
//		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));		
//		Select select = new Select(country);
//		select.selectByIndex(9);
//		select.selectByVisibleText("India");
//		select.selectByValue("Taiwan");
		
		By country = By.id("Form_submitForm_Country");
		doDropDownSelectByIndex(country, 10);
		doDropDownSelectByVisibleText(country, "France");
		doDropDownSelectByValue(country, "India");
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doDropDownSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);	
	}
	
	public static void doDropDownSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);	
	}
	
	public static void doDropDownSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);	
	}

}

package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//4th: By locator with generic method (getElement())
		
//		By username = By.id("input-email");
//		By password = By.id("input-password");
//		
//		getElement(username).sendKeys("abhi@gmail.com");
//		getElement(password).sendKeys("admin");
		
		//5th: By locator with generic method (getElement() with action methods)
		
//		By username = By.id("input-email");
//		By password = By.id("input-password");
//		doSendKeys(username, "abhi@gmail.com");
//		doSendKeys(password, "admin");
		
		//6th ElementUtil class with generic methods
//		By username = By.id("input-email");
//		By password = By.id("input-password");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(username, "Naveen@test.com");
//		eleUtil.doSendKeys(password, "admin123");
		
		//7th String locator values:
		
		String userNameId = "input-email";
		String passwordId = "input-password";
		doSendKeys("id", userNameId, "test@email.com");
		doSendKeys("id", passwordId, "test1");
		
		
	}
	
	public static By getBy(String locatorType, String locatorValue) {
		By locator = null;
		
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;

		default:
			System.out.println("please pass the right locator type and value...");
			break;
		}
		return locator;	
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(locatorType, locatorValue).sendKeys(value);
	}

}

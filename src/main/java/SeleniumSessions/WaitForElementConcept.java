package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		By username = By.name("username11");
		By password = By.name("password");
		By loginBtn = By.xpath("//input[@type='submit']");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement userName_ele = wait.until(ExpectedConditions.presenceOfElementLocated(username));
//		userName_ele.sendKeys("Naveen");
		
		//doSendKeys(username, "naveen", 10);
		
		
//		doPresenceOfElementLocated(username, 10, 2000);
//		driver.findElement(password).sendKeys("12345");
//		driver.findElement(loginBtn).click();
		
		By footers = By.xpath("//footer//ul[@class='footer-nav']//a");
		
//		List<WebElement> footerList = waitForElementsToBeVisible(footers, 5);
//		for (WebElement e : footerList) {
//			System.out.println(e.getText());
//		}
		if(getElementsTextListWithWait(footers, 5).contains("Partners")) {
			System.out.println("PASS");
		}
		
	}
	
	public static void doSendKeys(By locator, String value, int timeOut) {
		doPresenceOfElementLocated(locator, timeOut).sendKeys(value);
	}
	
	public static WebElement doPresenceOfElementLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement doPresenceOfElementLocated(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement waitForElementToBeVisibleWithWebElement(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}
	
	public static List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public static List<WebElement> waitForElementsToBeVisible(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public static List<String> getElementsTextListWithWait(By locator, int timeOut) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeOut);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e: eleList) {
			String text = e.getText();
			eleTextList.add(text);
		}
		return eleTextList;
	}

}

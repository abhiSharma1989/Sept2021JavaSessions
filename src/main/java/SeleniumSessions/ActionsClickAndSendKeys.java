package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
//		Actions act = new Actions(driver);
//		
//		WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
//		WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
//		
//		act.sendKeys(firstName, "Abhinandan").perform();
//		act.sendKeys(lastName, "Sharma").perform();
//		
//		act.click(firstName).sendKeys("Abhinandan").perform();
		
		By firstName = By.xpath("//input[@id='input-firstname']");
		By lastName = By.xpath("//input[@id='input-lastname']");
		By agree = By.xpath("//input[@name='agree']");
		
		doActionsSendKeys(firstName, "Abhinandan");
		doActionsSendKeys(lastName, "Sharma");
		
		doActionClick(agree);
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).build().perform();
	}
	
	public static void doActionsSendKeysOnActiveElement(By locator, String value) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).sendKeys(value).build().perform();
	}
	
	public static void doActionClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}
	
	public static void doActionMoveToElementClick(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).click().build().perform();
	}

}

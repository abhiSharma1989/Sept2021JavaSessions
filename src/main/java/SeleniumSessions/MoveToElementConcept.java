package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/search/?txtsearch=how-to-create-menu-with-submenu-using-css-html");
		
//		WebElement parentMenu = driver.findElement(By.xpath("//a[contains(text(), 'Content')]"));
//		
//		Actions act = new Actions(driver);
//		act.moveToElement(parentMenu).perform();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.linkText("COURSES")).click();
		
		By contentLink = By.xpath("//a[contains(text(), 'Content')]");
		By coursesText = By.linkText("COURSES");
		Thread.sleep(2000);
		By articlesText = By.linkText("ARTICLES");
		doClickOnChildMenu(contentLink, coursesText);
		doClickOnChildMenu(contentLink, articlesText);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doMoveToElement(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).perform();
	}
	
	public static void doClickOnChildMenu(By parentMenuLocator, By childMenuLocator) throws InterruptedException {
		doMoveToElement(parentMenuLocator);
		Thread.sleep(2000);
		getElement(childMenuLocator).click();
	}

}

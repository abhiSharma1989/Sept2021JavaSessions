package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyElement {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		By formFields = By.className("text");
		int fieldsCount = driver.findElements(formFields).size();
		if(fieldsCount == 0) {
			System.out.println("form fields are not available");
		}else {
			System.out.println("form fields are available");
		}
		
		//to verify the single element:
		By contactSalesLink = By.linkText("CONTACT SALES11");
		//driver.findElement(contactSalesLink).click();
		Boolean flag = driver.findElement(contactSalesLink).isDisplayed();
		System.out.println(flag);
		
		if(driver.findElements(contactSalesLink).size() >= 1) {
			System.out.println("contact sales link is present on the page");
		}
		
		Boolean flag2 = isElementExist(contactSalesLink);
		System.out.println(flag2);
	}
	
	
	public static boolean isElementExist(By locator) {
		int elementCount = driver.findElements(locator).size();
		System.out.println("total elements found: " + elementCount);
		if(elementCount >= 1) {
			System.out.println("Element is found..." + locator);
			return true;
		}else {
			System.out.println("Element is not found..." + locator);
			return false;
		}
	}

}

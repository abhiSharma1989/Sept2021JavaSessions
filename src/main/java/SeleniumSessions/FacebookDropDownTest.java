package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookDropDownTest {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		Thread.sleep(2000);
		
		By createAccount = By.linkText("Create New Account");
		By day = By.id("day");
		By month = By.id("month");
		By year = By.id("year");
		
		
		eleUtil.doClick(createAccount);
		
		Thread.sleep(4000);
		eleUtil.doDropDownSelectByValue(day, "26");
		eleUtil.doDropDownSelectByValue(month, "9");
		eleUtil.doDropDownSelectByVisibleText(year, "1989");
		
		
		

	}

}

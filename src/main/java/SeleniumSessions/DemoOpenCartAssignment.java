package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoOpenCartAssignment {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		List<WebElement> linkElements = driver.findElements(By.xpath("//a[@class='list-group-item']"));
		System.out.println(linkElements.size());
		
		for(WebElement e: linkElements) {
			String text = e.getText();
			String attr = e.getAttribute("href");
			System.out.println(text + " ----> " + attr);
		}
		
	}

}

package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("naveen automation labs");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']//span/b[contains(text(),'linkedin')]")).click();	
		
		List<WebElement> suggList = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']/span"));
		System.out.println(suggList.size());
		
		int count = 1;
		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(count + " " + text);
			count++;
			if(text.equals("naveen automation labs linkedin")) {
				e.click();
				break;
			}
			
		}

	}

}

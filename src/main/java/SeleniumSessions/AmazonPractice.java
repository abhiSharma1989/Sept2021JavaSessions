package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPractice {
	
	static WebDriver driver;
	//getLinksTextList
	//clickOnElement

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		By amzFooter = By.xpath("//div[@class='navFooterVerticalRow navAccessibility']/div//ul/li");
		//clickOnElement(amzFooter, "Investor Relations");
		List<String> amzFooterText=getLinksTextList(amzFooter);
		System.out.println(amzFooterText);
		if(amzFooterText.contains("Amazon Devices")) {
			System.out.println("Amazon Devices is present on the page");
		}
	}
	
	public static List<String> getLinksTextList(By locator) {
		List<WebElement> amazonFooters = driver.findElements(locator);
		List<String> footersText = new ArrayList<String>();
		System.out.println(amazonFooters.size());
		
		for(WebElement e : amazonFooters) {
			String footers = e.getText();
			footersText.add(footers);
		}
		return footersText;
	}
	
	public static void clickOnElement(By locator, String linkText) {
		List<WebElement> amazonFooters = driver.findElements(locator);
		System.out.println(amazonFooters.size());
		
		for(WebElement e : amazonFooters) {
			String footers = e.getText().trim();
			System.out.println(footers);
			if(footers.equals(linkText)) {
				e.click();
				break;
				
			}
		}
	}

}

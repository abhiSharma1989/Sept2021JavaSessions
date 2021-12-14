package SeleniumSessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		
		WebElement ele = driver.findElement(By.xpath("//a[text()='Terrebonne, Canada']"));
		WebElement ele2 = driver.findElement(By.xpath("//a[text()='Ontario']"));
//		String aqNum = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
//		System.out.println(aqNum);
//		
//		String rank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
//		System.out.println(rank);
//		
//		String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
//		System.out.println(belowCity);
//		
//		String cityColName = driver.findElement(with(By.tagName("p")).above(ele)).getText();
//		System.out.println(cityColName);
//		
//		String name = driver.findElement(with(By.tagName("p")).near(ele)).getText();
//		System.out.println(name);
		
		String location = driver.findElement(with(By.tagName("th")).near(ele2)).getText();
		System.out.println(location);
		
		List<WebElement> pollutedCities = driver.findElements(with(By.tagName("td")).toRightOf(ele2));
		for(WebElement e : pollutedCities) {
			String text = e.getText();
			System.out.print(text + " ");
		}
		

	}

}

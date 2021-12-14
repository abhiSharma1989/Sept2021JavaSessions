package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketBowlingTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/icc-men-s-t20-world-cup-2021-22-1267897/australia-vs-pakistan-2nd-semi-final-1273755/full-scorecard");
		
		System.out.println(getBowlingStats("Glenn Maxwell"));

	}
	
	public static List<String> getBowlingStats(String playerName) {
		String xpath = "(//a[text()='"+playerName+"']/parent::td)[1]/following-sibling::td";
		List<WebElement> bowlingStats = driver.findElements(By.xpath(xpath));
		List<String> bowlingValues = new ArrayList<String>();
		for(int i =0; i<bowlingStats.size(); i++) {
			String text = bowlingStats.get(i).getText();
			bowlingValues.add(text);	
		}
		return bowlingValues;
	}
}

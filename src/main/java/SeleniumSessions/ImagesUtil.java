package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagesUtil {

	// you have to get the count of all the images on the page
	// then print the src/alt attributes of each link on the console

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		By images = By.tagName("img");
		By links = By.tagName("a");
		System.out.println(getElementsCount(images));
		List<String> attrList = getAttributeList(images, "src");
		System.out.println("Switch values are: 1");
		printElementValues(attrList);
		System.out.println("Switch values are: 2");
		printElementValues(getAttributeList(images, "alt"));
		System.out.println("Switch values are: 3");
		printElementValues(getAttributeList(links, "href"));
		System.out.println("Switch values are: 4");
	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	public static void printElementValues(List<String> eleList) {
		for(String e : eleList) {
			System.out.println(e);
		}
	}
	
	public static List<String> getAttributeList(By locator, String attributeName) {
		List<WebElement> eleList = getElements(locator);
		List<String> attrList = new ArrayList<String>();
		
		for(WebElement e : eleList) {
			String attrValue = e.getAttribute(attributeName);
			attrList.add(attrValue);
		}
		return attrList;
	}
	
}

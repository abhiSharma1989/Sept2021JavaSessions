package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameCount {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://allwebco-templates.com/support/S_script_IFrame.htm");
		
		driver.findElement(By.id("name11")).click();
		
//		List<WebElement> alto = driver.findElements(By.tagName("iframe11"));
//		System.out.println(alto.size());

	}

}

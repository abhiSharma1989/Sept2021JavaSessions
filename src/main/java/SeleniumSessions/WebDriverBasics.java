package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abhinandan Sharma\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		
		if(title.equals("Google")) {
			System.out.println("Pass -- Correct Title");
		}else {
			System.out.println("Fail -- Incorrect Title");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();

	}

}

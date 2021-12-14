package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTest {

	static WebDriver driver;

	public static void main(String[] args) {

		String Browser = "Chrome";

		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Abhinandan Sharma\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome Browser launched");
		} else if (Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Abhinandan Sharma\\Downloads\\geckodriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("Please pass the correct browser..." + Browser);
		}
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);

		if (title.equals("Google")) {
			System.out.println("Pass -- Correct Title");
		} else {
			System.out.println("Fail -- Incorrect Title");
		}

		System.out.println(driver.getCurrentUrl());

		driver.quit();

	}

}

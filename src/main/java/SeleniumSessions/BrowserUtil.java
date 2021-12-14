package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtil {
	public WebDriver driver;

	public WebDriver launchBrowser(String Browser) {
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
		return driver;
	}

	public void getUrl(String url) {
		if (url == null) {
			System.out.println("url is missing");
			return;
		}
		if (url.indexOf("http") == -1) {
			System.out.println("http is missing in url");
			return;
		}
		driver.get(url);
	}

	public String getAppCurrenturl() {
		return driver.getCurrentUrl();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}

package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClosevsQuit {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		// a95622a2675edc146f078a7862d6c71f  //quit 4ed8936b125d8e27ce041eff1a473f4f
		String url = driver.getCurrentUrl();
		System.out.println(url);
//		driver.close();//NoSuchSessionException -- invalid session id
		driver.quit();//NoSuchSessionException -- session id is null
		
//		System.out.println(driver.getTitle());
		driver = new ChromeDriver();
		//c5543d9ba4c1279f362b2aa398039e01  //quit 4ed8936b125d8e27ce041eff1a473f4f Earlier session id will become null
		
	}

}

package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameTestAssignment {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get("https://allwebco-templates.com/support/S_script_IFrame.htm");
		Thread.sleep(4000);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='Framename' and @class='framesample framesample2']")));
		
		driver.findElement(By.xpath("//img[@alt='Search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form[@name='application' and @class='formmargin']/table//input[@class='stterms']")).sendKeys("test123");
		driver.findElement(By.xpath("//form[@name='application' and @class='formmargin']/table//input[@name='submitbutton']")).click();
		driver.switchTo().defaultContent();
		String text = driver.getTitle();
		System.out.println(text);
		
		

	}

}

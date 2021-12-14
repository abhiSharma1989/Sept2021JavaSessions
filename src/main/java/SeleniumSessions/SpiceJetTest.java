package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		
		String text = driver.getTitle();
		System.out.println(text);
		
//		WebElement AddOnsLink = driver.findElement(By.xpath("//div[contains(text(), 'Add-ons')]"));
//		
//		Actions act = new Actions(driver);
//		act.moveToElement(AddOnsLink).perform();
//		
//		Thread.sleep(2000);
//		
//		driver.findElement(By.linkText("Visa Services")).click();
//		Thread.sleep(5000);
//		driver.switchTo().window("SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
//		
//		act.moveToElement(AddOnsLink).perform();
//		driver.findElement(By.linkText("Spice Assurance")).click();
		
		WebElement AddOnsLink = driver.findElement(By.xpath("//div[text() = 'Add-ons']"));
		WebElement SpiceMax = driver.findElement(By.xpath("//div[text() = 'SpiceMAX']"));
		WebElement Seat = driver.findElement(By.xpath("//div[text() = 'Seat + Meal Combo']"));
		WebElement VisaServices = driver.findElement(By.xpath("//div[text() = 'Visa Services']"));
		Thread.sleep(12000);
		Actions act = new Actions(driver);
		act.click(AddOnsLink).build().perform();
		System.out.println("1");
		Thread.sleep(1000);
		act.click(SpiceMax).build().perform();
		System.out.println("2");
		Thread.sleep(1000);
		act.click(SpiceMax).build().perform();
		System.out.println("3");
		Thread.sleep(1000);
		act.click(SpiceMax).build().perform();
		System.out.println("4");
		
		driver.getWindowHandle();
		
		
		
		

	}

}

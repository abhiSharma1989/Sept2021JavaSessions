package MyTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WhenWiseTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://whenwise.com/sign-in");
		driver.findElement(By.id("email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
	}
		
	@Test
	public void displayTest() {
		driver.navigate().to("https://whenwise.com/");
		Boolean flag = driver.findElement(By.xpath("//div[text()='Recent visited businesses']")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void elementPresentTest() {
		driver.findElement(By.xpath("//span[@class='avatar-status avatar-online']/img")).click();
		driver.findElement(By.xpath("//a[text()='Edit Profile']")).click();
		String text = driver.findElement(By.xpath("//h5[text()='Edit Profile']")).getText();
		System.out.println(text.contains("Edit Profile"));
	}
	
	@Test
	public void getAttributeTest() {
		driver.navigate().to("https://whenwise.com/users/2835/edit");
		String value= driver.findElement(By.id("user_first_name")).getAttribute("value");
		Assert.assertTrue(value.equals("Naveen"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		

}


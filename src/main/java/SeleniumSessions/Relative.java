package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://whenwise.com/sign-in");

		driver.findElement(By.id("email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();

		driver.navigate().to("https://whenwise.com/users/2835/edit");

		WebElement ele = driver.findElement(By.xpath("//span[text()='Email on booking confirmation?']"));
		WebElement ele2 = driver.findElement(By.xpath("//span[text()='Accept SMS appointment reminder?']"));
		By classLever = By.className("lever");

		directionClick(classLever, ele);

		directionClick(classLever, ele2);

	}

	public static void directionClick(By classlocator, WebElement ele) {
		driver.findElement(with(classlocator).toRightOf(ele)).click();
	}

}

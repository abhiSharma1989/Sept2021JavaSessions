package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("alert('Hey, this is just a test')");
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		String title = jsUtil.getTitleByJS();
		System.out.println(title);
		
//		jsUtil.generateAlert("this is my js pop up");
		
//		String innerText = jsUtil.getPageInnerText();
//		System.out.println(innerText);
//		System.out.println(innerText.contains("We just need a few more information."));
		
//		jsUtil.refreshBrowserByJS();
//		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
//		WebElement loginForm = driver.findElement(By.id("loginForm"));
//		jsUtil.drawBorder(loginForm);
		
//		jsUtil.flash(login);
//		jsUtil.flash(loginForm);
		
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
		
//		jsUtil.flash(emailId);
//		emailId.sendKeys("naveen@gmail.com");
//		jsUtil.flash(password);
//		password.sendKeys("test123");
		
//		WebElement register = driver.findElement(By.linkText("Register"));
//		jsUtil.clickElementByJS(register);
		
//		WebElement comfyStyles = driver.findElement(By.xpath("//h2[contains(text(), 'Comfy styles for her')]"));
//
//		jsUtil.scrollPageDown();
//		Thread.sleep(2000);
//		jsUtil.scrollPageUp();
//		Thread.sleep(2000);
//		jsUtil.scrollPageDown("500");
//		Thread.sleep(2000);
//		jsUtil.scrollIntoView(comfyStyles);
		
		

	}

}

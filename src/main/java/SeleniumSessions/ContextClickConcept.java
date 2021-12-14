package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClickConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement rightClickMe = driver.findElement(By.xpath("//span[text()='right click me']"));

		Actions act = new Actions(driver);

		act.contextClick(rightClickMe).build().perform();

		By contextClickButton = By.xpath(
				"//ul[@class='context-menu-list context-menu-root']//li[contains(@class, 'context-menu-icon')]/span");
		
		
		contextClickAlertHandle(contextClickButton, "Edit", "clicked: edit");
		act.contextClick(rightClickMe).build().perform();
		contextClickAlertHandle(contextClickButton, "Cut", "clicked: cut");
		act.contextClick(rightClickMe).build().perform();
		contextClickAlertHandle(contextClickButton, "Copy", "clicked: copy");
		act.contextClick(rightClickMe).build().perform();
		contextClickAlertHandle(contextClickButton, "Paste", "clicked: paste");
		act.contextClick(rightClickMe).build().perform();
		contextClickAlertHandle(contextClickButton, "Delete", "clicked: delete");
		act.contextClick(rightClickMe).build().perform();
		contextClickAlertHandle(contextClickButton, "Quit", "clicked: quit");

	}

	public static void contextClickAlertHandle(By locator, String value, String alertValue) throws InterruptedException {
		
		List<WebElement> optList = driver.findElements(locator);

		for (WebElement e : optList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				Alert alert = driver.switchTo().alert();
				String text1 = alert.getText();
				System.out.println(text1);
				Thread.sleep(2000);
				if (text1.equals(alertValue)) {
					alert.accept();
					break;
				}
			}
		}
	}
}

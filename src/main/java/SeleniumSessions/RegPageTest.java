package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest {

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.getUrl("https://demo.opencart.com/index.php?route=account/register");
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
		By cont = By.xpath("//input[@value='Continue']");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Ronnie");
		eleUtil.doSendKeys(lastName, "Nayyar");
		eleUtil.doSendKeys(email, "Ronnie@test.com");
		eleUtil.doSendKeys(telephone, "9780704172");
		eleUtil.doSendKeys(password, "abhi1");
		eleUtil.doSendKeys(confirmPassword, "admin1");
		eleUtil.doClick(cont);
		
		Thread.sleep(5000);
		
		brUtil.quitBrowser();
		

	}

}

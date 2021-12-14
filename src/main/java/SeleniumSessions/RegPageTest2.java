package SeleniumSessions;

import org.openqa.selenium.WebDriver;

public class RegPageTest2 {

	public static void main(String[] args) throws InterruptedException {
		
		
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.getUrl("https://demo.opencart.com/index.php?route=account/register");
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		String fName = "input-firstname";
		String lName = "input-lastname";
		String email1 = "input-email";
		String phone = "input-telephone";
		String pswd = "input-password";
		String cnfrmPswd = "input-confirm";
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", fName, "Andy");
		eleUtil.doSendKeys("id", lName, "FLower");
		eleUtil.doSendKeys("id", email1, "andy@test.com");
		eleUtil.doSendKeys("id", phone, "8360820660");
		eleUtil.doSendKeys("id", pswd, "Army1");
		eleUtil.doSendKeys("id", cnfrmPswd, "Army1");
		
		Thread.sleep(5000);
		
		brUtil.quitBrowser();
		

	}

}

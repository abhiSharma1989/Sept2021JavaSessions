package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeApplicationTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://test.wurknow.io/?logoutFromAllProducts=True");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("a1d2m3i4n5");
		driver.findElement(By.xpath("//button[@onclick = 'loginAction();']")).click();
		Thread.sleep(8000);
		
		//div[@class='k-grid-aria-root']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[2]/span
		
		By rowComp = By.xpath("//div[@class='k-grid-aria-root']/kendo-grid-list/div/div[1]/table/tbody/tr");
		By colComp = By.xpath("//div[@class='k-grid-aria-root']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td");
		String beforeXpath = "//div[@class='k-grid-aria-root']/kendo-grid-list/div/div[1]/table/tbody/tr[";
		String afterXpath = "]/td[";
		printCompanyTable(rowComp, colComp, beforeXpath, afterXpath);
		
				

	}
	
	public static void printCompanyTable(By rowLoc, By colLoc, String beforeXpath, String afterXpath) {
		int rowCount = driver.findElements(rowLoc).size();
		int colCount = driver.findElements(colLoc).size();
		
		for (int row =1; row<=rowCount; row++) {
			for(int col = 2; col<=colCount; col++) {
				String xpath = beforeXpath + row + afterXpath + col+"]";
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(text + "  |  ");
			}
			System.out.println();
		}
	}
	
	

}

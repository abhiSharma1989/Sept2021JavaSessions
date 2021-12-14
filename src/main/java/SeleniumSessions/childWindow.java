package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class childWindow {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	    driver.get("https://demoqa.com/browser-windows");

	    // Opening all the child window
	    driver.findElement(By.id("windowButton")).click();
	    driver.findElement(By.id("messageWindowButton")).click();
	    Thread.sleep(4000);
	    
	    String MainWindow = driver.getWindowHandle();
	    System.out.println("Main window handle is " + MainWindow);

	    // To handle all new opened window
	    Set<String> s1 = driver.getWindowHandles();
	    System.out.println("Child window handle is" + s1);
	    Iterator<String> i1 = s1.iterator();

	    // Here we will check if child window has other child windows and when child window
	    //is the main window it will come out of loop.
	      while (i1.hasNext()) {
	          String ChildWindow = i1.next();
	          if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
	              driver.switchTo().window(ChildWindow);
	              driver.close();
	              System.out.println("Child window closed");
	           }
	       }
	}
}
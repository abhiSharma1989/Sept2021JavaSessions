package SeleniumSessions;

public class AmazonTest {

	public static void main(String[] args) {
	 BrowserUtil br = new BrowserUtil();
	 br.launchBrowser("chrome");
	 br.getUrl("www.amazon.com");
	 String title = br.getPageTitle();
	 if(title.contains("Amazon")) {
		 System.out.println("Correct Title");
	 }
	 String url = br.getAppCurrenturl();
	 System.out.println(url);
	 
	 br.closeBrowser();

	}

}

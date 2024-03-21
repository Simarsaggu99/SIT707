package sit707_week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOperations {
	private static final String key = "webdriver.chrome.driver";
	private static final String value = "C:\\Users\\yuvra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
	
	//this function open any website of your choice and once it is opened it will for 10 seconds
	public static void navigateToWebsite(String website) {
		System.out.println("Hello from 223426915, Simardeep Singh");
		System.setProperty(key, value);
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(website);
		driver.manage().window().maximize();
		
		waitForSeconds(10);
		
	}
	public static void waitForSeconds(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		navigateToWebsite("https://www.google.com/");
	}
}

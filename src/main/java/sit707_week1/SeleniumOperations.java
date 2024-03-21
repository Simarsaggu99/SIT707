package sit707_week1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumOperations {
	private static final String key = "webdriver.chrome.driver";
	private static final String value = "C:\\Users\\yuvra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
	private static final String officeWorksWebsite = "https://www.officeworks.com.au/app/identity/create-account";
	private static final String bunningsWebsite = "https://www.bunnings.com.au/register";

	public static WebDriver driver; 

	//locators for officeworks website
	public static String fName_id="firstname";
	public static String lName_id= "lastname" ; 
	public static String phoneNo_id="phoneNumber";
	public static String email_id= "email";
	public static String pass_id= "password";
	public static String cPass_id= "confirmPassword";
	
	
    //locators for bunnings website
	public static String bunningsEmail = "//input[contains(@name,'uid')]";
	public static String bunningsPassword = "//input[contains(@name,'password')]";
	public static String bunningsFName = "//input[contains(@name,'firstName')]";
	public static String bunningsLName = "//input[contains(@name,'lastName')]";
	public static String bunningsCreateAccountButton = "//span[text()='Create Account']";
	
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
	

	
	public static void initWebDriver(String website) throws InterruptedException{
		System. setProperty(key, value);
		driver = new ChromeDriver();
		driver.get(website);
		driver.manage().window().maximize();
	}

	public static void officeWorksFailure(String fName, String lName, String phoneNo, String email, String pass, String cPass) throws IOException{
		waitExplicitlyForId(fName_id);
		driver.findElement(By.id(fName_id)).sendKeys(fName);
		waitExplicitlyForId(lName_id);
		driver.findElement(By.id(lName_id)).sendKeys(lName);
		waitExplicitlyForId(phoneNo_id);
		driver.findElement(By.id(phoneNo_id)).sendKeys(phoneNo);
		waitExplicitlyForId(email_id);
		driver.findElement(By.id(email_id)).sendKeys(email);
		waitExplicitlyForId(pass_id);
		driver.findElement(By.id(pass_id)).sendKeys(pass);
		waitExplicitlyForId(cPass_id);
		driver.findElement(By.id(cPass_id)).sendKeys(cPass);
		takeScreenShot("officeWorks");
		waitForSeconds(5);
	}
	
	public static void bunningsSignUpFailure(String bEmail,String bPass,String bFirstName,String bLastName) throws IOException {
		waitExplicitlyForXpath(bunningsEmail);
		driver.findElement(By.xpath(bunningsEmail)).sendKeys(bEmail);
		waitExplicitlyForXpath(bunningsPassword);
		driver.findElement(By.xpath(bunningsPassword)).sendKeys(bPass);
		waitExplicitlyForXpath(bunningsFName);
		driver.findElement(By.xpath(bunningsFName)).sendKeys(bFirstName);
		waitExplicitlyForXpath(bunningsLName);
		driver.findElement(By.xpath(bunningsLName)).sendKeys(bLastName);
		waitExplicitlyForXpath(bunningsCreateAccountButton);
		driver.findElement(By.xpath(bunningsCreateAccountButton)).click();
		takeScreenShot("bunnings");
		waitForSeconds(5);
		
	}
	public static void takeScreenShot(String fileName) throws IOException{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("screenshots/" + fileName + ".png");
		FileUtils.copyFile(SrcFile, DestFile);
	}
	public static void waitExplicitlyForId(String tagID){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tagID)));
	}
	
	public static void waitExplicitlyForXpath(String tagID){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tagID)));
	}

	public static void main(String args[]) throws InterruptedException, IOException {
		//week 1 task
        // navigateToWebsite("https://www.google.com/");
		
		// week 2 task
		initWebDriver(officeWorksWebsite);
		officeWorksFailure("Test", "Test", "04751111115", "test@yopmail.com", "Test", "Test");
		driver.close();
		waitForSeconds(5);
		initWebDriver(bunningsWebsite);
		bunningsSignUpFailure("test@yopmail.com", "Test", "Test", "Test");
		driver.quit();
	}
	
}

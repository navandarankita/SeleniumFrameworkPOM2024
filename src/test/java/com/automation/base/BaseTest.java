package com.automation.base;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.automation.utility.Constants;
import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.PropertiesUtility;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected static WebDriver driver = null;
	private Logger mylog = LogManager.getLogger(BaseTest.class);
	protected ExtentReportsUtility extentReport = ExtentReportsUtility.getInstance();

	@BeforeMethod
	public void setUpBeforeMethod()
	{
		System.out.println("******* SetUpBeforeMethod *******");
		launchBrowser("chrome");
		String url= PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "url");
		goToUrl(url);
	}
	
	@AfterMethod
	public void tearDownAfterMethod()
	{
		System.out.println("******* tearDownAfterMethod *******");
		closeDriver();
	}
	
	public void launchBrowser(String browserName){
		
		switch(browserName.toLowerCase()){
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			break;
		}		
	}
	
	public void goToUrl(String url)
	{
		driver.get(url);
		mylog.info(url+" is entered");
	}
	
	public void closeDriver()
	{
		driver.close();
	}
	public void takeScreenshot(String filepath)
	{
		System.out.println("inside take screenshot");
		System.out.println(filepath);
		TakesScreenshot screenCapture = (TakesScreenshot)driver;
		File src = screenCapture.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		try {
			Files.copy(src, destFile);
			System.out.println("Screen captured");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			mylog.error("Problem occured while taking screenshot");
		}	
	}
}

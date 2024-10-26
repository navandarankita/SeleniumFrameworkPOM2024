package com.automation.pages.base;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automation.base.BaseTest;
import com.automation.utility.ExtentReportsUtility;

public class BasePage extends BaseTest{
	protected WebDriver driver;
	private WebDriverWait wait = null;
	private Logger mylog = LogManager.getLogger(BasePage.class);
	protected ExtentReportsUtility extentreportUtility = ExtentReportsUtility.getInstance();
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void enterText(WebElement ele, String data, String objectName)
	{
		if(data!= "")
		{
			if(ele.isDisplayed())
			{
				ele.clear();
				ele.sendKeys(data);
				System.out.println("data is entered in the " +objectName);
			}
			else
			{
				System.out.println(objectName+ " textbox is not displayed");
			}
		}
		else {
			System.out.println(objectName+ " can not be empty");
		}
		
	}
	
	public void clickElement(WebElement ele, String objectName)
	{
		if(ele.isEnabled())
		{
			ele.click();
			System.out.println(objectName +" button is clicked");
		}
		else {
			System.out.println(objectName +" button is not enabled");
		}
	}
	
	public void selectByTextData(WebElement ele, String value)
	{
		Select select =  new Select(ele);
		select.selectByVisibleText(value);
	}
	
	public void selectByValueData(WebElement ele, String value)
	{
		Select select =  new Select(ele);
		select.selectByValue(value);
	}
	
	public void selectByIndexData(WebElement ele, int value)
	{
		Select select =  new Select(ele);
		select.deselectByIndex(value);	
	}
	
	public String FirstSelectedOption(WebElement ele)
	{
		Select select =  new Select(ele);
		String returnVal = select.getFirstSelectedOption().getText();
		return returnVal;
	}
	
	public WebElement selectFromListUsingText(List<WebElement> list, String text)
	{
		WebElement element = null;
		for(WebElement i: list)
		{
			if(i.getText().equalsIgnoreCase(text))
			{
				mylog.info("selected:"+i.getText());
				element = i;
				break;
			}
		}
		return element;
	}
	
	public void checkBoxSelected(WebElement ele, String objectName)
	{
		if(!ele.isSelected())
		{
			ele.click();
			System.out.println(objectName+ " Checkbox selected");
		}
	}
		
	public void waitForVisibility1(WebElement ele, long timeInSec,String objectName)
	{
		System.out.println("waiting for visiblity of "+objectName+ " for " +timeInSec);
		wait = new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
}

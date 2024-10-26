package com.automation.pages.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class ProfilePage extends BasePage{
	
	@FindBy(xpath="//a[@class='contactInfoLaunch editLink']") WebElement editContact;
	@FindBy(id="contactInfoContentId") WebElement frameEle1;
	@FindBy(xpath="//li[@id='aboutTab']") WebElement aboutTab;
	@FindBy(xpath="//input[@id='lastName']") WebElement lastName;
	@FindBy(xpath="//div/input[@value='Save All']") WebElement saveAllButton;
	@FindBy(xpath="//a[@id='publisherAttachTextPost']") WebElement post;
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']") WebElement frameEle2;
	@FindBy(xpath="/html/body") WebElement textArea;
	@FindBy(xpath="//div[@class='bottomBarRight']") WebElement share;

	public ProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickEditContact()
	{
		clickElement(editContact, "editContact");
	}
	
	public WebDriver switchToframe1()
	{
		 return driver.switchTo().frame(frameEle1);
	}
	
	public WebDriver switchToDefault()
	{
		 return driver.switchTo().defaultContent();
	}
	
	public WebDriver switchToframe2()
	{
		 return driver.switchTo().frame(frameEle2);
	}
	
	public void clickAboutContact()
	{
		clickElement(aboutTab, "aboutTab");
	}
	
	public void enterLastName(String data)
	{
		enterText(lastName, data, "lastName");
	}
	
	public void clickSaveAllButton()
	{
		clickElement(saveAllButton, "clickSaveAllButton");
	}

	public void clickPost()
	{
		clickElement(post, "clickPost");
	}
	
	public void clickShare()
	{
		clickElement(share, "clickShare");
	}
	
	public void postAMessage(String data)
	{
		enterText(textArea, data, "postAMessage");
	}
	
	
	
}

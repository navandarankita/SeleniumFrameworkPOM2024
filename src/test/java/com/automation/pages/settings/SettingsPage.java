package com.automation.pages.settings;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class SettingsPage extends BasePage{
	
	@FindBy(xpath="//*[@id='DisplayAndLayout']") WebElement displayAndLayout;
	@FindBy(xpath="//*[@id='DisplayAndLayout_child']/div[1]") WebElement customizeTabs;
	@FindBy(xpath="//*[@id='p4']") WebElement customeApp;
	@FindBy(id="duel_select_0") WebElement availableTab;
	@FindBy(id="duel_select_0_right") WebElement addButton;
	@FindBy(xpath="//*[@id='duel_select_1']") List<WebElement> elements;


	public SettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickDisplayAndLayout()
	{
		clickElement(displayAndLayout, "displayAndLayout");
	}
	
	public void clickCustomizeTabs()
	{
		clickElement(customizeTabs, "customizeTabs");
	}
	
	public void customeApp()
	{
		selectByTextData(customeApp, "Salesforce Chatter");
	}
	
	public void clickAvailableTab()
	{
		selectByValueData(availableTab, "report");
	}
	
	public void clickAddButton()
	{
		clickElement(addButton, "addButton");
	}
	
	public String availablereport()
	{
		WebElement text =  selectFromListUsingText(elements, "Reports");
		String returnString = text.getText();
		return returnString;	
	}
	
	

}

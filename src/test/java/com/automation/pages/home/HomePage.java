package com.automation.pages.home;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(id="userNavLabel") WebElement userMenuDropdown;
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[1]") WebElement profile;
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[2]") WebElement settings;
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[3]") WebElement devConsole;
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[4]") WebElement switchToLightningExp;
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[5]") WebElement logout;
	@FindBy(xpath="//*[@id='Account_Tab']") WebElement accountTab;


	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public String getUserMenuNameText()
	{
		String name = userMenuDropdown.getText();
		return name;	
	}
	
	//*******************click element*****************************************
	
	public void clickUserMenuDropdown()
	{
		clickElement(userMenuDropdown, "userMenuDropdown");
	}
	
	public void clickUserMenuProfile()
	{
		clickElement(profile, "profile");
	}
	public void clickUserMenuSettings()
	{
		clickElement(settings, "settings");
	}
	
	public void clickUserMenuDevConsole()
	{
		clickElement(devConsole, "devConsole");
	}
	
	public void clickAccountTab()
	{
		clickElement(accountTab, "accountTab");
	}
	
	//*******************get text element*****************************************

	public String getUserMenuprofile()
	{
		String name = profile.getText();
		return name;	
	}
	public String getUserMenusettings()
	{
		String name = settings.getText();
		return name;	
	}
	public String getUserMenudevConsole()
	{
		String name = devConsole.getText();
		return name;	
	}
	public String getUserMenuswitchToLightningExp()
	{
		String name = switchToLightningExp.getText();
		return name;	
	}
	public String getUserMenulogout()
	{
		String name = logout.getText();
		return name;	
	}
	
	public WebDriver logout()
	{
		clickElement(logout, "logout");
		return driver;
	}
	
	//************************developer console ******************************************
	
	public void windowHandles()
	{
		 List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		 if (windowHandles.size() > 1) {
			 System.out.println(windowHandles.size());
	            // Switch to the new window (the last one in the list)
	            driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));

	            // Now you can interact with the new window
	            System.out.println("Title of new window: " + driver.getTitle());

	            // Optionally, switch back to the original window
	            driver.switchTo().window(windowHandles.get(0));
	            System.out.println("Back to original window: " + driver.getTitle());
	        }
	}
	
	
}

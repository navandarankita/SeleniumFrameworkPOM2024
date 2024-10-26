package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.pages.home.HomePage;
import com.automation.pages.profile.ProfilePage;
import com.automation.pages.settings.SettingsPage;


public class UserMenuDropdownTests extends LoginTests{
		
	@Test
	public void checkUserdropdownContent()
	{

		validLogin();
		HomePage homepage = new HomePage(driver);
		homepage.clickUserMenuDropdown();
		String option1 = homepage.getUserMenuprofile();
		String option2 = homepage.getUserMenusettings();
		String option3 = homepage.getUserMenudevConsole();
		String option4 = homepage.getUserMenuswitchToLightningExp();
		String option5 = homepage.getUserMenulogout();
		
		Assert.assertEquals(option1, "My Profile");
		Assert.assertEquals(option2, "My Settings");
		Assert.assertEquals(option3, "Developer Console");
		Assert.assertEquals(option4, "Switch to Lightning Experience");
		Assert.assertEquals(option5, "Logout");
		
		homepage.logout();		
	}

	@Test
	public void myProfile() 
	{
		validLogin();
		
		HomePage homepage = new HomePage(driver);
		homepage.clickUserMenuDropdown();
		homepage.clickUserMenuProfile();
		
		ProfilePage profilepage = new ProfilePage(driver);
		profilepage.clickEditContact();
		profilepage.switchToframe1();
		profilepage.clickAboutContact();
		profilepage.enterLastName("Abcd");
		profilepage.clickSaveAllButton();
		profilepage.switchToDefault();
		profilepage.clickPost();
		profilepage.switchToframe2();
		profilepage.postAMessage("Hello World!!!");
		profilepage.switchToDefault();
		profilepage.clickShare();
	}
	
	@Test
	public void mySettings() 
	{
		validLogin();
		
		HomePage homepage = new HomePage(driver);
		homepage.clickUserMenuDropdown();
		Assert.assertEquals(homepage.getUserMenusettings(), "My Settings");
		homepage.clickUserMenuSettings();
		
		SettingsPage settingspage = new SettingsPage(driver);
		settingspage.clickDisplayAndLayout();
		settingspage.clickCustomizeTabs();
		settingspage.customeApp();
		settingspage.clickAvailableTab();
		settingspage.clickAddButton();
		String actualText = settingspage.availablereport();
		
		Assert.assertEquals(actualText, "Reports");
	}
	
	@Test
	public void devConsole() 
	{
		validLogin();
		
		HomePage homepage = new HomePage(driver);
		homepage.clickUserMenuDropdown();
		homepage.clickUserMenuDevConsole();
		homepage.windowHandles();
		homepage.logout();
	}
	
	@Test
	public void logout()
	{
		validLogin();
		HomePage homepage = new HomePage(driver);
		homepage.logout();
	}
}

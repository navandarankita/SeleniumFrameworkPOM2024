package com.automation.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.base.BaseTest;
import com.automation.pages.home.HomePage;
import com.automation.pages.login.ForgotPasswordPage;
import com.automation.pages.login.LoginPage;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class LoginTests extends BaseTest{
	
	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	

	@Test
	public void loginError()
	{
		String expectedText ="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";	
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameData);
		loginpage.enterPassword("1234");
		loginpage.clickLoginButton();
		String actualText = loginpage.getErrorMessage();
		Assert.assertEquals(actualText, expectedText);		
	}
	
	@Test
	public void validLogin()
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameData);
		loginpage.enterPassword(passwordData);
		loginpage.clickLoginButton();
	
	}
	
	@Test
	public void checkRememberMe()
	{
		String expectedText = "Ann Abcd";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernameData);
		loginpage.enterPassword(passwordData);
		loginpage.rememberMeCheckbox();
		loginpage.clickLoginButton();
		
		HomePage homepage = new HomePage(driver);
		String actualText = homepage.getUserMenuNameText();
		
		Assert.assertEquals(actualText, expectedText);
		
		homepage.clickUserMenuDropdown();
		homepage.logout();
	}
	
	
	@Test
	public void forgotPassword() 
	{		
		ForgotPasswordPage forgotpasswordpage = new ForgotPasswordPage(driver);
		forgotpasswordpage.forgotPassword();
		forgotpasswordpage.enterForgotPasswordUserName(usernameData);
		forgotpasswordpage.clickContinueButton();
		String emailSentText = forgotpasswordpage.getEmailSenttext();
		System.out.println("Email Sent Text: "+emailSentText);
	}
	
	
	@Test
	public void incorrectLogin() 
	{
		String expectedText= "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName("123");
		loginpage.enterPassword("22131");
		loginpage.clickLoginButton();
		String errorMessage = loginpage.getErrorMessage();
		
		Assert.assertEquals(errorMessage, expectedText);
		
	}


}


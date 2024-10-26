package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class ForgotPasswordPage extends BasePage{
	
	@FindBy(id="forgot_password_link") WebElement forgotPassword;
	@FindBy(id="un") WebElement forgotPasswordUserName;
	@FindBy(id="continue") WebElement continueButton;
	@FindBy(id="header") WebElement emailSentText;

	
	
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void forgotPassword()
	{
		clickElement(forgotPassword, "forgot password");
	}
	
	public void enterForgotPasswordUserName(String data)
	{
		enterText(forgotPasswordUserName, data, "forgot password");
	}
	
	public WebDriver clickContinueButton()
	{
		clickElement(continueButton, "continue button");
		return driver;
	}
	
	public String getEmailSenttext()
	{
		String text = emailSentText.getText();
		return text;	
	}
	

}

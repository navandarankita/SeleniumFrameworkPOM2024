package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.pages.base.BasePage;

public class LoginPage extends BasePage{
	@FindBy(id="username") WebElement userName;
	@FindBy(id="password") WebElement password;
	@FindBy(id="Login") WebElement login;
	@FindBy(id="error") WebElement errorMessage;
	@FindBy(id="rememberUn") WebElement checkBox;
	@FindBy(id="forgot_password_link") WebElement forgotPassword;

	@FindBy(id="un") WebElement forgotPasswordUserName;
	@FindBy(id="continue") WebElement continueButton;


	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	public void enterUserName(String data)
	{
		enterText(userName, data, "userName");
	}
	
	public void enterPassword(String data)
	{
		enterText(password, data, "password");
	}
	
	public String getErrorMessage()
	{
		String message = errorMessage.getText();
		return message;	
	}
	
	public void rememberMeCheckbox()
	{
		checkBoxSelected(checkBox, "remember me checkbox");
	}
	
	public WebDriver clickLoginButton()
	{
		clickElement(login, "login");
		return driver;
	}

}

package com.automation.pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class AccountPage extends BasePage{
	
	@FindBy(xpath="//*[@id='hotlist']/table/tbody/tr/td[2]/input") WebElement newButton;
	@FindBy(xpath="//div[@class='pbHeader']//input[@title ='Save']") WebElement saveButton;
	@FindBy(xpath="//a[text()='Create New View']") WebElement createNewViewLink;
	@FindBy(xpath="//*[@id='filter_element']/div/span/span[2]/a[1]") WebElement editLink;
	@FindBy(xpath="//*[@id='stageForm']/div/div[2]/div[4]/input[2]") WebElement findAccountButton;
	@FindBy(xpath="//div[@class='pbBottomButtons']/input[1]") WebElement nextButton;
	@FindBy(xpath="//div[@class='pbBottomButtons']/input[2]") WebElement mergeButton;
	@FindBy(xpath="//*[@id='toolsContent']//a[text()='Merge Accounts']") WebElement mergeAccountLink;
	
	@FindBy(xpath="//*[@id='toolsContent']//a[text()='Accounts with last activity > 30 days']") WebElement reportLink;
	@FindBy(xpath="//*[@id='ext-gen152']") WebElement fromDate;
	@FindBy(xpath="//button[text()='Today']") WebElement todayButton;
	@FindBy(xpath="//button[text()='Save']") WebElement reportSaveButton;
	@FindBy(xpath="//button[text()='Save and Run Report']") WebElement saveRunButton;
	

	@FindBy(xpath="//*[@id='acc2']") WebElement accountName;
	@FindBy(xpath="//*[@id='fname']") WebElement editViewName;
	@FindBy(xpath="//*[@id='fval1']") WebElement enterValue;
	@FindBy(xpath="//input[@id='fname']") WebElement enterViewName;
	@FindBy(xpath="//*[@id='00Nbm000004QE1q']") WebElement customerPriority;
	@FindBy(xpath="//*[@id='contactHeaderRow']/div[2]/h2") WebElement displayedName;
	@FindBy(xpath="//input[@id='srch']") WebElement findAccount;
	@FindBy(xpath="//tr[2]/th/a") WebElement displayedText;
	@FindBy(xpath="//input[@id='saveReportDlg_reportNameField']") WebElement reportName;

	
	@FindBy(xpath="//div[@class='topNav primaryPalette']//select[@class='title']") WebElement dropdown;
	@FindBy(xpath="//*[@id='fcol1']") WebElement selectAccountName;
	@FindBy(xpath="//*[@id='fop1']") WebElement selectOperator;
	@FindBy(xpath="//*[@id='acc6']") WebElement type;
	
	


	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	//************************************enterText***********************************//
	
	public void setAccountName(String data)
	{
		enterText(accountName, data, "accountName");
	}
	
	public void enterViewName(String data)
	{
		enterText(enterViewName, data, "enter a view name");
	}
	
	public void editViewName() {
		
		enterText(editViewName, "Dansie", "edit view name");	
	}
	
	public void enterAccountValue() {
		
		enterText(enterValue, "<a>", "account value");	
	}
	
	public void findAccounts(String data) {
		enterText(findAccount, data, "findAccount");
		
	}
	
	public void enterReportName(String data) {
		enterText(reportName, data, "report name");
		
	}

	//************************************clickElement***********************************//
	
	public void clicknewButton()
	{
		clickElement(newButton, "newButton");
	}
	
	public void clickSaveButton()
	{
		clickElement(saveButton, "saveButton");
	}
	
	public void clickNewView()
	{
		clickElement(createNewViewLink, "create new view");
	}
	
	public void editView()
	{
		clickElement(editLink, "edit view");
	}
	
	public void clickMergeAccountLink() {
		clickElement(mergeAccountLink, "merge account link");
		
	}

	public void clickFindAccountsButton() {
		clickElement(findAccountButton, "find account button");
		
	}

	public void clickNextButton() {
		clickElement(nextButton, "next button");
		
	}

	public void clickMergeButton() {
		clickElement(mergeButton, "merge button");
		
	}
	
	public void clickReportLink() {
		clickElement(reportLink, "report link");
		
	}

	public void clickFromDate() {
		clickElement(fromDate, "from date");
		
	}

	public void clickSaveRunReport() {
		clickElement(saveRunButton, "save and run button");
		
	}

	public void clickTodayButton() {
		clickElement(todayButton, "today button");
		
	}

	public void clickSaveReportButton() {
		clickElement(reportSaveButton, "report save button");
		
	}
	
	//*************************************selectValue***************************************//
	
	public void selectCustomerPriority(String value)
	{
		selectByValueData(customerPriority, value);
	}
	
	public void selectType(String value)
	{
		selectByValueData(type, value);
	}
	
	public void selectAccountName(String value) {
		
		selectByValueData(selectAccountName, value);
		
	}

	public void selectOperator(String value) {
		
		selectByValueData(selectOperator, value);
	}
	
	//*************************************getText***************************************//
	
	public String getDropdownText()
	{
		String text = FirstSelectedOption(dropdown);
		return text;
	}
	
	public String getDisplayedName()
	{
		String displayName = displayedName.getText();
		return displayName;	
	}

	public String getDisplayedText() {
		String text = displayedText.getText();
		return text;
	}
}

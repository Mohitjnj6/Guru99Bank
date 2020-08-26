package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase
{
	//PageFactory
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement newCustomerBtn;
	
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	WebElement editCustomerBtn;
	
//	@FindBy(xpath="//a[contains(text(),'New Customer')]")
//	WebElement deleteCustomerBtn;
	
	@FindBy(xpath=".//div//a[contains(text(),'New Account')]")
	WebElement newAccountBtn;
	
	@FindBy(xpath="//div//a[contains(text(),'Edit Account')]")
	WebElement editAccountBtn;
	
	@FindBy(xpath="//a[contains(text(),'Delete Account')]")
	WebElement deleteAccountBtn;
	
	@FindBy(xpath="//a[contains(text(),'Deposit')]")
	WebElement depositBtn;
	
	@FindBy(xpath="//a[contains(text(),'Withdrawal')]")
	WebElement withdrawalBtn;
	
	@FindBy(xpath="//a[contains(text(),'Fund Transfer')]")
	WebElement fundTransferBtn;
	
	@FindBy(xpath="//a[contains(text(),'Change Password')]")
	WebElement changePasswordBtn;
	
	@FindBy(xpath="//a[contains(text(),'Balance Enquiry')]")
	WebElement balanceEnquiryBtn;
	
	@FindBy(xpath="//a[contains(text(),'Mini Statement')]")
	WebElement miniStatementBtn;
	
	@FindBy(xpath="//a[contains(text(),'Customised Statement')]")
	WebElement customisedStatementBtn;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logoutBtn;
	
	
	//Initialization
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public String verifyHomePageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public NewCustomerPage verifynewCustomerBtn()
	{
		newCustomerBtn.click();
		return new NewCustomerPage();
	}
	
	public EditCustomerPage verifyeditCustomerBtn()
	{
		editCustomerBtn.click();
		return new EditCustomerPage();
	}
	
//	public DeleteCustomerPage verifydeleteCustomerBtn()
//	{
//		deleteCustomerBtn.click();
//		return new DeleteCustomerPage();
//	}
	
	public NewAccountPage verifynewAccountBtn()
	{
		newAccountBtn.click();
		return new NewAccountPage();
	}
	
	public EditAccountPage verifyeditAccountBtn()
	{
		editAccountBtn.click();
		return new EditAccountPage();
	}
	
	public DeleteAccountPage verifydeleteAccountBtn()
	{
		deleteAccountBtn.click();
		return new DeleteAccountPage();
	}
	
	public DepositPage verifyDepositBtn()
	{
		depositBtn.click();
		return new DepositPage();
	}
	
	public WithdrawalPage vertifydepositBtn()
	{
		withdrawalBtn.click();
		return new WithdrawalPage();
	}
	
	public FundTransferPage verifyfundTransferBtn() 
	{
		fundTransferBtn.click();
		return new FundTransferPage();
	}
	
	public ChangePasswordPage verifychangePasswordBtn()
	{
		changePasswordBtn.click();
		return new ChangePasswordPage();
	}
	
	public BalanceEnquiryPage verifybalanceEnquiryBtn()
	{
		balanceEnquiryBtn.click();
		return new BalanceEnquiryPage();
	}
	
	public MiniStatementPage verifyminiStatementBtn()
	{
		miniStatementBtn.click();
		return new MiniStatementPage();
	}
	
	public CustomisedStatementPage verifycustomisedStatementBtn()
	{
		customisedStatementBtn.click();
		return new CustomisedStatementPage();
	}
	
	public String verifylogoutBtn()
	{
		logoutBtn.click();
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		driver.switchTo().alert().accept();
		return alert;
		//return new LoginPage();
	}

}


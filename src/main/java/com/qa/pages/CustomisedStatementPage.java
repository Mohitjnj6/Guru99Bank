package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class CustomisedStatementPage extends TestBase
{
	//PageFactory
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement accountno;

	@FindBy(xpath="//input[@name='fdate']")
	WebElement fdate;

	@FindBy(xpath="//input[@name='tdate']")
	WebElement tdate;
	
	@FindBy(xpath="//input[@name='amountlowerlimit']")
	WebElement amountLowerLimit;
	
	@FindBy(xpath="//input[@name='numtransaction']")
	WebElement numOfTransaction;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submitBtn;

	@FindBy(xpath="/input[@name='res']")
	WebElement ResetrBtn;


	//Initialization
	public CustomisedStatementPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Action
	public String verifyCustomisedStatementPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void verifySubmitBtn()
	{
		accountno.sendKeys("");
		fdate.sendKeys("");
		tdate.sendKeys("");
		amountLowerLimit.sendKeys("");
		numOfTransaction.sendKeys("");
		submitBtn.click();
	}

	public String verifyResettBtn()
	{
		accountno.sendKeys("");
		fdate.sendKeys("");
		tdate.sendKeys("");
		amountLowerLimit.sendKeys("");
		numOfTransaction.sendKeys("");
		ResetrBtn.click();
		submitBtn.click();
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		driver.switchTo().alert().accept();
		return alert;
	}

}

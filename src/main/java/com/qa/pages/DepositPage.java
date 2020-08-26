package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class DepositPage extends TestBase
 {
	
	//PageFactory
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement accountNo;

	@FindBy(xpath="//input[@name='ammount']")
	WebElement amount;
	
	@FindBy(xpath="//input[@name='desc']")
	WebElement description;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submitBtn;

	@FindBy(xpath="/input[@name='res']")
	WebElement ResetrBtn;


	//Initialization
	public DepositPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Action
	public String verifyDepositPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void verifySubmitBtn()
	{
		accountNo.sendKeys("");
		amount.sendKeys("");
		description.sendKeys("");
		submitBtn.click();
	}

	public String verifyResettBtn()
	{
		accountNo.sendKeys("");
		amount.sendKeys("");
		description.sendKeys("");
		ResetrBtn.click();
		submitBtn.click();
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		driver.switchTo().alert().accept();
		return alert;
	}



}

package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class NewAccountPage extends TestBase
 {
	//PageFactory
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement customerId;

	@FindBy(xpath="//select[@name='selaccount']")
	WebElement selaccount;
	
	@FindBy(xpath="//option[@value='Savings']")
	WebElement Savings;
	
	@FindBy(xpath="//option[@value='Current']")
	WebElement Current;
	
	@FindBy(xpath="//input[@name='inideposit']")
	WebElement inideposit;
		
	@FindBy(xpath="//input[@name='button2'] ")
	WebElement submitBtn;

	@FindBy(xpath="/input[@name='res']")
	WebElement ResetrBtn;


	//Initialization
	public NewAccountPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Action
	public String verifyNewAccountPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void verifySubmitBtn()
	{
		customerId.sendKeys("");
		Select select = new Select(selaccount);
		select.selectByVisibleText(TestUtil.newAccType);
		inideposit.sendKeys("");
		submitBtn.click();
	}

	public String verifyResettBtn()
	{
		customerId.sendKeys("");
		Select select = new Select(selaccount);
		select.selectByVisibleText(TestUtil.newAccType);
		inideposit.sendKeys("");
		ResetrBtn.click();
		submitBtn.click();
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		driver.switchTo().alert().accept();
		return alert;
	}

}

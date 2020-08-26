package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class MiniStatementPage  extends TestBase
{
	//PageFactory
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement AccountNo;

	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submitBtn;

	@FindBy(xpath="/input[@name='res']")
	WebElement ResetrBtn;


	//Initialization
	public MiniStatementPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Action
	public String verifyMiniStatementPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void verifySubmitBtn()
	{
		AccountNo.sendKeys("");
		submitBtn.click();
	}

	public String verifyResettBtn()
	{
		AccountNo.sendKeys("");
		ResetrBtn.click();
		submitBtn.click();
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		driver.switchTo().alert().accept();
		return alert;
	}
}

package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class DeleteAccountPage extends TestBase
 {

	//PageFactory
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement AccountNo;

	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submitBtn;

	@FindBy(xpath="//input[@name='res']")
	WebElement ResetBtn;


	//Initialization
	public DeleteAccountPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Action
	public String verifyDeleteAccountPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public String verifySubmitBtn()
	{
		AccountNo.sendKeys("1230000000");
		submitBtn.click();
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		driver.switchTo().alert().accept();
		return alert;
	}

	public String verifyResetBtn()
	{
		AccountNo.sendKeys("1230000000");
		ResetBtn.click();
		submitBtn.click();
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		driver.switchTo().alert().accept();
		return alert;
	}

}

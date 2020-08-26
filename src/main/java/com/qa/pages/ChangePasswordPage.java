package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ChangePasswordPage extends TestBase
{

	//PageFactory
	
	@FindBy(xpath="//input[@name='oldpassword']")
	WebElement oldPassword;

	@FindBy(xpath="//input[@name='newpassword']")
	WebElement newPassword;
	
	@FindBy(xpath="//input[@name='confirmpassword']")
	WebElement confirmPassword;
		
	@FindBy(xpath="//input[@name='desc']")
	WebElement description;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submitBtn;

	@FindBy(xpath="/input[@name='res']")
	WebElement ResetrBtn;


	//Initialization
	public ChangePasswordPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Action
	public String verifyChangePasswordPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public void verifySubmitBtn()
	{
		oldPassword.sendKeys("");
		newPassword.sendKeys("");
		confirmPassword.sendKeys("");
		description.sendKeys("");
		submitBtn.click();
	}

	public String verifyResettBtn()
	{
		oldPassword.sendKeys("");
		newPassword.sendKeys("");
		confirmPassword.sendKeys("");
		description.sendKeys("");
		ResetrBtn.click();
		submitBtn.click();
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		driver.switchTo().alert().accept();
		return alert;
	}



}

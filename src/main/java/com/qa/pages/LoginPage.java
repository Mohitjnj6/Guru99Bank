package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase
{

	//PageFactory
	@FindBy(name="uid")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	@FindBy(name="btnReset")
	WebElement resetBtn;
	
	@FindBy(xpath="//div[@class='logo']//img")
	WebElement logo;
	
	
	//Initialization
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyLoginPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public HomePage verifyLoginBtn(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	public String verifyResetBtn(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		resetBtn.click();
		loginBtn.click();
		String alert = driver.switchTo().alert().getText();
		System.out.println(alert);
		driver.switchTo().alert().accept();
		return alert;
	}
	
	public boolean verifyLogo()
	{
		boolean bLogo = logo.isDisplayed();
		return bLogo;
	}
	
	
}

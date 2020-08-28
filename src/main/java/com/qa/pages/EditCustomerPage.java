package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class EditCustomerPage  extends TestBase
{
	//PageFactory
	
		@FindBy(xpath="//input[@name='cusid']")
		WebElement customerId;

		@FindBy(xpath="//input[@name='AccSubmit']")
		WebElement submitBtn;

		@FindBy(xpath="//input[@name='res']")
		WebElement ResetBtn;


		//Initialization
		public EditCustomerPage()
		{
			PageFactory.initElements(driver, this);
		}

		//Action
		public String verifyEditCustomerPageTitle()
		{
			String title = driver.getTitle();
			return title;
		}
		
		public String verifySubmitBtn()
		{
			customerId.sendKeys("1230000000");
			submitBtn.click();
			String alert = driver.switchTo().alert().getText();
			System.out.println(alert);
			driver.switchTo().alert().accept();
			return alert;
		}

		public String verifyResetBtn()
		{
			customerId.sendKeys("1230000000");
			ResetBtn.click();
			submitBtn.click();
			String alert = driver.switchTo().alert().getText();
			System.out.println(alert);
			driver.switchTo().alert().accept();
			return alert;
		}
}

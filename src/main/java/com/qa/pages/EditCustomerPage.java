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

		@FindBy(xpath="//input[@name='AccSubmit'] ")
		WebElement submitBtn;

		@FindBy(xpath="/input[@name='res']")
		WebElement ResetrBtn;


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
		
		public void verifySubmitBtn()
		{
			customerId.sendKeys("");
			submitBtn.click();
		}

		public void verifyResettBtn()
		{
			customerId.sendKeys("");
			ResetrBtn.click();
		}
}

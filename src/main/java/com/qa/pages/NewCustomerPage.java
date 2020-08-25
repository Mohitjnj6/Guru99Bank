package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class NewCustomerPage extends TestBase
{
	//PageFactory
		@FindBy(name="name")
		WebElement Custname;

		@FindBy(xpath="//input[@name='rad1'][1]")
		WebElement male;
		
		@FindBy(xpath="//input[@name='rad1'][2]")
		WebElement female;
		
		@FindBy(name="dob")
		WebElement dob;			

		@FindBy(name="addr")
		WebElement address;

		@FindBy(name="city")
		WebElement city;
		
		@FindBy(name="state")
		WebElement state;

		@FindBy(name="pinno")
		WebElement pin;
		
		@FindBy(name="telephoneno")
		WebElement mobile;
		
		@FindBy(name="emailid")
		WebElement emailId;
		
		@FindBy(name="password")
		WebElement password;

		@FindBy(name="sub")
		WebElement submit;

		@FindBy(name="res")
		WebElement reset;
		
		
		
		//Initialization
		public NewCustomerPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		//Actions	       
		public String verifyLoginPageTitle()
		{
			String title = driver.getTitle();
			return title;
		}
		
		public void verifySubmitBtn(String cName, String db, String addrs, String cty,
						   String stt, String pinNo, String phone, String email,String pwd)
		{
			Custname.sendKeys(cName);
			dob.sendKeys(db);
			address.sendKeys(addrs);
			city.sendKeys(cty);
			state.sendKeys(stt);
			pin.sendKeys(pinNo);
			mobile.sendKeys(phone);
			emailId.sendKeys(email);
			password.sendKeys(pwd);
			submit.click();
			
		}
		
		public String verifyResetBtn(String cName, String db, String addrs, String cty,
				   String stt, String pinNo, String phone, String email,String pwd)
		{
			Custname.sendKeys(cName);
			dob.sendKeys(db);
			address.sendKeys(addrs);
			city.sendKeys(cty);
			state.sendKeys(stt);
			pin.sendKeys(pinNo);
			mobile.sendKeys(phone);
			emailId.sendKeys(email);
			password.sendKeys(pwd);
			reset.click();
			submit.click();
			String alert = driver.switchTo().alert().getText();
			System.out.println(alert);
			driver.switchTo().alert().accept();
			return alert;
		}
		
//		public boolean verifyLogo()
//		{
//			boolean bLogo = logo.isDisplayed();
//			return bLogo;
//		}
		
		


}

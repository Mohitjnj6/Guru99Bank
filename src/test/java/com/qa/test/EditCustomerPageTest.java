package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.EditCustomerPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class EditCustomerPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	EditCustomerPage editCustomer;
	
	public EditCustomerPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void startUp()
	{
		initialization();
	   loginPage = new LoginPage();
	    homePage = loginPage.verifyLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
	    homePage.verifyeditCustomerBtn();
	}
	
	@Test
	public void verifyEditCustomerPageTitleTest()
	{
		String editCustomerTitle = editCustomer.verifyEditCustomerPageTitle();
		System.out.println(editCustomerTitle);
		Assert.assertEquals(editCustomerTitle, "Guru99 Bank Edit Customer Page");
	}
	
	@Test
	public void verifySubmitBtnTest()	//from here to edit
	{
		String submitMsg = editCustomer.verifySubmitBtn();
		System.out.println(submitMsg);
		Assert.assertEquals(submitMsg, "Customer does not exist!!");
	}
	
	
	@Test
	public void verifyResetBtnTest()
	{
		String alertMsg = loginPage.verifyResetBtn(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(alertMsg, "User or Password is not valid");
	}
	
	
	@Test
	public void verifyLogoTest()
	{
		 boolean bankLogo = loginPage.verifyLogo();
		Assert.assertTrue(bankLogo);
	}
	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
}

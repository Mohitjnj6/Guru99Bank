package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.EditAccountPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class EditAccountPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	EditAccountPage editAccountPage;
	
	public EditAccountPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void startUp()
	{
		initialization();
	   loginPage = new LoginPage();
	    homePage = loginPage.verifyLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
	    homePage.verifyeditAccountBtn();
	    editAccountPage = new EditAccountPage();
	}
	
	@Test
	public void verifyEditAccountPageTitleTest() throws InterruptedException
	{
		Thread.sleep(2000);
		String deleteCustomerTitle = editAccountPage.verifyEditAccountPageTitle();
		System.out.println(deleteCustomerTitle);
		Assert.assertEquals(deleteCustomerTitle, "Guru99 Edit Account Page");
		
	}
	
	@Test
	public void verifySubmitBtnTest() throws InterruptedException
	{
		//Thread.sleep(2000);
		String submitMsg = editAccountPage.verifySubmitBtn();
		System.out.println(submitMsg);
		Assert.assertEquals(submitMsg, "Account does not exist");
	}
	
	
	@Test
	public void verifyResetBtnTest()
	{
		String submitMsg = editAccountPage.verifyResetBtn();
		System.out.println(submitMsg);
		Assert.assertEquals(submitMsg, "Account does not exist");
		
	}
	
		
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
}


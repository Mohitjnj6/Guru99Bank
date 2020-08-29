package com.qa.pages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class DeleteAccountPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	DeleteAccountPage deleteAccountPage;
	
	public DeleteAccountPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void startUp()
	{
		initialization();
	   loginPage = new LoginPage();
	    homePage = loginPage.verifyLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
	    homePage.verifydeleteAccountBtn();
	    deleteAccountPage = new DeleteAccountPage();
	}
	
	@Test
	public void verifyDeleteAccountPageTitleTest() throws InterruptedException
	{
		Thread.sleep(2000);
		String deleteCustomerTitle = deleteAccountPage.verifyDeleteAccountPageTitle();
		Assert.assertEquals(deleteCustomerTitle, "Guru99 Bank Delete Account Page");
		
	}
	
	@Test
	public void verifySubmitBtnTest() throws InterruptedException
	{
		Thread.sleep(2000);
		String submitMsg = deleteAccountPage.verifySubmitBtn();
		Assert.assertEquals(submitMsg, "Do you really want to delete this Account?");
	}
	
	
	@Test
	public void verifyResetBtnTest()
	{
		String submitMsg = deleteAccountPage.verifyResetBtn();
		System.out.println(submitMsg);	Assert.assertEquals(submitMsg, "Do you really want to delete this Account?");
	}
	
		
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
}


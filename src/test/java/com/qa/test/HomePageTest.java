package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void startUp()
	{
		initialization();
	   loginPage = new LoginPage();
	   homePage = loginPage.verifyLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void verifyHomePageTitleTest()//working
	{
		String homeTitle = homePage.verifyHomePageTitle();
		System.out.println(homeTitle);
		Assert.assertEquals(homeTitle, "Guru99 Bank Manager HomePage");
	}
	
	@Test
	public void verifynewCustomerBtnTest()//working
	{
		homePage.verifynewCustomerBtn();
		String newCustomerTitle = driver.getTitle();
		System.out.println(newCustomerTitle);
		Assert.assertEquals(newCustomerTitle, "Guru99 Bank New Customer Entry Page");
	}
	
	
	@Test
	public void verifyeditCustomerBtnTest() throws InterruptedException //working
	{
		homePage.verifyeditCustomerBtn();
		Thread.sleep(2000);
		String editCustomerTitle = driver.getTitle();
		System.out.println(editCustomerTitle);
		Assert.assertEquals(editCustomerTitle, "Guru99 Bank Edit Customer Page");
	}
	

//	@Test
//	public void verifydeleteCustomerBtnTest()
//	{
//		homePage.verifydeleteCustomerBtn();
//		String deleteCustomerTitle = driver.getTitle();
//		System.out.println(deleteCustomerTitle);
//		Assert.assertEquals(deleteCustomerTitle, "Guru99 Bank Delete Customer Page");
//	}
//
	@Test
	public void verifynewAccountBtnTest() //working
	{
		homePage.verifynewAccountBtn();
		String newAccountTitle = driver.getTitle();
		System.out.println(newAccountTitle);
		Assert.assertEquals(newAccountTitle, "Guru99 bank add new account");
	}

	@Test
	public void verifyeditAccountBtnTest() //working
	{
		homePage.verifyeditAccountBtn();
		String editAccountTitle = driver.getTitle();
		System.out.println(editAccountTitle);
		Assert.assertEquals(editAccountTitle, "Guru99 Edit Account Page");
	}

	@Test
	public void verifydeleteAccountBtnTest() //working
	{
		homePage.verifydeleteAccountBtn();
		String deleteAccountTitle = driver.getTitle();
		System.out.println(deleteAccountTitle);
		Assert.assertEquals(deleteAccountTitle, "Guru99 Bank Delete Account Page");
	}

//	@Test
//	public void verifyDepositBtnTest() // not clickable
//	{
//		homePage.verifyDepositBtn();
//		String DepositrTitle = driver.getTitle();
//		System.out.println(DepositrTitle);
//		Assert.assertEquals(DepositrTitle, "Guru99 Bank Amount Deposit Page");
//	}

//	@Test
//	public void verifyfundTransferBtnTest() //not clickable
//	{
//		homePage.verifyfundTransferBtn();
//		String fundTransferTitle = driver.getTitle();
//		System.out.println(fundTransferTitle);
//		Assert.assertEquals(fundTransferTitle, "Guru99 Bank New Customer Entry Page");
//	}

	@Test
	public void verifychangePasswordBtnTest() //working
	{
		homePage.verifychangePasswordBtn();
		String changePasswordTitle = driver.getTitle();
		System.out.println(changePasswordTitle);
		Assert.assertEquals(changePasswordTitle, "Guru99 Bank New Customer Entry Page");
	}

	@Test
	public void verifybalanceEnquiryBtnTest() //Working
	{
		homePage.verifybalanceEnquiryBtn();
		String balanceEnquiryTitle = driver.getTitle();
		System.out.println(balanceEnquiryTitle);
		Assert.assertEquals(balanceEnquiryTitle, "Guru99 Bank Balance Enquiry Page");
	}

	@Test
	public void verifyminiStatementBtnTest() //working
	{
		homePage.verifyminiStatementBtn();
		String miniStatementTitle = driver.getTitle();
		System.out.println(miniStatementTitle);
		Assert.assertEquals(miniStatementTitle, "Guru99 Bank Mini Statement Page");
	}

	@Test
	public void verifycustomisedStatementBtnTest() //working
	{
		homePage.verifycustomisedStatementBtn();
		String customisedStatementTitle = driver.getTitle();
		System.out.println(customisedStatementTitle);
		Assert.assertEquals(customisedStatementTitle, "Guru99 Bank Statement Page");
	}

	@Test
	public void verifylogoutBtnTest() //working
	{
		String logout = homePage.verifylogoutBtn();
		Assert.assertEquals(logout, "You Have Succesfully Logged Out!!");
	
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
}

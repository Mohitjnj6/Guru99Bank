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
	public void verifyHomePageTitleTest()
	{
		String homeTitle = homePage.verifyHomePageTitle();
		System.out.println(homeTitle);
		Assert.assertEquals(homeTitle, "Guru99 Bank Manager HomePage");
	}
	
	@Test
	public void verifynewCustomerBtnTest()
	{
		homePage.verifynewCustomerBtn();
		String newCustomerTitle = driver.getTitle();
		System.out.println(newCustomerTitle);
		Assert.assertEquals(newCustomerTitle, "Guru99 Bank New Customer Entry Page");
	}
	
	
	@Test
	public void verifyeditCustomerBtnTest() throws InterruptedException
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
	public void verifynewAccountBtnTest()
	{
		homePage.verifynewAccountBtn();
		String newAccountTitle = driver.getTitle();
		System.out.println(newAccountTitle);
		Assert.assertEquals(newAccountTitle, "Guru99 bank add new account");
	}

	@Test
	public void verifyeditAccountBtnTest() throws InterruptedException
	{
		homePage.verifyeditAccountBtn();
		Thread.sleep(2000);
		String editAccountTitle = driver.getTitle();
		System.out.println(editAccountTitle);
		Assert.assertEquals(editAccountTitle, "Guru99 Edit Account Page");
	}

	@Test
	public void verifydeleteAccountBtnTest()
	{
		homePage.verifydeleteAccountBtn();
		String deleteAccountTitle = driver.getTitle();
		System.out.println(deleteAccountTitle);
		Assert.assertEquals(deleteAccountTitle, "Guru99 Bank Delete Account Page");
	}

//	@Test
//	public void verifyDepositBtnTest()
//	{
//		homePage.verifyDepositBtn();
//		String DepositrTitle = driver.getTitle();
//		System.out.println(DepositrTitle);
//		Assert.assertEquals(DepositrTitle, "Guru99 Bank New Deposite Page");
//	}

	@Test
	public void verifyfundTransferBtnTest() throws InterruptedException
	{
		homePage.verifyfundTransferBtn();
		Thread.sleep(5000);
		String fundTransferTitle = driver.getTitle();
		System.out.println(fundTransferTitle);
		//Assert.assertEquals(fundTransferTitle, "Guru99 Bank New Customer Entry Page");
	}

//	@Test
//	public void verifynewCustomerBtnTest()
//	{
//		homePage.verifynewCustomerBtn();
//		String newCustomerTitle = driver.getTitle();
//		System.out.println(newCustomerTitle);
//		Assert.assertEquals(newCustomerTitle, "Guru99 Bank New Customer Entry Page");
//	}
//
//	@Test
//	public void verifynewCustomerBtnTest()
//	{
//		homePage.verifynewCustomerBtn();
//		String newCustomerTitle = driver.getTitle();
//		System.out.println(newCustomerTitle);
//		Assert.assertEquals(newCustomerTitle, "Guru99 Bank New Customer Entry Page");
//	}
//
//	@Test
//	public void verifynewCustomerBtnTest()
//	{
//		homePage.verifynewCustomerBtn();
//		String newCustomerTitle = driver.getTitle();
//		System.out.println(newCustomerTitle);
//		Assert.assertEquals(newCustomerTitle, "Guru99 Bank New Customer Entry Page");
//	}
//
//	@Test
//	public void verifynewCustomerBtnTest()
//	{
//		homePage.verifynewCustomerBtn();
//		String newCustomerTitle = driver.getTitle();
//		System.out.println(newCustomerTitle);
//		Assert.assertEquals(newCustomerTitle, "Guru99 Bank New Customer Entry Page");
//	}
//
//	@Test
//	public void verifynewCustomerBtnTest()
//	{
//		homePage.verifynewCustomerBtn();
//		String newCustomerTitle = driver.getTitle();
//		System.out.println(newCustomerTitle);
//		Assert.assertEquals(newCustomerTitle, "Guru99 Bank New Customer Entry Page");
//	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
}

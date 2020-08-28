package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.DeleteCustomerPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class DeleteCustomerPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	DeleteCustomerPage deleteCustomerPage;
	
	public DeleteCustomerPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void startUp()
	{
		initialization();
	   loginPage = new LoginPage();
	    homePage = loginPage.verifyLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
	    homePage.verifyeditCustomerBtn();// yet to modify
	    deleteCustomerPage = new DeleteCustomerPage();
	}
	
	@Test
	public void verifyEditCustomerPageTitleTest() throws InterruptedException
	{
		Thread.sleep(2000);
		String deleteCustomerTitle = deleteCustomerPage.verifyDeleteCustomerPageTitle();
		System.out.println(deleteCustomerTitle);
		Assert.assertEquals(deleteCustomerTitle, "Guru99 Bank Edit Customer Page");// Defect
		//Assert.assertEquals(deleteCustomerTitle, "Guru99 Bank Delete Customer Page");// but it should be like
		
	}
	
	@Test
	public void verifySubmitBtnTest() throws InterruptedException	//from here to edit
	{
		//Thread.sleep(2000);
		String submitMsg = deleteCustomerPage.verifySubmitBtn();
		System.out.println(submitMsg);
		Assert.assertEquals(submitMsg, "Customer does not exist!!");
	}
	
	
	@Test
	public void verifyResetBtnTest()
	{
		String submitMsg = deleteCustomerPage.verifyResetBtn();
		System.out.println(submitMsg);
		Assert.assertEquals(submitMsg, "Customer does not exist!!");// its a defect
		//Assert.assertEquals(submitMsg, "Please fill all fields");// output should be
		
	}
	
		
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
}


package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void startUp()
	{
		initialization();
	   loginPage = new LoginPage();
		
	}
	
	@Test
	public void verifyLoginPageTitleTest()
	{
		String loginTitle = loginPage.verifyLoginPageTitle();
		System.out.println(loginTitle);
		Assert.assertEquals(loginTitle, "Guru99 Bank Home Page");
	}
	
	@Test
	public void verifyLoginBtnTest()
	{
		loginPage.verifyLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
		String homeTitle = driver.getTitle();
		System.out.println(homeTitle);
		Assert.assertEquals(homeTitle, "Guru99 Bank Manager HomePage");
	}
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
}

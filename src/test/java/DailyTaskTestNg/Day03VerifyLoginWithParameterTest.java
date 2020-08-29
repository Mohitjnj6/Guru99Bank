package DailyTaskTestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class Day03VerifyLoginWithParameterTest  extends TestBase
{
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Samsung\\Downloads\\geckodriver.exe");
//		driver  = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\Downloads\\chromedriver.exe");
		driver  = new ChromeDriver();
		 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoad_Timeout , TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		//To get login page Title
		String loginPageTitle = driver.getTitle();
		System.out.println(loginPageTitle);
	}
	
	@DataProvider
	public void testdata()
	{
		TestUtil.getLoginDataFromExcel()
	}
	
	
	@Test
	public void verifyLoginTest(String un, String pwd)
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		//Verification of login
		//to get Home Page Title	
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle); 
		Assert.assertEquals(homePageTitle, "Guru99 Bank Manager HomePage");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}



package DailyTaskTestNg;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

/**
 * 
 * @author Mohit Juneja
 *        Day02VerifyLoginTest
 *        ************** 
 *        Test Steps
 *        1)  Go to http://www.demo.guru99.com/V4/
          2) Enter valid UserId
          3) Enter valid Password
          4) Click Login
          5) Verify	 (new task for day 02)
          (New) //As there should be no hard coded value, so
          config.properties, base class & TestUtil added from Day 02) 
 */		  

public class Day02VerifyLoginTest extends TestBase
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
	
	
	@Test
	public void verifyLoginTest()
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("password"));
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

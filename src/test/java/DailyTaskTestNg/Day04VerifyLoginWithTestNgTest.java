package DailyTaskTestNg;

import java.util.ArrayList;
import java.util.Iterator;
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

/**
 * 
 * @author Mohit Juneja
 *        Day03VerifyLoginWithParameterTest
 *        ************** 
 *        Test Steps
 *        1)  Go to http://www.demo.guru99.com/V4/
          2) Enter valid UserId and
          3) and Enter valid Password (Parameterization)((New task))Use TestNg(Already there))
          4) Click Login
          5) Verify
 */	

public class Day04VerifyLoginWithTestNgTest  extends TestBase
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
	public Iterator<Object[]> testData()
	{
		ArrayList<Object[]> data = TestUtil.getLoginDataFromExcel();
		return data.iterator();
	}
	
	
	@Test(dataProvider= "testData")
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




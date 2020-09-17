package DailyTaskTestNg;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class Day06VerifyLoginWithScreenshotTest extends TestBase
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
	public void verifyLoginTest(String un, String pwd) throws IOException
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		//Verification of login
		//to get Home Page Title	
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle); 
		String managerId = driver.findElement(By.xpath("//tr[@class='heading3']//td")).getText();
		System.out.println("Welcome "+managerId); 
		Assert.assertEquals(managerId, ("Manger Id : "+prop.getProperty("username")));
//		System.out.println(System.getProperty("user.dir"));
//		TestUtil.takeScreenshot();
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(file,new File (".\\screenShots\\"+filename+".jpg"));
		//FileUtils.copyFile(file, new File ("C:\\Users\\Samsung\\eclipse-workspace\\Guru99Bank\\screenShots\\"+System.currentTimeMillis()+".jpg"));
		FileUtils.copyFile(file, new File ("C:\\Users\\Samsung\\Desktop\\New folder\\"+System.currentTimeMillis()+".jpg"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}


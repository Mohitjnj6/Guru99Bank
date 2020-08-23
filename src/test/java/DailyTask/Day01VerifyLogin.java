package DailyTask;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author Mohit Juneja
 *        Day01VerifyLogin
 *        ************** 
 *        Test Steps
 *        1)  Go to http://www.demo.guru99.com/V4/
          2) Enter valid UserId
          3) Enter valid Password
          4) Click Login
 */

public class Day01VerifyLogin {

	public static void main(String[] args) throws InterruptedException 
	{
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Samsung\\Downloads\\geckodriver.exe");
//		WebDriver driver  = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samsung\\Downloads\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://www.demo.guru99.com/V4/");
		
		//To get login page Title
		String loginPageTitle = driver.getTitle();
		System.out.println(loginPageTitle);
		
		//Perform Login
//		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr280518");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ApEhupu");
//		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		
//		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr280518");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ApEhupu");
//		driver.findElement(By.xpath("//input[@name='btnReset']")).click();
//		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
//		String alert = driver.switchTo().alert().getText();
//		System.out.println(alert);
//		driver.switchTo().alert().accept();
																																												
		driver.quit();
		
		
	}

}

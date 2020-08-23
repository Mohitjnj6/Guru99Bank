package DailyTask;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Day01VerifyLogin {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Samsung\\Downloads\\geckodriver.exe");
		WebDriver driver  = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://www.demo.guru99.com/V4/");
		
		//To get login page Title
		String loginPageTitle = driver.getTitle();
		System.out.println(loginPageTitle);
		
		//Perform Login
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr280518");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ApEhupu");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		//to get Home Page Title
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);
		
		Thread.sleep(70000);
		driver.quit();
		
		
	}

}

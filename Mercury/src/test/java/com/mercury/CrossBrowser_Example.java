package com.mercury;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowser_Example extends Application_Test_Data {
	WebDriver driver ;

	 @Test(dataProvider="Login")
	
	public void Sign_On_Success(String uname,String upass) {
		  
		  driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys(uname);
			// driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElement(By.name("password")).sendKeys(upass);
			driver.findElement(By.name("login")).click();
			driver.findElement(By.linkText("SIGN-OFF")).click();
	  
	  }
	  @BeforeTest
	  @Parameters("browser")
		  public void LaunchBrowser(String browser) {
		  if(browser.equalsIgnoreCase("chrome"))
		  {
			  String absolutepath = System.getProperty("user.dir");
				//String relativepath = absolutepath+"\\chromedriver.exe";
				String relativepath = absolutepath+"\\chromedriver.exe";
				System.setProperty("WebDriver.chrome.driver",relativepath);
				driver = new ChromeDriver();
		  }
		  else if
		  (browser.equalsIgnoreCase("ie"))
		  {
			  String absolutepath = System.getProperty("user.dir");
				//String relativepath = absolutepath+"\\chromedriver.exe";
				String relativepath = absolutepath+"\\IEDriverServer.exe";
				System.setProperty("WebDriver.ie.driver",relativepath);
				driver = new InternetExplorerDriver();
		  }
			driver.manage().window().maximize();
			driver.get("http://newtours.demoaut.com");
			}
	  

	  @AfterTest
	  public void closeBrowser() {
		     //driver.quit();
			}
}
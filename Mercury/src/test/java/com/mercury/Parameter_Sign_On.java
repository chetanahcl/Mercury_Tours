package com.mercury;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Parameter_Sign_On {
	
	ChromeDriver driver ;
  @Test
  @Parameters({"uname","upass"})
public void Sign_On_Success(String uname,String upass) {
	  
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElementByName("userName").sendKeys(uname);
		// driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys(upass);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();
  
  }
  @BeforeTest
	  
	  public void LaunchBrowser() {
		String absolutepath = System.getProperty("user.dir");
		//String relativepath = absolutepath+"\\chromedriver.exe";
		String relativepath = absolutepath+"\\chromedriver.exe";
		System.setProperty("WebDriver.chrome.driver",relativepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com");
		}
  

  @AfterTest
  public void closeBrowser() {
	     //driver.quit();
		}


}

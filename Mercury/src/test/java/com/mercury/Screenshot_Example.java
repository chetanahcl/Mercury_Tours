package com.mercury;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Screenshot_Example extends Application_Test_Data {
	
	ChromeDriver driver ;
	String filepath = "C:\\Selenium_Training\\Workspace\\Mercury\\screenshot";
	
  @Test
  public void Sign_On_Success() {
	  
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElementByName("userName").sendKeys("testing");
		// driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("logins")).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();
  
  }
  @BeforeTest
	  
	  public void LaunchBrowser() {
		String absolutepath = System.getProperty("user.dir");
		String relativepath = absolutepath+"\\chromedriver.exe";
		//String relativepath = absolutepath+"\\IEDriverServer.exe";
		System.setProperty("WebDriver.ie.driver",relativepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com");
		}
  
  @AfterMethod
  public void teardown(ITestResult result) throws IOException{
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  File Browserscreenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//  FileUtils.copyFile(Browserscreenshot, new File("C:\\Selenium_Training\\Workspace\\Mercury\\screenshot\\login.png"));
		  FileUtils.copyFile(Browserscreenshot, new File(filepath+"/"+result.getName()+"_"+System.nanoTime()+ ".png"));
	  }
  }
  

  @AfterTest
  public void closeBrowser() {
	     //driver.quit();
		}

}

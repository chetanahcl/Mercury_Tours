package com.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Actions_Example {
	ChromeOptions options ;
	ChromeDriver driver ;
	
  @Test
  public void Sign_On_Success() {
	 
	  WebElement element = driver.findElementByXPath("//a[contains(text(),'My Account')]");
	  Actions action = new Actions(driver);
	  action.moveToElement(element).build().perform();
	  driver.findElementById("signInBtn").click();
	  
  }
  @BeforeTest
	  
	  public void LaunchBrowser() {
		String absolutepath = System.getProperty("user.dir");
		//String relativepath = absolutepath+"\\chromedriver.exe";
		String relativepath = absolutepath+"\\chromedriver.exe";
		options = new ChromeOptions();
		options.setHeadless(false);
		options.addArguments("incognito");
		System.setProperty("WebDriver.chrome.driver",relativepath);		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.yatra.com/");
		}
  

  @AfterTest
  public void closeBrowser() {
	    // driver.quit();
		}

}

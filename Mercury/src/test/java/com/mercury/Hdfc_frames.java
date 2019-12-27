package com.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hdfc_frames {
	ChromeOptions options ;
	ChromeDriver driver ;
	
  @Test
  public void Sign_On_Success() {
	  driver.switchTo().frame("login_page");
	  WebElement element=  driver.findElement(By.name("fldLoginUserId"));
	  element.sendKeys("1000");
	  driver.findElement(By.xpath("//img[@alt='continue']")).click();
      driver.switchTo().defaultContent();
	  
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
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		}
  

  @AfterTest
  public void closeBrowser() {
	    // driver.quit();
		}

}

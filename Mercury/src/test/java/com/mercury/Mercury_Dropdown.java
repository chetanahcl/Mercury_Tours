package com.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mercury_Dropdown {
	
	ChromeDriver driver ;
	
  @Test
  public void Sign_On_Success() throws InterruptedException {
	  
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElementByName("userName").sendKeys("testing");
		// driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		
		Select selectpass = new Select(driver.findElementByName("passCount"));
		selectpass.selectByValue("4");
		

		
		Select selectdep = new Select(driver.findElementByName("fromPort"));
		selectdep.selectByValue("London");
		
		
		Select selectair = new Select(driver.findElementByName("airline"));
		selectair.selectByVisibleText("Blue Skies Airlines");
		
		driver.findElement(By.name("findFlights")).click();
		
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

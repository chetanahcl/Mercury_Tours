package com.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mercury_Following_Sibling_Xpah_Example {
	
	ChromeDriver driver ;
	
  @Test
  public void Sign_On_Success() throws InterruptedException {
	  
	 
		
		driver.findElement(By.xpath("//td[@width='67']//following-sibling::td[1]/a")).click();
		
		driver.findElement(By.xpath("//td[@width='77']//preceding-sibling::td[1]/a")).click();
		Thread.sleep(6000);
		
				
				

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
	  //   driver.quit();
		}

}

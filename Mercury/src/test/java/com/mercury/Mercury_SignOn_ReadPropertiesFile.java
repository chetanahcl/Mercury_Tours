package com.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Mercury_SignOn_ReadPropertiesFile extends Application_Test_Data {
	
	ChromeDriver driver ;
	
  @Test(dataProvider="LoginDataXLSX")
  public void Sign_On_Success(String uname,String password) {
	  
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElementByName("userName").sendKeys(uname);
		// driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
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
  

  @AfterTest
  public void closeBrowser() {
	     //driver.quit();
		}

}

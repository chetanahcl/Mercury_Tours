package com.mercury;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Mercury_SignOn_TestNG extends Application_Test_Data  {
	
	
	  ChromeDriver driver ;
	
	  File file =new File("C:\\Selenium_Training\\Workspace\\Mercury\\mercury_tours.properties");
	  Properties prop =new Properties();
	
	  
	
	  
	
  @Test(dataProvider="LoginDataXLSX")
  public void Sign_On_Success(String uname,String password) throws IOException {
	  FileInputStream fileInput =new FileInputStream(file);
		 prop.load(fileInput);
	  driver.findElement(By.linkText(prop.getProperty("Issignon"))).click();
		driver.findElementByName(prop.getProperty("userName")).sendKeys(uname);
		// driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name(prop.getProperty("password"))).sendKeys(password);
		driver.findElement(By.name(prop.getProperty("Login"))).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();
  
  }
  @BeforeTest
	  
	  public void LaunchBrowser() throws IOException  {
	  
	  String absolutepath = System.getProperty("user.dir");
	 FileInputStream fileInput =new FileInputStream(file);
	 prop.load(fileInput);
		String relativepath = absolutepath+"\\chromedriver.exe";
		//String relativepath = absolutepath+"\\IEDriverServer.exe";
		System.setProperty("WebDriver.ie.driver",relativepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		}
  

  @AfterTest
  public void closeBrowser() {
	     //driver.quit();
		}

}

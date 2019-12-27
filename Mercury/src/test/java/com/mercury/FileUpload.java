package com.mercury;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpload {
	
	ChromeDriver driver ;
	
  @Test
  public void Sign_On_Success() throws InterruptedException {
	  String absoultepath =System.getProperty("user.dir");
	  String filePath=absoultepath+"\\screenshot\\login.png";
	  System.out.println(filePath);
	  driver.findElement(By.id("btnChooseFiles")).click();	
	  uploadFile(filePath);	  
	  Thread.sleep(10);

  }
  
  public static void uploadFile(String fileLocation)
  {
	  try{
		  //upload through Robot API
		  StringSelection ss =new StringSelection(fileLocation);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		  //navigate key strokes for CTRL V and ENTER keys
		  
		  Robot robot =new Robot();
		  robot.delay(1000);
		  //Press CTRL+V
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  
		  //Release CTRL+V
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  
		  //Press Enter
		  robot.delay(1000);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  robot.delay(1000);
		  
	  }catch (Exception exp){
		  exp.printStackTrace();
	  }
		  
		  
  }

  
  @BeforeTest
	  
	  public void LaunchBrowser() {
		String absolutepath = System.getProperty("user.dir");
		//String relativepath = absolutepath+"\\chromedriver.exe";
		String relativepath = absolutepath+"\\chromedriver.exe";
		
		System.setProperty("WebDriver.chrome.driver",relativepath);		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gofile.io/?t=uploadFiles");
		}
  

  @AfterTest
  public void closeBrowser() {
	    // driver.quit();
		}

}

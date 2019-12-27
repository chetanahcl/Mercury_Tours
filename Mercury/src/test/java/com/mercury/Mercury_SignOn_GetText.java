package com.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mercury_SignOn_GetText {
	
	ChromeDriver driver ;
	
  @Test
  public void Sign_On_Success() throws InterruptedException {
	  
	  driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElementByName("userName").sendKeys("testing");
		// driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
WebElement element = driver.findElement(By.linkText("SIGN-OFF"));
String ActValue = element.getText();
String ExpValue = "SIGN-OFF";
System.out.println(ActValue);
Assert.assertEquals(ExpValue,ActValue);


String ExpUrl = "http://newtours.demoaut.com/mercuryreservation.php";
String ActUrl = driver.getCurrentUrl();
System.out.println(ActUrl);
Assert.assertEquals(ActUrl, ExpUrl);

String ExpTitle = "Find a Flight: Mercury Tours:";
String ActTitle = driver.getTitle();
System.out.println(ActTitle);
Assert.assertEquals(ExpTitle, ActTitle);

//To verify Roundtrip select or not
String str = driver.findElement(By.xpath("//input[@value='roundtrip']")).getAttribute("checked");
if(str.equalsIgnoreCase("true"))
{
	System.out.println("Round Trip Is Selected");
}


//To select Radio Button
//driver.findElementByXPath("//input[@value='oneway']").click();

//To Verify whether oneway get selected or not post click
WebElement check = driver.findElementByXPath("//input[@value='oneway']");
check.click();

Assert.assertEquals(check.isSelected(),true);


//using cssSelector
WebElement Bussiness =driver.findElementByCssSelector("input[value='Business']");
Bussiness.click();
Assert.assertEquals(Bussiness.isSelected(),true);
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
	     driver.quit();
		}

}

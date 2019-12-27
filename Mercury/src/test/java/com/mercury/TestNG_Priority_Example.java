package com.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Priority_Example {
	
	ChromeDriver driver ;
	
	  @Test(priority=1)
	  public void Login() {
		  
		  driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElementByName("userName").sendKeys("testing");
			// driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElement(By.name("password")).sendKeys("testing");
			driver.findElement(By.name("login")).click();

		  
	  }
	  
	  @Test(priority=2)
	  public void SearchFlight()
	  {
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
	
	@Test(priority=3)
	public void Depart()
	{
		Select selectpass = new Select(driver.findElementByName("passCount"));
		selectpass.selectByValue("4");
		

		
		Select selectdep = new Select(driver.findElementByName("fromPort"));
		selectdep.selectByValue("London");
		
		
		Select selectair = new Select(driver.findElementByName("airline"));
		selectair.selectByVisibleText("Blue Skies Airlines");
		
		driver.findElement(By.name("findFlights")).click();
		
		String depart = driver.findElement(By.xpath("//td[@class='title']//font[contains(text(),'DEPART')]")).getText();
		System.out.println(depart);
		Assert.assertEquals("DEPART", depart);
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

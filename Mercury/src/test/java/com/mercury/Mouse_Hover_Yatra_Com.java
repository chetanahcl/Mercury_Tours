package com.mercury;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mouse_Hover_Yatra_Com {
	
	ChromeDriver driver;
	@Test()
	public void MouseHoverFlipCart() throws InterruptedException
	{
		driver.get( "https://www.yatra.com/");
		WebElement element = driver.findElementByXPath("//a[contains(text(),'My Account')]");
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        //Thread.sleep(6000);
		driver.findElementById("signInBtn").click();
	}
	
	@BeforeTest
	public void LaunchBrowser()
		
		{
		String absolutePath=System.getProperty("user.dir");
		String filepath=absolutePath+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",filepath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
}

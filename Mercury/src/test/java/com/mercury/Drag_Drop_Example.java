package com.mercury;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Drag_Drop_Example {
	ChromeOptions options;
	ChromeDriver driver;

	@Test
	public void Sign_On_Success() throws InterruptedException {

		Actions action = new Actions(driver);
		WebElement drag = driver.findElementById("draggable");
		WebElement drop = driver.findElementById("droppable");
		action.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(5000);
	}

	@BeforeTest

	public void LaunchBrowser() {
		String absolutepath = System.getProperty("user.dir");
		// String relativepath = absolutepath+"\\chromedriver.exe";
		String relativepath = absolutepath + "\\chromedriver.exe";
		options = new ChromeOptions();
		options.setHeadless(false);
		options.addArguments("incognito");
		System.setProperty("WebDriver.chrome.driver", relativepath);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
	}

	@AfterTest
	public void closeBrowser() {
		// driver.quit();
	}

}

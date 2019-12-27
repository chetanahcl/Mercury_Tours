package com.mercury;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NvigateAllLinks {
	ChromeOptions options;
	ChromeDriver driver;

	@Test
	public void Sign_On_Success() {
		List<WebElement> linksize = driver.findElements(By.tagName("a"));
		int linkscount = linksize.size();
		System.out.println("Total No of links avialable" + linkscount);
		String[] links = new String[linkscount];
		System.out.println("List of links Avialable");
		for (int i = 0; i < linkscount; i++) {
	    links[i] = linksize.get(i).getAttribute("href");
		System.out.println(linksize.get(i).getAttribute("href"));

		}
		// naviate to each link in the the page

		for (int i = 0; i < linkscount; i++) {
			driver.navigate().to(links[i]);
			System.out.println(driver.getTitle());
			driver.navigate().back();
		}
		driver.close();
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
		driver.get("https://www.google.co.in/");
	}

	@AfterTest
	public void closeBrowser() {
		// driver.quit();
	}

}

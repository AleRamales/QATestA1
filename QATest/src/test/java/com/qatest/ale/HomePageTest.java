package com.qatest.ale;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest {
	WebDriver driver;
	String baseUrl = "https://www.google.com/";

	@BeforeClass
	public void SetUp() {
		System.out.println("Starting Test On Chrome Browser");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*"); // Launching the browser
		driver = new ChromeDriver(opt); // driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test
	public void homePageGoogle() {

		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, baseUrl);
		//Assert.assertTrue(actualUrl.isOpen(),"Home page is not open");
		
	}

	@Test
	public void searchPanelField() {

		WebElement searchPanel = driver.findElement(By.id("APjFqb"));
		searchPanel.submit();

	}

	@AfterClass
	public void afterMethod() {
		driver.close();
		System.out.println("Finished Test On Chrome Browser");
	}

}

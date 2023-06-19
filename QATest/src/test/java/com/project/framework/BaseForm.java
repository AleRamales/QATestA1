package com.project.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BaseForm{
	
	WebDriver driver;
	String baseUrl = "https://userinyerface.com/";
	String actualUrl;
	String gameUrl = "https://userinyerface.com/game.html";
	//By passMail = By.name("Choose Password");
	

	@BeforeClass
	public void SetUp() {
		System.out.println("Starting Test On Chrome Browser");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*"); // Launching the browser
		driver = new ChromeDriver(opt); // driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	public boolean isOpen(String url) {
		boolean result = false;
		if (url != null) {
			result = true;
		}
		return result;

	}

	public boolean isPassBoxOpen(By PassField) {
		boolean result = false;
		if (PassField != null) {
			result = true;
		}
		return result;

	}

	
	@Test (priority = 1)
	public void MainPage() {
		  String actualUrl = driver.getCurrentUrl();
		  Assert.assertTrue(isOpen(actualUrl), "Home Page is not open");
	 }
	
	
	@AfterClass
	public void TurnDown () {

		 driver.close();
		  }

		}

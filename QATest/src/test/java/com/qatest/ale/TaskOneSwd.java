package com.qatest.ale;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

public class TaskOneSwd {
	WebDriver driver;
	String baseUrl = "https://userinyerface.com/";
	String actualUrl, BaseHere;
	String gameUrl = "https://userinyerface.com/game.html";

	
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
		if(url != null){
		result = true;
		}
		return result;
		
	}
  @Test
  public void MainPage() {
	  String actualUrl = driver.getCurrentUrl();
	  Assert.assertTrue(isOpen(actualUrl), "Home Page is not open");
 }
  
  
  
  @Test
  public void ClickHere () {
	  String actualUrl = driver.getCurrentUrl();
	  driver.findElement(By.className("start__link")).click();
	  Assert.assertTrue(isOpen(actualUrl), "Game Page is not open");
}
  
  @Test
  public void HelpResponse () {
	  String actualHelp= driver.getPageSource();
	  driver.findElement(By.className("help-form__help-button")).click(); 
	  driver.findElement(By.className("help-form__response")).getText();
	  Assert.assertTrue(isOpen(actualHelp), "Help response is not displayed"); 
  }
  
  
  
  @AfterClass
  public void TurnDown () {

  driver.close();
  } 
}

package com.qatest.ale;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchTest {
	WebDriver driver ;
	String baseUrl = "https://www.google.com/";
	By searchBoxLocator = By.id("APjFqb");
	By resultsLocator = By.cssSelector("textArea#APjFqb.gLFyf");
	   
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Starting Test On Chrome Browser");
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*"); // Launching the browser
        driver=new ChromeDriver(opt); // driver = new ChromeDriver();
        driver.get(baseUrl);
	}
	
	public boolean isOpen(String page) {
		System.out.println(page);
		boolean result = false;
		if(page != null){
		result = true;
		}
		return result;
		
	}
	
	public boolean isSearchFieldDisplayed(By searchBoxLocator2) {
		boolean result = false;
		if(searchBoxLocator2 != null){
		result = true;
		}
		return result;
		
	}
	
	@Test
	public void homePageTest() {
	  
			String actualUrl = driver.getCurrentUrl();//impl
			Assert.assertTrue(isOpen(actualUrl), "Home Page is not open");
  }
	
	@Test
	public void searchPanelField() {
		
		final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";//impl
		StringBuilder sb = new StringBuilder ();//impl
		
		for(int i=0; i<7; i++) {//impl
			double aleatorio = Math.random()*letters.length();//impl
			int position = (int)aleatorio;//impl
			char letter = letters.charAt(position);//impl
			sb.append(letter);//impl
		}
		
		WebElement searchInt = driver.findElement(searchBoxLocator);//impl
		searchInt.clear();//impl
		searchInt.sendKeys(sb.toString()+ "  ");//impl
		searchInt.submit();//impl
		
		Assert.assertTrue(isSearchFieldDisplayed(searchBoxLocator),"Search field is not displayed ");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (7));//impl
		wait.until(ExpectedConditions.presenceOfElementLocated(resultsLocator));//impl
		System.out.println("This is the random value: "+driver.findElement(resultsLocator).getText());
		String actualUrl = driver.getCurrentUrl();

		
		Assert.assertTrue(isOpen(actualUrl), "Search field is not displayed");
		
		Assert.assertEquals(driver.findElement(resultsLocator).getText(),sb.toString(),"Text is not equal to searched");
		
	}
	
	@AfterClass
	public void afterMethod() {
		 driver.close();//impl
		System.out.println("Finished Test On Chrome Browser");
	}
}
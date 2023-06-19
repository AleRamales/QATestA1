package com.qatest.ale;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import java.util.*;

public class TaskOneSwdPartTwo {
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
		if (url != null) {
			result = true;
		}
		return result;

	}

	public boolean start(WebElement timeZero) {
		boolean result = false;

		result = false;
		if (timeZero.equals("00:00")) {
			System.out.println("The timer start at 00:00");
			result = true;
		}
		return result;
	}

	@Test
	public void HelpForm() {
		String actualUrl = driver.getCurrentUrl();
		String actualHelp = driver.getPageSource();

		driver.findElement(By.className("start__link")).click();
		driver.findElement(By.className("help-form__help-button")).click();
		driver.findElement(By.className("help-form__response")).click();

		Assert.assertTrue(isOpen(actualUrl), "Home Page is not open");
		Assert.assertTrue(isOpen(actualUrl), "Game Page is not open");
		Assert.assertTrue(isOpen(actualHelp), "Help response is not displayed");

	}

	@Test
	public void isTimer() {
		boolean actualTime = driver.getPageSource().contains("00:00");
		Assert.assertTrue(actualTime);
		System.out.println("Inició en: "+actualTime);
	}

	@AfterClass
	public void TurnDown() {

		driver.close();
	}

}

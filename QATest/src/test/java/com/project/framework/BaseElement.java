package com.project.framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseElement extends BaseForm {

	// Waits

	@Test(priority = 1)
	public void HelpForm() {
		String actualUrl = driver.getCurrentUrl();
		String actualHelp = driver.getPageSource();
		driver.findElement(By.className("start__link")).click();
		Assert.assertTrue(isOpen(actualUrl), "Home Page is not open");
		Assert.assertTrue(isOpen(actualHelp), "Game Page is not open");

	}

	@Test(priority = 2)

	public void ValueRandom() {

		final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			double aleatorio = Math.random() * letters.length();
			int position = (int) aleatorio;
			char letter = letters.charAt(position);
			sb.append(letter);
		}

	
		WebElement passwordMail = driver.findElement(By.name("Choose Password"));
		passwordMail.clear();
		passwordMail.sendKeys(sb.toString() + "          ");
		passwordMail.submit();

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
		String actualUrl = driver.getCurrentUrl();

		}

	@AfterClass
	public void TurnDown() {

		driver.close();
	}

}

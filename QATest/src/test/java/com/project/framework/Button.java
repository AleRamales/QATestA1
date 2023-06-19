package com.project.framework;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;


@Test(priority=1)
public class Button extends BaseForm{
	
	
	
	public void HelpForm() throws Exception{
		String actualUrl = driver.getCurrentUrl();
		String actualHelp = driver.getPageSource();

		driver.findElement(By.className("start__link")).click();
		driver.findElement(By.className("help-form__help-button")).click();
		driver.findElement(By.className("help-form__response")).click();
		Thread.sleep(5000);
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		Assert.assertTrue(isOpen(actualUrl), "Home Page is not open");
		Assert.assertTrue(isOpen(actualUrl), "Game Page is not open");
		Assert.assertTrue(isOpen(actualHelp), "Help response is not displayed");

	}

	@Test(priority=2)
	public void isTimer() throws InterruptedException {
		
		boolean actualTime = driver.getPageSource().contains("00:00");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		Assert.assertTrue(actualTime);
		System.out.println("Inició en: "+actualTime);
		
	}
	
	@Test(priority=3)
	public void InvalidPassword() {
		final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			double aleatorio = Math.random() * letters.length();
			int position = (int) aleatorio;
			char letter = letters.charAt(position);
			sb.append(letter);
		}

		List<WebElement> e = driver.findElements(By.cssSelector("input[class='input input--blue input--gray']"));
		System.out.println("element"+e);
		
		WebElement passwordMail = e.get(0);

		passwordMail.clear();
		passwordMail.sendKeys(sb.toString() + "          ");
		
		WebElement emailField = e.get(1);
		emailField.clear();
		emailField.sendKeys(sb.toString() + "          ");
				
		WebElement domainMail = e.get(2);		
		domainMail.clear();
		domainMail.sendKeys("gmail");
				
		WebElement dropdownMail = driver.findElement(By.cssSelector("div[class='dropdown__field']"));
		dropdownMail.click();
		List<WebElement> dl = driver.findElements(By.cssSelector("div[class='dropdown__list-item']"));
		WebElement lis = dl.get(0);		
		lis.click();
		
		
		}
	
	
	@Test(priority=4)
	public void ValidPassword() {
		final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			double aleatorio = Math.random() * letters.length();
			int position = (int) aleatorio;
			char letter = letters.charAt(position);
			sb.append(letter);
		}

		List<WebElement> e = driver.findElements(By.cssSelector("input[class='input input--blue input--gray']"));
		System.out.println("element"+e);
		
		WebElement passwordMail = e.get(0);

		passwordMail.clear();
		passwordMail.sendKeys(sb.toString() + "          ");
		
		WebElement emailField = e.get(1);
		emailField.clear();
		emailField.sendKeys(sb.toString() + "          ");
				
		WebElement domainMail = e.get(2);		
		domainMail.clear();
		domainMail.sendKeys("gmail");
				
		WebElement dropdownMail = driver.findElement(By.cssSelector("div[class='dropdown__field']"));
		dropdownMail.click();
		List<WebElement> dl = driver.findElements(By.cssSelector("div[class='dropdown__list-item']"));//desplegable del dominio .org .com
		WebElement lis = dl.get(0);		
		lis.click();
		
		
		}
		
		@Test(priority=5)
	public void TermsAndConditions()throws Throwable {
		//
		WebElement acceptButton = driver.findElement(By.className("checkbox__label"));
		acceptButton.click();
		Thread.sleep(5000);
		
		WebElement termsAndConditions = driver.findElement(By.className("login-form__terms-conditions-underline"));
		termsAndConditions.click();
		WebElement acceptTermsButton = driver.findElement(By.className("terms-and-conditions__accept-button-container"));
		acceptTermsButton.click();
		
		
		WebElement cerrarEmergente = driver.findElement(By.className("modal__close-copyright"));
		cerrarEmergente.click();
		Thread.sleep(1800);

	}
	
	@AfterClass
	public void TurnDown () {

		 driver.close();
		  }

		}

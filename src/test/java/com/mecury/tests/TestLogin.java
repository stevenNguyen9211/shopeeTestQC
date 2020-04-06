package com.mecury.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {

	public static void main(String[] args) {
		String browserDriver = System.getProperty("user.dir") + "/src/main/resources/";
		System.setProperty("webdriver.chrome.driver", browserDriver + "chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		login(driver, "shopeetest", "Shopee@2020");
		driver.quit();
	}

	public static void login(WebDriver driver, String username, String password) {
		WebElement inputUser = driver.findElement(By.xpath("//input[@name='userName']"));
		inputUser.sendKeys(username);
		WebElement inputPass = driver.findElement(By.xpath("//input[@name='password']"));
		inputPass.sendKeys(password);
		WebElement submitLogin = driver.findElement(By.xpath("//input[@name='login']"));
		submitLogin.click();
	}

}

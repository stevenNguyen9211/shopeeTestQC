package com.mecury.tests;

import org.testng.annotations.Test;

import com.mecury.webpages.HomePage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginMecury {
	ChromeDriver driver;

	@Parameters({ "username", "password" })
	@Test
	public void TestLogin(String username, String password) {
		new HomePage(driver).goToHomePage().loginSite(username, password);
	}

	@BeforeTest
	public void initBrowser() {
		String browserDriver = System.getProperty("user.dir") + "/src/main/resources/";
		System.setProperty("webdriver.chrome.driver", browserDriver + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}

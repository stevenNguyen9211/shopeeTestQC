package com.mecury.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.initPage.InitDriver;
import com.mecury.webpages.HomePage;

public class LoginMecury extends InitDriver{
	
	@Parameters({ "username", "password" })
	@Test
	public void TestLogin(String username, String password) {
		new HomePage(driver).goToHomePage().loginSite(username, password);
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}

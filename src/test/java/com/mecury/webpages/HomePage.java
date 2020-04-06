package com.mecury.webpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	private static String HOMEPAGE_URL = "http://newtours.demoaut.com/";

	@FindBy(how = How.XPATH, using = "//input[@name='userName']")
	private WebElement inputUser;

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement inputPass;

	@FindBy(how = How.XPATH, using = "//input[@name='login']")
	private WebElement btnSubmit;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// Initialise Elements
		PageFactory.initElements(driver, this);
	}

	private void checkLoadPage(int timeOutInSeconds) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String jsCommand = "return document.readyState";

		// Validate readyState before doing any waits
		if (js.executeScript(jsCommand).toString().equals("complete")) {
			return;
		}

		for (int i = 0; i < timeOutInSeconds; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (js.executeScript(jsCommand).toString().equals("complete")) {
				break;
			}
		}
	}

	public HomePage goToHomePage() {
		driver.get(HOMEPAGE_URL);
		checkLoadPage(5000);
		return this;
	}

	public HomePage loginSite(String username, String pass) {
		inputUser.sendKeys(username);
		inputPass.sendKeys(pass);
		btnSubmit.submit();
		return this;
	}

}

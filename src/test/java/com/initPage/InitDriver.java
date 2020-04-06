package com.initPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class InitDriver {

	public ChromeDriver driver;

	public InitDriver() {
		String browserDriver = System.getProperty("user.dir") + "/src/main/resources/";
		System.setProperty("webdriver.chrome.driver", browserDriver + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

}

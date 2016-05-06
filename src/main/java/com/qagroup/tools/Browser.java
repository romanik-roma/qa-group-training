package com.qagroup.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver start() {

		String browserName = System.getProperty("browser", "firefox");

		switch (browserName.toLowerCase()) {
		case "chrome":
			String userDir = System.getProperty("user.dir");
			String pathToChromedriver = userDir + "/src/main/resources/chromedriver";
			System.setProperty("webdriver.chrome.driver", pathToChromedriver);
			return new ChromeDriver();

		case "firefox":
			return new FirefoxDriver();
		default:
			return new FirefoxDriver();
		}
	}

}

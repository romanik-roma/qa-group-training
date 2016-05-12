package com.qagroup.tools;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Browser {

	public static WebDriver start() {

		String browserName = System.getProperty("browser", "firefox");

		switch (browserName.toLowerCase()) {
		case "android":
			return startChromeOnAndroid();

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

	private static WebDriver startChromeOnAndroid() {
		WebDriver driver = null;
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy A3");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}

		return driver;
	}

}

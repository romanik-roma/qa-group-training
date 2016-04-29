package com.qagroup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class Google {
	private WebDriver innerDriver;

	private static String baseUrl = "http://www.google.com";

	@Step("Opens Google start page")
	public GoogleStartPage openStartPage() {
		innerDriver = new FirefoxDriver();
		// dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		innerDriver.manage().window().maximize();

		innerDriver.get(baseUrl);
		GoogleStartPage page = new GoogleStartPage(innerDriver);
		return page;
	}

	public void close() {
		innerDriver.quit();
		innerDriver = null;
	}
}

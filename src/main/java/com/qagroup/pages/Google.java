package com.qagroup.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qagroup.tools.Browser;
import com.qagroup.tools.IWebApp;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class Google implements IWebApp {
	private WebDriver innerDriver;

	private static String baseUrl = "http://www.google.com";

	@Step("Opens Google start page")
	public GoogleStartPage openStartPage() {
		innerDriver = Browser.start();

		innerDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		innerDriver.manage().window().maximize();

		innerDriver.get(baseUrl);
		GoogleStartPage page = new GoogleStartPage(innerDriver);
		return page;
	}

	public void close() {
		innerDriver.quit();
		innerDriver = null;
	}

	@Override
	@Attachment
	public byte[] takeScreenshot(String name) {
		TakesScreenshot ts = (TakesScreenshot) innerDriver;
		return ts.getScreenshotAs(OutputType.BYTES);
	}
}

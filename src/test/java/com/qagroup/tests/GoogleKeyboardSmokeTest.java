package com.qagroup.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qagroup.pages.Google;
import com.qagroup.pages.GoogleStartPage;
import com.qagroup.tools.GoogleTestListener;
import com.qagroup.tools.IWebApp;
import com.qagroup.tools.IWebAppTest;

import ru.yandex.qatools.allure.annotations.Description;

@Listeners(GoogleTestListener.class)
public class GoogleKeyboardSmokeTest implements IWebAppTest {
	private Google google = new Google();
	private GoogleStartPage googleStartPage;

	@BeforeClass
	public void setUp() {
		googleStartPage = google.openStartPage();
	}

	@Test
	@Description(value = "Google keyboard smoke test")
	public void testKeyboardAppears() {
		googleStartPage.openKeyboard();

		assertTrue(googleStartPage.isKeyboardDisplayed(), "Keyboard should be displayed on Google start page.");
	}

	@Test(dependsOnMethods = { "testKeyboardAppears" })
	public void testKeyboardDisappears() {
		googleStartPage.closeKeyboard();

		assertFalse(googleStartPage.isKeyboardDisplayed(), "Keyboard should not be displayed on Google start page.");
	}

	@AfterClass
	public void tearDown() {
		google.close();
	}

	@Override
	public IWebApp getTestedInstance() {
		return google;
	}
}

package com.qagroup.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qagroup.pages.Google;
import com.qagroup.pages.GoogleStartPage;
import com.qagroup.tools.GoogleTestListener;
import com.qagroup.tools.IWebApp;
import com.qagroup.tools.IWebAppTest;

@Listeners(GoogleTestListener.class)
public class KeyboardInputInteractionTest implements IWebAppTest {

	private Google google = new Google();
	private GoogleStartPage googleStartPage;

	private static String typedText = "911";

	@BeforeClass
	public void setUp() {
		googleStartPage = google.openStartPage();
		googleStartPage.openScreenKeyboard();
	}

	@Test
	public void testInputTextFromKeyboard() {
		googleStartPage.enterFromScreenKeyboard(typedText);

		assertEquals(googleStartPage.getSearchInputFieldValue(), typedText, "Incorrect text in Search input field:");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		google.close();
	}

	@Override
	public IWebApp getTestedInstance() {
		return google;
	}
}

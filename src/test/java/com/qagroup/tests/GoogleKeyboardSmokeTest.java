package com.qagroup.tests;

import static org.testng.Assert.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qagroup.pages.Google;
import com.qagroup.pages.GoogleStartPage;

public class GoogleKeyboardSmokeTest {
	private Google google = new Google();
	private GoogleStartPage googleStartPage;

	@BeforeClass
	public void setUp() {
		googleStartPage = google.openStartPage();
	}

	@Test
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
}

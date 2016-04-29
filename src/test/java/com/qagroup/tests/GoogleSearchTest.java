package com.qagroup.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qagroup.pages.Google;
import com.qagroup.pages.SearchResultsPage;

public class GoogleSearchTest {

	private Google google = new Google();

	private SearchResultsPage searchResultsPage;

	int expectedResultNumber = 10;
	String textToSearch = "Selenium IDE";

	@BeforeClass
	public void setUp() {
		searchResultsPage = google.openStartPage().searchFor(textToSearch);
		// searchResultsPage = GoogleStartPage.open().searchFor(textToSearch);
	}

	@Test
	public void testResultNumber() {
		int actualResutlNumber = searchResultsPage.getResultNumber();

		assertEquals(actualResutlNumber, expectedResultNumber, "Incorrect number of found results:");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		google.close();
	}
}

package com.qagroup.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Step;

public class SearchResultsPage {

	@FindBy(css = ".g")
	private List<WebElement> results;

	private WebDriver innerDriver;

	public SearchResultsPage(WebDriver driver) {
		this.innerDriver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step
	public int getResultNumber() {
		new WebDriverWait(innerDriver, 10).until(ExpectedConditions.visibilityOfAllElements(results));
		return results.size();
	}

}

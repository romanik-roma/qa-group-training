package com.qagroup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ru.yandex.qatools.allure.annotations.Step;

public class GoogleStartPage {

	@FindBy(id = "lst-ib")
	private WebElement inputField;

	@FindBy(name = "btnG")
	private WebElement searchButton;

	@FindBy(id = "gs_ok0")
	private WebElement keyboardIcon;

	@FindBy(id = "kbd")
	private WebElement keyboard;

	@FindBy(css = ".vk-t-btn")
	private WebElement keyboardCloseButton;

	private WebDriver innerDriver;

	public GoogleStartPage(WebDriver driver) {
		this.innerDriver = driver;
		PageFactory.initElements(driver, this);
	}

	@Step
	public SearchResultsPage searchFor(String textToSearch) {
		clearAndSendKeys(textToSearch);
		searchButton.click();

		return new SearchResultsPage(innerDriver);
	}

	@Step
	public void typeIntoSearchBox(String textToType) {
		clearAndSendKeys(textToType);
	}

	@Step
	private void clearAndSendKeys(String textToType) {
		inputField.clear();
		inputField.sendKeys(textToType);
	}

	@Step
	public void openKeyboard() {
		clickOnKeyboardIcon();
	}

	@Step
	private void clickOnKeyboardIcon() {
		keyboardIcon.click();
	}

	public boolean isKeyboardDisplayed() {
		return keyboard.isDisplayed();
	}

	@Step
	public void closeKeyboard() {
		keyboardCloseButton.click();
	}
}

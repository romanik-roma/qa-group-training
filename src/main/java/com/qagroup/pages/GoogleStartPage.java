package com.qagroup.pages;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy(css = ".vk-btn")
	private List<WebElement> keys;

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
	public void openScreenKeyboard() {
		clickOnKeyboardIcon();
	}

	@Step
	private void clickOnKeyboardIcon() {
		keyboardIcon.click();
	}

	@Step("Checks if Screen Keyboard is Displayed")
	public boolean isScreenKeyboardDisplayed() {
		return keyboard.isDisplayed();
	}

	@Step
	public void closeKeyboard() {
		keyboardCloseButton.click();
	}

	@Step
	public void enterFromScreenKeyboard(String string) {
		List<String> keyValues = new ArrayList<>();

		for (WebElement key : keys) {
			String value = key.getText();
			keyValues.add(value);
		}

		String[] letters = string.split("");

		for (String letter : letters) {
			int index = keyValues.indexOf(letter);

			if (index == -1)
				throw new NoSuchElementException("There is no key with value [" + letter + "]");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			clickJS(keys.get(index));
		}
	}

	private void clickJS(WebElement element) {
		((JavascriptExecutor) innerDriver).executeScript("arguments[0].click()", element);
	}

	@Step
	public String getSearchInputFieldValue() {
		return inputField.getAttribute("value");
	}

	public static void main(String[] args) {
		System.out.println(LocalDate.of(2017, 1, 1).compareTo(LocalDate.now()));
	}
}

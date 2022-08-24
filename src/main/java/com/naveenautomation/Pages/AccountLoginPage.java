package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage() {
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(id = "input-email")
	private WebElement emailInputField;

	@FindBy(id = "input-password")
	private WebElement passwordInputField;

	@FindBy(css = "input[type='submit']")
	private WebElement loginBtn;

	public void enterEmail(String email) {

		emailInputField.sendKeys(email);
	}

	public void enterPassword(String pass) {

		passwordInputField.sendKeys(pass);
	}

	public MyAccountPage clickLoginBtn() {

		loginBtn.click();
		return new MyAccountPage();
	}

	public MyAccountPage login(String email, String password) {

		enterEmail(email);
		enterPassword(password);
		return clickLoginBtn();
	}
}

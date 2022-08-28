package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.Utils;
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

		Utils.sendKeys(emailInputField, email);
	}

	public void enterPassword(String pass) {

		Utils.sendKeys(passwordInputField, pass);
	}

	public MyAccountPage clickLoginBtn() {

		Utils.click(loginBtn);
		return new MyAccountPage();
	}

	public MyAccountPage login(String email, String password) {

		enterEmail(email);
		enterPassword(password);
		return clickLoginBtn();
	}
}

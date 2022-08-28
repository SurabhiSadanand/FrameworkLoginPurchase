package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.Utils;
import com.naveenautomation.base.TestBase;

public class YourStorePage extends TestBase {

	public YourStorePage() {
		//waitForDocumentCompleteState(10);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "ul.list-inline li:nth-of-type(2) span")
	private WebElement myAccountBtn;

	@FindBy(css = "ul.dropdown-menu.dropdown-menu-right li:nth-of-type(2) a")
	private WebElement loginBtn;

	@FindBy(css = "ul.list-inline li:nth-of-type(2)  ul li:nth-of-type(1) a")
	WebElement regBtn;

	public void clickMyAccountBtn() {

		Utils.javascriptClick(myAccountBtn);
	}

	public AccountLoginPage clickLoginBtn() {

		Utils.click(loginBtn);
		return new AccountLoginPage();
	}

	public RegisterAccountPage clickRegButton() {

		Utils.click(regBtn);
		return new RegisterAccountPage();
	}
}

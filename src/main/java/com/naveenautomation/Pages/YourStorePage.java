package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class YourStorePage extends TestBase {

	public YourStorePage() {
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "ul.list-inline li:nth-of-type(2) span")
	private WebElement myAccountBtn;

	@FindBy(css = "ul.dropdown-menu.dropdown-menu-right li:nth-of-type(2) a")
	private WebElement loginBtn;

	public void clickMyAccountBtn() {

		myAccountBtn.click();
	}

	public AccountLoginPage clickLoginBtn() {

		loginBtn.click();
		return new AccountLoginPage();
	}
}

package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class YourAccountCreatedPage extends TestBase {

	public YourAccountCreatedPage() {
		//waitForDocumentCompleteState(10);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "div#content h1")
	WebElement accountAlertText;

	public String getTextOfAccountCreated() {
		return accountAlertText.getText();
	}
}

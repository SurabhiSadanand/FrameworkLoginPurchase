package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomation.base.TestBase;

public class OrderPlacedPage extends TestBase {

	public OrderPlacedPage() {

		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "div#content h1")
	WebElement orderPlaced;

	public String getTitle() {

		explicitWait("Your order has been placed!", 30);
		return orderPlaced.getText();
	}

	public boolean explicitWait(String name, int sec) {

		WebDriverWait wait = new WebDriverWait(webDriver, sec);

		return wait.until(ExpectedConditions.titleContains(name));
	}
}

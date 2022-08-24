package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MonitorsPage extends TestBase {

	MonitorsPage() {

		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "#content div.row:nth-of-type(3) div.product-layout:nth-of-type(2) div.button-group span")
	WebElement addToCartBtn;

	@FindBy(css = "ul.list-inline>li:nth-of-type(5) span")
	WebElement checkOutBtn;

	public void clickAddToCart() {

		addToCartBtn.click();
	}

	public CheckoutPage clickCheckoutBtn() {

		checkOutBtn.click();
		return new CheckoutPage();
	}

	public CheckoutPage checkoutProcess() {

		clickAddToCart();
		return clickCheckoutBtn();
	}

	public String getTitle() {

		return webDriver.getTitle();
	}
}

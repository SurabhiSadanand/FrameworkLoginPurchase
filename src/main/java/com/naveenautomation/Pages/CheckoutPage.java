package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomation.Utils.Utils;
import com.naveenautomation.base.TestBase;

public class CheckoutPage extends TestBase {

	public CheckoutPage() {

		// waitForDocumentCompleteState(10);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "form.form-horizontal>div:nth-of-type(3) input")
	WebElement newAddressBtn;

	@FindBy(css = "#input-payment-firstname")
	WebElement fnameInputField;

	@FindBy(css = "#input-payment-lastname")
	WebElement lnameInputField;

	@FindBy(css = "#input-payment-company")
	WebElement companyInputField;

	@FindBy(css = "#input-payment-address-1")
	WebElement address1InputField;

	@FindBy(css = "#input-payment-city")
	WebElement cityInputField;

	@FindBy(css = "#input-payment-postcode")
	WebElement postCodeInputField;

	@FindBy(css = "#input-payment-country")
	WebElement countryField;

	@FindBy(css = "#input-payment-zone")
	WebElement zoneField;

	@FindBy(css = "div.buttons input")
	WebElement billingContinueBtn;

	@FindBy(css = "input#button-shipping-address")
	WebElement deliveryDetailsContinueBtn;

	@FindBy(css = "input#button-shipping-method")
	WebElement deliveryMethodContinueBtn;

	@FindBy(css = "div.panel-group>div:nth-of-type(5)>div:nth-of-type(2)>div>div.buttons div.pull-right input:nth-of-type(1)")
	WebElement termsAgreeBtn;

	@FindBy(css = "div.pull-right #button-payment-method")
	WebElement paymentContinueBtn;

	@FindBy(css = "div#collapse-checkout-confirm div.panel-body>div:nth-of-type(2) input")
	WebElement confirmOrderBtn;

	public void newAddressBtnClick() {
		Utils.click(newAddressBtn);
	}

	public void enterFirstName(String fname) {
		Utils.sendKeys(fnameInputField, fname);
	}

	public void enterLastName(String lname) {
		Utils.sendKeys(lnameInputField, lname);
	}

	public void enterCompanyName(String companyName) {
		Utils.sendKeys(companyInputField, companyName);
	}

	public void enterAddress(String address) {
		Utils.sendKeys(address1InputField, address);
	}

	public void enterCity(String city) {
		Utils.sendKeys(cityInputField, city);
	}

	public void enterPostcode(String code) {
		Utils.sendKeys(postCodeInputField, code);
	}

	public void selectCountry() {
		select(countryField).selectByVisibleText("Canada");

	}

	public void selectZone(String zone) {
		Utils.selectWithWait(webDriver, By.cssSelector("#input-payment-zone"), 50, "Ontario",
				webDriver.findElement(By.cssSelector("#input-payment-zone")));
		// Utils.selectFromDropDown(zoneField, zone);

	}

	public void clickBillingContinueBtn() {
		Utils.click(billingContinueBtn);
	}

	public void clickDeliveryDetailsContinueBtn() {
		Utils.waitForElementToBeClickable(deliveryDetailsContinueBtn);
		Utils.click(deliveryDetailsContinueBtn);
	}

	public void clickDeliveryMethodContinueBtn() {
		Utils.click(deliveryMethodContinueBtn);
	}

	public void clicktermsAgreeBtn() {
		Utils.click(termsAgreeBtn);
	}

	public void clickPaymentContinueBtn() {
		Utils.click(paymentContinueBtn);
	}

	public OrderPlacedPage clickconfirmOrderBtn() {

		Utils.click(confirmOrderBtn);
		return new OrderPlacedPage();
	}

	public OrderPlacedPage checkoutCompleteProcess(String fname, String lname, String addr, String city, String pc,
			String country, String zone) {
		Utils.sleep(5000);
		newAddressBtnClick();

		enterFirstName(fname);

		enterLastName(lname);

		enterAddress(addr);

		enterCity(city);

		enterPostcode(pc);

		selectCountry();

		selectZone(zone);

		clickBillingContinueBtn();
		clickDeliveryDetailsContinueBtn();
		clickDeliveryMethodContinueBtn();
		clicktermsAgreeBtn();
		clickPaymentContinueBtn();
		return clickconfirmOrderBtn();

	}

	public String getTitle() {

		return webDriver.getTitle();
	}

	public Select select(WebElement element) {

		Select sc = new Select(element);

		return sc;
	}

}

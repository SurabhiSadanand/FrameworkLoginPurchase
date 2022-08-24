package com.naveenautomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomation.base.TestBase;

public class CheckoutPage extends TestBase {

	public CheckoutPage() {

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
		newAddressBtn.click();
	}

	public void enterFirstName(String fname) {
		fnameInputField.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lnameInputField.sendKeys(lname);
	}

	public void enterCompanyName(String companyName) {
		companyInputField.sendKeys(companyName);
	}

	public void enterAddress(String address) {
		address1InputField.sendKeys(address);
	}

	public void enterCity(String city) {
		cityInputField.sendKeys(city);
	}

	public void enterPostcode(String code) {
		postCodeInputField.sendKeys(code);
	}

	public void selectCountry(String country) {
		select(countryField).selectByVisibleText(country);
	}

	public void selectZone(String zone) {
		select(zoneField).selectByVisibleText(zone);
	}

	public void clickBillingContinueBtn() {
		billingContinueBtn.click();
	}

	public void clickDeliveryDetailsContinueBtn() {
		deliveryDetailsContinueBtn.click();
	}

	public void clickDeliveryMethodContinueBtn() {
		deliveryMethodContinueBtn.click();
	}

	public void clicktermsAgreeBtn() {
		termsAgreeBtn.click();
	}

	public void clickPaymentContinueBtn() {
		paymentContinueBtn.click();
	}

	public OrderPlacedPage clickconfirmOrderBtn() {

		confirmOrderBtn.click();
		return new OrderPlacedPage();
	}

	public OrderPlacedPage checkoutCompleteProcess(String fname, String lname, String addr, String city, String pc,
			String country, String zone) {
		newAddressBtnClick();

		enterFirstName(fname);

		enterLastName(lname);

		enterAddress(addr);

		enterCity(city);

		enterPostcode(pc);

		selectCountry(country);

		selectZone(zone);

		clickBillingContinueBtn();
		clickDeliveryDetailsContinueBtn();
		clickDeliveryMethodContinueBtn();
		clicktermsAgreeBtn();
		clickPaymentContinueBtn();
		return clickconfirmOrderBtn();

	}

	public Select select(WebElement element) {

		Select sc = new Select(element);

		return sc;

	}

	public String getTitle() {

		return webDriver.getTitle();
	}

}

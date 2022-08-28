package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.Utils;
import com.naveenautomation.base.TestBase;

public class RegisterAccountPage extends TestBase {

	public RegisterAccountPage() {
		// waitForDocumentCompleteState(10);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "#input-firstname")
	WebElement firstNameInputField;

	@FindBy(css = "#input-lastname")
	WebElement lastNameInputField;

	@FindBy(css = "#input-email")
	WebElement emailInputField;

	@FindBy(css = "#input-telephone")
	WebElement phoneNumberInputField;

	@FindBy(css = "div#content form fieldset:nth-of-type(2)>div:nth-of-type(1) input")
	WebElement passwordInputField;

	@FindBy(css = "div#content form fieldset:nth-of-type(2)>div:nth-of-type(2) input")
	WebElement confirmPasswordInputField;

	@FindBy(css = "div.buttons input:nth-of-type(1)")
	WebElement agreeBtn;

	@FindBy(css = "div.buttons input:nth-of-type(2)")
	WebElement submitBtn;

	public void enterFirstName(String name) {
		Utils.sendKeys(firstNameInputField, name);
	}

	public void enterLastName(String name) {
		Utils.sendKeys(lastNameInputField, name);
	}

	public void enterEmail(String mail) {
		Utils.sendKeys(emailInputField, mail);
	}

	public void enterTelephone(String phone) {
		Utils.sendKeys(phoneNumberInputField, phone);
	}

	public void enterPassword(String pass) {
		Utils.sendKeys(passwordInputField, pass);
	}

	public void enterConfirmPass(String pass) {
		Utils.sendKeys(confirmPasswordInputField, pass);
	}

	public void clickAgree() {
		Utils.click(agreeBtn);
	}

	public YourAccountCreatedPage clickSubmit() {
		submitBtn.submit();
		return new YourAccountCreatedPage();
	}

	public YourAccountCreatedPage registrationProcess(String name, String lname, String email, String phoneNo,
			String pass, String cpass) {

		enterFirstName(name);
		enterLastName(lname);
		enterEmail(email);
		enterTelephone(phoneNo);
		enterPassword(pass);
		enterConfirmPass(cpass);
		clickAgree();
		clickSubmit();
		return new YourAccountCreatedPage();
	}

}

package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.Utils.Utils;
import com.naveenautomation.base.TestBase;

public class ChangePasswordPage extends TestBase {

	public ChangePasswordPage() {

		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "#input-password")
	WebElement password;

	@FindBy(css = "#input-confirm")
	WebElement passwordConfirm;

	@FindBy(css = "div.buttons.clearfix>div:nth-of-type(2) input")
	WebElement continueBtn;

	public void enterPassword(String pass) {
		Utils.sendKeys(password, pass);
	}

	public void enterConfirmPassword(String pass) {
		Utils.sendKeys(passwordConfirm, pass);
	}

	public MyAccountPage clickContinueBtn() {
		Utils.click(continueBtn);
		return new MyAccountPage();
	}

	public String getTitleOfPassword() {
		return webDriver.getTitle();
	}

	public MyAccountPage confirmPasswordBtn(String pass, String cpass) {
		enterPassword(pass);
		enterConfirmPassword(cpass);
		continueBtn.click();
		return new MyAccountPage();
	}

}

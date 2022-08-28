package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MyAccountPage extends TestBase {
	public MyAccountPage() {
		//waitForDocumentCompleteState(10);
		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "ul.nav.navbar-nav li:nth-of-type(3) a")
	WebElement componentsBtn;

	@FindBy(css = "ul.nav.navbar-nav li:nth-of-type(3) ul li:nth-of-type(2) a")
	WebElement monitorsBtn;

	@FindBy(css = "div#content ul:nth-of-type(1) li:nth-of-type(2) a")
	WebElement changePassword;

	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	WebElement successMessage;

	@FindBy(css = "div#content ul:nth-of-type(2) li:nth-of-type(1) a")
	WebElement orderHistory;

	public void hoverOverComponentsBtn() {
		ac.moveToElement(componentsBtn).perform();
	}

	public MonitorsPage clickMonitorsBtn() {

		monitorsBtn.click();
		return new MonitorsPage();
	}

	public MonitorsPage selectMonitorsCategory() {
		hoverOverComponentsBtn();
		return clickMonitorsBtn();
	}

	public ChangePasswordPage changePasswordBtnClick() {

		changePassword.click();

		return new ChangePasswordPage();
	}

	public OrderHistoryPage orderHistoryClick() {
		orderHistory.click();
		return new OrderHistoryPage();
	}

	public String getTitle() {

		return webDriver.getTitle();
	}

	public String getTextOfSuccessMsg() {
		return successMessage.getText();
	}

}

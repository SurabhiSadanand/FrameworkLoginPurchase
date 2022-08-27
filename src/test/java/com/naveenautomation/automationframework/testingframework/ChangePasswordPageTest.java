package com.naveenautomation.automationframework.testingframework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.ChangePasswordPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.YourStorePage;
import com.naveenautomation.base.TestBase;

public class ChangePasswordPageTest extends TestBase {

	YourStorePage yourStorePage;
	AccountLoginPage accountLoginPage;
	MyAccountPage myAccountPage;

	ChangePasswordPage changePasswordPage;

	@BeforeMethod
	public void startBrowser() {
		initialization();
		yourStorePage = new YourStorePage();

	}

	@Test
	public void changePasswordTest() {

		yourStorePage.clickMyAccountBtn();
		accountLoginPage = yourStorePage.clickLoginBtn();
		myAccountPage = accountLoginPage.login(email(), password());
		changePasswordPage = myAccountPage.changePasswordBtnClick();

		String title = changePasswordPage.confirmPasswordBtn(newPassword(), newPassword()).getTextOfSuccessMsg();
		Assert.assertEquals(title, "Success: Your password has been successfully updated.",
				"Login title is not matching");

	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();

	}
}

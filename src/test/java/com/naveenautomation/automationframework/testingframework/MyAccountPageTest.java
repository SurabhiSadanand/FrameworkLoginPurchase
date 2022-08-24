package com.naveenautomation.automationframework.testingframework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MonitorsPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.YourStorePage;
import com.naveenautomation.base.TestBase;

public class MyAccountPageTest extends TestBase {

	YourStorePage yp;
	AccountLoginPage accountLogin;
	MyAccountPage myAccount;

	@BeforeMethod
	public void startBrowserSession() {

		initialization();
		yp = new YourStorePage();
		yp.clickMyAccountBtn();
		accountLogin = yp.clickLoginBtn();
		myAccount = accountLogin.login("surabhi.sadanand@gmail.com", "test");

	}

	@Test
	public void selectCategoryTest() {

		Assert.assertEquals(myAccount.selectMonitorsCategory().getTitle(), "Monitors", "Page title doesnot match");

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}

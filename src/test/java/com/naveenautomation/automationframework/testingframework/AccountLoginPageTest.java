package com.naveenautomation.automationframework.testingframework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.YourStorePage;
import com.naveenautomation.base.TestBase;

public class AccountLoginPageTest extends TestBase {

	YourStorePage yp;
	AccountLoginPage accountLogin;

	@BeforeMethod
	public void startBrowserSession() {

		initialization();
		yp = new YourStorePage();
		yp.clickMyAccountBtn();
		accountLogin = yp.clickLoginBtn();
	}

	@Test
	public void test() {

		String titleOfPage = accountLogin.login("surabhi.sadanand@gmail.com", "test").getTitle();

		Assert.assertEquals(titleOfPage, "My Account", "Login title doesnot match!!!");
	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}

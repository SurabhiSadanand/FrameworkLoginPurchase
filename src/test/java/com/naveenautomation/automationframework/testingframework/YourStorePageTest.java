package com.naveenautomation.automationframework.testingframework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.YourStorePage;
import com.naveenautomation.base.TestBase;

public class YourStorePageTest extends TestBase {

	YourStorePage ys;
	AccountLoginPage acc;

	@BeforeMethod
	public void startBrowserSession() {

		initialization();
		ys = new YourStorePage();
	}

	@Test(priority = 1)
	public void myAccountBtnClickTest() {
		ys.clickMyAccountBtn();

	}

	@Test(priority = 2)
	public void loginBtnClickTest() {
		myAccountBtnClickTest();
		acc = ys.clickLoginBtn();

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}

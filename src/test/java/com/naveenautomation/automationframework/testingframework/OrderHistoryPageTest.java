package com.naveenautomation.automationframework.testingframework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.OrderHistoryPage;
import com.naveenautomation.Pages.YourStorePage;
import com.naveenautomation.base.TestBase;

public class OrderHistoryPageTest extends TestBase {

	YourStorePage yourStorePage;
	AccountLoginPage accLoginPage;
	MyAccountPage myAccPagePage;
	OrderHistoryPage orderHistoryPage;

	@BeforeMethod
	public void startBrowserSession() {
		initialization();
		yourStorePage = new YourStorePage();

	}

	@Test
	public void verifyTotalAndOrderDate() {

		accLoginPage = new AccountLoginPage();
		yourStorePage.clickMyAccountBtn();
		yourStorePage.clickLoginBtn();
		myAccPagePage = accLoginPage.login(email(), password());
		orderHistoryPage = myAccPagePage.orderHistoryClick();
		String orderTotal = orderHistoryPage.totalFromTable("#1592");
		Assert.assertEquals(orderTotal, "$405.00", "Order total does not match");

		String orderDate = orderHistoryPage.dateFromTable("#1592");
		Assert.assertEquals(orderDate, "28/08/2022", "Date does not match");

	}

	@AfterMethod
	public void CloseBrowserSession() {
		quitBrowser();
	}

}

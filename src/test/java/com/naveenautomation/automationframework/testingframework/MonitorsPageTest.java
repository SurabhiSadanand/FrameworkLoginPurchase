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

public class MonitorsPageTest extends TestBase {

	YourStorePage yp;
	AccountLoginPage accLogin;
	MyAccountPage myAcc;
	MonitorsPage mp;
	
	@BeforeMethod
	public void startBrowserSession() {

		initialization();
		yp = new YourStorePage();
		yp.clickMyAccountBtn();
		accLogin = yp.clickLoginBtn();
		myAcc = accLogin.login("surabhi.sadanand@gmail.com", "test");
		mp=myAcc.selectMonitorsCategory();
	}
	
	@Test
	public void test() {
		Assert.assertEquals(mp.checkoutProcess().getTitle(),"Checkout","Page title doesnot match");
	}
	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}
}

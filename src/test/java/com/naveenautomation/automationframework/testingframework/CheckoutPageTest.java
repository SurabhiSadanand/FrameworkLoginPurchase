package com.naveenautomation.automationframework.testingframework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Pages.AccountLoginPage;
import com.naveenautomation.Pages.CheckoutPage;
import com.naveenautomation.Pages.MonitorsPage;
import com.naveenautomation.Pages.MyAccountPage;
import com.naveenautomation.Pages.OrderPlacedPage;
import com.naveenautomation.Pages.YourStorePage;
import com.naveenautomation.base.TestBase;

public class CheckoutPageTest extends TestBase {

	YourStorePage yp;
	AccountLoginPage accLogin;
	MyAccountPage myAcc;
	MonitorsPage mp;
	CheckoutPage cp;
	OrderPlacedPage op;

	@BeforeMethod
	public void startBrowserSession() {

		initialization();
		yp = new YourStorePage();

	}

	@Test
	public void checkoutTest() {

		yp.clickMyAccountBtn();
		accLogin = yp.clickLoginBtn();
		myAcc = accLogin.login(email(), password());
		mp = myAcc.selectMonitorsCategory();
		mp.clickAddToCart();
		cp = mp.checkoutProcess();
		cp.checkoutCompleteProcess(firstName(), lastName(), address(), place(), postalCode(), country(), zone());

	}

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}

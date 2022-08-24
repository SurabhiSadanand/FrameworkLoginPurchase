package com.naveenautomation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class MyAccountPage extends TestBase {
	public MyAccountPage() {

		PageFactory.initElements(webDriver, this);
	}

	@FindBy(css = "ul.nav.navbar-nav li:nth-of-type(3) a")
	WebElement componentsBtn;

	@FindBy(css = "ul.nav.navbar-nav li:nth-of-type(3) ul li:nth-of-type(2) a")
	WebElement monitorsBtn;

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

	public String getTitle() {

		return webDriver.getTitle();
	}

}

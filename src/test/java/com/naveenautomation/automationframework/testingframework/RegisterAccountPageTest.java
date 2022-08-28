package com.naveenautomation.automationframework.testingframework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenautomation.Pages.RegisterAccountPage;
import com.naveenautomation.Pages.YourStorePage;
import com.naveenautomation.Utils.ExcelUtils;
import com.naveenautomation.base.TestBase;

public class RegisterAccountPageTest extends TestBase {

	YourStorePage yourStorePage;
	RegisterAccountPage registerAccountPage;

	@BeforeMethod
	public void startBrowser() {
		initialization();
		yourStorePage = new YourStorePage();

	}

	@Test(dataProvider = "Register")
	public void loginTest(String fname, String lname, String email, String telephone, String pass, String cpass) {
		yourStorePage.clickMyAccountBtn();
		registerAccountPage = yourStorePage.clickRegButton();
		String text = registerAccountPage.registrationProcess(fname, lname, email, telephone, pass, cpass)
				.getTextOfAccountCreated();

		Assert.assertEquals(text, "Your Account Has Been Created!", "Account not created!!");
	}

	@AfterMethod
	public void quittingBrowser() {
		quitBrowser();
	}

	@DataProvider(name = "Register")
	String[][] dataProviderToLogin() throws Exception {
		String filePath = "C:\\Users\\Surabhi\\Desktop\\RegisterData.xlsx";
		int row = ExcelUtils.getRowsCount(filePath, "Sheet1");
		int col = ExcelUtils.getColumnCount(filePath, "Sheet1", row);

		String[][] registerdata = new String[row][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				registerdata[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}
		}

		return registerdata;

	}
}

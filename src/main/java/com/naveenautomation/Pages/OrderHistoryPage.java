package com.naveenautomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class OrderHistoryPage extends TestBase {

	public OrderHistoryPage() {
		PageFactory.initElements(webDriver, this);
	}

	public String totalFromTable(String orderIDEntered) {
		return getCellFromTable(orderIDEntered, OrderHistory_Table.TOTAL).getText();
	}

	public String dateFromTable(String orderIDEntered) {
		return getCellFromTable(orderIDEntered, OrderHistory_Table.DATEADDED).getText();
	}

	private WebElement getCellFromTable(String orderID, OrderHistory_Table column) {

		int columnIndex = getIndexForColumn(column);
		int orderIdColumnIndex = getIndexForColumn(OrderHistory_Table.ORDERID);

		if (columnIndex < 0) {
			return null;
		}

		List<WebElement> rows = webDriver
				.findElements(By.cssSelector("table[class='table table-bordered table-hover'] tbody tr"));
		for (int i = 1; i < rows.size(); i++) {
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			if (cells.size() < columnIndex || cells.size() < orderIdColumnIndex) {
				continue;
			}
			String[] devicesIds = cells.get(orderIdColumnIndex).getText().split("\n");
			for (int j = 0; j < devicesIds.length; j++) {
				if (devicesIds[j].equals(orderID)) {
					return cells.get(columnIndex);
				}
			}

		}
		System.out.println(String.format("Cant find row with Order Id =%s", orderID));
		return null;
	}

	private int getIndexForColumn(OrderHistory_Table column) {
		List<WebElement> headers = null;
		headers = webDriver.findElements(By.cssSelector("table[class='table table-bordered table-hover'] thead td"));

		for (WebElement header : headers) {
			if (column.getText().equals(header.getText())) {
				return headers.indexOf(header);
			}
		}
		return -1;
	}

	public enum OrderHistory_Table {
		ORDERID("Order ID"), CUSTOMER("Customer"), NOOFPRODUCTS("No. of Products"), STATUS("Status"), TOTAL("Total"),
		DATEADDED("Date Added");

		private String value;

		OrderHistory_Table(String value) {
			this.value = value;
		}

		public String getText() {
			return value;
		}

	}

}
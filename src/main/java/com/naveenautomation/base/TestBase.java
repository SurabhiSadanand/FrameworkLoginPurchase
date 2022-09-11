package com.naveenautomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.Utils.Utils;
import com.naveenautomation.Utils.WebDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver webDriver;
	public Properties prop;
	public static Actions ac;
	public static Logger logger;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEvents events;
	public static JavascriptExecutor jse;

	public TestBase() {

		prop = new Properties();
		FileInputStream file1;

		try {
			file1 = new FileInputStream(
					"./src\\main\\java\\com\\naveenautomation\\Config\\Config.properties");
			try {
				prop.load(file1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void loggerSetup() {

		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);

	}

	public void initialization() {

		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "chrome":
			webDriver = WebDriverManager.chromedriver().create();
			break;
		case "firefox":
			webDriver = WebDriverManager.firefoxdriver().create();
			break;
		case "edge":
			webDriver = WebDriverManager.edgedriver().create();
			break;
		default:
			System.out.println("Verify you passed the correct browser name");
			break;
		}
		jse = (JavascriptExecutor) webDriver;
		ac = new Actions(webDriver);
		e_driver = new EventFiringWebDriver(webDriver);
		events = new WebDriverEvents();

		e_driver.register(events);
		webDriver = e_driver;
		webDriver.manage().window().maximize();
		webDriver.get(prop.getProperty("base_url"));
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().pageLoadTimeout(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(Utils.PAGE_LOAD_WAIT, TimeUnit.SECONDS);

	}

	public String email() {
		return prop.getProperty("email");
	}

	public String password() {
		return prop.getProperty("password");
	}

	public String firstName() {
		return prop.getProperty("firstname");
	}

	public String lastName() {
		return prop.getProperty("lastname");
	}

	public String address() {
		return prop.getProperty("address");
	}

	public String place() {
		return prop.getProperty("place");
	}

	public String postalCode() {
		return prop.getProperty("postalcode");
	}

	public String country() {
		return prop.getProperty("country");
	}

	public String zone() {
		return prop.getProperty("zone");
	}

	public String newPassword() {
		return prop.getProperty("newpassword");
	}

	public void quitBrowser() {

		webDriver.quit();
	}

//	public void waitForDocumentCompleteState(int timeOutInSeconds) {
//		new WebDriverWait(webDriver, timeOutInSeconds).until((ExpectedCondition<Boolean>) v -> {
//			logger.info("Verifying page has loaded......");
//			jse = (JavascriptExecutor) webDriver;
//			String documentIsReady = jse.executeScript("return document.readyState").toString();
//			while (true) {
//				if (documentIsReady.equalsIgnoreCase("complete")) {
//					logger.info("Page has loaded completely......");
//					return true;
//				} else {
//					return false;
//				}
//			}
//		});
//	}

}

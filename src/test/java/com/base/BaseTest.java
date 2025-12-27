package com.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.config.Config;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class BaseTest {

	public static ThreadLocal<WebDriver> localDriver = new ThreadLocal<WebDriver>();

	@BeforeSuite
	@Parameters({ "stage" })
	public void oneTimeSetup(@Optional("local") String stage) {

		stage = System.getProperty("stage") != null ? System.getProperty("stage") : stage;
		Config.setStage(stage);
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void setup(@Optional("chrome") String browser) {

		Config.setBrowserName(browser);

		Driver driver = null;

		switch (browser.toLowerCase()) {
		case BrowserType.CHROME:
			driver = new Chrome();
			break;
		case BrowserType.FIREFOX:
			driver = new Firefox();
			break;
		case BrowserType.EDGE:
			driver = new Edge();
			break;
		default:
			driver = new Chrome();
			break;
		}

		if (Config.getStage().equals("remote")) {

			URL url = null;

			try {
				url = new URL(Config.getGridURL());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			driver.init(url);
		} else {
			driver.init();
		}

		driver.onboarding();

		localDriver.set(driver.get());
	}

	@AfterMethod
	public void tearup() {
		getDriver().quit();
	}

	public WebDriver getDriver() {
		return localDriver.get();
	}

}
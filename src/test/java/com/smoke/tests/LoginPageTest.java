package com.smoke.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LoginPage;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class LoginPageTest extends BaseTest {

	LoginPage loginPage;

	@Test
	public void verifyLandingPageTitle() {

		String EXPECTED_TITLE = "Swag Labs";

		loginPage = new LoginPage(getDriver());
		loginPage.openBrowserAndEnterURL();

		String title = loginPage.getPageTitle();
		Assert.assertTrue(title.equals(EXPECTED_TITLE), "Title not matched");
		loginPage.logger.pass("Title is displayed as expected", true);

		loginPage.enterCredentials("standard_user", "secret_sauce");

	}

}

package com.smoke.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.config.Config;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class HomePageTest extends BaseTest {

	@Test
	public void verifyLandingPageTitle() {

		String EXPECTED_TITLE = "Swag Labs";

		getDriver().get(Config.getTestApplicationURL());

		String title = getDriver().getTitle();

		Assert.assertTrue(title.equals(EXPECTED_TITLE), "Title not matched");
	}
}

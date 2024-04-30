package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.config.Config;
import com.utils.WebActionsUtil;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class LoginPage extends WebActionsUtil {

	private WebDriver driver = null;

	private final By usernameInput = By.name("user-name");
	
	private final By passwordInput = By.name("password");
	
	private final By loginButton = By.name("login-button");

	public LoginPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
	}

	public String getPageTitle() {
		
		return driver.getTitle();
	}

	public void openBrowserAndEnterURL() {
		
		driver.get(Config.getTestApplicationURL());
		logger.info(String.format("Entered URL (%s) in %s browser", Config.getTestApplicationURL(),
				Config.getBrowserName().toUpperCase()));
	}

	public void enterCredentials(String username, String password) {
		
		enter(usernameInput, username, String.format("Entered username = %s", username));
		enter(passwordInput, password, String.format("Entered password = %s", password), true);
		click(loginButton, "Clicked Login button");
	}

}

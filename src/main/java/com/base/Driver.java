package com.base;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.config.Config;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public interface Driver {

	void init();

	void init(URL url);

	WebDriver get();

	default void onboarding() {
		get().manage().window().fullscreen();
		get().manage().window().maximize();
		get().manage().deleteAllCookies();
		get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.getPageLoadWaitTime()));
		get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.getImplicitWaitTime()));
		get().manage().timeouts().scriptTimeout(Duration.ofSeconds(Config.getScriptLoadWaitTime()));
	}

}

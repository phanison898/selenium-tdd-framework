package com.base;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.config.Config;
import com.config.Paths;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class Firefox implements Driver {

	private WebDriver driver = null;

	public void init() {

		driver = new FirefoxDriver(firefoxOptions());
	}

	public void init(URL url) {

		driver = new RemoteWebDriver(url, firefoxOptions());
	}

	public WebDriver get() {

		return driver;
	}

	private FirefoxOptions firefoxOptions() {

		FirefoxOptions options = new FirefoxOptions();

		options.setAcceptInsecureCerts(true);
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", Paths.DEFAULT_DOWNLOAD_DIR);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		options.addPreference("signon.rememberSignons", false);

		if (Config.isHeadless()) {
			options.addArguments("--headless");
		}

		return options;
	}

}

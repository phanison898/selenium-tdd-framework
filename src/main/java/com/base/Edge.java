package com.base;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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

public class Edge implements Driver {

	private WebDriver driver = null;

	public void init() {

		driver = new EdgeDriver(edgeOptions());
	}

	public void init(URL url) {

		driver = new RemoteWebDriver(url, edgeOptions());
	}

	public WebDriver get() {

		return driver;
	}

	private EdgeOptions edgeOptions() {

		EdgeOptions options = new EdgeOptions();

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", Paths.DEFAULT_DOWNLOAD_DIR);
		prefs.put("download.prompt_for_download", false);
		prefs.put("download.directory_upgrade", true);
		prefs.put("safebrowsing.enabled", false);
		prefs.put("excludeSwitches", new String[] { "enable-automation" });
		prefs.put("profile.default_content_settings.popups", 0);

		options.addArguments("--disable-extensions");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--start-maximized");
		options.setExperimentalOption("prefs", prefs);

		if (Config.isHeadless()) {
			options.addArguments("--headless");
			options.addArguments("--disable-gpu");
			options.addArguments("--test-type");
			options.addArguments("--window-size=1920,1080");
		}

		return options;
	}

}

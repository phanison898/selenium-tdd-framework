package com.config;

import com.files.JsonReader;
import com.google.gson.JsonObject;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class Config {

	private static JsonObject jo = null;

	private static String browserName = null;

	public static String getBrowserName() {
		return browserName;
	}

	public static void setBrowserName(String browserName) {
		Config.browserName = browserName;
	}

	public static String getGridURL() {
		return getJsonObject().get("automation-provision").getAsJsonObject().get("grid-url").getAsString();
	}

	public static String getTestApplicationURL() {
		return getJsonObject().get("test-application").getAsJsonObject().get("web-url").getAsString();
	}

	public static boolean isScreenshots() {
		return getBrowserJsonObject().get("screenshots").getAsBoolean();
	}

	public static boolean isHighlight() {
		return getBrowserJsonObject().get("highlight").getAsBoolean();
	}

	public static boolean isHeadless() {
		return getBrowserJsonObject().get("headless").getAsBoolean();
	}

	public static long getPageLoadWaitTime() {
		return getBrowserJsonObject().get("timeouts").getAsJsonObject().get("page-load-wait-time").getAsLong();
	}

	public static long getImplicitWaitTime() {
		return getBrowserJsonObject().get("timeouts").getAsJsonObject().get("implicit-wait-time").getAsLong();
	}

	public static long getExplicitWaitTime() {
		return getBrowserJsonObject().get("timeouts").getAsJsonObject().get("explicit-wait-time").getAsLong();
	}

	public static long getScriptLoadWaitTime() {
		return getBrowserJsonObject().get("timeouts").getAsJsonObject().get("script-load-wait-time").getAsLong();
	}

	public static String getReportName() {
		return getJsonObject().get("report").getAsJsonObject().get("name").getAsString();
	}

	public static String getReportTitle() {
		return getJsonObject().get("report").getAsJsonObject().get("title").getAsString();
	}

	public static String getReportTheme() {
		return getJsonObject().get("report").getAsJsonObject().get("theme").getAsString();
	}

	public static String getAuthorName() {
		return getJsonObject().get("author").getAsJsonObject().get("name").getAsString();
	}

	public static String getAutherGithubUsername() {
		return getJsonObject().get("author").getAsJsonObject().get("github-username").getAsString();
	}

	public static String getAuthorEmail() {
		return getJsonObject().get("author").getAsJsonObject().get("email").getAsString();
	}

	private static JsonObject getJsonObject() {

		if (jo == null) {

			JsonReader jsonReader = new JsonReader(Paths.JSON_CONFIG_FILE);
			jo = jsonReader.read();
		}

		return jo;
	}

	private static JsonObject getBrowserJsonObject() {

		JsonObject jo = null;

		if (jo == null) {

			jo = getJsonObject().get("browser").getAsJsonObject();
		}
		return jo;
	}

}

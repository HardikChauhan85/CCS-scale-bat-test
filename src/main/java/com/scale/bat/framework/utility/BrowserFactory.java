package com.scale.bat.framework.utility;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import cucumber.api.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	Scenario scenario;
	private Logger log = Log.getLogger(BrowserFactory.class);
	private WebDriver driver;
	private ConfigurationReader configReader;
	public static final String URL = "";
	String destination = null;
	DesiredCapabilities caps = null;
	public static final String USERNAME = "amolsharma2";
	public static final String AUTOMATE_KEY = "ibXy5PxxuXNKSPNyvnXz";
	public static final String browserStackURL = "https://" + USERNAME + ":" + AUTOMATE_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	public WebDriver initiateDriver(String browserName, Scenario scenario) throws MalformedURLException {
		configReader = new ConfigurationReader();
		log.info("Opening " + browserName + "browser");
		this.scenario = scenario;

		switch (browserName.toUpperCase()) {
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--ignore-certificate-errors");
			option.addArguments("--ignore-ssl-errors=yes");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			EdgeDriverService service = EdgeDriverService.createDefaultService();
			driver = new EdgeDriver(service);
			driver.manage().window().maximize();
			break;
		case "SAFARI":
			driver = new SafariDriver();
			driver.manage().window().maximize();
			break;
		case "GRID_FIREFOX":
			caps = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
			break;
		case "GRID_CHROME":
			caps = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
			break;
		case "CHROME_HEADLESS":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			// destination = actualPath + "/Library/Application
			// Support/Google/Chrome/"+randomString(8);
			// copyFiles(actualPath + "/Library/Application
			// Support/Google/Chrome/profile1",destination);
			// options.addArguments("user-data-dir=" + destination);
			// options.addArguments("user-data-dir=" + actualPath + "/Library/Application
			// Support/Google/Chrome");
			options.addArguments("--no-sandbox");
			options.addArguments("--headless");
			options.setExperimentalOption("useAutomationExtension", false);
			// options.addArguments("disable-infobars");
			// options.addArguments("--disable-extensions");
			// options.addArguments("--disable-gpu");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("window-size=1920,1080");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			break;

		case "BROWSERSTACK":

			HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
			bsLocalArgs.put("key", AUTOMATE_KEY);
			caps = new DesiredCapabilities();
			caps.setCapability("os_version", "11");
			caps.setCapability("device", "iPhone 8 Plus");
			caps.setCapability("real_mobile", "true");
			caps.setCapability("browserstack.local", "false");
			caps.setCapability("name", scenario.getName());
			caps.acceptInsecureCerts();
			caps.setAcceptInsecureCerts(true);
			driver = new RemoteWebDriver(new URL(browserStackURL), caps);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public void launchURL(String url) {
		driver.get(url);
		log.info(URL + " launched");
	}

	public void launchURL(String portalName, String portalExtension) {
		driver.get(configReader.get(portalName) + portalExtension);
		log.info(URL + " launched");
	}

	public static String randomString(int count) {
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	public static void copyFiles(String source, String destination) {
		File src = new File(source);
		File dest = new File(destination);
		try {
			FileUtils.copyDirectory(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteDirectory() {
		try {
			if (!destination.isEmpty() || !destination.equalsIgnoreCase("")) {
				FileUtils.deleteDirectory(new File(destination));
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public void launchURL() {
		driver.get(configReader.getApplicationURL());
	}
}

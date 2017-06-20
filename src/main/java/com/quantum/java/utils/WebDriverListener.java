package com.quantum.java.utils;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;

import com.qmetry.qaf.automation.ui.webdriver.CommandTracker;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriverCommandListener;

import io.appium.java_client.AppiumDriver;

public class WebDriverListener implements QAFWebDriverCommandListener {

	@Override
	public void beforeCommand(QAFExtendedWebDriver driver, CommandTracker commandHandler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCommand(QAFExtendedWebDriver driver, CommandTracker commandHandler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFailure(QAFExtendedWebDriver driver, CommandTracker commandHandler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeInitialize(Capabilities desiredCapabilities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onInitialize(QAFExtendedWebDriver driver) {
		String appPath = getBundle().getString("driver.capabilities.appPath");
		String appName = getBundle().getString("driver.capabilities.applicationName");
		String driverclass = getBundle().getString("driver.capabilities.driverClass","android");
		String appID;
		if (driverclass.contains("android"))
			appID = getBundle().getString("driver.capabilities.appPackage");
		else
			appID = getBundle().getString("driver.capabilities.bundleId");
		AppiumDriver mobDriver = ((AppiumDriver) driver.getUnderLayingDriver());
		mobDriver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		if (!mobDriver.isAppInstalled(appID)) {
			
			
			System.out.println("app not installed... installing the application");
			
			
			String command = "mobile:application:install";
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("instrument", "instrument");
			params.put("file", appPath);
			mobDriver.executeScript(command, params);
			
			
			
		}

	}

	@Override
	public void onInitializationFailure(Capabilities desiredCapabilities, Throwable t) {
		// TODO Auto-generated method stub

	}

}

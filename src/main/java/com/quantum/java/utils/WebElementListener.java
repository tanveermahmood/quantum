package com.quantum.java.utils;

import org.openqa.selenium.remote.DriverCommand;

import com.qmetry.qaf.automation.ui.webdriver.CommandTracker;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElementCommandAdapter;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElementCommandListener;

public class WebElementListener implements QAFWebElementCommandListener {

	@Override
	public void beforeCommand(QAFExtendedWebElement element, CommandTracker commandTracker) {
		if(commandTracker.getCommand().equalsIgnoreCase(DriverCommand.SEND_KEYS_TO_ELEMENT)){
			element.clear();
		}
		
	}

	@Override
	public void afterCommand(QAFExtendedWebElement element, CommandTracker commandTracker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFailure(QAFExtendedWebElement element, CommandTracker commandTracker) {
		// TODO Auto-generated method stub
		
	}

}

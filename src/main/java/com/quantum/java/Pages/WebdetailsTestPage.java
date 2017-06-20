package com.quantum.java.Pages;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class WebdetailsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "WebDetails.google.img")
	private QAFWebElement webDetailsGoogleImg;
	@FindBy(locator = "WebDetail.googleSearch.txt")
	private QAFWebElement webDetailGoogleSearchTxt;
	@FindBy(locator = "WebDetail.googleSearchGo.btn")
	private QAFWebElement webDetailGoogleSearchGoBtn;
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	 


	public QAFWebElement getWebDetailsGoogleImg() {
		return webDetailsGoogleImg;
	}

	public QAFWebElement getWebDetailGoogleSearchTxt() {
		return webDetailGoogleSearchTxt;
	}

	public QAFWebElement getWebDetailGoogleSearchGoBtn() {
		return webDetailGoogleSearchGoBtn;
	}
 public void verifyGoogleHome()
 {
	 Validator.verifyThat(webDetailsGoogleImg.getText(), Matchers.containsString("Google"));
	 webDetailGoogleSearchTxt.clear();
	 webDetailGoogleSearchTxt.sendKeys("http://infostretch.com");
	 webDetailGoogleSearchGoBtn.click();
	 waitForPageToLoad();
	 
 }
 
 
}

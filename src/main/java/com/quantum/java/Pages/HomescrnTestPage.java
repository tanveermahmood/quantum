
package com.quantum.java.Pages;

import java.util.List;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.java.utils.DriverUtils;

import io.appium.java_client.TouchAction;

public class HomescrnTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "Homescrn.quiz.lst")
	private List<QAFWebElement> HomesrcnquizList;

	@FindBy(locator = "Homesrcn.loader")
	private QAFWebElement HomesrcnLoader;

	@FindBy(locator = "Homescrn.collection.btn")
	private QAFWebElement homescrnCollectionBtn;

	public List<QAFWebElement> getHomesrcnquiz() {

		return HomesrcnquizList;
	}

	public QAFWebElement getHomescrnCollectionBtn() {
		homescrnCollectionBtn.waitForVisible();
		return homescrnCollectionBtn;
	}

	public QAFWebElement getHomesrcnLoader() {
		return HomesrcnLoader;
	}

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public void verifyHomeScren() {
		getHomesrcnLoader().waitForNotVisible(90000);
		QAFTestBase.pause(5000);
		DriverUtils.getAppiumDriver().navigate().back();
		System.out.println(getHomesrcnquiz().isEmpty());

		System.out.println(getHomesrcnquiz().size() + "<-------------------------------------------------------size");

	}

	public void selectQuiz(String quizName) {
		switch (quizName) {
		case "English":
			getHomesrcnquiz().get(0).click();
			System.out.println("0");
			break;

		case "Mathematics":
			getHomesrcnquiz().get(1).click();
			System.out.println("1");
			break;

		case "Reading":
			getHomesrcnquiz().get(2).click();
			System.out.println("2");
			break;

		case "Science":
			getHomesrcnquiz().get(3).click();
			System.out.println("3");
			break;

		}
	}

	public void clickOnCollection() {
		QAFTestBase.pause(100000);
		DriverUtils.getAppiumDriver().navigate().back();
		// QAFTestBase.pause(5000);
		System.out.println("Before swipe");
		/* DriverUtils.getAppiumDriver().swipe(50, 150, 50, 50, 3); */

		org.openqa.selenium.Dimension dim = DriverUtils.getAppiumDriver().manage().window().getSize();
		TouchAction action = new TouchAction(DriverUtils.getAppiumDriver());

		action.press(70, 1000).moveTo(70, 50).release().perform();

		System.out.println("After swipe");
		QAFTestBase.pause(5000);

		getHomescrnCollectionBtn().click();
	}

}

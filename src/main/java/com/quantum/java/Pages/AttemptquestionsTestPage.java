package com.quantum.java.Pages;

import java.util.List;
import java.util.Random;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.MessageTypes;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class AttemptquestionsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "attemptquestionspage.list.questions")
	private List<QAFWebElement> attemptquestionspageListQuestions;
	@FindBy(locator = "attemptquestionspage.list.answers")
	private List<QAFWebElement> attemptquestionspageListAnswers;
	@FindBy(locator = "attemptquestionspage.button.finish")
	private QAFWebElement attemptquestionspageButtonFinish;
	@FindBy(locator = "attemptquestionspage.summary.result")
	private QAFWebElement attemptquestionspageSummaryResult;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public List<QAFWebElement> getAttemptquestionspageListQuestions() {
		return attemptquestionspageListQuestions;
	}

	public List<QAFWebElement> getAttemptquestionspageListAnswers() {
		return attemptquestionspageListAnswers;
	}

	public QAFWebElement getAttemptquestionspageButtonFinish() {
		return attemptquestionspageButtonFinish;
	}

	public QAFWebElement getAttemptquestionspageSummaryResult() {
		return attemptquestionspageSummaryResult;
	}

	public void selectQuestionAndAnswer() {
		for (int i = 0; i < getAttemptquestionspageListQuestions().size(); i++) {
			getAttemptquestionspageListQuestions().get(i).waitForVisible();
			getAttemptquestionspageListQuestions().get(i).click();
			QAFExtendedWebElement catogoryElement = new QAFExtendedWebElement(String.format(
					ConfigurationManager.getBundle().getString("attemptquestionspage.list.answers"), radomAnswer()));
			catogoryElement.waitForVisible();
			catogoryElement.click();
			QAFTestBase.pause(2000);
			
		}
		if (getAttemptquestionspageButtonFinish().isPresent()) {
			getAttemptquestionspageButtonFinish().click();
			
			
		}
	}

	public char radomAnswer() {
		Random r = new Random();
		String alphabet = "ABCDE";
		char result = 0;
		for (int i = 0; i < 5; i++) {
			result = alphabet.charAt(r.nextInt(alphabet.length()));
		}
		return result;
	}

	public void verifyResult() {

		getAttemptquestionspageSummaryResult().waitForVisible();
		int startIndex = getAttemptquestionspageSummaryResult().getText().indexOf(':');
		int endIndex = getAttemptquestionspageSummaryResult().getText().indexOf('/');
		String result = getAttemptquestionspageSummaryResult().getText().subSequence(startIndex + 1, endIndex)
				.toString();
		Reporter.log("Correct Answer Count: " + result, MessageTypes.Pass);

	}

}

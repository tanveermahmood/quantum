package com.quantum.java.Test;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.quantum.java.Pages.AttemptquestionsTestPage;
import com.quantum.java.Pages.HomescrnTestPage;
import com.quantum.java.Pages.TakequizTestPage;
import com.quantum.java.Pages.WebdetailsTestPage;

public class ActTest extends WebDriverTestCase {

	AttemptquestionsTestPage attemptquestionsTestPage = new AttemptquestionsTestPage();
	HomescrnTestPage home;
	TakequizTestPage takequizTestPage;

	WebdetailsTestPage webdetailsTestPage;

	@Test(description = "TC_1", priority = 1)
	public void bookmarkAQuestion() throws InterruptedException {
		home = new HomescrnTestPage();
		takequizTestPage = new TakequizTestPage();
		webdetailsTestPage = new WebdetailsTestPage();
		home.launchPage(null);
		home.verifyHomeScren();
		home.selectQuiz("English");
		takequizTestPage.verifyTitle();
		takequizTestPage.clickOnStartButton();
		takequizTestPage.storeQuesInfo();
		takequizTestPage.bookmaringQues();
		home.clickOnCollection();
		takequizTestPage.VerifyBookmarkedQues();
		takequizTestPage.VerifyBookmark("bookmark.ques");
	}

	@Test(description = "TC_2 ", priority = 2)
	public void takeAQuiz() throws InterruptedException {
		home = new HomescrnTestPage();
		takequizTestPage = new TakequizTestPage();
		home.launchPage(null);
		home.verifyHomeScren();
		home.selectQuiz("Mathematics");
		takequizTestPage.verifyTitle();
		takequizTestPage.clickOnStartButton();
		attemptquestionsTestPage.selectQuestionAndAnswer();
		attemptquestionsTestPage.verifyResult();
	}

	@Test(description = "TC_3", priority = 3)
	public void searchInWeb() throws InterruptedException {
		home = new HomescrnTestPage();
		takequizTestPage = new TakequizTestPage();
		webdetailsTestPage = new WebdetailsTestPage();
		home.launchPage(null);
		home.verifyHomeScren();
		home.selectQuiz("Mathematics");
		takequizTestPage.verifyTitle();
		takequizTestPage.clickOnIcon();
		takequizTestPage.verifyIconContent();
		takequizTestPage.clickOnWeb();
		webdetailsTestPage.verifyGoogleHome();
		takequizTestPage.clickOnWeb();
		webdetailsTestPage.verifyGoogleHome();

	}

}
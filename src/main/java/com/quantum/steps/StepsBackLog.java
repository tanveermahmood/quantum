/**
 * 
 */
package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.quantum.java.Pages.AttemptquestionsTestPage;
import com.quantum.java.Pages.HomescrnTestPage;
import com.quantum.java.Pages.TakequizTestPage;
import com.quantum.java.Pages.WebdetailsTestPage;

/**
 * @author tanveer.mahmood
 *
 */
public class StepsBackLog {
	
	AttemptquestionsTestPage attemptquestionsTestPage = new AttemptquestionsTestPage();
	HomescrnTestPage home = new HomescrnTestPage();
	TakequizTestPage takequizTestPage = new TakequizTestPage();

	WebdetailsTestPage webdetailsTestPage = new WebdetailsTestPage();

	@QAFTestStep(description = "user opens ACT Test application")
	public void OpensACTApplication() {
		home.launchPage(null);
	}

	@QAFTestStep(description = "user Select any quiz and Verify Take a quiz screen")
	public void VerifyTakeAQuizScreen() {
		home.verifyHomeScren();
		home.selectQuiz("English");
		takequizTestPage.verifyTitle();
	}

	@QAFTestStep(description = "user Click Start button")
	public void clickStartButton() {
		takequizTestPage.clickOnStartButton();
	}

	@QAFTestStep(description = "user Get question info")
	public void getQuestionInfo() {
		takequizTestPage.storeQuesInfo();
	}

	@QAFTestStep(description = "user Click on bookmark icon and bookmark question and Go Back")
	public void clickOnBookmarkIcon() {
		takequizTestPage.bookmaringQues();
	}

	@QAFTestStep(description = "user Navigate to Your Collections screen")
	public void navigateToCollections() {
		home.clickOnCollection();
	}


	@QAFTestStep(description = "user Select previously selected quiz type and Click on View button on top right corner and select Bookmarked option")
	public void clickOnViewButtonOn() {
		takequizTestPage.VerifyBookmarkedQues();
	}

	@QAFTestStep(description = "user Verify bookmarked question displayed in list")
	public void verifyBookmarkedQues() {
		takequizTestPage.VerifyBookmark("bookmark.ques");
	}

	@QAFTestStep(description = "user Select number of questions {0} & click on Start.")
	public void ClickOnStart(long l0) {
		home.selectQuiz("Mathematics");
		takequizTestPage.verifyTitle();
		takequizTestPage.clickOnStartButton();
	}

	@QAFTestStep(description = "user  Give all {0} questions answer randomly & also store correct answer count. Click finish button.")
	public void ClickFinishButton(long l0) {
		attemptquestionsTestPage.selectQuestionAndAnswer();
	}

	@QAFTestStep(description = "user Verify correct answer count on summary page.")
	public void VerifyCorrectAnswere() {
		attemptquestionsTestPage.verifyResult();
	}

	@QAFTestStep(description = "user Click icon in middle left side of screen")
	public void Clickicon() {
		takequizTestPage.clickOnIcon();
	}

	
	@QAFTestStep(description = "user Verify side bar opens with Note, Whiteboard and web tabs")
	public void VerifySideBar() {
		takequizTestPage.verifyIconContent();
	}

	
	@QAFTestStep(description = "user Click on Web tab and go to google.com")
	public void ClickOnWebTab() {
		takequizTestPage.clickOnWeb();
	}

	
	@QAFTestStep(description = "user Search for InfoStretch and Verify Infostretch website link is listed in search results")
	public void SearchForInfoStretch() {
		webdetailsTestPage.verifyGoogleHome();
	}


}

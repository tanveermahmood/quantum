package com.quantum.java.Pages;

import java.util.List;
import java.util.Set;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
import com.quantum.java.utils.DriverUtils;

public class TakequizTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "Takequiz.strt.btn")
	private QAFWebElement takequizStrtBtn;
	
	@FindBy(locator = "Takequiz.title.txt")
	private QAFWebElement takequizTitleTxt;

	@FindBy(locator = "Takequiz.icon.btn")
	private QAFWebElement takequicon;

	@FindBy(locator = "Takequiz.quesinfo.txt")
	private QAFWebElement takequizQuesinfoTxt;

	@FindBy(locator = "Verify.note.title")
	private QAFWebElement verifyNoteTitle;
	@FindBy(locator = "Verify.whiteboard.title")
	private QAFWebElement verifyWhiteboardTitle;
	@FindBy(locator = "Verify.web.title")
	private QAFWebElement verifyWebTitle;

	@FindBy(locator = "Takequiz.bookmark.link")
	private QAFWebElement takequizBookmarkLink;

	@FindBy(locator = "Takequiz.back.btn")
	private QAFWebElement takequizBackBtn;

	@FindBy(locator = "Takequiz.bookmark.btn")
	private QAFWebElement takequizBookmarkBtn;

	@FindBy(locator = "Takequiz.Yes.btn")
	private QAFWebElement takequizYesBtn;
	
	@FindBy(locator = "Takequiz.English_act.btn")
	private QAFWebElement takequizEnglish_act;

	@FindBy(locator = "Takequiz.view.btn")
	private QAFWebElement takequizview;

	@FindBy(locator = "Takequiz.bookmarked.btn")
	private QAFWebElement Takequizbookmarked;
	
	@FindBy(locator = "Takequiz.verifyques.txt")
	private List<QAFWebElement> Takequizverifyques;


	public QAFWebElement getTakequicon() {
		takequicon.waitForEnabled();
		return takequicon;
	}

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}
	public QAFWebElement getTakequizEnglish_act() {
		return takequizEnglish_act;
	}

	public QAFWebElement getTakequizview() {
		return takequizview;
	}

	public QAFWebElement getTakequizbookmarked() {
		return Takequizbookmarked;
	}

	public QAFWebElement getTakequizStrtBtn() {
		return takequizStrtBtn;
	}

	public List<QAFWebElement> getTakequizverifyques() {
		return Takequizverifyques;
	}

	
	public QAFWebElement getTakequizQuesinfoTxt() {
		return takequizQuesinfoTxt;
	}

	public QAFWebElement getTakequizTitleTxt() {
		return takequizTitleTxt;
	}

	public QAFWebElement getVerifyNoteTitle() {
		return verifyNoteTitle;
	}

	public QAFWebElement getVerifyWhiteboardTitle() {
		return verifyWhiteboardTitle;
	}

	public QAFWebElement getVerifyWebTitle() {
		return verifyWebTitle;
	}

	public QAFWebElement getTakequizBookmarkLink() {
		return takequizBookmarkLink;
	}

	public QAFWebElement getTakequizBackBtn() {
		return takequizBackBtn;
	}

	public QAFWebElement getTakequizBookmarkBtn() {
		return takequizBookmarkBtn;
	}

	public QAFWebElement getTakequizYesBtn() {
		return takequizYesBtn;
	}

	public void verifyTitle() {
		Validator.verifyThat(takequizTitleTxt.getText(), Matchers.containsString("Take a quiz"));

	}

	public void clickOnStartButton() {
		takequizStrtBtn.waitForVisible();
		takequizStrtBtn.click();
	}

	public void clickOnIcon() {

		takequicon.click();
	}

	/*public void storeQuesInfo() {
		String que_Info = getTakequizQuesinfoTxt().getText();
		System.out.println(que_Info + "....................................................................");

	}*/
	public void storeQuesInfo() {
		getTakequizQuesinfoTxt().waitForVisible();
		   String BookmarkQues = getTakequizQuesinfoTxt().getText();
		   ConfigurationManager.getBundle().addProperty("bookmark.ques", BookmarkQues);
		  System.out.println("Quiz Question Information : " + BookmarkQues);
		 }

	public void verifyIconContent() {
		Validator.verifyThat(verifyNoteTitle.getText(), Matchers.containsString("Note"));
		Validator.verifyThat(verifyWhiteboardTitle.getText(), Matchers.containsString("White Board"));
		Validator.verifyThat(verifyWebTitle.getText(), Matchers.containsString("Web"));
	}

	public void clickOnWeb() {
		verifyWebTitle.click();
		/* DriverUtils.getAppiumDriver().context("WEBVIEW"); */
		Set<String> contextNames = DriverUtils.getAppiumDriver().getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextNames);
		}
		DriverUtils.getAppiumDriver().context((String) contextNames.toArray()[1]);

	}

	public void bookmaringQues() {
		getTakequizBookmarkLink().click();
		getTakequizBookmarkBtn().click();
		getTakequizBackBtn().click();
		getTakequizYesBtn().click();

	}
	
	public void VerifyBookmarkedQues()
	{
		getTakequizEnglish_act().isPresent();
		getTakequizEnglish_act().click();
		getTakequizview().isPresent();
		getTakequizview().click();
		getTakequizbookmarked().isPresent();
		getTakequizbookmarked().click();
		
	
	}
	public void VerifyBookmark(String BookmarkQues) {
		
		 boolean res=false;
		  for (QAFWebElement Bookmarkedques : Takequizverifyques) {
		   res=Bookmarkedques.getText().contentEquals(BookmarkQues);
		   if(res)
		    break;
		  }
		  Validator.verifyThat("Bookmarked question is present in the list ", res, Matchers.equalTo(true));
		 }
}

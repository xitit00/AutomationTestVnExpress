package pageObjects.vnexpress;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.vnexpress.Article_Page_UI;
import pageUIs.vnexpress.Login_Page_UI;

public class ArticlePageObject extends BasePage {
	
	WebDriver driver;
	
	public ArticlePageObject(WebDriver driver) {
		
		this.driver = driver;
	}

	public void clickLoginLink() {
		// TODO Auto-generated method stub
		
		waitForElementClickable(driver, Login_Page_UI.LOGIN_LINK);
		clickToElement(driver, Login_Page_UI.LOGIN_LINK);
		
	}
	
	public boolean isTitleEmailLoginDisplay() {
		
		waitForElementVisible(driver, Login_Page_UI.LOGIN_EMAIL_TITLE);
		return isElementDisplayed(driver, Login_Page_UI.LOGIN_EMAIL_TITLE);
	}

 
	public void inputEmail(String email) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Login_Page_UI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, Login_Page_UI.EMAIL_TEXTBOX, email);
		
	}


	public boolean isEnableLoginButton() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Login_Page_UI.LOGIN_BUTTON);
		return isElementEnabled(driver, Login_Page_UI.LOGIN_BUTTON);
	
	}


	public void clearEmailText() {
		// TODO Auto-generated method stub

		clearValueInElement(driver,  Login_Page_UI.EMAIL_TEXTBOX);
		
	}

	public void clickPasswordTextBox() {
		// TODO Auto-generated method stub
		
		waitForElementClickable(driver, Login_Page_UI.PASSWORD_TEXTBOX);
		clickToElement(driver, Login_Page_UI.PASSWORD_TEXTBOX);
	}


	public void clickTitleEmailLogin() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, Login_Page_UI.LOGIN_EMAIL_TITLE);
		clickToElement(driver, Login_Page_UI.LOGIN_EMAIL_TITLE);
	}



	public void inputPassword(String password) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, Login_Page_UI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, Login_Page_UI.PASSWORD_TEXTBOX, password);
	}



	public boolean isClosePopup() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, Login_Page_UI.LOGIN_POPUP);
		return isElementDisplayed(driver, Login_Page_UI.LOGIN_POPUP);
	}


	public void clickLoginButton() {
		// TODO Auto-generated method stub
		
		waitForElementClickable(driver, Login_Page_UI.LOGIN_BUTTON);
		clickToElement(driver, Login_Page_UI.LOGIN_BUTTON);
	}

	public boolean isIFrameDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Login_Page_UI.IFRAME_POPUP);
		return isElementDisplayed(driver, Login_Page_UI.IFRAME_POPUP);
	}

	public void switchToIFrame() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Login_Page_UI.IFRAME_POPUP);
		switchToFrameIframe(driver, Login_Page_UI.IFRAME_POPUP);
	}

	public boolean isLoginLinkDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Login_Page_UI.LOGIN_LINK);
		return isElementDisplayed(driver, Login_Page_UI.LOGIN_LINK);
		
	}

	public void switchToDefault() {
		// TODO Auto-generated method stub
		
		switchToDefaultContent(driver);
	}

	public boolean isUserAvartarDisplay(String email) {
		// TODO Auto-generated method stub

		waitForElementVisible(driver, Login_Page_UI.USER_AVATAR, email);
		return isElementDisplayed(driver, Login_Page_UI.USER_AVATAR, email);
	}

	public String getActualEmailTextErr() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Login_Page_UI.EMAIL_ERR_TEXT);
		
		return getWebElement(driver, Login_Page_UI.EMAIL_ERR_TEXT).getText();
	}

	public String getActualPasswordTextErr() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, Login_Page_UI.PASSWORD_ERR_TEXT);
		
		return getWebElement(driver, Login_Page_UI.PASSWORD_ERR_TEXT).getText();
		
	}

	public String getActualEmailTitle() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Login_Page_UI.LOGIN_EMAIL_TITLE);
		
		return getWebElement(driver, Login_Page_UI.LOGIN_EMAIL_TITLE).getText();
	}

	public ZingPageObject navigateToZing(String urlString) {
		// TODO Auto-generated method stub
		
		ZingPageObject z = PageGeneratorManager.getZingPage(driver);
		navigateToPage(driver, urlString);
		return z;
	}

	public void refreshCurrentPage() {
		// TODO Auto-generated method stub
		
		refreshCurrentPage(driver);
	}

	public ZingPageObject forwardToZing() {
		// TODO Auto-generated method stub
		
		ZingPageObject z = PageGeneratorManager.getZingPage(driver);
		forwardToPage(driver);
		return z;
	}

	public boolean isTitleArticleDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_TITLE);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_TITLE);
	}

	public MailPageObject clickMailLinkAndSwitchToMailTab() {
		// TODO Auto-generated method stub
		
		MailPageObject m = PageGeneratorManager.getMailPage(driver);
		waitForElementClickable(driver, Article_Page_UI.EMAIL_LINK);
		clickToElement(driver, Article_Page_UI.EMAIL_LINK);
		switchToMailTab();
		return m;
	}

	public void switchToMailTab() {
		// TODO Auto-generated method stub
		
		String windowID = getPageID(driver);
		switchToWindowByID(driver,windowID);
	}

	public void closeMailTab() {
		// TODO Auto-generated method stub
		
		String windowID = getPageID(driver);
		closeAllTabWithoutParent(driver, windowID);
		
	}

	public FacebookPageObject clickFacebookLinkAndSwitchtoFacebookWindow() {
		// TODO Auto-generated method stub
		
		FacebookPageObject fb = PageGeneratorManager.getFacebookPage(driver);
		waitForElementClickable(driver, Article_Page_UI.FB_LINK);
		clickToElement(driver, Article_Page_UI.FB_LINK);
		switchToFacebokWindow();
		return fb;
	}

	public void switchToFacebokWindow() {
		// TODO Auto-generated method stub
		
		String windowID = getPageID(driver);
		switchToWindowByID(driver,windowID);
	}


	public void closeFacebookWindow() {
		// TODO Auto-generated method stub
		
		String windowID = getPageID(driver);
		closeAllTabWithoutParent(driver, windowID);
	}
	
	// CHECK CONTENT ARTICLE

	public boolean isVnExpressLogoDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.VNEXPRESS_LOGO);
		return isElementDisplayed(driver, Article_Page_UI.VNEXPRESS_LOGO);
	}

	public boolean isCurrentDateTimeDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.CURRENT_DATE_TIME);
		return isElementDisplayed(driver, Article_Page_UI.CURRENT_DATE_TIME);
	}

	public boolean isVnExpressInternationalDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.INTERNATIONAL_VNEXPRESS);
		return isElementDisplayed(driver, Article_Page_UI.INTERNATIONAL_VNEXPRESS);
	}

	public boolean isNewsAreaDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NEWS_AREA);
		return isElementDisplayed(driver, Article_Page_UI.NEWS_AREA);
	}

	public boolean isSearchInputDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.SEARCH_INPUT);
		return isElementDisplayed(driver, Article_Page_UI.SEARCH_INPUT);
	}

	public boolean isSearchButtonDisplay() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, Article_Page_UI.SEARCH_BUTTON);
		return isElementDisplayed(driver, Article_Page_UI.SEARCH_BUTTON);
	}

	public boolean isUserImageDisplay() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, Article_Page_UI.LOGIN_HEADER);
		return isElementDisplayed(driver, Article_Page_UI.LOGIN_HEADER);
	}

	public boolean isUserNotificationDisplay() {
		
		// TODO Auto-generated method stub
		waitForElementVisible(driver, Article_Page_UI.NOTIFICATION_HEADER);
		return isElementDisplayed(driver, Article_Page_UI.NOTIFICATION_HEADER);
	}

	public boolean isHomeNavBarDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.HOME_ICON);
		return isElementDisplayed(driver, Article_Page_UI.HOME_ICON);
	}

	public boolean isThoiSuNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
	
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isGocNhinNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isTheGioiNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isVideoNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isPodCastsNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isKinhDoanhNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isKhoaHocNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isGiaiTriNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isTheThaoNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isPhapLuatNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isGiaoDucNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isSucKhoeNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isDoiSongNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isDuLichNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isSoHoaNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isXeNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isYKienNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isTamSuNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}

	public boolean isThuGianNavBarDisplay(String nav_dymamic_class, String nav_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dymamic_class, nav_dymamic_text);
	}


	public boolean isMenuDanSinhDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.MENU_DAN_SINH);
		return isElementDisplayed(driver, Article_Page_UI.MENU_DAN_SINH);
	}

	public boolean isMenuThoiSuDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.MENU_THOI_SU);
		return isElementDisplayed(driver, Article_Page_UI.MENU_THOI_SU);
	}

	public boolean isArticleDateTimeDisplay() {
		// TODO Auto-generated method stub
	
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_DATE_TIME);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_DATE_TIME);
	}

	public boolean isLocationDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.LOCATION_TEXT);
		return isElementDisplayed(driver, Article_Page_UI.LOCATION_TEXT);
	}

	public boolean isDescriptionDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.DESCRIPTION_TEXT);
		return isElementDisplayed(driver, Article_Page_UI.DESCRIPTION_TEXT);
	}

	public boolean isAuthorNameDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.AUTHOR_NAME);
		return isElementDisplayed(driver, Article_Page_UI.AUTHOR_NAME);
	}

	public boolean isVideoDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_VIDEO);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_VIDEO);
	}

	public boolean isSocialLeftBackDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.SOCIAL_LEFT_BACK_ICON);
		return isElementDisplayed(driver, Article_Page_UI.SOCIAL_LEFT_BACK_ICON);
	}

	public boolean isFooterContentSaveDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.FOOTER_CONTENT_SAVE_ICON);
		return isElementDisplayed(driver, Article_Page_UI.FOOTER_CONTENT_SAVE_ICON);
		
	}
	
	// SECTION_DETAL_PAGE

	public boolean isParagraph1Display(String paragraph_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
		
	}

	public boolean isParagraph2Display(String paragraph_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
	}

	public boolean isParagraph3Display(String paragraph_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
	}

	public boolean isParagraph4Display(String paragraph_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
	}

	public boolean isParagraph5Display(String paragraph_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
	}

	public boolean isParagraph6Display(String paragraph_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
	}

	public boolean isParagraph7Display(String paragraph_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
	}

	public boolean isParagraph8Display(String paragraph_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
	}

	public boolean isParagraph9Display(String paragraph_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
	}

	public boolean isParagraph10Display(String paragraph_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_CONTENT, paragraph_dymamic_text);
	}

	public boolean isImage1Display(String image_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.ARTICLE_IMAGE, image_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.ARTICLE_IMAGE, image_dymamic_text);
	}

	public boolean isCaptionImage1Display(String caption_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.CAPTION_IMAGE_VIDEO, caption_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.CAPTION_IMAGE_VIDEO, caption_dymamic_text);
	}

	public boolean isImage2Display(String image_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.CAPTION_IMAGE_VIDEO, image_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.CAPTION_IMAGE_VIDEO, image_dymamic_text);
	}

	public boolean isCaptionImage2Display(String caption_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.CAPTION_IMAGE_VIDEO, caption_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.CAPTION_IMAGE_VIDEO, caption_dymamic_text);
	}

	public boolean isCaptionVideoDisplay(String caption_dymamic_text) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.CAPTION_IMAGE_VIDEO, caption_dymamic_text);
		return isElementDisplayed(driver, Article_Page_UI.CAPTION_IMAGE_VIDEO, caption_dymamic_text);
	}

	public boolean isFooterContentTwitterDisplay(String footer_content_dymamic_class) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.FOOTER_CONTENT_ICON, footer_content_dymamic_class);
		return isElementDisplayed(driver, Article_Page_UI.FOOTER_CONTENT_ICON, footer_content_dymamic_class);
	}

	public boolean isFooterContentMailDisplay(String footer_content_dymamic_class) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, Article_Page_UI.FOOTER_CONTENT_ICON, footer_content_dymamic_class);
		return isElementDisplayed(driver, Article_Page_UI.FOOTER_CONTENT_ICON, footer_content_dymamic_class);
	}

	public boolean isFooterContentFacebookDisplay(String footer_content_dymamic_class) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, Article_Page_UI.FOOTER_CONTENT_ICON, footer_content_dymamic_class);
		return isElementDisplayed(driver, Article_Page_UI.FOOTER_CONTENT_ICON, footer_content_dymamic_class);
	}

	public boolean isFooterContentCopyAndPasteDisplay(String footer_content_dymamic_class) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.FOOTER_CONTENT_ICON, footer_content_dymamic_class);
		return isElementDisplayed(driver, Article_Page_UI.FOOTER_CONTENT_ICON, footer_content_dymamic_class);
	}

	public boolean isSocialLeftFacebookDisplay(String social_left_dymamic_title) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.SOCIAL_LEFT_ICON, social_left_dymamic_title);
		return isElementDisplayed(driver, Article_Page_UI.SOCIAL_LEFT_ICON, social_left_dymamic_title);
	}

	public boolean isSocialLeftTwitterDisplay(String social_left_dymamic_title) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.SOCIAL_LEFT_ICON, social_left_dymamic_title);
		return isElementDisplayed(driver, Article_Page_UI.SOCIAL_LEFT_ICON, social_left_dymamic_title);
	}

	public boolean isSocialLeftLinkedInDisplay(String social_left_dymamic_title) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.SOCIAL_LEFT_ICON, social_left_dymamic_title);
		return isElementDisplayed(driver, Article_Page_UI.SOCIAL_LEFT_ICON, social_left_dymamic_title);
	}

	public boolean isSocialLeftSaveDisplay(String social_left_dymamic_title) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.SOCIAL_LEFT_ICON, social_left_dymamic_title);
		return isElementDisplayed(driver, Article_Page_UI.SOCIAL_LEFT_ICON, social_left_dymamic_title);
	}

	public boolean isSocialLeftCommentDisplay(String social_left_dymamic_title) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.SOCIAL_LEFT_ICON, social_left_dymamic_title);
		return isElementDisplayed(driver, Article_Page_UI.SOCIAL_LEFT_ICON, social_left_dymamic_title);
	}

	public TheGioiPageObject clickMenuTheGioi(String nav_dynamic_class, String nav_dynamic_test) {
		// TODO Auto-generated method stub
		
		TheGioiPageObject tg = PageGeneratorManager.getTheGioiPage(driver);
		
		waitForElementClickable(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dynamic_class, nav_dynamic_test);
		clickToElement(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dynamic_class, nav_dynamic_test);
		
		return tg;
	}

	public void hoverMenuTheGioi(String nav_dynamic_class, String nav_dynamic_test) {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dynamic_class, nav_dynamic_test);
		hoverMouseToElement(driver, Article_Page_UI.NAVIGATE_BAR_ICON, nav_dynamic_class, nav_dynamic_test);
		
	}

	public PhanTichPageObject clickSubMenuLink() {
		// TODO Auto-generated method stub
		
		PhanTichPageObject pt = PageGeneratorManager.getPhanTichPage(driver);
		waitForElementClickable(driver, Article_Page_UI.SUB_MENU_LINK);
		clickToElement(driver, Article_Page_UI.SUB_MENU_LINK);
		
		return pt;
	}

	

}

package pageObjects.vnexpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static ArticlePageObject getArticlePage(WebDriver driver) {
		
		return new ArticlePageObject(driver);
	}
	
	public static TheGioiPageObject getTheGioiPage(WebDriver driver) {
		
		return new TheGioiPageObject(driver);
	}
	
	public static PhanTichPageObject getPhanTichPage(WebDriver driver) {
		
		return new PhanTichPageObject(driver);
	}
	
	public static ZingPageObject getZingPage(WebDriver driver) {
		
		return new ZingPageObject(driver);
	}

	public static MailPageObject getMailPage(WebDriver driver) {
	
		return new MailPageObject(driver);
	}
	
	public static FacebookPageObject getFacebookPage(WebDriver driver) {
		
		return new FacebookPageObject(driver);
	}

}

package pageObjects.vnexpress;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.vnexpress.Zing_Page_UI;

public class ZingPageObject extends BasePage {

	public WebDriver driver;
	
	public ZingPageObject(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public boolean isZingPageDisplay() {
		// TODO Auto-generated method stub
		
		waitForElementVisible(driver, Zing_Page_UI.ZING_TITLE);
		return isElementDisplayed(driver, Zing_Page_UI.ZING_TITLE);
	}
	
	public ArticlePageObject backToVnExpress() {
		// TODO Auto-generated method stub
		
		ArticlePageObject art = PageGeneratorManager.getArticlePage(driver);
		backToPage(driver);
		return art;
	}
	
	public ArticlePageObject openVnExpress(String url) {
		// TODO Auto-generated method stub
		
		ArticlePageObject art = PageGeneratorManager.getArticlePage(driver);
		openPageUrl(driver, url);
		return art;
	}


}

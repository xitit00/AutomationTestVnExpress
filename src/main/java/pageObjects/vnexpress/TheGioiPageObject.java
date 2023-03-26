package pageObjects.vnexpress;

import org.openqa.selenium.WebDriver;
import pageUIs.vnexpress.Thegioi_Page_UI;

import common.BasePage;

public class TheGioiPageObject extends BasePage {

	public WebDriver driver;
	
	public TheGioiPageObject(WebDriver driver) {
		
		this.driver = driver;
		
	}

	public boolean isTitleTheGioiPageDisplay() {
	
		waitForElementVisible(driver, Thegioi_Page_UI.THE_GIOI_TITLE);
		return isElementDisplayed(driver, Thegioi_Page_UI.THE_GIOI_TITLE);
	}

	public ArticlePageObject backToVnExpressPage() {
		// TODO Auto-generated method stub
		
		ArticlePageObject art = PageGeneratorManager.getArticlePage(driver);
		backToPage(driver);
		return art;
	}
	
}

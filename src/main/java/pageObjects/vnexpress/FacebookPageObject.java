package pageObjects.vnexpress;

import org.openqa.selenium.WebDriver;
import pageUIs.vnexpress.Thegioi_Page_UI;

import common.BasePage;

public class FacebookPageObject extends BasePage {

	public WebDriver driver;
	
	public FacebookPageObject(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public boolean isFacebookPageDisplay() {
		// TODO Auto-generated method stub
		String pageTitle = getPageTitle(driver);
		
		if (pageTitle.contains("Facebook")) {
			
			return true;
		}
		else {
			
			return false;
		}
	}
	
	public ArticlePageObject switchToVnExpressTab() {
		// TODO Auto-generated method stub
		
		ArticlePageObject art = PageGeneratorManager.getArticlePage(driver);
		String windowID = getPageID(driver);
		switchToWindowByID(driver,windowID);
		return art;
	}

}

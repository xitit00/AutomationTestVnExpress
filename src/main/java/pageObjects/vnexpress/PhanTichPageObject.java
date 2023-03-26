package pageObjects.vnexpress;

import org.openqa.selenium.WebDriver;
import pageUIs.vnexpress.Thegioi_Page_UI;

import common.BasePage;

public class PhanTichPageObject extends BasePage {

	public WebDriver driver;
	
	public PhanTichPageObject(WebDriver driver) {
		
		this.driver = driver;
		
	}

	public String getTitlePage() {
		// TODO Auto-generated method stub
		
		return getPageTitle(driver);


	}

	public ArticlePageObject backToVnExpressPage() {
		// TODO Auto-generated method stub
		
		ArticlePageObject art = PageGeneratorManager.getArticlePage(driver);
		backToPage(driver);
		return art;
	}


	
}

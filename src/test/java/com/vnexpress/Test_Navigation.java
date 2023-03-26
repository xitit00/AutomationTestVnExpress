package com.vnexpress;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common.BaseTest;
import pageObjects.vnexpress.ArticlePageObject;
import pageObjects.vnexpress.FacebookPageObject;
import pageObjects.vnexpress.MailPageObject;
import pageObjects.vnexpress.PageGeneratorManager;
import pageObjects.vnexpress.PhanTichPageObject;
import pageObjects.vnexpress.TheGioiPageObject;
import pageObjects.vnexpress.ZingPageObject;
import reportConfig.ExtentTestManagerV5;


public class Test_Navigation extends BaseTest {
	
	private WebDriver driver;
	private ArticlePageObject articlePageObject;
	private TheGioiPageObject theGioiPageObject;
	private PhanTichPageObject phanTichPageObject;
	private ZingPageObject zingPageObject;
	private MailPageObject mailPageObject;
	private FacebookPageObject facebookPageObject;
	
	
	private String nav_dynamic_class;
	private String nav_dynamic_test;
	private String url;
	

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {

		driver = getBrowserDriver(browserName, appurl);
		articlePageObject = PageGeneratorManager.getArticlePage(driver);
		url = appurl;
		
	}
	
	@Test
	public void TC_01_NavigateToZing(Method method) {
	
		ExtentTestManagerV5.startTest(method.getName(), "TC_01_NavigateToZing");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_NavigateToZing - Step 01: navigateToZingPage");
		zingPageObject = articlePageObject.navigateToZing("https://zingnews.vn/");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_NavigateToZing - Step 02: verifyZingPageDisplay");
		Assert.assertTrue(zingPageObject.isZingPageDisplay());
	}
	
	@Test
	public void TC_02_BackToVnExpress(Method method) {
		
		sleepInSecond(2);
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_02_BackToVnExpress");
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_BackToVnExpress - Step 01: backToVnExpressPage");
		articlePageObject =  zingPageObject.backToVnExpress();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_BackToVnExpress - Step 02: verifyArticleTitleVnExpressDisplay");
		Assert.assertTrue(articlePageObject.isTitleArticleDisplay());
	}
	
	@Test
	public void TC_03_RefreshVnExpressUrl(Method method) {
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_03_RefreshVnExpressUrl");
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_RefreshVnExpressUrl - Step 01: refreshVnExpressPage");
		articlePageObject.refreshCurrentPage();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_RefreshVnExpressUrl - Step 02: verifyArticleTitleVnExpressDisplay");
		Assert.assertTrue(articlePageObject.isTitleArticleDisplay());
	}
	
	@Test
	public void TC_04_ForwardToZing(Method method) {
	
		ExtentTestManagerV5.startTest(method.getName(), "TC_04_ForwardToZing");
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_ForwardToZing - Step 01: forwardToZingPage");
		zingPageObject = articlePageObject.forwardToZing();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_ForwardToZing - Step 02: verifyZingPageDisplay");
		Assert.assertTrue(zingPageObject.isZingPageDisplay());
	}
	
	@Test
	public void TC_05_NavigateToTheGioiPageByClickMenu(Method method) {
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_05_NavigateToTheGioiPageByClickMenu");
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_NavigateToTheGioiPageByClickMenu - Step 01: openVnExPressPage");
		articlePageObject = zingPageObject.openVnExpress(url);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_NavigateToTheGioiPageByClickMenu - Step 02: verifyArticleTitleVnExpressDisplay");
		Assert.assertTrue(articlePageObject.isTitleArticleDisplay());
		
		nav_dynamic_class = "thegioi";
		nav_dynamic_test = "Thế giới";
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_NavigateToTheGioiPageByClickMenu - Step 03: clickMenuTheGioi");
		theGioiPageObject = articlePageObject.clickMenuTheGioi(nav_dynamic_class,nav_dynamic_test);
		
		sleepInSecond(2);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_NavigateToTheGioiPageByClickMenu - Step 04: verifyTitleTheGioiDisplay");
		Assert.assertTrue(theGioiPageObject.isTitleTheGioiPageDisplay());
		
	}
	
	@Test
	public void TC_06_NavigateToPhanTichPageByHoverMenuAndClickSubMenu(Method method) {
		
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_06_NavigateToPhanTichPageByHoverMenuAndClickSubMenu");
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_NavigateToPhanTichPageByHoverMenuAndClickSubMenu - Step 01: backToVnExpressPage");
		articlePageObject = theGioiPageObject.backToVnExpressPage();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_NavigateToPhanTichPageByHoverMenuAndClickSubMenu - Step 02: verifyArticleTitleVnExpressDisplay");
		Assert.assertTrue(articlePageObject.isTitleArticleDisplay());
		
		nav_dynamic_class = "thegioi";
		nav_dynamic_test = "Thế giới";
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_NavigateToPhanTichPageByHoverMenuAndClickSubMenu - Step 03: verifyTheGioiNavBarDisplay");
		articlePageObject.isTheGioiNavBarDisplay(nav_dynamic_class, nav_dynamic_test);
	
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_NavigateToPhanTichPageByHoverMenuAndClickSubMenu - Step 04: hoverMenuTheGioi");
		articlePageObject.hoverMenuTheGioi(nav_dynamic_class,nav_dynamic_test);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_NavigateToPhanTichPageByHoverMenuAndClickSubMenu - Step 05: clickSubMenuPhanTich");
		phanTichPageObject = articlePageObject.clickSubMenuLink();
		
		sleepInSecond(2);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_NavigateToPhanTichPageByHoverMenuAndClickSubMenu - Step 06: verifyPhanTichTitleDisplay");
		Assert.assertEquals(phanTichPageObject.getTitlePage(),"Phân tích kinh tế & bình luận chính trị thế giới - VnExpress");
		
	}
	
	
	@Test
	public void TC_07_SwitchFromVnExpressToMailTab(Method method) {
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_07_SwitchFromVnExpressToMailTab");
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_07_SwitchFromVnExpressToMailTab - Step 01: backToVnExpressPage");
		articlePageObject = phanTichPageObject.backToVnExpressPage();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_07_SwitchFromVnExpressToMailTab - Step 02: verifyArticleTitleVnExpressDisplay");
		Assert.assertTrue(articlePageObject.isTitleArticleDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_07_SwitchFromVnExpressToMailTab - Step 03: clickMailLinkAndSwitchToMailTab");
		mailPageObject = articlePageObject.clickMailLinkAndSwitchToMailTab();
		
		sleepInSecond(2);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_07_SwitchFromVnExpressToMailTab - Step 04: verifyMailPageDisplay");
		Assert.assertTrue(mailPageObject.isMailPageDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_07_SwitchFromVnExpressToMailTab - Step 05: switchToVnExPressPage");
		articlePageObject = mailPageObject.switchToVnExpressTab();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_07_SwitchFromVnExpressToMailTab - Step 06: verifyArticleTitleVnExpressDisplay");
		Assert.assertTrue(articlePageObject.isTitleArticleDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_07_SwitchFromVnExpressToMailTab - Step 07: closeMailTab");
		articlePageObject.closeMailTab();
	}
	
	@Test
	public void TC_08_SwitchFromVnExpressToFacebookWindow(Method method) {


		ExtentTestManagerV5.startTest(method.getName(), "TC_08_SwitchFromVnExpressToFacebookWindow");
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_08_SwitchFromVnExpressToFacebookWindow - Step 01: clickFacebookLinkAndSwitchtoFacebookWindow");
		facebookPageObject = articlePageObject.clickFacebookLinkAndSwitchtoFacebookWindow();

		sleepInSecond(2);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_08_SwitchFromVnExpressToFacebookWindow - Step 02: verifyFacebookPageDisplay");
		Assert.assertTrue(facebookPageObject.isFacebookPageDisplay());

		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_08_SwitchFromVnExpressToFacebookWindow - Step 03: switchToVnExPressTab");
		articlePageObject = facebookPageObject.switchToVnExpressTab();

		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_08_SwitchFromVnExpressToFacebookWindow - Step 04: verifyArticleTitleVnExpressDisplay");
		Assert.assertTrue(articlePageObject.isTitleArticleDisplay());

		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_08_SwitchFromVnExpressToFacebookWindow - Step 05: closeFacebookWindow");
		articlePageObject.closeFacebookWindow();
	}
	
	public void sleepInSecond(long timeoutInSec){
		
		try {
			
			Thread.sleep(timeoutInSec * 1000);
			
		}catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}
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
import pageObjects.vnexpress.PageGeneratorManager;
import reportConfig.ExtentTestManagerV5;


public class Test_Authentication extends BaseTest {
	
	private WebDriver driver;
	private ArticlePageObject articlePageObject;
	
	private String email;
	private String password;
	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appurl) {

		driver = getBrowserDriver(browserName, appurl);
		articlePageObject = PageGeneratorManager.getArticlePage(driver);
		
	}
	
	@Test
	public void TC_01_VerifyEmailInvalid(Method method) {
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_01_VerifyEmailInvalid");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "VerifyEmailInvalid - Step 01: verifyLoginLinkDisplay");
		Assert.assertTrue(articlePageObject.isLoginLinkDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "VerifyEmailInvalid - Step 02: clickLoginLink");
		articlePageObject.clickLoginLink();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "VerifyEmailInvalid - Step 03: verifyIFrameDisplay");
		Assert.assertTrue(articlePageObject.isIFrameDisplay());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "VerifyEmailInvalid - Step 04: switchToIFrame");
		articlePageObject.switchToIFrame();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "VerifyEmailInvalid - Step 05: verifyEmailTitleDisplay");
		Assert.assertEquals(articlePageObject.getActualEmailTitle(), "Đăng nhập với email");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "VerifyEmailInvalid - Step 06: inputEmail");
		email = "abc";
		articlePageObject.inputEmail(email);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "VerifyEmailInvalid - Step 07: verifyEmailTextErrorDisplay");
		Assert.assertEquals(articlePageObject.getActualEmailTextErr(), "Email không hợp lệ");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "VerifyEmailInvalid - Step 08: verifyLoginButtonDisable");
		Assert.assertFalse(articlePageObject.isEnableLoginButton());

		
	}
	
	@Test
	public void TC_02_VerifyDisplayPleaseInputPasswordErrText(Method method) {
		
		
		sleepInSecond(3);
		email = "auto@gmail.com";
		ExtentTestManagerV5.startTest(method.getName(), "TC_03_VerifyDisplayPleaseInputPasswordErrText");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_VerifyDisplayPleaseInputPasswordErrText - Step 01: inputEmail");
		articlePageObject.inputEmail(email);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_VerifyDisplayPleaseInputPasswordErrText - Step 02: clickPasswordTextBox");
		articlePageObject.clickPasswordTextBox();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_VerifyDisplayPleaseInputPasswordErrText - Step 03: clickTitleEmailLogin");
		articlePageObject.clickTitleEmailLogin();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_VerifyDisplayPleaseInputPasswordErrText - Step 04: verifyPasswordTextError");
		Assert.assertEquals(articlePageObject.getActualPasswordTextErr(), "Hãy nhập mật khẩu");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_VerifyDisplayPleaseInputPasswordErrText - Step 05: verifyLoginButtonDisable");
		Assert.assertFalse(articlePageObject.isEnableLoginButton());
		
	}
	
	@Test
	public void TC_03_VerifyPasswordLessThanSixChars(Method method) {
		
		sleepInSecond(3);
		password = "123";
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_04_VerifyPasswordLessThanSixChars");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_VerifyPasswordLessThanSixChars - Step 01: inputPassword");
		articlePageObject.inputPassword(password);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_VerifyPasswordLessThanSixChars - Step 02: verifyPasswordTextError");
		Assert.assertEquals(articlePageObject.getActualPasswordTextErr(), "Mật khẩu ít nhất 6 ký tự và nhỏ hơn 15 ký tự");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_VerifyPasswordLessThanSixChars - Step 03: verifyLoginButtonDisable");
		Assert.assertFalse(articlePageObject.isEnableLoginButton());
	}
	
	
	@Test
	public void TC_04_VerifyPasswordMuchMoreThanFifteenChars(Method method) {
		
		sleepInSecond(3);
		password = "automationtest123@";
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_05_VerifyPasswordMuchMoreThanFifteenChars");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_VerifyPasswordMuchMoreThanFifteenChars - Step 01: inputPassword");
		articlePageObject.inputPassword(password);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_VerifyPasswordMuchMoreThanFifteenChars - Step 02: verifyPasswordTextError");
		Assert.assertEquals(articlePageObject.getActualPasswordTextErr(), "Mật khẩu ít nhất 6 ký tự và nhỏ hơn 15 ký tự");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_VerifyPasswordMuchMoreThanFifteenChars - Step 03: verifyLoginButtonDisable");
		Assert.assertFalse(articlePageObject.isEnableLoginButton());
	}
	
	@Test
	public void TC_05_verifyEmailValid(Method method) {
		
		sleepInSecond(3);
		email = "autotest2411@gmail.com";
		
		ExtentTestManagerV5.startTest(method.getName(), "TC_06_verifyEmailValid");
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_verifyEmailValid - Step 01: inputEmail");
		articlePageObject.inputEmail(email);
	
		password = "auto@123";
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_verifyEmailValid - Step 02: inputPassword");
		articlePageObject.inputPassword(password);	
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_verifyEmailValid - Step 03: verifyLoginButtonEnable");
		Assert.assertTrue(articlePageObject.isEnableLoginButton());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_verifyEmailValid - Step 04: clickLoginButton");
		articlePageObject.clickLoginButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_verifyEmailValid - Step 05: closePopup");
		Assert.assertTrue(articlePageObject.isClosePopup());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_verifyEmailValid - Step 06: switchToDefault");
		articlePageObject.switchToDefault();
		
		String expectedString = getRePlaceString(email);
		ExtentTestManagerV5.getTest().log(Status.INFO, "TC_06_verifyEmailValid - Step 07: verifyUserInfoDisplay");
		Assert.assertTrue(articlePageObject.isUserAvartarDisplay(expectedString));
		
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

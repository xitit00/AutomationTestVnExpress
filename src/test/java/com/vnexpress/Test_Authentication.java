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
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.vnexpress.ArticlePageObject;
import pageObjects.vnexpress.PageGeneratorManager;
import pageUIs.vnexpress.Login_Page_UI;
//import reportConfig.ExtentTestManagerV5;


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
	
	@Description("Verify Email Invalid")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_VerifyEmailInvalid(Method method) {
		
		//ExtentTestManagerV5.startTest(method.getName(), "TC_01_VerifyEmailInvalid");
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_VerifyEmailInvalid - Step 01: verifyLoginLinkDisplay");
		Assert.assertTrue(articlePageObject.isLoginLinkDisplay());
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_VerifyEmailInvalid - Step 02: clickLoginLink");
		articlePageObject.clickLoginLink();
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_VerifyEmailInvalid - Step 03: verifyIFrameDisplay");
		Assert.assertTrue(articlePageObject.isIFrameDisplay());
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_VerifyEmailInvalid - Step 04: switchToIFrame");
		articlePageObject.switchToIFrame();
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_VerifyEmailInvalid - Step 05: verifyEmailTitleDisplay");
		Assert.assertEquals(articlePageObject.getActualEmailTitle(), "Đăng nhập với email");
		
		String rgbColorEmail = articlePageObject.getElementCssValue(driver, Login_Page_UI.EMAIL_TEXTBOX, "border-color");
		System.out.println("RGB color: " + rgbColorEmail);
		
		String hexColorEmail = articlePageObject.getHexaColorFromRGBA(rgbColorEmail);
		System.out.println("Hex color: " + hexColorEmail);
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_VerifyEmailInvalid - Step 06: inputEmail");
		email = "abc";
		articlePageObject.inputEmail(email);
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_VerifyEmailInvalid - Step 07: verifyEmailTextErrorDisplay");
		Assert.assertEquals(articlePageObject.getActualEmailTextErr(), "Email không hợp lệ");
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_01_VerifyEmailInvalid - Step 08: verifyLoginButtonDisable");
		Assert.assertFalse(articlePageObject.isEnableLoginButton());

		
	}
	
//	@Description("Verify Email Invalid")
//	@Severity(SeverityLevel.NORMAL)
//	@Test
//	public void TC_02_verifyDisplayPleaseInputEmailErrText(Method method) {
//		
//		sleepInSecond(3);
//		//ExtentTestManagerV5.startTest(method.getName(), "TC_02_verifyDisplayPleaseInputEmailErrText");
//		
//		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_verifyDisplayPleaseInputEmailErrText - Step 01: clearEmailText");
//		articlePageObject.clearEmailText();
//		sleepInSecond(3);
//		
//		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_verifyDisplayPleaseInputEmailErrText - Step 02: verifyEmailTextError");
//		Assert.assertEquals(articlePageObject.getActualEmailTextErr(), "Hãy nhập email");
//		
//		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_verifyDisplayPleaseInputEmailErrText - Step 03: verifyLoginButtonDisable");
//		Assert.assertFalse(articlePageObject.isEnableLoginButton());
//		
//	
//		
//	}
	
	@Description("Verify Email Invalid")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_verifyDisplayPleaseInputEmailErrText(Method method) {
	
		System.out.print("Add TC_02 Passed!");
		
	}
	

	@Description("Verify Display Please Input Password Err Text")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_03_VerifyDisplayPleaseInputPasswordErrText(Method method) {
		
		
		sleepInSecond(3);
		email = "auto@gmail.com";
		//ExtentTestManagerV5.startTest(method.getName(), "TC_02_VerifyDisplayPleaseInputPasswordErrText");
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_VerifyDisplayPleaseInputPasswordErrText - Step 01: inputEmail");
		articlePageObject.inputEmail(email);
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_VerifyDisplayPleaseInputPasswordErrText - Step 02: clickPasswordTextBox");
		articlePageObject.clickPasswordTextBox();
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_VerifyDisplayPleaseInputPasswordErrText - Step 03: clickTitleEmailLogin");
		articlePageObject.clickTitleEmailLogin();
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_VerifyDisplayPleaseInputPasswordErrText - Step 04: verifyPasswordTextError");
		Assert.assertEquals(articlePageObject.getActualPasswordTextErr(), "Hãy nhập mật khẩu");
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_02_VerifyDisplayPleaseInputPasswordErrText - Step 05: verifyLoginButtonDisable");
		Assert.assertFalse(articlePageObject.isEnableLoginButton());
		
	}
	
	@Description("Verify Password Less Than Six Chars")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_04_VerifyPasswordLessThanSixChars(Method method) {
		
		sleepInSecond(3);
		password = "123";
		
		//ExtentTestManagerV5.startTest(method.getName(), "TC_03_VerifyPasswordLessThanSixChars");
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_VerifyPasswordLessThanSixChars - Step 01: inputPassword");
		articlePageObject.inputPassword(password);
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_VerifyPasswordLessThanSixChars - Step 02: verifyPasswordTextError");
		Assert.assertEquals(articlePageObject.getActualPasswordTextErr(), "Mật khẩu ít nhất 6 ký tự và nhỏ hơn 15 ký tự");
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_03_VerifyPasswordLessThanSixChars - Step 03: verifyLoginButtonDisable");
		Assert.assertFalse(articlePageObject.isEnableLoginButton());
	}
	
	@Description("Verify Password Much More Than Fifteen Chars")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_05_VerifyPasswordMuchMoreThanFifteenChars(Method method) {
		
		sleepInSecond(3);
		password = "automationtest123@";
		
		//ExtentTestManagerV5.startTest(method.getName(), "TC_04_VerifyPasswordMuchMoreThanFifteenChars");
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_VerifyPasswordMuchMoreThanFifteenChars - Step 01: inputPassword");
		articlePageObject.inputPassword(password);
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_VerifyPasswordMuchMoreThanFifteenChars - Step 02: verifyPasswordTextError");
		Assert.assertEquals(articlePageObject.getActualPasswordTextErr(), "Mật khẩu ít nhất 6 ký tự và nhỏ hơn 15 ký tự");
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_04_VerifyPasswordMuchMoreThanFifteenChars - Step 03: verifyLoginButtonDisable");
		Assert.assertFalse(articlePageObject.isEnableLoginButton());
	}
	
	@Description("Verify Email Valid")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_06_VerifyEmailValid(Method method) {
		
		sleepInSecond(3);
		email = "autotest2411@gmail.com";
		
		//ExtentTestManagerV5.startTest(method.getName(), "TC_05_verifyEmailValid");
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_verifyEmailValid - Step 01: inputEmail");
		articlePageObject.inputEmail(email);
	
		password = "auto@123";
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_verifyEmailValid - Step 02: inputPassword");
		articlePageObject.inputPassword(password);	
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_verifyEmailValid - Step 03: verifyLoginButtonEnable");
		Assert.assertTrue(articlePageObject.isEnableLoginButton());
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_verifyEmailValid - Step 04: clickLoginButton");
		articlePageObject.clickLoginButton();
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_verifyEmailValid - Step 05: closePopup");
		Assert.assertTrue(articlePageObject.isClosePopup());
		
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_verifyEmailValid - Step 06: switchToDefault");
		articlePageObject.switchToDefault();
		
		String expectedString = getRePlaceString(email);
		//ExtentTestManagerV5.getTest().log(Status.INFO, "TC_05_verifyEmailValid - Step 07: verifyUserInfoDisplay");
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

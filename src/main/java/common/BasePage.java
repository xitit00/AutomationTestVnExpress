package common;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static BasePage getBasePageObject() {

		BasePage b = new BasePage();
		return b;
	}

	// Web Browser Command
	public void openPageUrl(WebDriver driver, String pageUrl) {

		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {

		return driver.getTitle();
	}
	
	public String getPageID(WebDriver driver) {

		return driver.getWindowHandle();
	}

	public String getPageUrl(WebDriver driver) {

		return driver.getCurrentUrl();

	}

	public String getPageSourceCode(WebDriver driver) {

		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {

		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {

		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {

		driver.navigate().refresh();
	}

	public void navigateToPage(WebDriver driver, String url) {

		driver.navigate().to(url);
	}

	// Dynamic Locator
	public By getByLocator(String locatorType) {

		By byLocator = null;

		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {

			String strId = locatorType.substring(3);
			byLocator = By.id(strId);

		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class")) {

			String strClass = locatorType.substring(6);
			byLocator = By.className(strClass);
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {

			String strName = locatorType.substring(5);
			byLocator = By.name(strName);
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {

			String strCss = locatorType.substring(4);
			byLocator = By.cssSelector(strCss);
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {

			String strXpath = locatorType.substring(6);
			byLocator = By.xpath(strXpath);

		} else {

			throw new RuntimeException("Locator type is not supported");
		}

		return byLocator;
	}

	public String getDynamicXpath(String locatorType, String... restValues) {

		System.out.println("Locator Type Before = " + locatorType);

		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {

			locatorType = String.format(locatorType, (Object[])restValues);
		}

		for (String value : restValues) {

			System.out.println("Values map to locator = " + value);
		}

		System.out.println("Locator Type After = " + locatorType);
		return locatorType;
	}

	// Web Browser command
	public WebElement getWebElement(WebDriver driver, String locatorType) {

		return driver.findElement(getByLocator(locatorType));
	} 

	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {

		return driver.findElements(getByLocator(locatorType));
	}


	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {

		WebElement element = getWebElement(driver, locatorType);

		element.clear();
		element.sendKeys(textValue);

	}

	public void clickToElement(WebDriver driver, String locatorType) {

		getWebElement(driver, locatorType).click();

	}
	
	public void clickToElement(WebDriver driver, String locatorType, String... restValues) {

		locatorType = getDynamicXpath(locatorType, restValues);
		getWebElement(driver, locatorType).click();

	}

	public void clearValueInElementByDeleteKey(WebDriver driver, String locatorType) {


		WebElement element = getWebElement(driver, locatorType);
		element.sendKeys(Keys.chord(Keys.COMMAND,"a",Keys.DELETE));
	}
	
	public void clearValueInElement(WebDriver driver, String locatorType) {


		WebElement element = getWebElement(driver, locatorType);
		element.clear();
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue , String... restValues) {

		locatorType = getDynamicXpath(locatorType, restValues);

		WebElement element = getWebElement(driver, locatorType);

		element.clear();
		element.sendKeys(textValue);

	}
	
	public String getElementTextByElement(WebElement element) {
		
		return element.getText();
	}

	public void sleepInSecond(long timeoutInSec) {

		try {

			Thread.sleep(timeoutInSec * 1000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}


	// override time out
	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {

		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	// check State Element
	public boolean isElementDisplayed(WebDriver driver , String locatorType) {

		return getWebElement(driver, locatorType).isDisplayed();
	}

	public boolean isElementDisplayed(WebDriver driver , String locatorType, String... restValues) {

		return getWebElement(driver, getDynamicXpath(locatorType, restValues)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver , String locatorType) {

		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementEnabled(WebDriver driver , String locatorType, String... restValues) {

		return getWebElement(driver, getDynamicXpath(locatorType, restValues)).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver , String locatorType) {

		return getWebElement(driver, locatorType).isSelected();
	}

	public boolean isElementSelected(WebDriver driver , String locatorType, String... restValues) {

		return getWebElement(driver, getDynamicXpath(locatorType, restValues)).isSelected();
	}

	// Frame , Iframe

	public void switchToFrameIframe(WebDriver driver , String locatorType ) {

		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	public void switchToDefaultContent(WebDriver driver) {

		driver.switchTo().defaultContent();
	}

	//window , tab

	public void switchToWindowByID(WebDriver driver,String pageID) {

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		for (String window : allWindows) {

			if (!window.equals(pageID)) {

				driver.switchTo().window(window);
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver,String expectedPageTitle) {

		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		for (String window : allWindows) {


			driver.switchTo().window(window);

			String actualTitle = driver.getTitle().trim();
			System.out.println(actualTitle);
			if (actualTitle.equals(expectedPageTitle)) {

				break;
			}
		}
	}

	public void closeAllTabWithoutParent(WebDriver driver,String parentPageID) {

		Set<String> allWindowsID = driver.getWindowHandles();

		for (String windowID : allWindowsID) {

			if (!windowID.equals(parentPageID)) {

				driver.switchTo().window(windowID);
				driver.close();

			}
		}

		driver.switchTo().window(parentPageID);
	}
	

	// ít dùng

	public String getElementAttribute(WebDriver driver , String locatorType, String attributeName) {

		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver , String locatorType, String attributeName, String... restValues ) {

		return getWebElement(driver, getDynamicXpath(locatorType, restValues)).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver , String locatorType) {

		return getWebElement(driver, locatorType).getText();
	}

	public String getElementText(WebDriver driver , String locatorType, String... restValues) {

		return getWebElement(driver, getDynamicXpath(locatorType, restValues)).getText();
	}

	public String getElementCssValue(WebDriver driver , String locatorType, String propertyName) {

		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	public String getHexaColorFromRGBA(String rgbaValue) {

		return Color.fromString(rgbaValue).asHex();
	}

	public int getElementSize(WebDriver driver , String locatorType) {

		return  getListWebElement(driver, locatorType).size();
	}

	public int getElementSize(WebDriver driver , String locatorType, String... restValues) {

		locatorType = getDynamicXpath(locatorType, restValues);
		return  getListWebElement(driver, locatorType).size();
	}

	// User action
	
	public void hoverMouseToElement(WebDriver driver , String locatorType ) {
		
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	
	public void hoverMouseToElement(WebDriver driver , String locatorType, String...restValues) {
		
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, getDynamicXpath(locatorType, restValues))).perform();
	}
	
	public void pressKeyToElement(WebDriver driver , String locatorType , Keys key) {
		
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver , String locatorType , Keys key , String...restValues) {
		
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, restValues)), key).perform();
		
	}

	//JsExecutor

	public void scrollToBottomPage(WebDriver driver) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void hightlightElement(WebDriver driver, String locatorType , String...restValues) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		locatorType = getDynamicXpath(locatorType, restValues);

		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");

		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);

		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void clickToElementByJS(WebDriver driver, String locatorType, String...restValues) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		locatorType = getDynamicXpath(locatorType, restValues);
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElementOnTop(WebDriver driver, String locatorType) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void scrollToElementOnDown(WebDriver driver, String locatorType) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public boolean isPageLoadedSuccess(WebDriver driver) {

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {

				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active == 0);");

			}

		};

		return explicitWait.until(jQueryLoad);

	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;
		}
		return false;
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType, String...restValues) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		locatorType = getDynamicXpath(locatorType, restValues);
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;
		}
		return false;
	}


	// Explicit Wait

	public void waitForElementVisible(WebDriver driver, String typeLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(typeLocator)));

	}

	public void waitForElementVisible(WebDriver driver, String typeLocator, String... restValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(typeLocator, restValues))));

	}

	public void waitForAllElementVisible(WebDriver driver, String typeLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(typeLocator)));

	}

	public void waitForAllElementVisible(WebDriver driver, String typeLocator, String... restValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(typeLocator, restValues))));

	}

	public void waitForElementInVisible(WebDriver driver, String typeLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(typeLocator)));

	}


	public void waitForElementInVisible(WebDriver driver, String typeLocator, String... restValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(typeLocator, restValues))));

	}

	public void waitForAllElementInVisible(WebDriver driver, String typeLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElement(driver, typeLocator)));

	}

	public void waitForAllElementInVisible(WebDriver driver, String typeLocator, String... restValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getWebElement(driver, getDynamicXpath(typeLocator, restValues))));

	}

	public void waitForElementClickable(WebDriver driver, String typeLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(typeLocator)));

	}

	public void waitForElementClickable(WebDriver driver, String typeLocator, String... restValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(typeLocator, restValues))));

	}
	public void waitForElementPresence(WebDriver driver, String typeLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(getByLocator(typeLocator)));

	}

	public void waitForAllElementPresence(WebDriver driver, String typeLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(typeLocator)));

	}

}

package common;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {


	private WebDriver driverBaseTest;

	public WebDriver getDriverInstance() {

		return this.driverBaseTest;
	}


	//Enum 
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {

		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());

		switch (browserList) {

		case FIREFOX:


			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();

			break;

		case CHROME:

			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();

			break;

		case EDGE:

			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();

			break;

		default:

			throw new RuntimeException("Browser name invalid");

		}

		driverBaseTest.get(appUrl);
		driverBaseTest.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driverBaseTest.manage().window().maximize();

		return driverBaseTest;
	}

	protected String getRePlaceString(String beginString) {
		
		beginString = beginString.replace("@gmail.com", "");
		return beginString;
	}

}

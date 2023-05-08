package common;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {


	private WebDriver driverBaseTest;
	
	@BeforeSuite
	public void initBeforeSuite() {

		deleteAllureReport();
	}

	public WebDriver getDriverInstance() {

		return this.driverBaseTest;
	}

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
	
	public void deleteAllureReport() {
		try {

			String pathFolderDownload = GlobalConstants.PROJECT_PATH + "/allure-results";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected String getRePlaceString(String beginString) {
		
		beginString = beginString.replace("@gmail.com", "");
		return beginString;
	}

}

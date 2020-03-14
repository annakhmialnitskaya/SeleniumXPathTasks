package by.test.selenium.google;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmokeTest {

	private static final String DRIVER_NAME = "webdriver.chrome.driver";
	private static final String DRIVER_LOCATION = "C:/programs/selenium/chromedriver.exe";

	private WebDriver driver;

	@Before
	public void initBrowser() {
		System.setProperty(DRIVER_NAME, DRIVER_LOCATION);
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@Test
	public void mainTest() {
		// Open home page
		HomePage homePage = new HomePage(driver);
		homePage.open();
		// Open result page
		ResultPage resultPage = homePage.getResultPage();
		// Compare results
		Assert.assertTrue("The page title should start with the search string after the search.",
				resultPage.getTitle().startsWith("Java"));
	}

	@After
	public void destroyBrowser() {
		driver.quit();
	}
}

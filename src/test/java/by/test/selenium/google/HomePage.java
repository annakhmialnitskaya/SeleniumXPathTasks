package by.test.selenium.google;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page {

	private static final String URL = "https://www.google.ru/";
	private static final String INPUT_REQUEST_XPATH = "//input[@title='Поиск']";
	private static final String RESULTS_XPATH = "//*[@id='search']";
	private static final String REQUEST = "Java";

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getDriver().get(URL);
	}

	public ResultPage getResultPage() {

		WebElement inputRequestElement = (new WebDriverWait(driver, Duration.ofSeconds(2)))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(INPUT_REQUEST_XPATH)));

		/*
		 * Wait<WebDriver> wait = new
		 * FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
		 * .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.
		 * class);
		 * 
		 * WebElement inputRequestElement = wait.until(new Function<WebDriver,
		 * WebElement>() { public WebElement apply(WebDriver driver) { return
		 * driver.findElement(By.xpath(INPUT_REQUEST_XPATH)); } });
		 */
		inputRequestElement.sendKeys(REQUEST);
		inputRequestElement.submit();

		(new WebDriverWait(driver, Duration.ofSeconds(2)))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(RESULTS_XPATH)));

		/*
		 * wait.until(new Function<WebDriver, WebElement>() { public WebElement
		 * apply(WebDriver driver) { return
		 * driver.findElement(By.xpath(RESULTS_XPATH)); } });
		 */

		return new ResultPage(driver);
	}
}

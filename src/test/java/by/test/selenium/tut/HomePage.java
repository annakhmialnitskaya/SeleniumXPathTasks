package by.test.selenium.tut;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page {

	private static final String URL = "https://www.tut.by/";
	private static final String MAIN_NEWS_XPATH = "//*[@id='title_news_block']/div[1]/h3/a";
	private static final String RESULTS_XPATH = "//h1[@itemprop='headline']";

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void open() {
		getDriver().get(URL);
	}

	public NewsPage getNewsPage() {

		WebElement mainNewsElement = (new WebDriverWait(driver, Duration.ofSeconds(20)))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MAIN_NEWS_XPATH)));

		mainNewsElement.click();

		(new WebDriverWait(driver, Duration.ofSeconds(20)))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(RESULTS_XPATH)));

		return new NewsPage(driver);
	}
}

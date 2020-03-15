package by.test.selenium.tut;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsPage extends Page {

	private static final String BODY_XPATH = ".//*[@id='article_body']/p";

	public NewsPage(WebDriver driver) {
		super(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public int calculateParagraphCount() {
		List<WebElement> pElements = driver.findElements(By.xpath(BODY_XPATH));
		return pElements.size();
	}
}

package by.test.selenium.google;

import org.openqa.selenium.WebDriver;

public class ResultPage extends Page {

	public ResultPage(WebDriver driver) {
		super(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}

}

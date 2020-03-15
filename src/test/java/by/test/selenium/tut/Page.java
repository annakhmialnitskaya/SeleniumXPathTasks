package by.test.selenium.tut;

import org.openqa.selenium.WebDriver;

public class Page {

	protected final WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return this.driver;
	}
}

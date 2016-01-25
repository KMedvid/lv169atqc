package com.softserve.edu.fedyk.mdVerificator.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Application {

	private WebDriver driver;

	public Application(WebDriver driver1) {
		this.driver = driver1;
		driver.get("http://localhost:8080/#/start");
	}

	public void loginButtonClick() {
		WebElement button = driver.findElement(By.cssSelector("a[href*='#/login']"));
		button.click();
	}

}

package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.md.data.User;

public class CalibratorHomePage {
	private WebDriver driver;
	private WebElement title;
	private WebElement loginname;
	private WebElement options;
	private WebElement logout;

	/**
	 * 
	 * Constructor of Calibrator Home Page. Check if all necessary elements
	 * exist.
	 */
	public CalibratorHomePage(WebDriver driver) {

		this.driver = driver;
		this.title = driver.findElement(By.cssSelector("h1.page-header.ng-binding"));
		this.loginname = driver.findElement(By.cssSelector("div label.ng-scope"));
		this.options = driver.findElement(By.cssSelector("div i.fa.fa-caret-down"));
		this.logout = driver.findElement(By.xpath("//p[text()='Вилогуватись']"));
	}

	public WebElement getTitle() {
		return this.title;
	}

	public WebElement getOptions() {
		return this.options;
	}

	public WebElement getLoginName() {
		return this.loginname;
	}

	public String getTitleText() {
		return this.title.getAttribute("textContent");
	}

	public String getLoginNameText() {
		return this.loginname.getAttribute("textContent");
	}

	public WebElement getLogout() {
		return this.logout;
	}

	public void clickLogout() {
		this.logout.click();
	}

	public void gotoLogout() {
		getOptions().click();
		clickLogout();
	}

	public CalibratorHomePage successCalLogin(User calibrator) {
		return new CalibratorHomePage(driver);
	}
}

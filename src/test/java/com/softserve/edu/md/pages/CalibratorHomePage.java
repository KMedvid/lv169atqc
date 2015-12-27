package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.User;

public class CalibratorHomePage {
	private WebDriver driver;
	private WebElement verificationPageButton;
	private WebElement measuringEquipmentPagebutton;
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
		this.verificationPageButton = driver.findElement(By.xpath("//div/ul/li[2]/a/span[1]"));
		this.measuringEquipmentPagebutton = driver.findElement(By.xpath("//li[3]/a/span"));
		this.title = driver.findElement(By.cssSelector("h1.page-header.ng-binding"));
		this.loginname = driver.findElement(By.cssSelector("div label.ng-scope"));
		this.options = driver.findElement(By.cssSelector("div i.fa.fa-caret-down"));
		this.logout = driver.findElement(By.xpath("//p[text()='Вилогуватись']"));
	}

	public WebElement getverificationPageButton() {
		return this.verificationPageButton;
	}
	
	public WebElement getmeasuringEquipmentPagebutton() {
		return this.measuringEquipmentPagebutton;
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

	public CalibratorHomePage successCalLogin(IUser calibrator) {
		return new CalibratorHomePage(driver);
	}

	public NewVerificationPage gotoverificationpage(){
		this.verificationPageButton.click();;
		return new NewVerificationPage(driver);
	}

	public MeasuringEquipmentPage gotoMeasuringEquipmentPage(){
		this.measuringEquipmentPagebutton.click();
		return new MeasuringEquipmentPage(driver);
	}
}

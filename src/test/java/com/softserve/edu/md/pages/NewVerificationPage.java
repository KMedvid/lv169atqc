package com.softserve.edu.md.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.md.data.User;

public class NewVerificationPage {
	private WebDriver driver;
	private WebElement requestnumber;
	private WebElement clientdata;
	private WebElement clientstreet;
	private WebElement workerdata;
	private WebElement options;
	private WebElement logout;

	public static final String SERCH_NUMBER_DATA = "5aa79022-c720-4424-ab71-eed574d1b48d";
	public static final String SEARCH_STREET_DATA = "Лукаша";
	public static final String SEARCH_CLIENT_NAMES_DATA = "Чопик Василь Іванович";
	public static final String SEARCH_WORKER_NAMES_DATA = "Річардс Кейт Романович";

	/**
	 * Constructor of New Verifications Home Page. Check if all necessary
	 * elements exist.
	 */
	public NewVerificationPage(WebDriver driver) {
		this.driver = driver;
		this.requestnumber = driver.findElement(By.xpath("//table/thead/tr[2]/th[3]//input"));
		this.clientdata = driver.findElement(By.xpath("//table/thead/tr[2]/th[4]//input"));
		this.clientstreet = driver.findElement(By.xpath("//table/thead/tr[2]/th[5]//input"));
		this.workerdata = driver.findElement(By.xpath("//table/thead/tr[2]/th[7]//input"));
		this.options = driver.findElement(By.cssSelector("div i.fa.fa-caret-down"));
		this.logout = driver.findElement(By.xpath("//p[text()='Вилогуватись']"));

	}

	public WebElement getRequestnumber() {
		return this.requestnumber;
	}

	public String getRequestnumberText() {
		return this.requestnumber.getText();
	}

	public WebElement getClientdata() {
		return this.clientdata;
	}

	public WebElement getClientstreet() {
		return this.clientstreet;
	}

	public WebElement getWorkerdata() {
		return this.workerdata;
	}

	public WebElement getOptions() {
		return this.options;
	}

	public void clickLogout() {
		this.logout.click();
	}

	public WebElement getLogout() {
		return this.logout;
	}

	/**
	 * Search by Request Number field in New Verifications. Return string with
	 * text of found element.
	 */
	public String searchSearchNumber(String searchfilter) {
		getRequestnumber().sendKeys(searchfilter);
		String s = driver.findElement(By.cssSelector("td.ng-pristine.ng-untouched.ng-valid.ng-binding")).getText();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("screenfolde/screenshot_searchbynumber.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		getRequestnumber().clear();
		return s;
	}

	/**
	 * 
	 * Search by Worker Data field in New Verifications. Return string with text
	 * of found element.
	 * 
	 */
	public String searchWorkerData(String searchfilter) {
		getWorkerdata().sendKeys(searchfilter);
		String s = driver.findElement(By.xpath("//table/tbody/tr/td[7]")).getText();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("screenfolde/screenshot_searchbyworkerdata.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		getWorkerdata().clear();
		return s;
	}

	/**
	 * 
	 * Search by Client Data field in New Verifications. Return string with text
	 * of found element.
	 * 
	 * 
	 */
	public String searchClientData(String searchfilter) {
		getClientdata().sendKeys(searchfilter);
		String s = driver.findElement(By.xpath("//table/tbody/tr/td[4]")).getText();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("screenfolde/screenshot_searchbyclientdata.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		getClientdata().clear();
		return s;
	}

	/**
	 * 
	 * Search by Client Street field in New Verifications. Return string with
	 * text of found element.
	 * 
	 */
	public String searchClientStreet(String searchfilter) {
		getClientstreet().sendKeys(searchfilter);
		String s = driver.findElement(By.xpath("//table/tbody/tr/td[5]")).getText();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("screenfolde/screenshot_searchbyclientstreet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		getClientstreet().clear();
		return s;
	}

	// Return a new page object representing the destination.
	public NewVerificationPage successVerifaction(User calibrator) {
		return new NewVerificationPage(driver);
	}

	/**
	 * 
	 * Logout from your user account.
	 * 
	 */
	public void gotoLogout() {
		getOptions().click();
		clickLogout();
	}
}

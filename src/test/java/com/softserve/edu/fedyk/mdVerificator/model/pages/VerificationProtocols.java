package com.softserve.edu.fedyk.mdVerificator.model.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.softserve.edu.fedyk.mdVerificator.data.UserRepository;
import com.softserve.edu.fedyk.mdVerificator.tests.Tests;

public class VerificationProtocols {
	private static final Logger LOGGER = Logger.getLogger(Tests.class);
	private WebDriver driver;
	private WebElement fullName;
	private WebElement status;
	private WebElement edit;

	public VerificationProtocols(WebDriver driver) {
		this.driver = driver;
		this.fullName = driver.findElement(By.xpath(
				"//*[@id='page-wrapper']/div[3]/div/div[2]/div[2]/div/div/table/thead/tr[2]/th[3]/div/div/div/input"));
		this.status = driver.findElement(By.name("filter-status"));
		this.edit = driver.findElement(
				By.xpath("//*[@id='page-wrapper']/div[3]/div/div[2]/div[2]/div/div/table/tbody/tr[1]/td[8]/div/i[1]"));

	}

	public void clickFilter() {
		this.fullName.click();
	}

	public void clickEdit() {
		LOGGER.info("Click edit icon");
		this.edit.click();
	}

	public void clearFilter() {
		this.fullName.clear();
	}

	public void setFilter() {

		this.fullName.sendKeys(UserRepository.getUser());

	}

	public void setStatus() {
		status.click();
		WebElement newProtocols = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-0-0']/div/span"));
		// *[@id="ui-select-choices-row-0-0"]/div/span
		newProtocols.click();
	}

	public void findUser() {
		WebElement user = driver.findElement(By.cssSelector("td[data-title=\"'CLIENT_FULL_NAME' | translate\"]"));
		Assert.assertTrue(user.getText().contains(UserRepository.getUser()),"Повірку найдено");
	}

	public void doFilter() {
		LOGGER.info("Clearing Fields");
		clickFilter();
		clearFilter();
		LOGGER.info("Setting Filters");
		setFilter();
		setStatus();
		LOGGER.info("Checking if user exist in td");
		findUser();

	}

}

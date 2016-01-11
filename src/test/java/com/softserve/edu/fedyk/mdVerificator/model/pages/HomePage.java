package com.softserve.edu.fedyk.mdVerificator.model.pages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.fedyk.mdVerificator.model.pages.EmployeePage;
import com.softserve.edu.fedyk.mdVerificator.tests.Tests;

public class HomePage {
	private static final Logger LOGGER = Logger.getLogger(Tests.class);
	private WebElement verificator;
	private WebDriver driver;
	private WebElement workers;
	private WebElement addWorker;
	private WebElement protocols;

	public HomePage(WebDriver driver1) {
		this.driver = driver1;
		this.verificator = driver.findElement(By.className("fa-home"));
		this.workers = driver.findElement(By.cssSelector("a[href='#/verificator/employee-show']"));
		this.protocols = driver.findElement(By.cssSelector("a[href='#/verifications/new']"));
	}

	public WebElement getVerificator() {
		return this.verificator;
	}

	public void click() {
		workers.click();
	}
	public void clickProtocols(){
		LOGGER.info("Going to protocols");
		protocols.click();
	}

	public EmployeePage clickAdd() {
		this.addWorker = driver.findElement(By.cssSelector("button[ng-click='openAddEmployeeModal()']"));
		addWorker.click();
		return new EmployeePage(driver);
	}

	

//	public void logOut() {
//		WebElement but = driver.findElement(By.partialLinkText("��� ������"));
//		but.click();
//
//		WebElement logOut = driver.findElement(By.cssSelector("div[ng-click='logout()']"));
//
//		logOut.click();
//	}

}

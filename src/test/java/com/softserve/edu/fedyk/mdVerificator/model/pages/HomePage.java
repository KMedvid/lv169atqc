package com.softserve.edu.fedyk.mdVerificator.model.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.fedyk.mdVerificator.model.EmployeePage;

public class HomePage {

	private WebElement verificator;
	private WebDriver driver;
	private WebElement workers;
	private WebElement addWorker;

	public HomePage(WebDriver driver1) {
		this.driver = driver1;
		this.verificator = driver.findElement(By.className("fa-home"));
		this.workers = driver.findElement(By.cssSelector("a[href='#/verificator/employee-show']"));
	}

	public WebElement getVerificator() {
		return this.verificator;
	}

	public void click() {
		workers.click();
	}
//
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

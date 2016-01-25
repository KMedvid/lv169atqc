package com.softserve.edu.fedyk.mdVerificator.model.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.fedyk.mdVerificator.tests.Tests;

public class ChangeVerificator {
	private static final Logger LOGGER = Logger.getLogger(Tests.class);
	private WebDriver driver;
	private WebElement changeStatus;
	private WebElement noSuitable;
	private WebElement save;

	public ChangeVerificator(WebDriver driver) {
		//For java.training
//		this.changeStatus = driver.findElement(By.xpath("//*[@id='page-wrapper']/form/div[3]/div/div/a"));
		//For local
		this.changeStatus = driver.findElement(By.xpath("//*[@id='page-wrapper']/form/div[1]/div[15]/div/div/a/span[1]"));
		this.driver = driver;
		
//		this.noSuitable = driver.findElement(By.id("ui-select-choices-row-1-1"));
		
		//For java.training
//		this.save = driver.findElement(By.xpath("//*[@id='page-wrapper']/form/div[3]/div/button[1]"));
		//For local
		this.save = driver.findElement(By.xpath("//*[@id='page-wrapper']/form/div[1]/div[16]/div[1]/button"));
		
	}

	public void clickChangeStatus() {
		LOGGER.info("Click to change field");
		this.changeStatus.click();
	}

	public void clickSetNoSuitable() {
		LOGGER.info("Select no suitable");
		//For java.training
//		this.noSuitable = driver.findElement(By.id("//*[@id='ui-select-choices-row-1-1'])"));
		//For local
		this.noSuitable = driver.findElement(By.xpath("//*[@id='ui-select-choices-row-1-1']/div"));
		noSuitable.click();
	}

	public void clickSave() {
		LOGGER.info("Click Save Button");
		this.save.click();
	}

	public void changeToNoSuitable() {
		clickChangeStatus();
		clickSetNoSuitable();
		clickSave();
		//TODO Додати провірку чи помінялось.
	}
}

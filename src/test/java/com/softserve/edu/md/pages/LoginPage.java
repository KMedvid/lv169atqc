package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.User;

//import some.test.stuff.data.User;

public class LoginPage {
	// constants with testing data
	public static final String TITLE = "Головна панель (вимірювальна лабораторія)";
	public static final String LOGIN_ATTRIBUTES = "Курт Кобейн";
	private WebDriver driver;
	//
	private WebElement login;
	private WebElement password;
	private WebElement submit;

	/**
	 * 
	 * Constructor of Login Page. Check if all necessary fields exists
	 * 
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		//
		this.login = driver.findElement(By.xpath("//input[@type='text']"));
		this.password = driver.findElement(By.id("inputPassword"));
		this.submit = driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block.withoutBorder.ng-binding"));
	}

	// Get Elements

	public WebElement getLogin() {
		return this.login;
	}

	public WebElement getPassword() {
		return this.password;
	}

	public WebElement getSubmit() {
		return this.submit;
	}

	public String getLoginText() {
		return this.login.getText();
	}

	public String getPasswordText() {
		return this.password.getText();
	}

	// Set Data

	public void setLogin(String login) {
		this.login.sendKeys(login);
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clearLogin() {
		this.login.clear();
	}

	public void clearPassword() {
		this.password.clear();
	}

	public void clickLogin() {
		this.login.click();
	}

	public void clickPassword() {
		this.password.click();
	}

	public void clickSubmit() {
		this.submit.click();
	}

	/**
	 * method that allows us to login as user
	 */
	private void setLoginData(IUser user) {
		clickLogin();
		clearLogin();
		setLogin(user.getLogin());
		clickPassword();
		clearPassword();
		setPassword(user.getPassword());
		clickSubmit();
	}

	public CalibratorHomePage successCalLogin(IUser calibrator) {
		setLoginData(calibrator);
		return new CalibratorHomePage(driver);
	}

	public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
		setLoginData(invalidUser);
		return new LoginValidatorPage(driver);
	}

  
}
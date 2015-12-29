package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.md.data.IUser;

public class LoginPage {
	private WebDriver driver;
	//
	private WebElement login;
	private WebElement password;
	private WebElement submit;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		//
		this.login = driver.findElement(By.xpath("//input[@ng-model ='loginForm.username']"));
		this.password = driver.findElement(By.id("inputPassword"));
		this.submit = driver.findElement(By.xpath("//button[@type = 'submit']"));
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

	// Business Logic
 /**
  * 
  * @param user - admin, calibrator and verificator is able to login
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

	/**
	 * Success admin login and move to admin home page.
	 * @param admin
	 * @return AdminHomePage
	 */
    public AdminHomePage successAdminLogin(IUser admin) {
		setLoginData(admin);
		// Return a new page object representing the destination.
		return new AdminHomePage(driver);
	}

	/**
	 * Unsuccessful user login with validator message.
	 * @param invalidUser
	 * @return LoginValidatorPage
	 */
	public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
		setLoginData(invalidUser);
		return new LoginValidatorPage(driver); // return this;
	}

}

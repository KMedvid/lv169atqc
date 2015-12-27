package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.oms.data.IUser;

public class CreateNewUserPage {
	protected WebDriver driver;
	private WebElement logout;
	//
	private WebElement login;
	private WebElement firstName;
	private WebElement lastName;
	private WebElement password;
	private WebElement confirmPassword;
	private WebElement email;
	private WebElement roleID1;
	private WebElement regionID;
	private WebElement emailError;
	private WebElement createBtn;

	public CreateNewUserPage(WebDriver driver) {
		this.driver = driver;
		//
		this.login = driver.findElement(By.name("login"));
		this.firstName = driver.findElement(By.name("firstName"));
		this.lastName = driver.findElement(By.name("lastName"));
		this.password = driver.findElement(By.name("password"));
		this.confirmPassword = driver.findElement(By.name("confirmPassword"));
		this.email = driver.findElement(By.name("email"));
		this.roleID1 = driver.findElement(By.id("roleID1"));
		this.emailError = driver.findElement(By.id("emailError"));
		this.logout = driver.findElement(By.cssSelector(".spec img"));
	}
	// Get Elements

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getRoleID1() {
		return roleID1;
	}

	public WebElement getRegionID() {
		return regionID;
	}

	public WebElement getEmailError() {
		return emailError;
	}

	public String getLoginText() {
		return this.login.getText();
	}

	public String getFirstNameText() {
		return this.firstName.getText();
	}

	public String getLastNameText() {
		return this.lastName.getText();
	}

	public String getPasswordText() {
		return this.password.getText();
	}

	public String getConfirmPasswordText() {
		return this.confirmPassword.getText();
	}

	public String getEmailText() {
		return this.email.getText();
	}

	// Set Elements
	public void setLogin(String login) {
		this.login.sendKeys(login);
	}

	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void setConfirmPassword(String Password) {
		this.confirmPassword.sendKeys(Password);
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void clearLogin() {
		this.login.clear();
	}

	public void clearFirstName() {
		this.firstName.clear();
	}

	public void clearLastName() {
		this.lastName.clear();
	}

	public void clearPassword() {
		this.password.clear();
	}

	public void clearConfirmPassword() {
		this.confirmPassword.clear();
	}

	public void clearEmail() {
		this.email.clear();
	}

	public void clickLogin() {
		this.login.click();
	}

	public void clickFirstName() {
		this.firstName.click();
	}

	public void clickLastName() {
		this.lastName.click();
	}

	public void clickPassword() {
		this.password.click();
	}

	public void clickConfirmPassword() {
		this.confirmPassword.click();
	}

	public void clickEmail() {
		this.email.click();
	}

	public void roleID1() {
		this.roleID1.click();
	}

	public void emailError() {
		this.emailError.submit();
	}

	public void clickLogout() {
		this.login.click();
	}

	private void setNewUserData(IUser user) {
		clickLogin();
		clearLogin();
		setLogin(user.getLogin());
		clickFirstName();
		clearFirstName();
		setFirstName(user.getFirstname());
		clickLastName();
		clearLastName();
		setLastName(user.getLastname());
		clickPassword();
		clearPassword();
		setPassword(user.getPassword());
		clickConfirmPassword();
		clearConfirmPassword();
		setConfirmPassword(user.getPassword());
		clickEmail();
		clearEmail();
		setEmail(user.getEmail());
		roleID1.click();
		emailError.submit();
	}

	// Business Logic
	public AdministrationPage successCreateNewUser(IUser user) {
		setNewUserData(user);
		// Return a new page object representing the destination.
		return new AdministrationPage(driver);
	}

	public LoginPage gotoLogout() {
		clickLogout();
		return new LoginPage(driver);
	}
}
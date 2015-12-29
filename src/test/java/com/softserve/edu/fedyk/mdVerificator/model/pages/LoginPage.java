package com.softserve.edu.fedyk.mdVerificator.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.fedyk.mdVerificator.data.UserRepository;
import com.softserve.edu.fedyk.mdVerificator.model.EmployeePage;
import com.softserve.edu.fedyk.mdVerificator.model.User;

public class LoginPage {

	private WebDriver driver;
	private WebElement login;
	private WebElement password;
	private WebElement submit;
	private WebElement workers;
	private WebElement addWorker;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.login = driver.findElement(By.cssSelector("input[ng-model='loginForm.username']"));
		this.password = driver.findElement(By.cssSelector("input[ng-model='loginForm.password']"));
		this.submit = driver.findElement(By.className("btn-lg"));
	}

	// Get
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() {
		return submit;
	}

	// Set
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

	private void setLoginData(User user) {
		clickLogin();
		clearLogin();
		setLogin(user.getLogin());
		clickPassword();
		clearPassword();
		setPassword(user.getPassword());
		clickSubmit();
	}
	public HomePage successUserLogin(User verificator) {
		setLoginData(verificator);
		// Return a new page object representing the destination.
		return new HomePage(driver);
	}
	public HomePage doLogin() {
	LoginPage login = new LoginPage(driver);
	User verificator = UserRepository.getVerificator();
	return login.successUserLogin(verificator);
}
	public void click() {
		workers.click();
	}

	public EmployeePage clickAdd() {
		this.addWorker = driver.findElement(By.cssSelector("button[ng-click='openAddEmployeeModal()']"));
		addWorker.click();
		return new EmployeePage(driver);
	}
	 
	 

}

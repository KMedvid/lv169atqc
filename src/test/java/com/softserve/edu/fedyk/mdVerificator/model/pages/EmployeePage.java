package com.softserve.edu.fedyk.mdVerificator.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeePage {

	private WebElement lastName;
	private WebElement name;
	private WebElement surname;
	private WebElement phoneNumber;
	private WebElement email;
	private WebElement login;
	private WebElement password;
	private WebElement secondPassword;
	private WebElement submit;
	private WebDriver driver;

	public EmployeePage(WebDriver driver) {
		this.lastName = driver.findElement(By.id("lastName"));
		this.name = driver.findElement(By.id("firstName"));
		this.surname = driver.findElement(By.id("middleName"));
		this.phoneNumber = driver.findElement(By.id("phone"));
		this.email = driver.findElement(By.id("email"));
		this.login = driver.findElement(By.id("username"));
		this.password = driver.findElement(By.name("password"));
		this.secondPassword = driver.findElement(By.name("rePassword"));
		this.submit = driver.findElement(By.className("btn-success"));
		this.driver = driver;
	}

	private void submit() {
		this.submit.click();
	}

	public void addEmployee(Employee employee) {
		setEmployeeData(employee);
		submit();
	}

//	public void doAccept(Employee employee) {
	public void doAccept() {
		
		By cssSelector = By.cssSelector("button[ng-click='successController.ok()']");
		WebElement accept = driver.findElement(cssSelector);
		accept.click();
//		set filter
//		....
//		check user field
//		By userRow = By.cssSelector("input[]");
//		WebElement userRowElement = driver.findElement(userRow);
//		Assert.assertTrue(userRowElement.getText().contains(employee.getSurname()));
	}

	// SET
	public void clickLastName() {
		this.lastName.click();
	}

	public void clearLastName() {
		this.lastName.clear();
	}

	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}

	public void clickName() {
		this.name.click();
	}

	public void clearName() {
		this.name.clear();
	}

	public void setName(String name) {
		this.name.sendKeys(name);
	}

	public void clickSurname() {
		this.surname.click();
	}

	public void clearSurname() {
		this.surname.clear();
	}

	public void setSurname(String surname) {
		this.surname.sendKeys(surname);
	}

	public void clickPhoneNumber() {
		this.phoneNumber.click();
	}

	public void clearPhoneNumber() {
		this.phoneNumber.clear();
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.sendKeys(phoneNumber);
	}

	public void clickEmail() {
		this.email.click();
	}

	public void clearEmail() {
		this.email.clear();
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
	}

	public void clickLogin() {
		this.login.click();
	}

	public void clearLogin() {
		this.login.clear();
	}

	public void setLogin(String login) {
		this.login.sendKeys(login);
	}

	public void clickPassword() {
		this.password.click();
	}

	public void clearPassword() {
		this.password.clear();
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickSecondPassword() {
		this.secondPassword.click();
	}

	public void clearSecondPassword() {
		this.secondPassword.clear();
	}

	public void setSecondPassword(String password) {
		this.secondPassword.sendKeys(password);
	}

	private void setEmployeeData(Employee employee) {
		clickLastName();
		clearLastName();
		setLastName(employee.getLastName());
		clickName();
		clearName();
		setName(employee.getName());
		clickSurname();
		clearSurname();
		setSurname(employee.getSurname());
		clickPhoneNumber();
		clearPhoneNumber();
		setPhoneNumber(employee.getPhoneNumber());
		clickEmail();
		clearEmail();
		setEmail(employee.getEmail());
		clickLogin();
		clearLogin();
		setLogin(employee.getLogin());
		clickPassword();
		clearPassword();
		setPassword(employee.getPassword());
		clickSecondPassword();
		clearSecondPassword();
		setSecondPassword(employee.getPassword());

	}

}

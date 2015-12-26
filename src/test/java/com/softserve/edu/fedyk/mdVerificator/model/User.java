package com.softserve.edu.fedyk.mdVerificator.model;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class User {
	private String login;
	private String password;
	private WebDriver driver;

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void logIn() {

		WebElement logIn = driver.findElement(By.cssSelector("input[ng-model='loginForm.username']"));
		logIn.click();
		WebElement password = driver.findElement(By.cssSelector("input[ng-model='loginForm.password']"));
		password.click();
	}

}

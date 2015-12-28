package com.softserve.edu.fedyk.mdVerificator.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.softserve.edu.fedyk.mdVerificator.model.Employee;
import com.softserve.edu.fedyk.mdVerificator.model.EmployeePage;
import com.softserve.edu.fedyk.mdVerificator.model.pages.Application;
import com.softserve.edu.fedyk.mdVerificator.model.pages.HomePage;
import com.softserve.edu.fedyk.mdVerificator.model.pages.LoginPage;

public class LoginTest {

	private WebDriver driver;

	// @AfterTest
	// private void logOut() {
	// HomePage page = new HomePage(driver);
	// page.logOut();
	// }
	@AfterTest

	public void tearDown() throws Exception {
		if (!driver.getCurrentUrl().contains("start")) {
			System.out.println("\t*** logout in progress ... ***");
			driver.get("http://localhost:8080/#/logout");
		}
		// driver.quit();
	}

	@BeforeClass
	private void init() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void openLoginPage() {
		new Application(driver).loginButtonClick();

	}

	@Test
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin();
	}

	@Test
	public void addEmployee() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		HomePage page = loginPage.doLogin();
		page.click();
		Employee petro = new Employee("petro19" /* + new Date() */, "pass", "Полухтович", "Петро", "Петрович",
				"666666666", "blabla@gmail.com");
		EmployeePage employeePage = page.clickAdd();
		employeePage.addEmployee(petro);

		// Assert.assertTrue(text.contains("Ви успішно додали нового
		// працівника!"));

		WebElement garazd = driver.findElement(By.cssSelector("button[ng-click='successController.ok()']"));
		String checkUser = garazd.getText();
		Assert.assertTrue(checkUser.contains("Гаразд"));
		garazd.click();

	}

	// public HomePage doLogin() {
	// LoginPage login = new LoginPage(driver);
	// User verificator = new User("verificator-lv", "pass");
	// return login.successUserLogin(verificator);
	// }

}

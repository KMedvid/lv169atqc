package com.softserve.edu.fedyk.mdVerificator.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.softserve.edu.fedyk.mdVerificator.model.pages.Application;
import com.softserve.edu.fedyk.mdVerificator.model.pages.ChangeVerificator;
import com.softserve.edu.fedyk.mdVerificator.model.pages.HomePage;
import com.softserve.edu.fedyk.mdVerificator.model.pages.LoginPage;
import com.softserve.edu.fedyk.mdVerificator.model.pages.VerificationProtocols;

public class Tests {
	private static final Logger LOGGER = Logger.getLogger(Tests.class);
	private WebDriver driver;

	// @AfterTest
	// private void logOut() {
	// HomePage page = new HomePage(driver);
	// page.logOut();
	// }
	@AfterTest

	public void tearDown() throws Exception {
		if (!driver.getCurrentUrl().contains("start")) {
			driver.get("http://localhost:8080/#/start");
		}
		// driver.quit();
	}

	@BeforeClass
	private void init() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LOGGER.info("Firefox fullscreen");

	}

	@BeforeMethod
	public void openLoginPage() {
		new Application(driver).loginButtonClick();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.doLogin();
		LOGGER.info("Log in as Verificator");
	}

	@Test
	public void checkProtocol() {
		LOGGER.info("!TEST - checkProtocol() - START!");
		HomePage page = new HomePage(driver);
		page.clickProtocols();
		VerificationProtocols protocols = new VerificationProtocols(driver);
		protocols.doFilter();
		LOGGER.info("!TEST - checkProtocol() - DONE!");

	}

	@Test
	public void editProtocol() {
		LOGGER.info("!TEST - editProtocol() - START!");
		HomePage page = new HomePage(driver);
		page.clickProtocols();
		VerificationProtocols protocols = new VerificationProtocols(driver);
		protocols.clickEdit();
		ChangeVerificator change = new ChangeVerificator(driver);
		change.changeToNoSuitable();
		LOGGER.info("!TEST - editProtocol() - DONE!");
		//TODO Check status in td
	}

	// @Test
	// public void addEmployee() throws InterruptedException {
	// HomePage page = new LoginPage(driver).doLogin();
	// page.click();
	// Employee petro = UserRepository.getPetro();
	// EmployeePage employeePage = page.clickAdd();
	// employeePage.addEmployee(petro);
	// employeePage.doAccept();
	//
	// }

	// public HomePage doLogin() {
	// LoginPage login = new LoginPage(driver);
	// User verificator = new User("verificator-lv", "pass");
	// return login.successUserLogin(verificator);
	// }

}

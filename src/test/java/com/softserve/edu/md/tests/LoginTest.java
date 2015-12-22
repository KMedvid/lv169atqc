package com.softserve.edu.md.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.md.data.User;
import com.softserve.edu.md.data.UserRepository;
import com.softserve.edu.md.pages.CalibratorHomePage;
import com.softserve.edu.md.pages.LoginPage;
import com.softserve.edu.md.pages.LoginValidatorPage;
import com.softserve.edu.md.pages.NewVerificationPage;
/**

 * Testing if we can log in at page http://localhost:8080/#/login
 * two tests in this class using right and wrong data to login
 * check if necessary elements are present on page

 * @version 1.00

 * @author Me

 */
public class LoginTest {
	
	private WebDriver driver;
	private SoftAssert softAssert;

	@BeforeClass
	public void oneTimeSetUp() {
		softAssert = new SoftAssert();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void oneTimeTearDown() {
		driver.close();

	}

	@AfterMethod
	public void afterMethod() {
		driver.get("http://localhost:8080/#/logout");

	}

	@DataProvider
	public Object[][] invalidUsers() {
		return new Object[][] { { UserRepository.get().getInvalidUser() }, };
	}

	@Test(dataProvider = "invalidUsers")
	public void checkInvalidLogin(User invalidUser) throws InterruptedException {
		driver.get("http://localhost:8080/#/login");
		LoginPage loginPage = new LoginPage(driver);
		LoginValidatorPage loginValidatorPage = loginPage
				.unsuccessfulLogin(invalidUser);
		Thread.sleep(2000);
		softAssert.assertEquals(loginValidatorPage
				.getValidatorText(), LoginValidatorPage.LOGIN_VALIDATOR_MESSAGE);
		Thread.sleep(2000);
		softAssert.assertAll();
	}

	@DataProvider
	public Object[][] calibratorUsers() {
		return new Object[][] { { UserRepository.get().getCalibratorUser() }, };
	}

	@Test(dataProvider = "calibratorUsers")
	public void checkCalibratorLogin(User calibrator) throws InterruptedException {
		driver.get("http://localhost:8080/#/login");
		CalibratorHomePage calhomepage = new LoginPage(driver).successCalLogin(calibrator);
		Thread.sleep(2000);
		softAssert.assertEquals(calhomepage.getLoginNameText(), LoginPage.LOGIN_ATTRIBUTES);
		softAssert.assertEquals(calhomepage.getTitleText(), LoginPage.TITLE);
		Thread.sleep(2000);
		calhomepage.gotoLogout();
		softAssert.assertAll();
	}

}

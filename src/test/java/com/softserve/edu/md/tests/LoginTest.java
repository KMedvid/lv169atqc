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

import com.softserve.edu.md.data.CombineProvider;
import com.softserve.edu.md.data.IUrls;
import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.UrlRepository;
import com.softserve.edu.md.data.User;
import com.softserve.edu.md.data.UserRepository;
import com.softserve.edu.md.pages.CalibratorHomePage;
import com.softserve.edu.md.pages.LoginPage;
import com.softserve.edu.md.pages.LoginStartPage;
import com.softserve.edu.md.pages.LoginValidatorPage;
import com.softserve.edu.md.pages.NewVerificationPage;

/**
 * 
 * Testing if we can log in at page http://localhost:8080/#/login two tests in
 * this class using right and wrong data to login check if necessary elements
 * are present on page
 * 
 * @version 1.00
 * 
 * @author Me
 * 
 */
public class LoginTest {

	// private WebDriver driver;
	private SoftAssert softAssert;

	@BeforeClass
	public void oneTimeSetUp() {
		softAssert = new SoftAssert();
	}

	@AfterMethod
	public void tearDown() {
		LoginStartPage.get().logout();
	}

	@AfterClass
	public void oneTimeTearDown() {
		LoginStartPage.get().close();
	}

	@DataProvider(parallel = true)
	public Object[][] invalidUsers() {
		return new Object[][] { { UserRepository.get().getInvalidUser(), UrlRepository.get().getLocalUrls() } };
	}

	//@Test(dataProvider = "invalidUsers")
	public void checkInvalidLogin(IUser invalidUser, IUrls urls) throws InterruptedException {
		LoginPage loginPage = LoginStartPage.get().load(urls);
		LoginValidatorPage loginValidatorPage = loginPage.unsuccessfulLogin(UserRepository.get().getInvalidUser());
		Thread.sleep(2000);
		softAssert.assertEquals(loginValidatorPage.getValidatorText(), LoginValidatorPage.LOGIN_VALIDATOR_MESSAGE);
		Thread.sleep(2000);
		softAssert.assertAll();
	}

	@DataProvider(parallel = true)
	public Object[][] calibratorUsers() {
		return new Object[][] { { UserRepository.get().getCalibratorUser(), UrlRepository.get().getLocalUrls() } };
	}

	@DataProvider
	public Object[][] existUsersCVS() {
		return CombineProvider.get().getExistUsersCVS(UrlRepository.get().getLocalUrls());
	}

	@Test(dataProvider = "existUsersCVS")
	public void checkCalibratorLogin(IUser calibrator, IUrls urls) throws InterruptedException {
		LoginPage loginPage = LoginStartPage.get().load(urls);
		CalibratorHomePage calhomepage = loginPage.successCalLogin(UserRepository.get().getCalibratorUser());
		Thread.sleep(2000);
		softAssert.assertEquals(calhomepage.getLoginNameText(), LoginPage.LOGIN_ATTRIBUTES);
		softAssert.assertEquals(calhomepage.getTitleText(), LoginPage.TITLE);
		Thread.sleep(2000);
		calhomepage.gotoLogout();
		softAssert.assertAll();
	}

}

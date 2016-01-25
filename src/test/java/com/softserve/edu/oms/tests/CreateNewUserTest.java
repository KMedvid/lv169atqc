package com.softserve.edu.oms.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.oms.data.IUrls;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UrlRepository;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.LoginStartPage;

public class CreateNewUserTest {
	private SoftAssert softAssert;
	public static final Logger logger = LoggerFactory.getLogger(CreateNewUserTest.class);

	@BeforeTest
	public void beforeTest() {
		softAssert = new SoftAssert();
	}

	@AfterMethod
	public void tearDown() {
		softAssert.assertAll();
		LoginStartPage.get().logout();
	}

	@AfterClass
	public void oneTimeTearDown() {
		LoginStartPage.get().close();
		logger.info("CreateNewUserTest - Done");
	}

	@DataProvider
	public Object[][] newUser() {
		return new Object[][] { { UserRepository.get().getNewUser(), UserRepository.get().getAdminUser(),
				UrlRepository.get().getLocalUrls() } };
	}

	@Test(dataProvider = "newUser")
	public void createNewUser(IUser newUser, IUser admin, IUrls urls) {
		logger.info("CreateNewUserTest - Start");
		// PreCondition
		AdministrationPage administrationPage = LoginStartPage.get().load(urls).successAdminLogin(admin)
				.gotoAdministration().gotoCreateNewUser().successCreateNewUser(newUser);
		administrationPage.searchByLoginName(newUser);
		// Check
		softAssert.assertEquals(administrationPage.getFirstnameText(), newUser.getFirstname());
		softAssert.assertEquals(administrationPage.getLastnameText(), newUser.getLastname());
	}
}
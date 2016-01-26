package com.softserve.edu.oms.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.data.StartData;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.StartPage;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;

public class CreateNewUserTest {
	private SoftAssert softAssert;
	StartData startdata;
	public static final Logger logger = LoggerFactory.getLogger(CreateNewUserTest.class);

	@BeforeTest
	public void beforeTest() {
		startdata = new StartData("http://localhost:8080/OMS/login.htm",
								"http://localhost:8080/OMS/logout.htm", 
								"",	"firefox", "");
		softAssert = new SoftAssert();
	}

	@AfterMethod
	public void tearDown() {
		softAssert.assertAll();
		StartPage.get().logout();
	}

	@AfterClass
	public void oneTimeTearDown() {
		StartPage.get().close();
		logger.info("CreateNewUserTest - Done");
	}

	@DataProvider
	public Object[][] newUser() {
		return new Object[][] { { UserRepository.get().getNewUser()
								, UserRepository.get().getAdminUser()} 
		};
	}

	@Test(dataProvider = "newUser")
	public void createNewUser(IUser newUser, IUser admin) {
		logger.info("CreateNewUserTest - Start");
		// PreCondition
		StartPage.get().load(startdata);
		AdministrationPage administrationPage = StartPage.get().load()
				.successAdminLogin(admin)
				.gotoAdministration()
				.gotoCreateNewUser()
				.createNewUser(newUser);
		 administrationPage.searchByLoginName(newUser);
		// Check
		 softAssert.assertEquals(administrationPage.getFirstnameText(),newUser.getFirstname());
		 softAssert.assertEquals(administrationPage.getLastnameText(), newUser.getLastname());
	}
}
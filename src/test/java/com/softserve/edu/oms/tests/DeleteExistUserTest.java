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

public class DeleteExistUserTest {
	private SoftAssert softAssert;
	StartData startdata;
	public static final Logger logger = LoggerFactory.getLogger(DeleteExistUserTest.class);

	@BeforeTest
	public void beforeTest() {
		 startdata = new StartData("http://localhost:8080/OMS/login.htm",
				"http://localhost:8080/OMS/logout.htm", 
				"",	"firefox", "");
		softAssert = new SoftAssert();
	}

	@AfterMethod
	public void afterMethod() {
		softAssert.assertAll();
		StartPage.get().logout();
	}

	@AfterClass
	public void afterClass() {
		StartPage.get().close();
		logger.info("DeleteExistUserTest - Done");
	}

	@DataProvider
	public Object[][] delUser() {
		return new Object[][] {
			{ UserRepository.get().getDelUser(),
			  UserRepository.get().getAdminUser()}
			};
	}

	@Test(dataProvider = "delUser")
	public void createNewUser(IUser delUser, IUser admin) throws InterruptedException {
		logger.info("DeleteExistUserTest - Done");
		// PreCondition
		StartPage.get().load(startdata);
		AdministrationPage administrationPage = 
				StartPage.get().load()
				.successAdminLogin(admin)
				.gotoAdministration()
				.gotoCreateNewUser()
				.createNewUser(delUser);
		administrationPage.deleteByLoginName(delUser);
		// Check
		softAssert.assertEquals(administrationPage.getUsersFound().getText(), "1");

	}
}

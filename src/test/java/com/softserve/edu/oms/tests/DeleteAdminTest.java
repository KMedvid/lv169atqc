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
import com.softserve.edu.specs.AssertWrapper;

public class DeleteAdminTest {
	private SoftAssert softAssert;
	StartData startdata;
	public static final Logger logger = LoggerFactory.getLogger(DeleteAdminTest.class);

	@BeforeTest
	public void beforeTest() {
		startdata = new StartData("http://localhost:8080/OMS/login.htm",
				"http://localhost:8080/OMS/logout.htm", 
				"",	"firefox", "");
		softAssert = new SoftAssert();
	}

	@AfterMethod
	public void afterMethod() {
		StartPage.get().logout();

	}

	@AfterClass
	public void afterClass() {
		StartPage.get().close();
		softAssert.assertAll();
		logger.info("DeleteAdminTest - Done");
	}

	@DataProvider
	public Object[][] delAdmin() {
		return new Object[][] {  {UserRepository.get().getNewUser()}  };
	}

	@Test(dataProvider = "delAdmin")
	public void createNewUser(IUser delAdmin) throws InterruptedException {
		logger.info("DeleteAdminTest - Done");
		// PreCondition
		StartPage.get().load(startdata);
		AdministrationPage administrationPage = StartPage.get().load()
				.successAdminLogin(delAdmin)
				.gotoAdministration();
		administrationPage.searchByLoginName(delAdmin);
		administrationPage.getDelete().isDisplayed();
		// Check
		softAssert.assertEquals(administrationPage.getDelete().isDisplayed(), false,
				"Administrator cannot be deleted by himself!");
		administrationPage.deleteByLoginName(delAdmin);
		//AssertWrapper.get().forElement(administrationPage.getDelete()).isVisible();
		logger.error("DeleteAdminTest - Fail");
	}
}

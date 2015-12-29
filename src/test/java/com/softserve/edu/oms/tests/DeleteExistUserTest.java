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

public class DeleteExistUserTest {
	private SoftAssert softAssert;
	public static final Logger logger = LoggerFactory.getLogger(DeleteExistUserTest.class);

	@BeforeTest
	public void beforeTest() {
		softAssert = new SoftAssert();
	}

	@AfterMethod
	public void afterMethod() {
		softAssert.assertAll();
		LoginStartPage.get().logout();
	}

	@AfterClass
	public void afterClass() {
		LoginStartPage.get().close();
		logger.info("DeleteExistUserTest - Done");
	}

	@DataProvider
	public Object[][] delUser() {
		return new Object[][] { { UserRepository.get().getDelUser(), UserRepository.get().getAdminUser(),
				UrlRepository.get().getLocalUrls() } };
	}

	@Test(dataProvider = "delUser")
	public void createNewUser(IUser delUser, IUser admin, IUrls urls) throws InterruptedException {
		logger.info("DeleteExistUserTest - Done");
		// PreCondition
		AdministrationPage administrationPage = LoginStartPage.get().load(urls).successAdminLogin(admin)
				.gotoAdministration().gotoCreateNewUser().successCreateNewUser(delUser);
		administrationPage.searchByLoginName(delUser);
		administrationPage.deleteSelectedUser();
		// Check
		softAssert.assertEquals(administrationPage.getUsersFoundText(), "1");

	}
}

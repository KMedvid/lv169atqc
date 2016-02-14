package com.softserve.edu.oms.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.data.StartData;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.StartDataRepository;
import com.softserve.edu.oms.data.StartPage;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.specs.AssertWrapper;

public class CreateNewUserTest {
	public static final Logger logger = LoggerFactory.getLogger(CreateNewUserTest.class);

	@AfterClass
	public void oneTimeTearDown() {
		StartPage.get().close();
		logger.info("CreateNewUserTest - Complete");
	}

	@AfterMethod
	public void tearDown() {
		AssertWrapper.get().check();
		StartPage.get().logout();
	}

	@DataProvider
	public Object[][] newUser() {
		StartData startData = StartDataRepository.get().getFirefoxLocal();
		return new Object[][] {
			{ startData, UserRepository.get().getNewUser(), UserRepository.get().getAdminUser() } };
	}

	@Test(dataProvider = "newUser")
	public void createNewUser(StartData startData,IUser newUser, IUser admin) {
		logger.info("CreateNewUserTest - Start");
		// PreCondition
		StartPage.get().load(startData);
		CreateNewUserPage createNewUserPage = StartPage.get().load()
				.successAdminLogin(admin)
				.gotoAdministration()
				.gotoCreateNewUser();
		// Test Operation
		AdministrationPage administrationPage = createNewUserPage.createNewUser(newUser);
						   administrationPage.searchByLoginName(newUser);
		// Check
		AssertWrapper.get()
        .forElement(administrationPage.getFirstname().getText())
            .valueMatch(newUser.getFirstname())
            .next()
        .forElement(administrationPage.getLastname().getText())
        	.valueMatch(newUser.getLastname())
        	.next()
        .forElement(administrationPage.getLogin().getText())
            .valueMatch(newUser.getLogin());
	}
}
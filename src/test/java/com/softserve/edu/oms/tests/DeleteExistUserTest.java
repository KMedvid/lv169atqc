package com.softserve.edu.oms.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.data.StartData;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.StartDataRepository;
import com.softserve.edu.oms.data.StartPage;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.AdministrationPage;
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.pages.HomePage;
import com.softserve.edu.specs.AssertWrapper;

public class DeleteExistUserTest {
	public static final Logger logger = LoggerFactory.getLogger(DeleteExistUserTest.class);
	
	@AfterClass
	public void afterClass() {
		StartPage.get().close();
		logger.info("DeleteExistUserTest - Complete");
	}

	@AfterMethod
	public void afterMethod() {
		AssertWrapper.get().check();
		StartPage.get().logout();
	}

	@DataProvider
	public Object[][] delUser() {
		StartData startData = StartDataRepository.get().getFirefoxLocal();
		return new Object[][] {
			{ startData, UserRepository.get().getDelUser(),
						 UserRepository.get().getAdminUser()}
		};
	}

	@Test(dataProvider = "delUser")
	public void deleteExistUser(StartData startData, IUser delUser, IUser admin) {
		logger.info("DeleteExistUserTest - Start");
		// PreCondition
		StartPage.get().load(startData);
		CreateNewUserPage createNewUserPage =StartPage.get().load() 
                .successAdminLogin(admin)
                .gotoAdministration()
                .gotoCreateNewUser();
        // Test Operation
        AdministrationPage administrationPage = createNewUserPage
                .createNewUser(delUser);     
        				   administrationPage.searchByLoginName(delUser);
        // Check
		AssertWrapper.get()
				.forElement(administrationPage.getFirstname().getText())
				.valueMatch(delUser.getFirstname())
				.next()
				.forElement(administrationPage.getLastname().getText())
				.valueMatch(delUser.getLastname())
				.next()
				.forElement(administrationPage.getLogin().getText())
				.valueMatch(delUser.getLogin());
        // Test Operation
        HomePage homePage = administrationPage.logout()
                .successUserLogin(delUser);
        // Check
        AssertWrapper.get()
        .forElement(homePage.getFirstname())
            .valueMatch(delUser.getFirstname())
            .valueStartsWith(delUser.getFirstname().substring(0,1))
            .next()
        .forElement(homePage.getLastname())
            .valueMatch(delUser.getLastname())
            .next()
        .forElement(homePage.getRole().getText())
            .valueMatch(delUser.getRole());
        // Test Operation
        administrationPage = homePage.logout()
                .successAdminLogin(admin)
                .gotoAdministration();
        administrationPage.deleteByLoginName(delUser);
	}
}

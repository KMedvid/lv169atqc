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
import com.softserve.edu.oms.pages.CreateNewUserPage;
import com.softserve.edu.oms.pages.HomePage;

public class DeleteExistUserTest {
	private SoftAssert softAssert;
	StartData startData;
	public static final Logger logger = LoggerFactory.getLogger(DeleteExistUserTest.class);

	@AfterClass
	public void afterClass() {
		StartPage.get().close();
		logger.info("DeleteExistUserTest - Complete");
	}
	
	@BeforeTest
	public void beforeTest() {
		 startData = new StartData("http://localhost:8080/OMS/login.htm",
				"http://localhost:8080/OMS/logout.htm", 
				"",	"firefox", "");
		softAssert = new SoftAssert();
	}

	@AfterMethod
	public void afterMethod() {
		softAssert.assertAll();
		StartPage.get().logout();
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
        Thread.sleep(2000);
        // Check
        softAssert.assertEquals(administrationPage.getFirstnameText(),
                delUser.getFirstname());
        softAssert.assertEquals(administrationPage.getLastnameText(),
                delUser.getLastname());
        softAssert.assertEquals(administrationPage.getLoginText(),
                delUser.getLogin());
        // Test Operation
        HomePage homePage = administrationPage.logout()
                .successUserLogin(delUser);
        Thread.sleep(2000);
        // Check
        softAssert.assertEquals(homePage.getFirstnameText(),
                delUser.getFirstname());
        softAssert.assertEquals(homePage.getLastnameText(),
                delUser.getLastname());
        softAssert.assertEquals(homePage.getRoleText(),
                delUser.getRole());
        // Test Operation
        administrationPage = homePage.logout()
                .successAdminLogin(admin)
                .gotoAdministration();
        Thread.sleep(2000);
        // Return to Previous State
        administrationPage.deleteByLoginName(delUser);		
	}
}

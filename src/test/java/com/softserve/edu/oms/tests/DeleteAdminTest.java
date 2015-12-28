package com.softserve.edu.oms.tests;

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

public class DeleteAdminTest {
	private SoftAssert softAssert;

	@BeforeTest
	public void beforeTest() {
		softAssert = new SoftAssert();
	}

	@AfterMethod
	public void afterMethod() {		
		LoginStartPage.get().logout();
		
	}

	@AfterClass
	public void afterClass() {
		LoginStartPage.get().close();
		softAssert.assertAll();
	}

	@DataProvider
	public Object[][] delAdmin() {
		return new Object[][] { { UserRepository.get().getNewUser(), UrlRepository.get().getLocalUrls() } };
	}

	@Test(dataProvider = "delAdmin")
	public void createNewUser(IUser delAdmin, IUrls urls){
		// PreCondition
		AdministrationPage administrationPage = LoginStartPage.get().load(urls).successAdminLogin(delAdmin)
				.gotoAdministration();
		administrationPage.searchByLoginName(delAdmin);
		administrationPage.getDelete().isDisplayed();
		// Check
		softAssert.assertEquals(administrationPage.getDelete().isDisplayed(), false,
				"Administrator cannot be deleted by himself!");

	}
}

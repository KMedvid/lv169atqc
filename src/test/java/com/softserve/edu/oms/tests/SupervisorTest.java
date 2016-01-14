package com.softserve.edu.oms.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.oms.data.IUrls;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.UrlRepository;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.LoginPage;
import com.softserve.edu.oms.pages.LoginStartPage;
import com.softserve.edu.oms.pages.LoginValidatorPage;
import com.softserve.edu.oms.pages.SupervisorHomePage;

public class SupervisorTest {
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
		LoginStartPage.get().quit();
	}

	@DataProvider 
	public Object[][] existUsers() {
		return new Object[][] { { UserRepository.get().getSuperVisorUser(), UrlRepository.get().getLocalUrls() } };
	}

	@DataProvider
	public Object[][] invalidUsers() {
		return new Object[][] { { UserRepository.get().getInvalidUser(), UrlRepository.get().getLocalUrls() }, };
	}

	@Test(dataProvider = "existUsers")
	public void checkLoginSupervisor(IUser svisor, IUrls urls) {
		// PreCondition
		SupervisorHomePage svisorHomePage = LoginStartPage.get().load(urls).successSvisorLogin(svisor);

		// Test Operation
		Assert.assertEquals(svisorHomePage.getRoleText(), svisor.getRole());
	}

	@Test(dataProvider = "invalidUsers")
	public void checkLoginInvalidSupervisor(IUser svisor, IUrls urls) {
		// PreCondition
		LoginValidatorPage loginValidatorPage = LoginStartPage.get().load(urls).unsuccessfulLogin(svisor);

		// Test Operation
		Assert.assertEquals(loginValidatorPage.getStartValidatorText(), LoginValidatorPage.START_VALIDATOR_MESSAGE);
	}

	@Test(dataProvider = "existUsers")
	public void checkLoginCheckboxSupervisor(IUser svisor, IUrls urls) {
		// PreCondition
		LoginPage loginPage = LoginStartPage.get().load(urls);
		loginPage.clickCheckbox();
		SupervisorHomePage svisorHomePage = loginPage.successSvisorLogin(svisor);

		// Test Operation
		softAssert.assertEquals(svisorHomePage.getRoleText(), svisor.getRole());

		svisorHomePage.clickLogout();
		loginPage.clickPassword();
		loginPage.clearPassword();
		loginPage.setPassword(svisor.getPassword());
		loginPage.clickSubmit();
		
		softAssert.assertEquals(svisorHomePage.getRoleText(), svisor.getRole());
		softAssert.assertAll();

	}
}

package com.softserve.edu.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.atqc.loggers.LoggerUtils;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.data.StartPage;
import com.softserve.edu.oms.data.UserRepository;
import com.softserve.edu.oms.pages.ItemManagementPage;
import com.softserve.edu.oms.pages.SupervisorHomePage;

public class SupervisorTest {
	StartData startData = new StartData("http://localhost:8080/OMS/login.htm", 
			"http://localhost:8080/OMS/logout.htm",
			"", "firefox", "");

	@BeforeClass
	public void oneTimeSetUp() {

	}

	@AfterClass
	public void oneTimeTearDown() {
		BrowserUtils.quitAll();
	}

	@BeforeMethod
	public void setUp() {

	}

	@AfterMethod
	public void tearDown() {
		StartPage.get().logout();
	}

	@DataProvider // (parallel = true)
	public Object[][] allUsers() {
		return new Object[][] { { UserRepository.get().getSupervisorUser() } };
	}

	@Test(dataProvider = "allUsers")
	public void checkSupervisorAddProduct(IUser user) throws InterruptedException {
		final String PRODUCT_NAME = "Shirt";
		final String PRODUCT_DESCRIPTION = "Green cotton";
		final Double PRODUCT_PRICE = 100.5;

		// Preconditions.
		LoggerUtils.get().infoLog("Load browser");
		StartPage.get().load(startData);
		
		// Test Steps.
		LoggerUtils.get().infoLog("Go to SupervisorHomePage");
		SupervisorHomePage homepage = StartPage.get().load().successSupervisorLogin(user);

		// Checking role.
		LoggerUtils.get().infoLog("Checking correct user logging");
		Assert.assertEquals(homepage.getRoleText(), user.getRole());
		//

		ItemManagementPage itemManagement = homepage.gotoItemManagement();
		LoggerUtils.get().infoLog("Add new product: " + PRODUCT_NAME);
		itemManagement = itemManagement.gotoAddProduct().addProduct(PRODUCT_NAME, PRODUCT_DESCRIPTION, PRODUCT_PRICE);
		LoggerUtils.get().infoLog("SearchP roduct By Name: " + PRODUCT_NAME);
		itemManagement.searchProductByName(PRODUCT_NAME);
	
		// Check
		LoggerUtils.get().infoLog("Checking added product : " + PRODUCT_NAME);
		Assert.assertEquals(itemManagement.getNameText(), PRODUCT_NAME);

	}

}

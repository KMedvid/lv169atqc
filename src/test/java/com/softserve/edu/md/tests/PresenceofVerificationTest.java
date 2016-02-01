package com.softserve.edu.md.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.md.data.CombineProvider;
import com.softserve.edu.md.data.IUrls;
import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.StartPage;
import com.softserve.edu.md.data.UrlRepository;
import com.softserve.edu.md.data.UserRepository;
import com.softserve.edu.md.pages.CalibratorHomePage;
import com.softserve.edu.md.pages.NewVerificationPage;

/**
 * 
 * Testing if we can log in at page http://java.training.local:8080/#/login two
 * tests in this class using right and wrong data to login check if necessary
 * elements are present on page
 * 
 * @version 1.00
 * 
 * @author Me
 * 
 */

public class PresenceofVerificationTest {

	private SoftAssert softAssert;
	public static final Logger logger = LoggerFactory.getLogger(SendtoCalibratorStationTest.class);
	StartData startData = new StartData("http://localhost:8080/#/login", 
			"http://localhost:8080/#/logout", "implicit", "firefox", "");

	@BeforeClass
	public void oneTimeSetUp() {
		softAssert = new SoftAssert();
	}

	@AfterMethod
	public void tearDown() {
		StartPage.get().logout();
	}

	@AfterClass
	public void oneTimeTearDown() {
		BrowserUtils.closeAll();
	}
	
	@DataProvider
	public Object[][] calibratorUsers() {
		return new Object[][] { { UserRepository.get().getCalibratorUser(), UrlRepository.get().getTrainingUrls() } };
	}

	@DataProvider
	public Object[][] calibratorUsersCVS() {
		return CombineProvider.get().getExistUsersCVS(UrlRepository.get().getTrainingUrls());
	}
	
	@Test(dataProvider = "calibratorUsers")
	public void checkPresenceofVerification(IUser calibrator, IUrls urls) throws InterruptedException {
		StartPage.get().load(startData);
		CalibratorHomePage calhomepage = StartPage.get().load().successCalLogin(calibrator);
		String verificationname = calhomepage.getVerificationClientName();
		Thread.sleep(2000);
		calhomepage.clickSelectPersonButton();
		Thread.sleep(2000);
		NewVerificationPage newVerificationPage = calhomepage.gotoverificationpage();
		Thread.sleep(2000);
		softAssert.assertEquals(
				newVerificationPage.getClientDataSearchResultText()
			.substring(0, verificationname.length()),
				(verificationname));
		Thread.sleep(2000);
		softAssert.assertAll();
	}
}

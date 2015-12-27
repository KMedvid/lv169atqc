package com.softserve.edu.md.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.md.data.IUrls;
import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.UrlRepository;
import com.softserve.edu.md.data.User;
import com.softserve.edu.md.data.UserRepository;
import com.softserve.edu.md.pages.CalibratorHomePage;
import com.softserve.edu.md.pages.LoginPage;
import com.softserve.edu.md.pages.LoginStartPage;
import com.softserve.edu.md.pages.NewVerificationPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
/**

 * Testing search by fields in New Verifications in Water Meter project
 * at page 	http://localhost:8080/employee#/calibrator/verifications/new"
 * check if result of serch are present on page

 * @version 1.00

 * @author Me

 */
public class VerificationSearchTest {

	private SoftAssert softAssert;

	@BeforeClass
	public void beforeSearch() {
		softAssert = new SoftAssert();
	}

	   @AfterMethod
	    public void tearDown() {
	        LoginStartPage.get().logout();
	    }

	    @AfterClass
	    public void oneTimeTearDown() {
	        LoginStartPage.get().close();
	    }
	    
	@DataProvider
	public Object[][] calibratorUsers() {
		return new Object[][] { 
			{ UserRepository.get().getCalibratorUser(), UrlRepository.get().getLocalUrls() }, 
			};
	}

	@Test(dataProvider = "calibratorUsers")
	public void checkVerificationSearch(IUser calibrator, IUrls urls) throws InterruptedException, IOException
	{
		LoginPage loginPage = LoginStartPage.get().load(urls);	
		CalibratorHomePage calhomepage = loginPage
				.successCalLogin(UserRepository.get().getCalibratorUser());
		NewVerificationPage newVerificationPage = calhomepage.gotoverificationpage();
		Thread.sleep(2000);
    	softAssert.assertEquals(newVerificationPage
    			.searchSearchNumber(NewVerificationPage.SERCH_NUMBER_DATA),
    			NewVerificationPage.SERCH_NUMBER_DATA );
    	Thread.sleep(2000);
		softAssert.assertEquals(newVerificationPage
				.searchClientData(NewVerificationPage.SEARCH_CLIENT_NAMES_DATA), 
				NewVerificationPage.SEARCH_CLIENT_NAMES_DATA);
		Thread.sleep(2000);
		softAssert.assertEquals(newVerificationPage
				.searchClientStreet(NewVerificationPage.SEARCH_STREET_DATA),
				NewVerificationPage.SEARCH_STREET_DATA);
		Thread.sleep(2000);
		softAssert.assertEquals(newVerificationPage
				.searchWorkerData(NewVerificationPage.SEARCH_WORKER_NAMES_DATA),
				NewVerificationPage.SEARCH_WORKER_NAMES_DATA);
		Thread.sleep(2000);
		newVerificationPage.gotoLogout();
		softAssert.assertAll();
	}

}

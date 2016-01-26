package com.softserve.edu.md.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.atqc.data.StartData;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.md.data.IUrls;
import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.StartPage;
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
	StartData startData = new StartData("http://java.training.local:8080/#/login",
			"http://java.training.local:8080/#/logout","","firefox","");
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
		return new Object[][] { 
			{ UserRepository.get().getCalibratorUser(), UrlRepository.get().getTrainingUrls() }, 
			};
	}

	@Test(dataProvider = "calibratorUsers")
	public void checkVerificationSearch(IUser calibrator, IUrls urls) throws InterruptedException, IOException
	{
		
		StartPage.get().load(startData);
        CalibratorHomePage calhomepage = StartPage.get().load().successCalLogin(calibrator);	
		NewVerificationPage newVerificationPage = calhomepage.gotoverificationpage();
		Thread.sleep(2000);
    	softAssert.assertEquals(newVerificationPage
    			.searchByNubmerOfHouse(NewVerificationPage.SERCH_NUMBER_OF_HOUSE_DATA),
    			NewVerificationPage.SERCH_NUMBER_OF_HOUSE_DATA);
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
				.searchDistrict(NewVerificationPage.SEARCH_DISTRICT_DATA),
				NewVerificationPage.SEARCH_DISTRICT_DATA);
		Thread.sleep(2000);
	//	newVerificationPage.gotoLogout();
		softAssert.assertAll();
		
	}

}

package com.softserve.edu.md.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.md.data.IUrls;
import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.UrlRepository;
import com.softserve.edu.md.data.UserRepository;
import com.softserve.edu.md.pages.CalibratorHomePage;
import com.softserve.edu.md.pages.LoginPage;
import com.softserve.edu.md.pages.LoginStartPage;
import com.softserve.edu.md.pages.MeasuringEquipmentPage;
import com.softserve.edu.md.pages.MeasuringEquipmentPage.MeasuringEquipmentEditPage;

/**
 * 
 * Testing if we can edit device at page
 * http://localhost:8080/employee#/calibrator/mEquipment/ test if after edit of
 * device message are visible on screen
 * 
 * @version 1.00
 * 
 * @author Me
 * 
 */
public class EquipmentEditNotificationTest {
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
		return new Object[][] { { UserRepository.get().getCalibratorUser(), UrlRepository.get().getLocalUrls() } };
	}

	@Test(dataProvider = "calibratorUsers")
	public void checkEquipmentEdit(IUser calibrator, IUrls urls) throws InterruptedException {
		LoginPage loginPage = LoginStartPage.get().load(urls);	
		CalibratorHomePage calhomepage = loginPage.
				successCalLogin(UserRepository.get().getCalibratorUser());	
		Thread.sleep(2000);	
		MeasuringEquipmentPage newMeasuringEquipmentPage = calhomepage.gotoMeasuringEquipmentPage();
		
		MeasuringEquipmentPage.MeasuringEquipmentEditPage newMeasuringEquipmentEditPage = 
				newMeasuringEquipmentPage.gotoMeasuringEquipmentEditForm();	

		newMeasuringEquipmentEditPage.editFields_with_Drop_Form(MeasuringEquipmentEditPage.FULL_EDIT_NAME_DATA,
				MeasuringEquipmentEditPage.FULL_EDIT_TYPE_DATA, MeasuringEquipmentEditPage.FULL_EDIT_PRODUCER_DATA,
				MeasuringEquipmentEditPage.FULL_EDIT_INTERVAL_DATA);
		Thread.sleep(2000);

		newMeasuringEquipmentEditPage.checkEdit_Notification_Existence();
	}

}

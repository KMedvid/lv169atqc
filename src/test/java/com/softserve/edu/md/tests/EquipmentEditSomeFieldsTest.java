package com.softserve.edu.md.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.md.data.User;
import com.softserve.edu.md.data.UserRepository;
import com.softserve.edu.md.pages.CalibratorHomePage;
import com.softserve.edu.md.pages.LoginPage;
import com.softserve.edu.md.pages.MeasuringEquipmentPage;
import com.softserve.edu.md.pages.NewVerificationPage;
import com.softserve.edu.md.pages.MeasuringEquipmentPage.MeasuringEquipmentEditPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
/**

 * Testing if we can edit device 
 * at page http://localhost:8080/employee#/calibrator/mEquipment/
 * test if edit of device work properly when we change fields "name" and "type"
 * check if necessary elements are present on page

 * @version 1.00

 * @author Me

 */
public class EquipmentEditSomeFieldsTest {
	
	private WebDriver driver;
	private SoftAssert softAssert;

	@BeforeClass
	public void beforeSearch() {
		softAssert = new SoftAssert();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "calibratorUsers")
	public void checkEquipmentEdit(User calibrator) throws InterruptedException {
		driver.get("http://localhost:8080/#/login");

		CalibratorHomePage calhomepage = new LoginPage(driver).successCalLogin(calibrator);
		driver.get("http://localhost:8080/employee#/calibrator/mEquipment/");
		Thread.sleep(2000);
		MeasuringEquipmentPage newMeasuringEquipmentPage = new MeasuringEquipmentPage(driver)
				.successMeasuringequipment(calibrator);

		newMeasuringEquipmentPage.getEditButton().click();
		Thread.sleep(2000);
		MeasuringEquipmentPage.MeasuringEquipmentEditPage newMeasuringEquipmentEditPage = newMeasuringEquipmentPage.new MeasuringEquipmentEditPage(driver)
				.successequipmentEdit(calibrator);

		newMeasuringEquipmentEditPage
				.editFields_without_Drop_Form(
						MeasuringEquipmentEditPage.PARTIAL_EDIT_NAME_DATA, 
						MeasuringEquipmentEditPage.PARTIAL_EDIT_TYPE_DATA);
		Thread.sleep(2000);
		softAssert.assertEquals(newMeasuringEquipmentEditPage
				.checkEdit_elements_existence(),
				MeasuringEquipmentEditPage.PARTIAL_EDIT_NAME_DATA);
		softAssert.assertAll();
	}

	@AfterMethod
	public void afterMethod() {
		driver.get("http://localhost:8080/#/logout");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	@DataProvider
	public Object[][] calibratorUsers() {
		return new Object[][] { { UserRepository.get().getCalibratorUser() }, };
	}

}

package com.softserve.edu.md.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.md.data.User;
import com.softserve.edu.md.data.UserRepository;
import com.softserve.edu.md.pages.CalibratorHomePage;
import com.softserve.edu.md.pages.LoginPage;
import com.softserve.edu.md.pages.MeasuringEquipmentPage;
import com.softserve.edu.md.pages.MeasuringEquipmentPage.MeasuringEquipmentEditPage;
/**

 * Testing if we can edit device 
 * at page http://localhost:8080/employee#/calibrator/mEquipment/
 * test if edit of device work properly when we clear all previous data
 * and enter new data
 * check if necessary elements are present on page

 * @version 1.00

 * @author Me

 */
public class EquipmentEditAllFieldsTest {
	
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
		MeasuringEquipmentPage.MeasuringEquipmentEditPage newMeasuringEquipmentEditPage = newMeasuringEquipmentPage.new MeasuringEquipmentEditPage(
				driver).successequipmentEdit(calibrator);

		newMeasuringEquipmentEditPage.editFields_with_Drop_Form(
				MeasuringEquipmentEditPage.FULL_EDIT_NAME_DATA,
				MeasuringEquipmentEditPage.FULL_EDIT_TYPE_DATA,
				MeasuringEquipmentEditPage.FULL_EDIT_PRODUCER_DATA, 
				MeasuringEquipmentEditPage.FULL_EDIT_INTERVAL_DATA);
		Thread.sleep(2000);
		softAssert.assertEquals(newMeasuringEquipmentEditPage
				.checkEdit_elements_existence(), 
				MeasuringEquipmentEditPage.FULL_EDIT_NAME_DATA);
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

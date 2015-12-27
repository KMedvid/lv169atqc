package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.User;
import com.softserve.edu.md.pages.MeasuringEquipmentPage.MeasuringEquipmentEditPage;

public class MeasuringEquipmentPage {
	
	private WebDriver driver;
	private WebElement editbutton;

	public MeasuringEquipmentPage(WebDriver driver) {
	    this.driver = driver;
		this.editbutton = driver.findElement(By.cssSelector(
				"td.text-center img[src='/resources/assets/button-icons/measuring-equipments%20icons/test-edit.png']"));
	}

	public WebElement getEditButton() {
		return this.editbutton;
	}

	public MeasuringEquipmentPage successMeasuringequipment(IUser calibrator) {
		return new MeasuringEquipmentPage(driver);
	}
	
	public MeasuringEquipmentPage.MeasuringEquipmentEditPage gotoMeasuringEquipmentEditForm() {
		this.editbutton.click();
		return new MeasuringEquipmentPage.MeasuringEquipmentEditPage(driver);
	}
	
	public class MeasuringEquipmentEditPage {
		// constants with testing data
		public static final String PARTIAL_EDIT_NAME_DATA = "ANOTHERNAME";
		public static final String PARTIAL_EDIT_TYPE_DATA = "WATER";
		//constants with testing data
		public static final String FULL_EDIT_NAME_DATA = "SOMANAME";
		public static final String FULL_EDIT_TYPE_DATA = "COLDWATER";
		public static final String FULL_EDIT_PRODUCER_DATA = "LONDON";
	    public static final String FULL_EDIT_INTERVAL_DATA = "145";
	    
		private WebDriver driver;
		private WebElement equipmentname;
		private WebElement equipmenttype;
		private WebElement equipmentproducer;
		private WebElement equipmentinterval;
		private WebElement changebutton;
		private WebElement dropformbutton;
		private WebElement cancelbutton;

		/**
		 * 
		 * Constructor of Measuring Equipment Edit Page. Check if all necessary
		 * fields exists
		 * 
		 */
		public MeasuringEquipmentEditPage(WebDriver driver) {
			this.driver = driver;
			this.equipmentname = driver.findElement(By.cssSelector("input#name"));
			this.equipmenttype = driver.findElement(By.cssSelector("input#deviceType"));
			this.equipmentproducer = driver.findElement(By.cssSelector("input#manufacturer"));
			this.equipmentinterval = driver.findElement(By.cssSelector("input#verificationInterval"));
			this.changebutton = driver.findElement(By.cssSelector("button.btn.btn-success.ng-binding"));
			this.dropformbutton = driver.findElement(By.cssSelector("a.btn.btn-warning.ng-binding"));
			this.cancelbutton = driver.findElement(By.cssSelector("button.btn.btn-danger.pull-right.ng-binding"));
		}

		public WebElement getEquipmentname() {
			return this.equipmentname;
		}

		public WebElement getEquipmenttype() {
			return this.equipmenttype;
		}

		public WebElement getEquipmentproducer() {
			return this.equipmentproducer;
		}

		public WebElement getEquipmentinterval() {
			return this.equipmentinterval;
		}

		public WebElement getChangebutton() {
			return this.changebutton;
		}

		public WebElement getDropformbutton() {
			return this.dropformbutton;
		}

		public WebElement getCancelbuttonText() {
			return this.cancelbutton;
		}

		public String getEquipmentnameText() {
			return this.equipmentname.getText();
		}

		public String getEquipmenttypeText() {
			return this.equipmenttype.getText();
		}

		public String getEquipmentproducerText() {
			return this.equipmentproducer.getText();
		}

		public String getEquipmentintervalText() {
			return this.equipmentinterval.getText();
		}
		
		/**
		 * 
		 * inner class of class MeasuringEquipment for edit form
		 */
		public MeasuringEquipmentEditPage successequipmentEdit(IUser calibrator) {
			return new MeasuringEquipmentEditPage(driver);
		}

		/**
		 * Edit all device fields using correct data and drop previous data
		 */
		public void editFields_with_Drop_Form(String TestData1, String TestData2, String TestData3, String TestData4) {
			getDropformbutton().click();
			getEquipmentname().sendKeys(TestData1);
			getEquipmenttype().sendKeys(TestData2);
			getEquipmentproducer().sendKeys(TestData3);
			getEquipmentinterval().sendKeys(TestData4);
			getChangebutton().click();
		}
	
		/**
		 * Edit only name and type device fields using correct data without drop
		 * previous data
		 */
		public void editFields_without_Drop_Form(String TestData1, String TestData2) {
			getEquipmentname().clear();
			getEquipmentname().sendKeys(TestData1);
			getEquipmenttype().clear();
			getEquipmenttype().sendKeys(TestData2);
			getChangebutton().click();
		}

		/**
		 * 
		 * Check if notification about successful edit exist.
		 * 
		 * 
		 */
		public void checkEdit_Notification_Existence() {
			driver.findElement(By.cssSelector("div#successMessage.modal-body.text-center.ng-scope h2"));
		}

		/**
		 * 
		 * Check if edited element exists. return String with text data of
		 * edited element
		 * 
		 */
		public String checkEdit_elements_existence() {
			return driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getAttribute("textContent");
		}
	}

}

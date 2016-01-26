package com.softserve.edu.md.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.User;


public class NewVerificationPage {
	public static final String SERCH_NUMBER_OF_HOUSE_DATA = "1";
	public static final String SEARCH_STREET_DATA = "Лукаша";
	public static final String SEARCH_CLIENT_NAMES_DATA = "Чопик Василь Іванович";
	public static final String SEARCH_DISTRICT_DATA = "Cихів";
	private NewVerificationPageUIMap controls;

	public class NewVerificationPageUIMap {

		public ITextField clientdata;
		public ITextField clientstreet;
		public ITextField district;
		public ITextField numberofhouse;
		public IButton options;
	//	public IButton logout;

		/**
		 * Constructor of New Verifications Home Page. Check if all necessary
		 * elements exist.
		 */
		public NewVerificationPageUIMap() {
			this.clientdata = TextField.get().getByXpath("//table/thead/tr[2]/th[3]//input");
			this.district = TextField.get().getByXpath("//table/thead/tr[2]/th[4]//input");
			this.clientstreet = TextField.get().getByXpath("//table/thead/tr[2]/th[5]//input");
			this.numberofhouse = TextField.get().getByXpath("//table/thead/tr[2]/th[6]//input");
			this.options = Button.get().getByCssSelector("div i.fa.fa-caret-down");
	//		this.logout = Button.get().getByXpath("//p[text()='Вилогуватись']");

		}
	}

	public NewVerificationPage() {
		controls = new NewVerificationPageUIMap();
	}

	public ITextField getDistrict() {
		return this.controls.district;
	}

	public String getDistricttext() {
		return this.controls.district.getText();
	}

	public ITextField getClientData() {
		return this.controls.clientdata;
	}

	public ITextField getClientStreet() {
		return this.controls.clientstreet;
	}

	public ITextField getNumberOfHouse() {
		return this.controls.numberofhouse;
	}

	public IButton getOptions() {
		return this.controls.options;
	}

//	public void clickLogout() {
//		this.controls.logout.click();
//	}

//	public IButton getLogout() {
//		return this.controls.logout;
//	}

	/**
	 * Search by Client Data field in New Verifications. Return string with
	 * text of found element.
	 */
	public String searchClientData(String searchfilter) {
		getClientData().sendKeys(searchfilter);
		String s = BrowserUtils.get().getBrowser().getWebDriver()
				.findElement(By.xpath("//table/thead/tr[2]/th[3]")).getText();
		// String s =
		// driver.findElement(By.cssSelector("td.ng-pristine.ng-untouched.ng-valid.ng-binding")).getText();
		return s;
	}

	/**
	 * 
	 * Search by District field in New Verifications. Return string with text
	 * of found element.
	 * 
	 */
	public String searchDistrict(String searchfilter) {
		getDistrict().sendKeys(searchfilter);
		String s = BrowserUtils.get().getBrowser().getWebDriver()
				.findElement(By.xpath("//table/thead/tr[2]/th[4]")).getText();
		        
		return s;
	}

	/**
	 * 
	 * Search by Client Street field in New Verifications. Return string with text
	 * of found element.
	 * 
	 * 
	 */
	public String searchClientStreet(String searchfilter) {
		getClientStreet().sendKeys(searchfilter);
		String s = BrowserUtils.get().getBrowser().getWebDriver()
				.findElement(By.xpath("//table/thead/tr[2]/th[5]"))
				.getText();

		return s;
	}

	/**
	 * 
	 * Search by Number of House field in New Verifications. Return string with
	 * text of found element.
	 * 
	 */
	public String searchByNubmerOfHouse(String searchfilter) {
		getNumberOfHouse().sendKeys(searchfilter);
		String s = BrowserUtils.get().getBrowser().getWebDriver()
				.findElement(By.xpath("//table/thead/tr[2]/th[6]"))
				.getText();
		return s;
	}

	// Return a new page object representing the destination.
	public NewVerificationPage successVerifaction(IUser calibrator) {
		return new NewVerificationPage();
	}

	/**
	 * 
	 * Logout from your user account.
	 * 
	 */
	//public void gotoLogout() {
//		getOptions().click();
	//	clickLogout();
//	}
}

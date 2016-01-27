package com.softserve.edu.md.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
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
	public static final String SERCH_NUMBER_OF_HOUSE_DATA = "12, 18";
	public static final String SEARCH_STREET_DATA = "Лукаша";
	public static final String SEARCH_CLIENT_NAMES_DATA = "Чопик";
	public static final String SEARCH_DISTRICT_DATA = "Львівський";
	public static final String SEARCH_CREATE_CLIENT_NAMES_DATA = "Тест";
	public static final String PAGE_TITLE = "Нові Повірки";
	private NewVerificationPageUIMap controls;
	private NewVerificationPageSendTaskFormUIMap formcontrols;

	public class NewVerificationPageUIMap {
		public ITextField pagetitle;
		public ITextField searchByclientdata;
		public ITextField searchByclientstreet;
		public ITextField searchBydistrict;
		public ITextField searchBynumberofhouse;

		public IButton topcheckbox;
		public IButton options;
		public IButton sendtaskbutton;
		// public IButton logout;

		/**
		 * Constructor of New Verifications Home Page. Check if all necessary
		 * elements exist.
		 */
		public NewVerificationPageUIMap() {
			this.pagetitle = TextField.get().getByCssSelector(".page-header.ng-binding");
			this.searchByclientdata = TextField.get().getByXpath("//th[3]//input");
			this.searchBydistrict = TextField.get().getByXpath("//th[4]//input");
			this.searchByclientstreet = TextField.get().getByXpath("//th[5]//input");
			this.searchBynumberofhouse = TextField.get().getByXpath("//th[6]//input");
			this.topcheckbox = Button.get().getByXpath("//tbody/tr[1]/td[1]/input");
			this.sendtaskbutton = Button.get().getByCssSelector("div.pull-left button.btn.btn-primary.ng-binding");
			this.options = Button.get().getByCssSelector("div i.fa.fa-caret-down");

		}

	}

	public class NewVerificationPageSendTaskFormUIMap {

		public IButton savebutton;
		public IButton selectesphere;
		public ITextField spherespan;
		public IButton datebutton;
		public IButton selectdatebutton;
		public IButton numberofmachine;
		public ITextField numberofmachinespan;

		public NewVerificationPageSendTaskFormUIMap() {
			this.savebutton = Button.get().getByCssSelector("button.btn.btn-success.ng-binding");
			this.selectesphere = Button.get().getById("applicationField_chosen");
			this.spherespan = TextField.get().getByCssSelector(".chosen-container-single-nosearch a.chosen-single.chosen-default");
			this.datebutton = Button.get().getByCssSelector(".ng-valid-required.ng-touched.active");
			this.selectdatebutton = Button.get().getByXpath("//div[8]/div[1]/div/table/tbody/tr[3]/td[5]");
			this.numberofmachine = Button.get().getById("installationNumber_chosen");

		}

	}

	public NewVerificationPage() {
		controls = new NewVerificationPageUIMap();
	}

	private void initSendTaskForm() {
		formcontrols = new NewVerificationPageSendTaskFormUIMap();
	}

	public String getTitle() {
		return this.controls.pagetitle.getText();
	}
	
	public IButton getSavebutton() {
		return this.formcontrols.savebutton;
	}

	public IButton getSelectesphere() {
		return this.formcontrols.selectesphere;
	}

	public ITextField getSpherespan() {
		return this.formcontrols.spherespan;
	}

	public IButton getDatebutton() {
		return this.formcontrols.datebutton;
	}

	public IButton getSelectdatebutton() {
		return this.formcontrols.selectdatebutton;
	}

	public IButton getNumberofmachine() {
		return this.formcontrols.numberofmachine;
	}

	public ITextField getNumberofmachinespan() {
		return this.formcontrols.numberofmachinespan;
	}

	public IButton getSendTaskButton() {
		return this.controls.sendtaskbutton;
	}

	public IButton getTopCheckBox() {
		return this.controls.topcheckbox;
	}

	public ITextField getsearchByDistrict() {
		return this.controls.searchBydistrict;
	}

	public String getDistricttext() {
		return getsearchByDistrict().getText();
	}

	public ITextField getClientData() {
		return this.controls.searchByclientdata;
	}

	public ITextField getsearchByClientStreet() {
		return this.controls.searchByclientstreet;
	}

	public ITextField getsearchByNumberOfHouse() {
		return this.controls.searchBynumberofhouse;
	}

	public IButton getOptions() {
		return this.controls.options;
	}

	public void clickLogout() {
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.xpath("//p[text()='Вилогуватись']")).click();
	}

	public String getDistrictSearchResultText() {
		return BrowserUtils.get().getBrowser().getWebDriver().findElement(By.xpath("//table/tbody/tr/td[4]")).getText();
	}

	public String getClientDataSearchResultText() {
		return BrowserUtils.get().getBrowser().getWebDriver().findElement(By.xpath("//table/tbody/tr/td[3]")).getText();
	}

	public String getClientStreetSearchResultText() {
		return BrowserUtils.get().getBrowser().getWebDriver().findElement(By.xpath("//table/tbody/tr/td[5]")).getText();
	}

	public String getNumberOfHouseSearchResultText() {
		return BrowserUtils.get().getBrowser().getWebDriver().findElement(By.xpath("//table/tbody/tr/td[6]")).getText();
	}

	/**
	 * Search by Client Data field in New Verifications.
	 * 
	 * 
	 */

	public void searchClientData(String searchfilter) throws InterruptedException {
		getClientData().sendKeys(searchfilter);
	}

	/**
	 * 
	 * Search by District field in New Verifications.
	 * 
	 */
	public void searchDistrict(String searchfilter) throws InterruptedException {
		getsearchByDistrict().sendKeys(searchfilter);
	}

	/**
	 * 
	 * Search by Client Street field in New Verifications.
	 * 
	 * 
	 */
	public void searchClientStreet(String searchfilter) {
		getsearchByClientStreet().sendKeys(searchfilter);
	}

	/**
	 * 
	 * Search by Number of House field in New Verifications.
	 * 
	 */
	public void searchByNubmerOfHouse(String searchfilter) {
		getsearchByNumberOfHouse().sendKeys(searchfilter);

	}

	public void sendTask() {
		getTopCheckBox().click();
		getSendTaskButton().click();
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.id("applicationField_chosen")).click();	
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.cssSelector(".chosen-container-single-nosearch a.chosen-single.chosen-default")).sendKeys(Keys.ARROW_DOWN);
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.cssSelector(".chosen-container-single-nosearch a.chosen-single.chosen-default")).sendKeys(Keys.ENTER);
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.cssSelector("form.ng-invalid.ng-invalid-required.ng-dirty.ng-valid-parse div.row div.form-group.col-md-8 div.input-group.right-inner-addon")).click();;
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.xpath("//div[8]/div[1]/div/table/tbody/tr[3]/td[5]")).click();
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.cssSelector("div#installationNumber_chosen.chosen-container.chosen-container-single.chosen-disabled a.chosen-single.chosen-default")).click();
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.cssSelector("button.btn.btn-success.ng-binding"));	
	}

	public CalibratorHomePage gotoHomePage() {
		BrowserUtils.get().getBrowser().previousPage();
		return new CalibratorHomePage();
	}

	/**
	 * 
	 * Logout from your user account.
	 * 
	 */
	public void gotoLogout() {
		getOptions().click();
		clickLogout();
	}
}

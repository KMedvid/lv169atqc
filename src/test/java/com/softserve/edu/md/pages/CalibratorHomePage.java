package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.User;

public class CalibratorHomePage {
	private CalibratorHomePageUIMap controls;

	private class CalibratorHomePageUIMap {
		// private WebDriver driver;
		public IButton verificationPageButton;
		public IButton calibratorTaskStationButton;
		public ITextField title;
		public ITextField loginname;
		public IButton options;
		//public IButton logout;

		/**
		 * 
		 * Constructor of Calibrator Home Page UI Map. Check if all necessary
		 * elements exist.
		 */
		public CalibratorHomePageUIMap() {

			this.verificationPageButton = Button.get().getByXpath("//div/ul/li[2]/a/span[1]");
			this.calibratorTaskStationButton = Button.get().getByXpath("//div/ul/li[6]/a/span[1]");
			this.title = TextField.get().getByCssSelector("h1.page-header.ng-binding");
			this.loginname = TextField.get().getByCssSelector("div label.ng-scope");
			this.options = Button.get().getByCssSelector("div i.fa.fa-caret-down");
		//	this.logout = Button.get().getByXpath("//p[text()='Вилогуватись']");
		}
	}

	public CalibratorHomePage() {
		controls = new CalibratorHomePageUIMap();
	}

	public IButton getverificationPageButton() {
		return this.controls.verificationPageButton;
	}

	public IButton getcalibratorTaskStationButton() {
		return this.controls.calibratorTaskStationButton;
	}

	public ITextField getTitle() {
		return this.controls.title;
	}

	public IButton getOptions() {
		return this.controls.options;
	}

	public ITextField getLoginName() {
		return this.controls.loginname;
	}

	public String getTitleText() {
		return this.controls.title.getAttribute("textContent");
	}

	public String getLoginNameText() {
		return this.controls.loginname.getAttribute("textContent");
	}

	////public IButton getLogout() {
	//	return this.controls.logout;
	//}

//	public void clickLogout() {
	//	this.controls.logout.click();
//	}

	//public void gotoLogout() {
//		getOptions().click();
//		clickLogout();
	//}
	
	public void clickSelectPersonButton() throws InterruptedException{
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.cssSelector("i.fa.fa-user.add_attached_user_icon")).click();
	Thread.sleep(1000);
		clickAcceptButton();
	}
	
	private void clickAcceptButton(){
		BrowserUtils.get().getBrowser().getWebDriver().findElement(By.cssSelector("button.btn.btn-success.pull-left.ng-binding")).click();
	}
	
	public String getVerificationClientName(){
		return BrowserUtils.get().getBrowser().getWebDriver().findElement(By.xpath("//tbody/tr/td[2]"))
		.getText();
	}
	
	 public NewVerificationPage gotoverificationpage(){
		 getverificationPageButton().click();;
	 return new NewVerificationPage();
	 }

	// public CalibratorTaskStationPage gotoCalibratorTaskStationPage{
//		 getcalibratorTaskStationButton().click();;
//	 return new CalibratorTaskStationPage;
//	 }
	 
}

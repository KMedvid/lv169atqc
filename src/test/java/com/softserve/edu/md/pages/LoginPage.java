package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.md.data.IUser;
import com.softserve.edu.md.data.User;

//import some.test.stuff.data.User;

public class LoginPage {
	// constants with testing data
	public static final String TITLE = "Головна панель (вимірювальна лабораторія)";
	public static final String LOGIN_ATTRIBUTES = "Курт Кобейн";

	private class LoginPageUIMap {
		public final ITextField login;
		public final ITextField password;
		public final IButton submit;


		/**
		 * 
		 * Constructor of Login Page UI Map. Check if all necessary fields
		 * exists
		 * 
		 */
		public LoginPageUIMap() {
			this.login = TextField.get().getByXpath("//input[@type='text']");
			this.password = TextField.get().getById("inputPassword");
			this.submit = Button.get()
					.getByCssSelector("button.btn.btn-lg.btn-primary.btn-block.withoutBorder.ng-binding");
		}
	}

	private LoginPageUIMap controls;

	public LoginPage() {
		controls = new LoginPageUIMap();
	}

	public void setLogin(String login) {
		this.controls.login.sendKeysClear(login);
	}

	public void setPassword(String password) {
		this.controls.password.sendKeysClear(password);
	}

	public void clearLogin() {
		this.controls.login.clear();
	}

	public void clearPassword() {
		this.controls.password.clear();
	}

	public void clickLogin() {
		this.controls.login.click();
	}

	public void clickPassword() {
		this.controls.password.click();
	}

	public void clickSubmit() {
		this.controls.submit.click();
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public ITextField getLogin() {
		return this.controls.login;
	}

	public ITextField getPassword() {
		return this.controls.password;
	}

	public IButton getSubmit() {
		return this.controls.submit;
	}

	public String getLoginText() {
		return this.controls.login.getText();
	}

	public String getPasswordText() {
		return this.controls.password.getText();
	}

	/**
	 * method that allows us to login as user
	 */
	private void setLoginData(IUser user) {
		clickLogin();
		clearLogin();
		setLogin(user.getLogin());
		clickPassword();
		clearPassword();
		setPassword(user.getPassword());
		clickSubmit();
	}

	 public CalibratorHomePage successCalLogin(IUser calibrator) {
	 setLoginData(calibrator);
	 return new CalibratorHomePage();
	 }


	 public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
	 setLoginData(invalidUser);
	 return new LoginValidatorPage();
	 }

}
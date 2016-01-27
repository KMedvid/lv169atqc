package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Label;

public class LoginValidatorPage extends LoginPage {
	public static final String LOGIN_VALIDATOR_MESSAGE = "Логін або пароль неправильні. Будь ласка, спробуйте ще раз.";
	private LoginValidatorPageUIMap controls;

	private class LoginValidatorPageUIMap {
		public final ILabel validator;

		/**
		 * 
		 * Constructor of Login Page with validator of unsuccessful attempt of
		 * login. Check if all necessary fields exists
		 * 
		 */
		public LoginValidatorPageUIMap() {
			this.validator = Label.get().getById("incorrectLoginMessage");
		}
	}

	public LoginValidatorPage() {
		this.controls = new LoginValidatorPageUIMap();
	}

	public ILabel getValidator() {
		return this.controls.validator;
	}

	public String getValidatorText() {
		return getValidator().getAttribute("textContent");
	}

}
package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginValidatorPage extends LoginPage {
    public static final String LOGIN_VALIDATOR_MESSAGE = "Не вдалось  залогуватись, перевірте коректність введених даних";
  
    private WebElement validator;
    /**

	 * Constructor of Login Page with validator of unsuccessful attempt of login.
	 * Check if all necessary fields exists

	 */
    public LoginValidatorPage(WebDriver driver) {
        super(driver);
        this.validator = driver.findElement(By.id("incorrectLoginMessage"));
    }

    // Get Elements

    public WebElement getValidator() {
        return this.validator;
    }

    public String getValidatorText() {
        return this.validator.getAttribute("textContent");
    }

}
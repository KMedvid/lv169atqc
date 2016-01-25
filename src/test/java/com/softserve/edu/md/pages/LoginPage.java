package com.softserve.edu.md.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.md.data.IUser;

public class LoginPage {

    /**
     * 
     * Map of all elements on page
     */
    private class LoginPageUIMap {
        public final ITextField login;
        public final ITextField password;
        public final IButton submit;

        public LoginPageUIMap() {
            this.login = TextField.get().getByXpath("//input[@ng-model ='loginForm.username']");
            this.password = TextField.get().getById("inputPassword");
            this.submit = Button.get().getByXpath("//button[@type = 'submit']");
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private LoginPageUIMap controls;

    public LoginPage() {
        controls = new LoginPageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

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


	// Business Logic
 /**
  * 
  * @param user - admin, calibrator and verificator is able to login
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

	/**
	 * Success admin login and move to admin home page.
	 * @param admin
	 * @return AdminHomePage
	 */
    public AdminHomePage successAdminLogin(IUser admin) {
		setLoginData(admin);
		// Return a new page object representing the destination.
		return new AdminHomePage();
	}

	/**
	 * Unsuccessful user login with validator message.
	 * @param invalidUser
	 * @return LoginValidatorPage
	 */
	public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
		setLoginData(invalidUser);
		return new LoginValidatorPage(); // return this;
	}

}

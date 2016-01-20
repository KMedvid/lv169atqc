package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.oms.data.IUser;

public class LoginPage {

    private class LoginPageUIMap {
        public final ITextField login;
        public final ITextField password;
        public final IButton submit;

        public LoginPageUIMap() {
            this.login = TextField.get().getByName("j_username");
            this.password = TextField.get().getByName("j_password");
            this.submit = Button.get().getByName("submit");
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

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    private void setLoginData(IUser user) {
        clickLogin();
        clearLogin();
        setLogin(user.getLogin());
        clickPassword();
        clearPassword();
        setPassword(user.getPassword());
        clickSubmit();
    }

    public HomePage successUserLogin(IUser user) {
        setLoginData(user);
        // Return a new page object representing the destination.
        return new HomePage();
    }

    public AdminHomePage successAdminLogin(IUser admin) {
        setLoginData(admin);
        // Return a new page object representing the destination.
        return new AdminHomePage();
    }

    public CustomerHomePage successCustomerLogin(IUser customer) {
        setLoginData(customer);
        // Return a new page object representing the destination.
        return new CustomerHomePage();
    }

    public LoginValidatorPage unSuccesfulLogin(IUser invalidUser) {
        setLoginData(invalidUser);
        return new LoginValidatorPage(); // return this;
    }

}

package com.softserve.edu.md.pages;

import org.openqa.selenium.WebDriver;

public class LoginStartData {
    private WebDriver driver;
    private String login;
    private String logout;

    public LoginStartData(WebDriver driver, String login, String logout) {
        this.driver = driver;
        this.login = login;
        this.logout = logout;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getLogin() {
        return login;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }

}

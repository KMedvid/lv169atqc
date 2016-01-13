package com.softserve.edu.atqc.data;

import com.softserve.edu.atqc.tools.ABrowser;

public final class StartData {
    private String login;
    private String logout;
    private String browserName;
    private String browserPath;
    private ABrowser browser;

    public StartData() {
        this.login = new String();
        this.logout = new String();
        this.browserName = new String();
        this.browserPath = new String();
    }

    public StartData(String login, String logout, String browserName, String browserPath) {
        this.login = login;
        this.logout = logout;
        this.browserName = browserName;
        this.browserPath = browserPath;
    }

    public String getLogin() {
        return login;
    }

    public String getLogout() {
        return logout;
    }

    public String getBrowserName() {
        return browserName;
    }

    public ABrowser getBrowser() {
        return browser;
    }

    public String getBrowserPath() {
        return browserPath;
    }

    public StartData setLogin(String login) {
        this.login = login;
        return this;
    }

    public StartData setLogout(String logout) {
        this.logout = logout;
        return this;
    }

    public StartData setBrowserName(String browserName) {
        this.browserName = browserName;
        return this;
    }

    public StartData setBrowserPath(String browserPath) {
        this.browserPath = browserPath;
        return this;
    }

    public StartData setBrowser(ABrowser browser) {
        this.browser = browser;
        return this;
    }

}

package com.softserve.edu.atqc.data;

import com.softserve.edu.atqc.tools.ABrowser;

public final class StartData {
    private String login;
    private String logout;
    private String searchStrategy;
    private String browserName;
    private String browserPath;
    private ABrowser browser;
    // TODO Set Implicit and Explicit Waits
    // TODO Set Logger Strategy
    // TODO Set Sleep for Demo
    
    public StartData() {
        this.login = new String();
        this.logout = new String();
        this.searchStrategy = new String();
        this.browserName = new String();
        this.browserPath = new String();
    }

    public StartData(String login, String logout, String searchStrategy, String browserName, String browserPath) {
        this.login = login;
        this.logout = logout;
        this.searchStrategy = searchStrategy;
        this.browserName = browserName;
        this.browserPath = browserPath;
    }

    public String getLogin() {
        return login;
    }

    public String getLogout() {
        return logout;
    }

    public String getSearchStrategy() {
        return searchStrategy;
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

    public StartData setSearchStrategy(String searchStrategy) {
        this.searchStrategy = searchStrategy;
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

    public StartData clone() {
        StartData startData = new StartData(this.login, this.logout, this.searchStrategy, this.browserName, this.browserPath);
        startData.setBrowser(this.browser);
        return startData;
    }

}

package com.softserve.edu.atqc.tools;

final class BrowserRepository {
    private static volatile BrowserRepository instance = null;

    private BrowserRepository() {
    }

    static BrowserRepository get() {
        if (instance == null) {
            synchronized (BrowserRepository.class) {
                if (instance == null) {
                    instance = new BrowserRepository();
                }
            }
        }
        return instance;
    }

    public ABrowser getDefault() {
        // TODO Create default class without create webdriver.
        return new FirefoxBrowser();
    }

    public ABrowser getFirefoxByTemporaryProfile() {
        return new FirefoxBrowser();
    }

    public ABrowser getChromeByTemporaryProfile() {
        return new ChromeBrowser();
    }

    public ABrowser getChromeByTemporaryProfile(String browserPath) {
        return new ChromeBrowser(browserPath);
    }

}

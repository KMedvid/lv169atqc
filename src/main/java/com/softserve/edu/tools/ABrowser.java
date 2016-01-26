package com.softserve.edu.tools;

import org.openqa.selenium.WebDriver;

public abstract class ABrowser {
    private final String BROWSER_CLOSED = "Browser was Closed.";
    private WebDriver driver = null;

    ABrowser() {
    }

    ABrowser(WebDriver driver) {
        this.driver = driver;
    }

    //TODO +++ Set Package Access
    public WebDriver getWebDriver() {
        if (driver != null) {
            return driver;
        } else {
            // TODO Create class Exception + log + report.
            throw new RuntimeException(BROWSER_CLOSED);
        }
    }

    void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }
    
    String getWebDriverName() {
        return this.getClass().getName();
    }

    boolean isEnabled() {
        return driver != null;
    }

    public void loadPage(String url) {
        getWebDriver().get(url);
    }

    public void refreshPage() {
        getWebDriver().navigate().refresh();
    }

    public void forwardPage() {
        // TODO Use try
        getWebDriver().navigate().forward();
    }

    public void previousPage() {
        // TODO Use try
        getWebDriver().navigate().back();
    }

    public String getCurrentUrl() {
        return getWebDriver().getCurrentUrl();
    }

    public void close() {
        getWebDriver().close();
        driver = null;
    }

    public void quit() {
        getWebDriver().quit();
        driver = null;
    }

}

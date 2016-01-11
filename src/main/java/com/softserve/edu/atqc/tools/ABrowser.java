package com.softserve.edu.atqc.tools;

import org.openqa.selenium.WebDriver;

abstract class ABrowser {
    private final String BROWSER_CLOSED = "Browser was Closed.";
    private WebDriver driver = null;

    ABrowser() {
    }

    ABrowser(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver getWebDriver() {
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

    void close() {
        getWebDriver().close();
        driver = null;
    }

    void quit() {
        getWebDriver().quit();
        driver = null;
    }

}

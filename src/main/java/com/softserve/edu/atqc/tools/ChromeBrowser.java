package com.softserve.edu.atqc.tools;

import org.openqa.selenium.chrome.ChromeDriver;

import com.softserve.edu.oms.tools.BrowserPathRepository.BrowserPath;

final class ChromeBrowser extends ABrowser {
    private final String CHROME_PROPERTY = "webdriver.chrome.driver";

    ChromeBrowser() {
        //super();
        init(BrowserPath.CHROME_PATH.toString());
    }

    ChromeBrowser(String browserPath) {
        //super();
        init(browserPath);
    }

    private void init(String browserPath) {
        System.setProperty(CHROME_PROPERTY, browserPath);
        setWebDriver(new ChromeDriver());
    }

}

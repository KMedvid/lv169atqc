package com.softserve.edu.tools;

import org.openqa.selenium.firefox.FirefoxDriver;

final class FirefoxBrowser extends ABrowser {

    FirefoxBrowser() {
        super(new FirefoxDriver());
    }

}

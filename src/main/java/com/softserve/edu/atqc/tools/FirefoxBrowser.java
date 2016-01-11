package com.softserve.edu.atqc.tools;

import org.openqa.selenium.firefox.FirefoxDriver;

final class FirefoxBrowser extends ABrowser {

    FirefoxBrowser() {
        super(new FirefoxDriver());
    }

}

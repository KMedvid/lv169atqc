package com.softserve.edu.oms.pages;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.softserve.edu.oms.data.IUrls;

public class LoginStartPage {
    private static volatile LoginStartPage instance = null;
    private static final String WEBDRIVER_ERROR = "WebDriver not found";
    private static final int DEFAULT_IMPLICITLY_WAIT = 10;
    //
    private int currentImplicitlyWait;
    private Map<Long, LoginStartData> startData;

    private LoginStartPage() {
        currentImplicitlyWait = DEFAULT_IMPLICITLY_WAIT;
        startData = new HashMap<Long, LoginStartData>();
    }

    public static LoginStartPage get() {
        if (instance == null) {
            synchronized (LoginStartPage.class) {
                if (instance == null) {
                    instance = new LoginStartPage();
                }
            }
        }
        return instance;
    }

    public int getCurrentImplicitlyWait() {
        return currentImplicitlyWait;
    }
    
    public void setImplicitlyWait(int implicitlyWait) {
        currentImplicitlyWait = implicitlyWait;
        getCurrentData().getDriver().manage().timeouts()
            .implicitlyWait(getCurrentImplicitlyWait(), TimeUnit.SECONDS);
    }

    public void restoreImplicitlyWaitByDefault() {
        setImplicitlyWait(DEFAULT_IMPLICITLY_WAIT);
    }
    
    private WebDriver createFirefoxDriver() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(getCurrentImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    private LoginStartData getCurrentData() {
        LoginStartData data = startData.get(Thread.currentThread().getId());
        if (data == null) {
            // TODO Develop Custom Exception
            throw new RuntimeException(WEBDRIVER_ERROR);
        }
        return data;
    }
    
    private WebDriver getDriver(IUrls urls) {
        LoginStartData data = startData.get(Thread.currentThread().getId());
        if (data == null) {
            startData.put(Thread.currentThread().getId(),
                    new LoginStartData(createFirefoxDriver(), urls));
        } else {
            data.setUrls(urls);
        }
        return startData.get(Thread.currentThread().getId()).getDriver();
    }

    public LoginPage load(IUrls urls) {
        WebDriver driver = getDriver(urls);
        driver.get(urls.getLogin());
        return new LoginPage(driver);
    }

    public LoginPage load() {
        LoginStartData data = getCurrentData();
        WebDriver driver = data.getDriver();
        driver.get(data.getUrls().getLogin());
        return new LoginPage(driver);
    }

    public LoginPage logout() {
        LoginStartData data = getCurrentData();
        WebDriver driver = data.getDriver();
        driver.get(data.getUrls().getLogout());
        return new LoginPage(driver);
    }

    public void close() {
        LoginStartData data = startData.get(Thread.currentThread().getId());
        if (data != null) {
            data.getDriver().close();
            startData.put(Thread.currentThread().getId(), null);
        }
    }

    public void quit() {
        for (LoginStartData data : startData.values()) {
            data.getDriver().quit();
        }
    }

}

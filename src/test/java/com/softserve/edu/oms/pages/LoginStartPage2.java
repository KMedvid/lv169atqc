package com.softserve.edu.oms.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginStartPage2 {
    private static volatile LoginStartPage2 instance = null;
    //
    private List<WebDriver> driverList = new ArrayList<WebDriver>();

    private LoginStartPage2() {
    }

    public static LoginStartPage2 get() {
        if (instance == null) {
            synchronized (LoginStartPage2.class) {
                if (instance == null) {
                    instance = new LoginStartPage2();
                }
            }
        }
        return instance;
    }

    public LoginPage load() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverList.add(driver);
        driver.get("http://localhost:8080/OMS/login.htm");
        return new LoginPage(driver);
    }

    public LoginPage loadOne() throws InterruptedException {
        if (driverList.isEmpty()) {
            return load();
        } else {
            // driverList.get(0).get("http://www.google.com.ua");
            // Thread.sleep(1000);
            driverList.get(0).get("http://localhost:8080/OMS/login.htm");
            // Thread.sleep(1000);
            return new LoginPage(driverList.get(0));
        }
    }

    public LoginPage logoutOne() {
        driverList.get(0).get("http://localhost:8080/OMS/logout.htm");
        return new LoginPage(driverList.get(0));
    }

    public void quit() {
        for (WebDriver driver : driverList) {
            driver.quit();
        }
    }

}

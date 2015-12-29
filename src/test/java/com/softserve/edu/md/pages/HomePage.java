package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    protected final int DEFAULT_EXPLICITLY_WAIT = 10;
    protected WebDriver driver;
    //
    private WebElement home;
    private WebElement about;
    private WebElement signIn;
    private WebElement applicationSend;
    private WebElement applicationStatus;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        //
        this.home = driver.findElement(By.xpath("//a[@ui-sref = 'start']"));
        this.about = driver.findElement(By.xpath("//a[@ui-sref = 'about']"));
        this.signIn = driver.findElement(By.xpath("//a[@ui-sref = 'login']"));
        this.applicationSend = driver.findElement(By.xpath("//a[@ui-sref = 'application-sending']"));
        this.applicationStatus = driver.findElement(By.xpath("//a[@ui-sref = 'application-status']"));
    }
    
    // Click Elements 
    public void clickHome() {
        this.home.click();
    }

    public void clickAbout() {
        this.about.click();
    }

    public void clickSignIn() {
        this.signIn.click();
    }

    public void clickApplicationSend() {
        this.applicationSend.click();
    }

    public void clickApplicationStatus() {
        this.applicationStatus.click();
    }

    // Get Elements
    public WebElement getHome() {
        return home;
    }

    public WebElement getAbout() {
        return about;
    }

    public WebElement getSignIn() {
        return signIn;
    }

    public WebElement getApplicationSend() {
        return applicationSend;
    }

    public WebElement getApplicationStatus() {
        return applicationStatus;
    }

    //Goto pages
    public HomePage gotoHomePage() {
        clickHome();
        return this;
    }

    public AboutPage gotoAbout() {
        clickAbout();
        return new AboutPage(driver);
    }

    public LoginPage gotoSignIn() {
        clickSignIn();
        return new LoginPage(driver);

    }

    public ApplicationSendPage gotoApplicationSend() {
        clickApplicationSend();
        return new ApplicationSendPage(driver);

    }

    public ApplicationStatusPage gotoApplicationStatus() {
        clickApplicationStatus();
        return new ApplicationStatusPage(driver);
    }

}

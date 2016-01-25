package com.softserve.edu.md.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class HomePage {
    
    private class HomePageUIMap {

        public final ILink home;
        public final ILink about;
        public final ILink signIn;
        public final ILink applicationSend;
        public final ILink applicationStatus;
        
        public HomePageUIMap() {
            this.home = Link.get().getByXpath("//a[@ui-sref = 'start']");
            this.about = Link.get().getByXpath("//a[@ui-sref = 'about']");
            this.signIn = Link.get().getByXpath("//a[@ui-sref = 'login']");
            this.applicationSend = Link.get().getByXpath("//a[@ui-sref = 'application-sending']");
            this.applicationStatus = Link.get().getByXpath("//a[@ui-sref = 'application-status']");
        }

    }
    
    private HomePageUIMap controls;
    
    public HomePage() {
        this.controls = new HomePageUIMap();
    }

  
    // Click Elements 
    public void clickHome() {
        this.controls.home.click();
    }

    public void clickAbout() {
        this.controls.about.click();
    }

    public void clickSignIn() {
        this.controls.signIn.click();
    }

    public void clickApplicationSend() {
        this.controls.applicationSend.click();
    }

    public void clickApplicationStatus() {
        this.controls.applicationStatus.click();
    }

    // Get Elements
    public ILink getHome() {
        return this.controls.home;
    }

    public ILink getAbout() {
        return this.controls.about;
    }

    public ILink getSignIn() {
        return this.controls.signIn;
    }

    public ILink getApplicationSend() {
        return this.controls.applicationSend;
    }

    public ILink getApplicationStatus() {
        return this.controls.applicationStatus;
    }

    //Goto pages
    public HomePage gotoHomePage() {
        clickHome();
        return this;
    }

    public AboutPage gotoAbout() {
        clickAbout();
        return new AboutPage();
    }

    public LoginPage gotoSignIn() {
        clickSignIn();
        return new LoginPage();

    }

    public ApplicationSendPage gotoApplicationSend() {
        clickApplicationSend();
        return new ApplicationSendPage();

    }

    public ApplicationStatusPage gotoApplicationStatus() {
        clickApplicationStatus();
        return new ApplicationStatusPage();
    }

}

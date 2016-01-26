package com.softserve.edu.md.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.tools.ControlSearch;

public abstract class InfoPage {

    private class InfoPageUIMap {
        public final ILink profile;
        public final ILabel title;

        public InfoPageUIMap() {
            this.profile = Link.get().getByCssSelector("fa fa-caret-down");
            this.title = Label.get().getByXpath("//a[@translate = 'HEAD_TITLE']");
        }
    }

    private class ProfilePopupUIMap {
        public final ILabel userName;
        public final ILink profileInfo;
        public final ILink settings;
        public final ILink logout;

        public ProfilePopupUIMap() {
            this.userName = Label.get().getByXpath("//label[@class = 'userlabel ng-scope']");
            this.profileInfo = Link.get().getByXpath("//div[@ui-sref = 'profile-info']");
            this.settings = Link.get().getByXpath("//p[@translate = 'SETTINGS']");
            this.logout = Link.get().getByXpath("//div[@ui-sref = 'profile-info']");
        }

    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private InfoPageUIMap controls;
    private ProfilePopupUIMap controlsPopup;

    protected InfoPage() {
        this.controls = new InfoPageUIMap();
        this.controlsPopup = new ProfilePopupUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Get Elements
    public ILink getProfile() {
        return this.controls.profile;
    }

    public ILabel getTitle() {
        return this.controls.title;
    }

    public String getTitleText() {
        return this.controls.title.getText();
    }

    // Click Elements
    public void clickProfile() {
        this.controls.profile.click();
    }

    // Get Elements
    public ILabel getUserName() {
        return this.controlsPopup.userName;
    }

    public String getUserNameText() {
        return this.controlsPopup.userName.getText();
    }

    public ILink getProfileInfo() {
        return this.controlsPopup.profileInfo;
    }

    public ILink getSettings() {
        return this.controlsPopup.settings;
    }

    /**
     * Popup window elements
     */
    public ILink getLogout() {
        return this.controlsPopup.logout;
    }

    // Click Elements
    /**
     * Popup window elements
     */
    public void clickProfileInfo() {
        this.controlsPopup.profileInfo.click();
    }

    /**
     * Popup window elements
     */
    public void clickSettings() {
        this.controlsPopup.settings.click();
    }

    /**
     * Popup window elements
     */
    public void clickLogout() {
        this.controlsPopup.logout.click();
    }

    // Business Logic
    /**
     * Click on profile button, wait until pop-up window appears and than click
     * logout button.
     * 
     * @return HomePage
     */
    public HomePage logout() {
        clickProfile();
        //TODO Explicitwait!
//        while(!getLogout().isInvisible()){}
//        ControlSearch.get().isInvisibleWebElement(controlLocation)
//        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT))
//                .until(ExpectedConditions.visibilityOf(profilePopup.getLogout()));
        clickLogout();
        return new HomePage();
    }

}

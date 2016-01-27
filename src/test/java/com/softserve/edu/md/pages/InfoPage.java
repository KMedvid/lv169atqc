package com.softserve.edu.md.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.Link;

public abstract class InfoPage {

    private class InfoPageUIMap {
        public final ILink profile;
        public final ILabel title;

        public InfoPageUIMap() {
            this.profile = Link.get().getByCssSelector(".fa.fa-caret-down");
            this.title = Label.get().getByXpath("//a[@translate = 'HEAD_TITLE']");
        }
    }

    
    private class ProfilePopupPage {
        
        private class ProfilePopupUIMap {
            public final ILabel userName;
            public final ILink profileInfo;
            public final ILink settings;
            public final ILink logout;

            public ProfilePopupUIMap() {
                this.userName = Label.get().getByCssSelector("userlabel ng-scope");//getByXpath("//label[@class = 'userlabel ng-scope']");
                this.profileInfo = Link.get().getByXpath("//div[@ui-sref = 'profile-info']");
                this.settings = Link.get().getByXpath("//p[@translate = 'SETTINGS']");
                this.logout = Link.get().getByXpath("//div[@ui-sref = 'profile-info']");
            }
            
        }
        //Elements
        private ProfilePopupUIMap controlsPopup;
        
        public ProfilePopupPage() {
            this.controlsPopup = new ProfilePopupUIMap();
        }
        
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
        
        
        
    }
    
    
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private InfoPageUIMap controls;

    protected InfoPage() {
        this.controls = new InfoPageUIMap();
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
  

    // Click Elements

  

    // Business Logic
    /**
     * Click on profile button, wait until pop-up window appears and than click
     * logout button.
     * 
     * @return HomePage
     */
    public HomePage logout() {
        clickProfile();
        new ProfilePopupPage().clickLogout();
        //TODO Explicitwait!
//        while(!getLogout().isInvisible()){}
//        ControlSearch.get().isInvisibleWebElement(controlLocation)
//        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT))
//                .until(ExpectedConditions.visibilityOf(profilePopup.getLogout()));
        //clickLogout();
        return new HomePage();
    }

}

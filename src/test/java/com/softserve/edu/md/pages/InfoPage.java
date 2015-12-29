package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class InfoPage {
    protected final static int DEFAULT_EXPLICITLY_WAIT = 10;
    protected WebDriver driver;
    //
    private WebElement profile;
    private WebElement title;
    private ProfilePopup profilePopup;

    public InfoPage(WebDriver driver) {
        this.driver = driver;
        this.title = driver.findElement(By.xpath("//a[@translate = 'HEAD_TITLE']"));
        this.profilePopup = new ProfilePopup(driver);
    }

    // Get Elements
    public WebElement getProfile() {
        return this.profile;
    }
    
    public WebElement getTitle() {
        return this.title;
    }
    
    public String getTitleText() {
        return this.title.getText();
    }
    
    // Click Elements
    public void clickProfile() {
        profile.click();
    }    

    class ProfilePopup {
        private WebElement userName;
        private WebElement profileInfo;
        private WebElement settings;
        private WebElement logout;

        ProfilePopup(WebDriver driver) {
            this.userName = driver.findElement(By.xpath("//label[@class = 'userlabel ng-scope']"));
            this.profileInfo = driver.findElement(By.xpath("//div[@ui-sref = 'profile-info']"));
            this.settings = driver.findElement(By.xpath("//p[@translate = 'SETTINGS']"));
            this.logout = driver.findElement(By.xpath("//div[@ui-sref = 'profile-info']"));
        }

        // Get Elements
        public WebElement getUserName() {
            return userName;
        }

        public String getUserNameText() {
            return userName.getText();
        }

        public WebElement getProfileInfo() {
            return profileInfo;
        }

        public WebElement getSettings() {
            return settings;
        }
        
        /**
         * 
         * @return WebElement logout
         */
        public WebElement getLogout() {
            return logout;
        }

        // Click Elements
        public void clickProfileInfo() {
            profileInfo.click();
        }

        public void clickSettings() {
            settings.click();
        }

        public void clickLogout() {
            logout.click();
        }

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
        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT))
                .until(ExpectedConditions.visibilityOf(profilePopup.getLogout()));
        profilePopup.clickLogout();
        return new HomePage(driver);
    }

}

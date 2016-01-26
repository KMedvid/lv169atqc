package calibrationDevices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileMenuPage extends MainPage {
    //
    private WebElement profileName;
    private WebElement profileInfo;
    private WebElement settings;
    private WebElement logout;

    public ProfileMenuPage(WebDriver driver) {
        super(driver);
        //
        this.profileName=driver.findElement(By.cssSelector(".userlabel"));
        this.profileInfo=driver.findElement(By.cssSelector("div[href*='#/profile-info']"));
        this.settings=driver.findElement(By.cssSelector(".ng-scope[translate ='SETTINGS']"));
        this.logout=driver.findElement(By.cssSelector(".dropdown [ng-click='logout()']"));
    }

    // Get Elements
    public WebElement getProfileName() {
        return this.profileName;
    }

    public WebElement getProfileInfo() {
        return this.profileInfo;
    }
    public WebElement getSettings() {
        return this.settings;
    }
    public WebElement getlogout() {
        return this.logout;
    }

	public String getProfileNameText() {
		return this.profileName.getText();
	}

    // Set Data
    public void clickProfileInfo() {
        this.profileInfo.click();
    }

    public void clickSettings() {
        this.settings.click();
    }

    public void clickLogout() {
        this.logout.click();
    }
    
    // Business Logic
    public ProfileInfoPage gotoProfileInfo() {
        clickProfileInfo();
        return new ProfileInfoPage(driver);
    }

    public SettingsPage gotoSettingsPage() {
        clickSettings();
        return new SettingsPage(driver);
    }

	public StartPageMD gotoLogout() {
		clickLogout();
		return new StartPageMD(driver);
	}
}

package calibrationDevices.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileInfoPage extends MainPage{
    //
    public static final String PROFILE_TITLE = "Загальна інформація";
    
    private WebElement pagetitle;
    private WebElement logout;
    private WebElement settings;
    
    private WebElement login;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement middleName;
    private WebElement email;
    private WebElement phone;
    private WebElement extraphone;

    public ProfileInfoPage(WebDriver driver) {
        super(driver);
        //
        this.pagetitle= driver.findElement(By.cssSelector("h2[class*='ng-binding']"));
        this.logout=driver.findElement(By.cssSelector(".btn.btn-warning.ng-binding"));
        this.settings=driver.findElement(By.cssSelector("button[ng-click='openEditProfileModal()']"));

        this.login=driver.findElement(By.cssSelector(".profile-info tr:nth-child(1) td:nth-child(2)"));
        this.firstName=driver.findElement(By.cssSelector(".profile-info tr:nth-child(2) td:nth-child(2)"));
        this.lastName=driver.findElement(By.cssSelector(".profile-info tr:nth-child(3) td:nth-child(2)"));
        this.middleName=driver.findElement(By.cssSelector(".profile-info tr:nth-child(4) td:nth-child(2)"));
        this.email=driver.findElement(By.cssSelector(".profile-info tr:nth-child(5) td:nth-child(2)"));
        this.phone=driver.findElement(By.cssSelector(".profile-info tr:nth-child(6) td:nth-child(2)"));
        this.extraphone=driver.findElement(By.cssSelector(".profile-info tr:nth-child(7) td:nth-child(2)"));
    }

    // Get Elements
    public WebElement getPagetitle() {
        return this.pagetitle;
    }
    
    public WebElement getLogout() {
        return this.logout;
    }
    
    public WebElement getEditSettings() {
        return this.settings;
    }
    
    public WebElement getLogin() {
        return this.login;
    }
    
    public WebElement getFirstName() {
        return this.firstName;
    }
    
    public WebElement getLastName() {
        return this.lastName;
    }
    
    public WebElement getMiddleName() {
        return this.middleName;
    }
    
    public WebElement getEmail() {
        return this.email;
    }
    
    public WebElement getPhone() {
        return this.phone;
    }
    
    public WebElement getExtraPhone() {
        return this.extraphone;
    }

    public String getPageTitleText() {
        return this.pagetitle.getText();
    }
    
    public String getLoginText() {
        return this.login.getText();
    }
    
    public String getFirstNameText() {
        return this.firstName.getText();
    }
    
    public String getLastNameText() {
        return this.lastName.getText();
    }
    
    public String getMiddleNameText() {
        return this.middleName.getText();
    }
    
    public String getEmailText() {
        return this.email.getText();
    }
    
    public String getPhoneText() {
        return this.phone.getText();
    }
    
    public String getExtraPhoneText() {
        return this.extraphone.getText();
    }

    public String getStartPageTitleText() {
        return this.pagetitle.getText().substring(0, PROFILE_TITLE.length());
    }

    // Set Data
    public void clickLogout() {
        this.logout.click();
    }
    
    public void clickEditSettings() {
        this.settings.click();
    }

    // Business Logic
    public SettingsPage gotoSettingsPage() {
        clickEditSettings();
        return new SettingsPage(driver);
    }

    public StartPageMD gotoLogout() {
        clickLogout();
        return new StartPageMD(driver);
    }

}

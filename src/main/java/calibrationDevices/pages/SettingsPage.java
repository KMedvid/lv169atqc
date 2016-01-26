package calibrationDevices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import calibrationDevices.data.IUser;

public class SettingsPage {
    private WebDriver driver;
    
    private WebElement firstName;
    private WebElement lastName;
    private WebElement middleName;
    private WebElement phone;
    private WebElement addExtraPhone;    
    private WebElement extraPhone;
    private WebElement email;
    private WebElement login;
    private WebElement generatePassword;
    private WebElement saveButton;    
    private WebElement closeButton;
    //

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        
        this.firstName = driver.findElement(By.id("firstName"));
        this.lastName = driver.findElement(By.id("lastName"));
        this.middleName = driver.findElement(By.id("middleName"));
        this.phone = driver.findElement(By.id("phone"));
        this.addExtraPhone = driver.findElement(By.cssSelector("[type='checkbox']"));
        this.extraPhone = driver.findElement(By.id("phoneNumberSecond"));
        this.email = driver.findElement(By.id("email"));
        this.login = driver.findElement(By.id("username"));
        this.generatePassword = driver.findElement(By.cssSelector("button[ng-hide='generationMessage']"));
        this.saveButton = driver.findElement(By.cssSelector("div [class ='form-group col-md-10'] button"));;
        this.closeButton = driver.findElement(By.cssSelector("button[ng-click='closeModal()']"));
    }

    // Get Elements
    public WebElement getFirstName() {
        return this.firstName;
    }

    public WebElement getLastName() {
        return this.lastName;
    }

    public WebElement getMiddleName() {
        return this.middleName;
    }

    public WebElement getPhone() {
        return this.phone;
    }

    public WebElement getAddExtraPhone() {
        return this.addExtraPhone;
    }
    
    public WebElement getExtraPhone() {
        return this.extraPhone;
    }

    public WebElement getEmail() {
        return this.email;
    } 
    
    public WebElement getLogin() {
        return this.login;
    }

    public WebElement getGeneratePassword() {
        return this.generatePassword;
    }

    public WebElement getSaveButton() {
        return this.saveButton;
    }
    
    public WebElement getCloseButton() {
        return this.closeButton;
    }


    public String getFierstNameText() {
        return this.firstName.getText();
    }

    public String getLastNameText() {
        return this.lastName.getText();
    }
    
    public String getMiddleNameText() {
        return this.middleName.getText();
    }

    public String getPhoneText() {
        return this.phone.getText();
    }
    
    public String getExtraPhoneText() {
        return this.extraPhone.getText();
    }

    public String getEmailText() {
        return this.email.getText();
    }

    public String getLoginText() {
        return this.login.getText();
    }

    // Set Data
    public void setLogin(String login) {
        this.login.sendKeys(login);
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }
    
    public void setMiddleName(String middleName) {
        this.middleName.sendKeys(middleName);
    }

    public void setPhone(String phone) {
        this.phone.sendKeys(phone);
    }
    
    public void setExtraPhone(String extraPhone) {
        this.extraPhone.sendKeys(extraPhone);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }
    
    
    public void clearLogin() {
        this.login.clear();
    }

    public void clearFirstName() {
        this.firstName.clear();
    }

    public void clearMiddleName() {
        this.middleName.clear();
    }
    
    public void clearLastName() {
        this.lastName.clear();
    }

    public void clearPhone() {
        this.phone.clear();
    }
    
    public void clearExtraPhone() {
        this.extraPhone.clear();
    }

    public void clearEmail() {
        this.email.clear();
    }
    
    public void clickLogin() {
        this.login.click();
    }

    public void clickFirstName() {
        this.firstName.click();
    }

    public void clickMiddleName() {
        this.middleName.click();
    }
    
    public void clickLastName() {
        this.lastName.click();
    }

    public void clickPhone() {
        this.phone.click();
    }
    
    public void clickExtraPhone() {
        this.extraPhone.click();
    }

    public void clickEmail() {
        this.email.click();
    }

    public void clickSaveButton() {
        this.saveButton.click();
    }

    public void clickCloseButton() {
        this.closeButton.click();
    }

    public void clickAddExtraPhone() {
        this.addExtraPhone.click();
    }

    public void clickGeneratePassword() {
        this.generatePassword.click();
    }

    // Business Logic
    private void setNewWorker(IUser user) {
        clickFirstName();
        clearFirstName();
        setFirstName(user.getFirstname());
        clickMiddleName();
        clearMiddleName();
        setMiddleName(user.getMiddlename());
        clickLastName();
        clearLastName();
        setLastName(user.getLastname());
        clickPhone();
        clearPhone();
        setPhone(user.getPhone());
        clickEmail();
        clearEmail();
        setEmail(user.getEmail());
        clickSaveButton();
//        clickCloseForm();

    }
    
    public EditedProfileConfirmPage successEditedProfile (IUser editedWorker) {
        setNewWorker(editedWorker);
        return new EditedProfileConfirmPage(driver);
    }

}

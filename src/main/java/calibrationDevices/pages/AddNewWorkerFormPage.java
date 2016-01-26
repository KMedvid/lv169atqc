package calibrationDevices.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import calibrationDevices.data.IUser;
public class AddNewWorkerFormPage {
    
    private WebDriver driver;
    
    private WebElement workerLogin;
    private WebElement workerPassword;
    private WebElement workerRepeatPassword;
    private WebElement workerName;
    private WebElement workerLastName;
    private WebElement workerMiddleName;
    private WebElement workerPhone;
    private WebElement workerExtraPhone;
    private WebElement workerEmail;
    private WebElement addButton;    
    private WebElement clearAll;    
    private WebElement closeFormButton;
    
    public AddNewWorkerFormPage(WebDriver driver) {
        this.driver = driver;
        
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 30)).until(ExpectedConditions
                .visibilityOfElementLocated(By.id("username")));

        this.workerLogin = driver.findElement(By.id("username"));
        this.workerPassword = driver.findElement(By.cssSelector("input[name='password']"));
        this.workerRepeatPassword = driver.findElement(By.cssSelector("input[name='rePassword']"));
        this.workerName = driver.findElement(By.id("firstName"));
        this.workerLastName = driver.findElement(By.id("lastName"));
        this.workerMiddleName = driver.findElement(By.id("middleName"));
        this.workerPhone = driver.findElement(By.id("phone"));
        this.workerEmail = driver.findElement(By.id("email"));
        this.addButton = driver.findElement(By.cssSelector(".btn.btn-success.ng-binding"));;
        this.clearAll = driver.findElement(By.cssSelector("button[type='reset']"));
        this.closeFormButton = driver.findElement(By.cssSelector("button[ng-click='closeModal()']"));
    }
    
    public class successMessage {{
        (new WebDriverWait(driver, 30)).until(ExpectedConditions
                .visibilityOfElementLocated(By.id("toast-container")));
        driver.findElement(By.id("toast-container"));
    }}

    // Get Elements
    public WebElement getWorkerLogin() {
        return this.workerLogin;
    }

    public WebElement getWorkerPassword() {
        return this.workerPassword;
    }
    
    public WebElement getWorkerRepeatPassword() {
        return this.workerRepeatPassword;
    }

    public WebElement getWorkerName() {
        return this.workerName;
    }
    public WebElement getWorkerLastName() {
        return this.workerLastName;
    }

    public WebElement getWorkerMiddleName() {
        return this.workerMiddleName;
    }

    public WebElement getWorkerPhone() {
        return this.workerPhone;
    }

    public WebElement getWorkerExtraPhone() {
        return this.workerExtraPhone;
    }

    public WebElement getWorkerEmail() {
        return this.workerEmail;
    }

    public WebElement getAddButton() {
        return this.addButton;
    }

    public WebElement getClearAll() {
        return this.clearAll;
    }

    public WebElement getCloseFormButton() {
        return this.closeFormButton;
    }

    public String getWorkerLoginText() {
        return this.workerLogin.getText();
    }

    public String getWorkerPasswordText() {
        return this.workerPassword.getText();
    }
    
    public String getWorkerRepeatPasswordText() {
        return this.workerRepeatPassword.getText();
    }
    
    public String getWorkerNameText() {
        return this.workerName.getText();
    }

    public String getWorkerLastNameText() {
        return this.workerLastName.getText();
    }
    
    public String getWorkerMiddleNameText() {
        return this.workerMiddleName.getText();
    }

    public String getWorkerPhoneText() {
        return this.workerPhone.getText();
    }
    
    public String getWorkerExtraPhoneText() {
        return this.workerExtraPhone.getText();
    }

    public String getWorkerEmailText() {
        return this.workerEmail.getText();
    }

    // Set Data
    public void setWorkerLogin(String workerLogin) {
        this.workerLogin.sendKeys(workerLogin);
    }

    public void setWorkerPassword(String workerPassword) {
        this.workerPassword.sendKeys(workerPassword);
    }
    
    public void setWorkerRepeatPassword(String workerRepeatPassword) {
        this.workerRepeatPassword.sendKeys(workerRepeatPassword);
    }
    
    public void setWorkerName(String workerName) {
        this.workerName.sendKeys(workerName);
    }

    public void setWorkerLastName(String workerLastName) {
        this.workerLastName.sendKeys(workerLastName);
    }
    
    public void setWorkerMiddleName(String workerMiddleName) {
        this.workerMiddleName.sendKeys(workerMiddleName);
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone.sendKeys(workerPhone);
    }
    
    public void setWorkerExtraPhone(String workerExtraPhone) {
        this.workerExtraPhone.sendKeys(workerExtraPhone);
    }

    public void setWorkerEmail(String workerEmail) {
        this.workerEmail.sendKeys(workerEmail);
    }

    public void clearWorkerLogin() {
        this.workerLogin.clear();
    }

    public void clearWorkerPassword() {
        this.workerPassword.clear();
    }
    
    public void clearWorkerRepeatPassword() {
        this.workerRepeatPassword.clear();
    }

    public void clearWorkerName() {
        this.workerName.clear();
    }

    public void clearWorkerMiddleName() {
        this.workerMiddleName.clear();
    }
    
    public void clearWorkerLastName() {
        this.workerLastName.clear();
    }

    public void clearWorkerPhone() {
        this.workerPhone.clear();
    }
    
    public void clearWorkerExtraPhone() {
        this.workerExtraPhone.clear();
    }

    public void clearWorkerEmail() {
        this.workerEmail.clear();
    }
    
    public void clickWorkerLogin() {
        this.workerLogin.click();
    }

    public void clickWorkerPassword() {
        this.workerPassword.click();
    }

    public void clickWorkerRepeatPassword() {
        this.workerRepeatPassword.click();
    }
    
    public void clickWorkerName() {
        this.workerName.click();
    }

    public void clickWorkerMiddleName() {
        this.workerMiddleName.click();
    }
    
    public void clickWorkerLastName() {
        this.workerLastName.click();
    }

    public void clickWorkerPhone() {
        this.workerPhone.click();
    }
    
    public void clickWorkerExtraPhone() {
        this.workerExtraPhone.click();
    }

    public void clickWorkerEmail() {
        this.workerEmail.click();
    }

    public void clickAddButton() {
        this.addButton.click();
    }

    public void clickClearAll() {
        this.clearAll.click();
    }

    public void clickCloseForm() {
        this.closeFormButton.click();
    }

    // Business Logic
    private void setNewWorker(IUser user) {
        clickWorkerLogin();
        clearWorkerLogin();
        setWorkerLogin(user.getLogin());
        clickWorkerPassword();
        clearWorkerPassword();
        setWorkerPassword(user.getPassword());
        clickWorkerRepeatPassword();
        clearWorkerRepeatPassword();
        setWorkerRepeatPassword(user.getPassword());
        clickWorkerName();
        clearWorkerName();
        setWorkerName(user.getFirstname());
        clickWorkerMiddleName();
        clearWorkerMiddleName();
        setWorkerMiddleName(user.getMiddlename());
        clickWorkerLastName();
        clearWorkerLastName();
        setWorkerLastName(user.getLastname());
        clickWorkerPhone();
        clearWorkerPhone();
        setWorkerPhone(user.getPhone());
        clickWorkerEmail();
        clearWorkerEmail();
        setWorkerEmail(user.getEmail());
        clickAddButton();
    }

    public AddNewWorkerConfirmPage successAddNewWorker(IUser newWorker) {
        setNewWorker(newWorker);
        return new AddNewWorkerConfirmPage(driver);
    }

    public AddNewWorkerValidationMPage unsuccessfullAddNewUser(IUser newWorker) {
        setNewWorker(newWorker);
        return new AddNewWorkerValidationMPage(driver);
    }
}
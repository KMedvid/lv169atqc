package calibrationDevices.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import calibrationDevices.data.IVerifications;

public class DeleteVerificationValidatorPage {
    
    private WebDriver driver;
    private WebElement okButton;
    private WebElement textField;

    
    public DeleteVerificationValidatorPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 30)).until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        this.okButton = driver.findElement(By.cssSelector("button[type='submit']"));
        this.textField = driver.findElement(By.id("message"));
    }
    
    // Get Elements
    
    public WebElement getOkButton() {
        return this.okButton;
    }
    
    public WebElement getTextField() {
        return this.textField;
    }
    
    public String getTextFieldTexxt() {
        return this.textField.getText();
    }
    
    public void setTextField(String message) {
        this.textField.sendKeys(message);
    }
    
    public void clickTextField() {
        this.textField.click();
    }
    
    public void clickOkButton() {
        this.okButton.click();
    }
    

    public NewVerificationsPage enterOkButton(IVerifications verification) {
        clickTextField();
        setTextField(verification.getLastName());
        clickOkButton();
        return new NewVerificationsPage(driver);
    }
}

package calibrationDevices.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignVerificationToWorkerPage {
    
    private WebDriver driver;
    private WebElement okButton;

    
    public AssignVerificationToWorkerPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector(" .btn-success.pull-left")));
        this.okButton = driver.findElement(By.cssSelector(".btn-success.pull-left"));
    }
    
    // Get Elements
    public WebElement getOkButton() {
        return this.okButton;
    }
    
    public void clickOkButton() {
        this.okButton.click();
    }

    public NewVerificationsPage enterOkButton() {
        clickOkButton();
        return new NewVerificationsPage(driver);
    }
}

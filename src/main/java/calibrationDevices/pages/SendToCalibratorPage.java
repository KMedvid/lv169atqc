package calibrationDevices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendToCalibratorPage {
    private WebDriver driver;
    private WebElement sendButton;

    public SendToCalibratorPage(WebDriver driver) {
        this.driver = driver;
        this.sendButton = driver.findElement(By.cssSelector(".btn-success.pull-left"));
    }
    
    // Get Elements
    public WebElement getSendButton() {
        return this.sendButton;
    }
    
    public void clickSendButton() {
        this.sendButton.click();
    }

    public NewVerificationsPage sendButton() {
        clickSendButton();
        return new NewVerificationsPage(driver);
    }
}

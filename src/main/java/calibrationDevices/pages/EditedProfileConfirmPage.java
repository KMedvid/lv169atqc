package calibrationDevices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditedProfileConfirmPage {
    public static final String START_SUCCESS_MESSAGE = "Ви успішно відредагували працівника!";
    //
    private WebDriver driver;
    private WebElement successMessage;
    private WebElement okButton;

    public EditedProfileConfirmPage(WebDriver driver) {
        this.driver = driver;
        this.successMessage = driver.findElement(By.id("successMessage"));
        this.okButton = driver.findElement((By.cssSelector("button[ ng-click='successController.ok()']")));
    }

    // Get Elements
    public WebElement getSuccessMessage() {
        return this.successMessage;
    }
    
    public WebElement getOkButton() {
        return this.okButton;
    }
    
    public String getSuccessMessageText() {
        return this.successMessage.getAttribute("textContent");
    }
    
    public String getStartSuccessMessageText() {
        return this.successMessage.getAttribute("textContent").substring(START_SUCCESS_MESSAGE.length());
    }
    
    public void clickOkButton() {
        this.okButton.click();
    }

    public ProfileInfoPage enterOkButton() {
        clickOkButton();
        return new ProfileInfoPage(driver);
    }

}

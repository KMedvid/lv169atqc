package calibrationDevices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewWorkerValidationMPage extends AddNewWorkerFormPage {
    public static final String START_VALIDATOR_MESSAGE = "Такий логін вже існує";
    //
    private WebElement validator;

    public AddNewWorkerValidationMPage(WebDriver driver) {
        super(driver);
        this.validator = driver.findElement(By.cssSelector("p[ng-if='!usernameValidation.isValid']"));
    }

    // Get Elements
    public WebElement getValidator() {
        return this.validator;
    }

    public String getValidatorText() {
        return this.validator.getAttribute("textContent");
    }

    public String getStartValidatorText() {
        return this.validator.getAttribute("textContent").substring(0, START_VALIDATOR_MESSAGE.length());
    }
}

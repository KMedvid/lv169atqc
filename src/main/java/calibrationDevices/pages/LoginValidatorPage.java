package calibrationDevices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginValidatorPage extends LoginPage {
    public static final String START_VALIDATOR_MESSAGE = 
            "Не вдалось  залогуватись, перевірте коректність введених даних";
    //
    private WebElement validator;

    public LoginValidatorPage(WebDriver driver) {
        super(driver);
        this.validator = driver.findElement(By.id("incorrectLoginMessage"));
    }

    // Get Elements

    public WebElement getValidator() {
        return this.validator;
    }

    public String getValidatorText() {
        return this.validator.getAttribute("textContent");
    }

    public String getStartValidatorText() {
        return this.validator.getAttribute("textContent")
                .substring(0, START_VALIDATOR_MESSAGE.length());
    }

}

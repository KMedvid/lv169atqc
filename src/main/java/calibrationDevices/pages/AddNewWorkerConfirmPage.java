package calibrationDevices.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewWorkerConfirmPage {
    public static final String START_SUCCESS_MESSAGE = "    Ви успішно додали нового працівника";
    //
    private WebDriver driver;
    private WebElement successMessage;
    private WebElement okButton;

    public AddNewWorkerConfirmPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 30)).until(ExpectedConditions
                .visibilityOfElementLocated(By.id("successMessage")));
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
        return this.successMessage.getAttribute("textContent").substring(1, START_SUCCESS_MESSAGE.length()+1);
    }
    
    public void clickOkButton() {
        this.okButton.click();
    }

    public EmployeesPage enterOkButton() {
        clickOkButton();
        return new EmployeesPage(driver);
    }

}

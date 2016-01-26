package calibrationDevices.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    protected WebDriver driver;
    
    private WebElement userName;
    private WebElement profileMenu;
    private WebElement languageChange;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 40)).until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".dropdown-toggle>div")));
        this.userName=driver.findElement(By.cssSelector(".dropdown-toggle>div"));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector(".fa.fa-caret-down")));
        this.profileMenu=driver.findElement(By.cssSelector(".fa.fa-caret-down"));
    }

    // Get Elements
    public WebElement getUserName() {
        return this.userName;
    }
    
    public WebElement getprofileMenu() {
        return this.profileMenu;
    }

    public WebElement getLanguageChange() {
        return this.languageChange;
    }
    
    public String getUserNameText() {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return userName.getText().length() != 0;
                }
    });
        return this.userName.getText();
    }
    
    public String getLanguageText() {
        return this.languageChange.getText();
    }

    // Set Data
    public void clickProfileMenu() {
        this.profileMenu.click();
    }
    
    public void clickLanguageChange() {
        this.languageChange.click();
    }

    // Business Logic
    public ProfileMenuPage openProfileMenu() {
        clickProfileMenu();
        return new ProfileMenuPage(driver);
    }

}

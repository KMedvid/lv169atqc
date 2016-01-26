package calibrationDevices.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPageMD {
    protected WebDriver driver;
    //
    private WebElement startPage;
    private WebElement language;
    private WebElement aboutPage;
    private WebElement login;
    private WebElement applyForVerification;
    private WebElement applicationStatus;

    public StartPageMD(WebDriver driver) {
        this.driver = driver;
        
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 40)).until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("a[href*='start']")));
        //
        this.startPage=driver.findElement(By.cssSelector("a[href*='start']"));
        this.language=driver.findElement(By.cssSelector(".dropdown-toggle.ng-binding"));
        this.aboutPage=driver.findElement(By.cssSelector("a[href*='about']"));
        this.login=driver.findElement(By.cssSelector("a[href*='login']"));
        this.applyForVerification=driver.findElement(By.cssSelector("a[href*='application-sending']"));
        this.applicationStatus=driver.findElement(By.cssSelector("a[href*='application-status']"));
    }

    // Get Elements
    public WebElement getStartPage() {
        return this.startPage;
    }
    
    public WebElement getLanguage() {
        return this.language;
    }

    public WebElement getAboutPage() {
        return this.aboutPage;
    }
    public WebElement getLogin() {
        return this.login;
    }
    
    public WebElement getApplyForVerification() {
        return this.applyForVerification;
    }

    public WebElement getApplicationStatus() {
        return this.applicationStatus;
    }
    
    // Set Data
    public void clickStartPage() {
        this.startPage.click();
    }
    
    public void clickLanguage() {
        this.language.click();
    }
    
    public void clickAboutPage() {
        this.aboutPage.click();
    }

    public void clickLogin() {
        this.login.click();
    }

    public void clickApplyForVerification() {
        this.applyForVerification.click();
    }

    public void clickApplicationStatus() {
        this.applicationStatus.click();
    }

    // Business Logic
    public LoginPage goToLoginPage() {
        clickLogin();
        return new LoginPage(driver);
    }
    
    public StartPageMD goToStartPage() {
        clickStartPage();
        return new StartPageMD(driver);
    }
    
    public ApplyForVerificationPage applyForVerification(){
        clickApplyForVerification();
        return new ApplyForVerificationPage(driver);
    }

}

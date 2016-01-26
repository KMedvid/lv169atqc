package calibrationDevices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationArchivePage extends MainPage {

    public static final String PAGE_TITLE = "Архів повірок";
    
    private WebElement pagetitle;

    public VerificationArchivePage(WebDriver driver) {
        super(driver);
        this.pagetitle= driver.findElement(By.cssSelector("h1[class*='page-header']"));
        //
    }

    // Get Elements
    public WebElement getPagetitle() {
        return this.pagetitle;
    }

    public String getPageTitleText() {
        return this.pagetitle.getText();
    }

    public String getStartPageTitleText() {
        return this.pagetitle.getText().substring(0, PAGE_TITLE.length());
    }
    // Set Data
    // Business Logic
}

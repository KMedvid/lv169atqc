package calibrationDevices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeStatisticsPage  extends MainPage{

    public static final String PAGE_TITLE = "'Продуктивність працівників'";
    
    private WebElement pagetitle;
    
    public EmployeeStatisticsPage(WebDriver driver) {
        super(driver);
        this.pagetitle= driver.findElement(By.cssSelector(".highcharts-title"));
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

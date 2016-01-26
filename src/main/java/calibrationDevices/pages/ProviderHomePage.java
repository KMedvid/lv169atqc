package calibrationDevices.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import calibrationDevices.pages.MainPage;

public class ProviderHomePage extends MainPage {
    //
    private WebElement providerMainPanel;
    private WebElement newVerifications;
    private WebElement employees;
    private WebElement verificationArchive;
    private WebElement employeeStatistics;
    
    public ProviderHomePage(WebDriver driver) {
        super(driver);
        //
        this.providerMainPanel=driver.findElement(By.cssSelector("span[translate*='MAIN_PANEL_PROVIDER']"));
        this.newVerifications=driver.findElement(By.cssSelector("span[translate*='NEW_VERIFICATIONS']"));
        this.employees=driver.findElement(By.cssSelector("span[translate*='EMPLOYEE']"));
        this.verificationArchive=driver.findElement(By.cssSelector("span[translate*='VERIFICATIONS_ARCHIVE']"));
        this.employeeStatistics=driver.findElement(By.cssSelector("span[translate*='STATISTIC_OF_EMPLOYEE_CAPACITY']"));
    }

    // Get Elements
    public WebElement getProviderMainPanel() {
        return this.providerMainPanel;
    }
    
    public WebElement getNewVerification() {
        return this.newVerifications;
    }
    
    public WebElement getEmployees() {
        return this.employees;
    }
    
    public WebElement getVerificationArchive() {
        return this.verificationArchive;
    }
    
    public WebElement getEmployeeStatistics() {
        return this.employeeStatistics;
    }

    // Set Data
    public void clickProviderMainPanel() {
        this.providerMainPanel.click();
    }
    
    public void clickNewVerifications() {
        this.newVerifications.click();
    }
    
    public void clickEmployees() {
        this.employees.click();
    }
    
    public void clickVerificationArchive() {
        this.verificationArchive.click();
    }
    
    public void clickEmployeeStatistics() {
        this.employeeStatistics.click();
    }
    
    // Business Logic
    public ProviderMainPanelPage gotoProviderMainPanelPage() {
        clickProviderMainPanel();
        return new ProviderMainPanelPage(driver);
    }
    
    public NewVerificationsPage gotoNewVerificationsPage() {
        clickNewVerifications();
        return new NewVerificationsPage(driver);
    }
    
    public EmployeesPage gotoEmployeesPage() {
        clickEmployees();
        return new EmployeesPage(driver);
    }
    
    public VerificationArchivePage gotoVerificationArchivePage() {
        clickVerificationArchive();
        return new VerificationArchivePage(driver);
    }
    
    public EmployeeStatisticsPage gotoEmployeeStatisticsPage() {
        clickEmployeeStatistics();
        return new EmployeeStatisticsPage(driver);
    }

}

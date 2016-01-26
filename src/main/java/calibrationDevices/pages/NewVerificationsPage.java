package calibrationDevices.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import calibrationDevices.data.IVerifications;
import calibrationDevices.data.VerificationsRepository;

public class NewVerificationsPage  extends MainPage{
    
    public static enum VerificationTableFields {
        LAST_NAME("Last Name"),
        VERIFICATION_ID("Role");
        //
        private String field;

        private VerificationTableFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    //
    public static final String PAGE_TITLE = "Нові повірки";
    
    private WebElement pagetitle;
    private WebElement searchFieldVerificationsId;
    private WebElement searchFieldName;
    private WebElement searchFieldRegion;
    private WebElement searchFieldDistrict;
    private WebElement searchFieldStreet;
    private WebElement searchFieldCity;
    private WebElement searchFieldWorkerName;
    private WebElement assignToWorker;
    private WebElement deleteVerification;
    private WebElement activateCheckbox;
    private WebElement sendToCalibrator;
    //
    private WebElement lastname;
    private WebElement verificationsId;
    
    public NewVerificationsPage(WebDriver driver) {
        super(driver);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector(".page-header")));
        this.pagetitle= driver.findElement(By.cssSelector(".page-header"));
        this.searchFieldVerificationsId= driver.findElement(By.cssSelector("th:nth-of-type(3) [ng-model='params.filter()[name]']"));
        this.searchFieldName= driver.findElement(By.cssSelector("th:nth-of-type(4) [ng-model='params.filter()[name]']"));
        this.searchFieldRegion= driver.findElement(By.cssSelector("th:nth-of-type(5) [ng-model='params.filter()[name]']"));
        this.searchFieldDistrict= driver.findElement(By.cssSelector("th:nth-of-type(6) [ng-model='params.filter()[name]']"));
        this.searchFieldStreet= driver.findElement(By.cssSelector("th:nth-of-type(7) [ng-model='params.filter()[name]']"));
        this.searchFieldCity= driver.findElement(By.cssSelector("th:nth-of-type(8) [ng-model='params.filter()[name]']"));
        this.searchFieldWorkerName= driver.findElement(By.cssSelector("th:nth-of-type(10) [ng-model='params.filter()[name]']"));
        this.sendToCalibrator = driver.findElement(By.cssSelector("[ng-click='openSendingModal()']"));

        //
    }

    private void initFirstTableRow() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 30)).until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("tr:nth-child(1) td[data-title *='VERIFICATION_ID']")));
        this.verificationsId = driver.findElement(By.cssSelector("tr:nth-child(1) td[data-title *='VERIFICATION_ID']"));
        this.deleteVerification = driver.findElement(By.cssSelector(".fa.fa-ban.cancel_icon"));
    }
    
    private void activateFirstCheckbox(){
        this.activateCheckbox = driver.findElement(By.cssSelector("tr:nth-child(1) [ng-model='verification.selected']"));
        this.activateCheckbox.click();
    }
    
    private void locateAssignToWorkerSign(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector(" .add_attached_user_icon")));
        this.assignToWorker = driver.findElement(By.cssSelector(" .add_attached_user_icon"));
    }

    private void findDeleteVerification(){
        this.deleteVerification = driver.findElement(By.cssSelector(".fa.fa-ban.cancel_icon"));
    }
    
    // Get Elements
    public WebElement getPagetitle() {
        return this.pagetitle;
    }
    
    public WebElement getSearchFieldVerificationsId() {
        return this.searchFieldVerificationsId;
    }
    
    public WebElement getSearchFieldName() {
        return this.searchFieldName;
    }
    
    public WebElement getSearchFieldRegion() {
        return this.searchFieldRegion;
    }
    
    public WebElement getSearchFieldDistrict() {
        return this.searchFieldDistrict;
    }
    
    public WebElement getSearchFieldStreet() {
        return this.searchFieldStreet;
    }
    
    public WebElement getSearchFieldCity() {
        return this.searchFieldCity;
    }
    
    public WebElement getSearchFieldWorkerName() {
        return this.searchFieldWorkerName;
    }

    public WebElement getLastname() {
        return this.lastname;
    }

    public WebElement getVerificatiosId() {
        return this.verificationsId;
    }
    
    public WebElement getAssignToWorker() {
        return this.assignToWorker;
    }
    
    public WebElement getDeleteVerification() {
        return this.deleteVerification;
    }
    
    public WebElement getActivateCheckbox() {
        return this.activateCheckbox;
    }
    
    public WebElement getSendToCalibrator() {
        return this.sendToCalibrator;
    }
    
    public String getPageTitleText() {
        return this.pagetitle.getText();
    }
    
    public String getVerificationsIdText() {
        return this.verificationsId.getText();
    }
    
    
    public String getSearchFieldVerificationsIdText() {
        return this.searchFieldVerificationsId.getText();
    }
    
    public String getSearchFieldNameText() {
        return this.searchFieldName.getText();
    }
    
    public String getSearchFieldRegionText() {
        return this.searchFieldRegion.getText();
    }
    
    public String getSearchFieldDistrictText() {
        return this.searchFieldDistrict.getText();
    }
    
    public String getSearchFieldStreetText() {
        return this.searchFieldStreet.getText();
    }
    
    public String getSearchFieldCityText() {
        return this.searchFieldCity.getText();
    }
    
    public String getSearchFieldWorkerNameText() {
        return this.searchFieldWorkerName.getText();
    }
    

    public void setSearchFieldVerificationsId(String searchText) {
        this.searchFieldVerificationsId.sendKeys(searchText);
    }
    

    public void setSearchFieldName(String searchText) {
        this.searchFieldName.sendKeys(searchText);
    }
    

    public void setSearchFieldRegion(String searchText) {
        this.searchFieldRegion.sendKeys(searchText);
    }
    

    public void setSearchFieldDistrict(String searchText) {
        this.searchFieldDistrict.sendKeys(searchText);
    }
    

    public void setSearchFieldStreet(String searchText) {
        this.searchFieldStreet.sendKeys(searchText);
    }
    

    public void setSearchFieldCity(String searchText) {
        this.searchFieldCity.sendKeys(searchText);
    }
    

    public void setSearchFieldWorkerName(String searchText) {
        this.searchFieldWorkerName.sendKeys(searchText);
    }

    public String getStartPageTitleText() {
        return this.pagetitle.getText().substring(0, PAGE_TITLE.length());
    }

    // Set Data
    public void clickSearchFieldVerificationsId() {
        this.searchFieldVerificationsId.click();
    }
    

    public void clickSearchFieldName() {
        this.searchFieldName.click();
    }
    

    public void clickSearchFieldRegion() {
        this.searchFieldRegion.click();
    }
    

    public void clickSearchFieldDistrict() {
        this.searchFieldDistrict.click();
    }
    

    public void clickSearchFieldStreet() {
        this.searchFieldStreet.click();
    }
    
    public void clickAssignToWorker() {
        this.assignToWorker.click();
    }
    
    public void clickDeleteVerification() {
        this.deleteVerification.click();
    }

    public void clickSearchFieldCity() {
        this.searchFieldCity.click();
    }
    

    public void clickSearchFieldWorkerName() {
        this.searchFieldWorkerName.click();
    }
    
    
    public void clickActivateCheckbox() {
        this.activateCheckbox.click();
    }
    
    public void clickSendToCalibrator() {
        this.sendToCalibrator.click();
    }
    
    public void submitSearchVerificationsId() {
        this.searchFieldVerificationsId.submit();
    }
    
    public void clearSearchFieldVerificationsId() {
        this.searchFieldVerificationsId.clear();
    }
    

    public void clearSearchFieldName() {
        this.searchFieldName.clear();
    }
    

    public void clearSearchFieldRegion() {
        this.searchFieldRegion.clear();
    }
    

    public void clearSearchFieldDistrict() {
        this.searchFieldDistrict.clear();
    }
    

    public void clearSearchFieldStreet() {
        this.searchFieldStreet.clear();
    }
    

    public void clearSearchFieldCity() {
        this.searchFieldCity.clear();
    }
    

    public void clearSearchFieldWorkerName() {
        this.searchFieldWorkerName.clear();
    }

    // Business Logic
    public void searchVerification(IVerifications verification, VerificationTableFields field) throws InterruptedException {
        switch (field) {
        case LAST_NAME:
            clickSearchFieldName();
            clearSearchFieldName();
            setSearchFieldName(verification.getLastName());
            break;
        case VERIFICATION_ID:
            clickSearchFieldVerificationsId();
            clearSearchFieldVerificationsId();
            setSearchFieldVerificationsId(verification.getVerificationsId());
            break;
        default:
            clickSearchFieldVerificationsId();
            clearSearchFieldVerificationsId();
            setSearchFieldVerificationsId(verification.getVerificationsId());
        }
        Thread.sleep(4000);
        initFirstTableRow();
    }
    
    public void searchVerificationById(IVerifications verification) throws InterruptedException  {
        searchVerification(verification, VerificationTableFields.VERIFICATION_ID);
    }
    
    public void searchVerificationByIdCOde(String verification) throws InterruptedException  {
        clickSearchFieldVerificationsId();
        clearSearchFieldVerificationsId();
        setSearchFieldVerificationsId(verification);
        Thread.sleep(4000);
        initFirstTableRow();
    }
    
    public AssignVerificationToWorkerPage assignToWorker() {
        locateAssignToWorkerSign();
        clickAssignToWorker();
        return new AssignVerificationToWorkerPage(driver);
    }
    
    
    public DeleteVerificationValidatorPage deleteVerification(String verification)  throws InterruptedException {
        searchVerificationByIdCOde(verification);
        findDeleteVerification();
        clickDeleteVerification();
        return new DeleteVerificationValidatorPage(driver);
    }
    
    public SendToCalibratorPage sendToCalibrator() {
        clickSendToCalibrator();
        return new SendToCalibratorPage(driver);
    }
    
    public SendToCalibratorPage assignVerificationToCalibrator(String verificationId) throws InterruptedException {
        searchVerificationByIdCOde(verificationId);
        Thread.sleep(2000);
        activateFirstCheckbox();
        clickSendToCalibrator();
        return new SendToCalibratorPage(driver);
    }
    
}

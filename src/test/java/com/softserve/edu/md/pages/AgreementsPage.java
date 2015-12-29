package com.softserve.edu.md.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.md.data.CustomerType;
import com.softserve.edu.md.data.IAgreement;
import com.softserve.edu.md.data.WaterType;

public class AgreementsPage extends AdminHomePage {

    private WebElement addAgreement;
    private WebElement agreementCodeField;
    private WebElement customerField;
    private WebElement executorField;
    private WebElement selectWaterTypeField;
    //
    private WebElement agreementCode;
    private WebElement customer;
    private WebElement executor;
    private WebElement WaterType;
    private WebElement deleteAgreement;

    AgreementsPage(WebDriver driver) {
        super(driver);
        this.addAgreement = driver.findElement(By
                .xpath("//button[@ng-click ='openAddAgreementModal()']"));
        this.agreementCodeField = driver.findElement(By.xpath("//th[1]//input"));
        this.customerField = driver.findElement(By.xpath("//th[3]//input"));
        this.executorField = driver.findElement(By.xpath("//th[4]//input"));
        this.selectWaterTypeField = driver.findElement(By
                .xpath("//a[@placeholder = 'Оберіть вид лічильника']"));

        this.agreementCode = driver.findElement(By
                .xpath("//tr[1]/td[@data-title-text = 'Код']"));
        this.customer = driver.findElement(By
                .xpath("//tr[1]/td[@data-title-text = 'Замовник']"));
        this.executor = driver.findElement(By
                .xpath("//tr[1]/td[@data-title-text = 'Виконавець']"));
        this.WaterType = driver.findElement(By
                .xpath("//tr[1]/td[@data-title-text = 'Вид лічильника']"));
        
        this.deleteAgreement = driver.findElement(By
                .xpath("//tr[1]/td[7]/div/button[@class = 'btn btn-danger']"));

    }

    // Get Elements
    public WebElement getAddAgreement() {
        return addAgreement;
    }

    public WebElement getAgreementCodeField() {
        return agreementCodeField;
    }

    public WebElement getCustomerField() {
        return customerField;
    }

    public WebElement getExecutorField() {
        return executorField;
    }

    public WebElement getSelectWaterTypeField() {
        return selectWaterTypeField;
    }

    public WebElement getAgreementCode() {
        return agreementCode;
    }

    public WebElement getCustomer() {
        return customer;
    }

    public WebElement getExecutor() {
        return executor;
    }

    public WebElement getWaterType() {
        return WaterType;
    }

    public WebElement getDeleteAgreement() {
        return deleteAgreement;
    }

    public String getAgreementCodeText() {
        return agreementCode.getText();
    }

    public String getCustomerText() {
        return customer.getText();
    }

    public String getExecutorText() {
        return executor.getText();
    }

    // Set Elements
    public void setAgreementCodeField(String agreementCode) {
        this.agreementCodeField.sendKeys(agreementCode);
    }

    public void setCustomerField(String customerField) {
        this.customerField.sendKeys(customerField);
    }

    public void setExecutorField(String executorField) {
        this.executorField.sendKeys(executorField);
    }

    public void setSelectWaterTypeField(WaterType waterTypeField) {
        clickSelectWaterTypeField();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[text() = '" + waterTypeField.toString() + "']")));

        driver.findElement(By.xpath("//span[text() = '" + waterTypeField.toString() + "']")).click();
    }

    // Click Elements
    public void clickAddAgreement() {
        addAgreement.click();
    }

    public void clickAgreementCodeField() {
        agreementCodeField.click();
    }

    public void clickDeleteAgreement() {
        deleteAgreement.click();
    }

    public void clickCustomerField() {
        customerField.click();
    }

    public void clickExecutorField() {
        executorField.click();
    }

    public void clickSelectWaterTypeField() {
        selectWaterTypeField.click();
    }

    // Clear Elements
    public void clearAgreementCodeField() {
        agreementCodeField.clear();
    }

    public void clearCustomerField() {
        customerField.clear();
    }

    public void clearExecutorField() {
        executorField.clear();
    }

    // Business Logic
    /**
     * 
     */
    public void addAgreement(IAgreement agreement) {
        clickAddAgreement();
        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT))
                .until(ExpectedConditions.visibilityOf(new NewAgreementPage(driver).getWaterTypeField()));

        new NewAgreementPage(driver).fillFieldsNewAgreement(agreement);

        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT))
                .until(ExpectedConditions.visibilityOf(new AgreementsPage(driver).getSelectWaterTypeField()));
    }

    /**
     * Read out all the elements of the first row of the meters category table.
     */
    public void initFirstTableRow() {
        this.agreementCode = driver.findElement(By.xpath("//tr[1]/td[@data-title-text = 'Код']"));
        this.customer = driver.findElement(By.xpath("//tr[1]/td[@data-title-text = 'Замовник']"));
        this.executor = driver.findElement(By.xpath("//tr[1]/td[@data-title-text = 'Виконавець']"));
        this.WaterType = driver.findElement(By.xpath("//tr[1]/td[@data-title-text = 'Вид лічильника']"));
        this.deleteAgreement = driver.findElement(By.xpath("//tr[1]/td[7]/div/button[@class = 'btn btn-danger']"));

    }

    /**
     * Pop-up window for adding new meter category page .
     */
    private class NewAgreementPage {
        private WebDriver driver;
        //
        private WebElement waterTypeField;
        private WebElement customerTypeField;
        private WebElement customerNameField;
        private WebElement executorField;
        private WebElement agreementCodeField;
        private WebElement meterQuantityField;
        private WebElement submit;

        NewAgreementPage(WebDriver driver) {
            this.driver = driver;
            this.waterTypeField = driver.findElement(
                    By.xpath("//div[@id = 'deviceType']/a[@class = 'select2-choice ui-select-match select2-default']"));
            this.customerTypeField = driver.findElement(By.xpath(
                    "//div[@id = 'organizationType']/a[@class = 'select2-choice ui-select-match select2-default']"));
            this.customerNameField = driver
                    .findElement(By.xpath("//div[@id = 'customers']/a[@class = 'select2-choice ui-select-match']"));
            this.executorField = driver
                    .findElement(By.xpath("//div[@id = 'executors']/a[@class = 'select2-choice ui-select-match']"));
            ;
            this.agreementCodeField = driver.findElement(By.xpath("//input[@id = 'number']"));
            this.meterQuantityField = driver.findElement(By.xpath("//input[@id = 'deviceCount']"));
            this.submit = driver
                    .findElement(By.xpath("//div[@class = 'form-group row row-buttons']/button[@type = 'submit']"));
        }

        // Get Elements
        public WebElement getWaterTypeField() {
            return waterTypeField;
        }

        public WebElement getCustomerTypeField() {
            return customerTypeField;
        }

        public WebElement getCustomerNameField() {
            return customerNameField;
        }

        public WebElement getExecutorField() {
            return executorField;
        }

        public WebElement getAgreementCodeField() {
            return agreementCodeField;
        }

        public WebElement getMeterQuantityField() {
            return meterQuantityField;
        }

        // Set Elements
        public void setCustomerTypeField(CustomerType customer) {
            clickCustomerTypeField();
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath("//span[text() = '" + customer.toString() + "']")));

            driver.findElement(By.xpath("//span[text() = '" + customer.toString() + "']")).click();
        }

        public void setCustomerNameField(String customerName) {
            clickCustomerNameField();
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text() = '" + customerName + "']")));

            driver.findElement(By.xpath("//span[text() = '" + customerName + "']")).click();
        }

        public void setExecutorField(String executor) {
            clickExecutorField();
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text() = '" + executor + "']")));

            driver.findElement(By.xpath("//span[text() = '" + executor + "']")).click();
        }

        public void setAgreementCodeField(String agreementCode) {
            clickAgreementCodeField();
            clearAgreementCodeField();
            this.agreementCodeField.sendKeys(agreementCode);
        }

        public void setMeterQuantityField(Integer meterQuantity) {
            clickMeterQuantityField();
            clearMeterQuantityField();
            this.meterQuantityField.sendKeys(meterQuantity.toString());
        }

        public void setWaterTypeField(WaterType waterType) {
            clickWaterTypeField();
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath("//span[text() = '" + waterType.toString() + "']")));

            driver.findElement(By.xpath("//span[text() = '" + waterType.toString() + "']")).click();
        }

        // Click Elements
        public void clickWaterTypeField() {
            this.waterTypeField.click();
        }

        public void clickCustomerTypeField() {
            this.customerTypeField.click();
        }

        public void clickCustomerNameField() {
            this.customerNameField.click();
        }

        public void clickExecutorField() {
            this.executorField.click();
        }

        public void clickAgreementCodeField() {
            this.agreementCodeField.click();
        }

        public void clickMeterQuantityField() {
            this.meterQuantityField.click();
        }

        public void clickSubmit() {
            this.submit.click();
        }

        // Clear Element
        public void clearWaterTypeField() {
            this.waterTypeField.clear();
        }

        public void clearCustomerTypeField() {
            this.customerTypeField.clear();
        }

        public void clearCustomerNameField() {
            this.customerNameField.clear();
        }

        public void clearExecutorField() {
            this.executorField.clear();
        }

        public void clearAgreementCodeField() {
            this.agreementCodeField.clear();
        }

        public void clearMeterQuantityField() {
            this.meterQuantityField.clear();
        }

        // Business Logic
        void fillFieldsNewAgreement(IAgreement agreement) {
            setWaterTypeField(agreement.getWaterType());
            setCustomerTypeField(agreement.getCustomerType());
            setCustomerNameField(agreement.getCustomerName());
            setExecutorField(agreement.getExecutorName());
            setAgreementCodeField(agreement.getAgreementCodeText());
            setMeterQuantityField(agreement.getMetersQuantity());
            clickSubmit();
        }
    }

}

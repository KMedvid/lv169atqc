package com.softserve.edu.md.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.md.data.WaterType;

public class MetersCategoryPage extends AdminHomePage{

    private WebElement addMeterCategory;
    private WebElement meterCodeField;
    private WebElement meterNameField;
    private WebElement selectWaterTypeField;

    private WebElement meterCode;
    private WebElement meterWaterType;
    private WebElement meterName;
    private WebElement deleteMeterCategory;

    MetersCategoryPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        this.addMeterCategory = driver.findElement(By.xpath("//button[@type = 'submit']"));
        this.meterCodeField = driver.findElement(By.xpath("//th[1]/div/div/div/input"));
        this.meterNameField = driver.findElement(By.xpath("//th[3]/div/div/div/input"));
        this.selectWaterTypeField = driver
                .findElement(By.xpath("//a[@class = 'select2-choice ui-select-match select2-default']"));

        this.meterCode = driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
        this.meterWaterType = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        this.meterName = driver.findElement(By.xpath("//tbody/tr[1]/td[3]"));
        this.deleteMeterCategory = driver.findElement(By.xpath("//tr[1]/td[4]/div/button[@class ='btn btn-danger']"));
    }

    // Get Elements
    public WebElement getSelectWaterTypeField() {
        return this.selectWaterTypeField;
    }
    
    public WebElement getMeterNameField() {
        return this.meterNameField;
    }

    public WebElement getMeterCode() {
        return this.meterCode;
    }

    public WebElement getMeterWaterType() {
        return this.meterWaterType;
    }

    public WebElement getMeterName() {
        return this.meterName;
    }

    public String getMeterNameFieldText() {
        return this.meterNameField.getText();
    }

    public String getMeterWaterTypeText() {
        return this.meterWaterType.getText();
    }

    public String getMeterNameText() {
        return this.meterName.getText();
    }

    // Set Elements
    public void setMeterCodeField(String meterCodeField) {
        this.meterCodeField.sendKeys(meterCodeField);
    }

    public void setMeterNameField(String meterNameField) {
        this.meterNameField.sendKeys(meterNameField);
    }

    public void setSelectWaterTypeField(WaterType waterType) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(ExpectedConditions
                .elementToBeClickable(getSelectWaterTypeField()));
        clickSelectWaterTypeField();
        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[text() = '" + waterType.toString() + "']")));
        driver.findElement(By.xpath("//span[text() = '" + waterType.toString() + "']")).click();
    }

    // Click Elements
    public void clickAddMeterCategory() {
        addMeterCategory.click();
    }

    public void clickSelectWaterTypeField() {
        selectWaterTypeField.click();
    }

    public void clickMeterNameField() {
        this.meterNameField.click();
    }

    public void clickDeleteMeterCategory() {
        deleteMeterCategory.click();
    }

    // Clear Elements
    public void clearMeterCodeField() {
        this.meterCodeField.clear();
    }

    public void clearMeterNameField() {
        this.meterNameField.clear();
    }

    /**
     * Read out all the elements of the first row of the meters category table.
     */
    public void initFirstTableRow() {
        this.meterCode = driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
        this.meterWaterType = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        this.meterName = driver.findElement(By.xpath("//tbody/tr[1]/td[3]"));
        this.deleteMeterCategory = driver.findElement(By.xpath("//tr[1]/td[4]/div/button[@class ='btn btn-danger']"));

    }

    // Business logic
    /**
     * Add new meter device category, steps: pressing add button, filling filed
     * water type and meter device name.
     * 
     * @param waterType
     *            - the type of water, COLD or HEATED.
     * @param meterName
     *            - the name of meter device.
     */
    public void addNewMeterCategory(WaterType waterType, String meterName) {
        clickAddMeterCategory();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT))
                .until(ExpectedConditions.visibilityOf(new NewMetersCategoryPage(driver).getMeterNameCategoryField()));
        new NewMetersCategoryPage(driver).addNewMetercategory(waterType, meterName);
        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT))
        .until(ExpectedConditions.visibilityOf(new MetersCategoryPage(driver).getMeterName()));
        
    }

    /**
     * Look for meter device category according to the parameters: water type
     * waterType and meter device name meterName.
     * 
     * @param waterType
     *            - the type of water, COLD or HEATED.
     * @param meterName
     *            - the name of meter device.
     * 
     */
    public void searchMeterCategory(WaterType waterType, String meterName) {
        setSelectWaterTypeField(waterType);
        clickMeterNameField();
        clearMeterNameField();
        setMeterNameField(meterName);
        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(ExpectedConditions.visibilityOf(getMeterName()));
        initFirstTableRow();
    }

    /**
     * Find and delete meter category from system.
     * 
     * @param waterType
     * @param meterName
     * @return true if the category found and deleted, otherwise false.
     */
    public boolean deleteMeterCategory(WaterType waterType, String meterName) {
        searchMeterCategory(waterType, meterName);
        if (getMeterNameText().equals(meterName)) {
            clickDeleteMeterCategory();
            return true;
        } else {
            return false;
        }

    }

    /**
     * Pop-up window for adding new meter category page .
     */
    private class NewMetersCategoryPage {
        private WebDriver driver;
        private WebElement waterTypeCategoryField;
        private WebElement meterNameCategoryField;
        private WebElement submit;

        NewMetersCategoryPage(WebDriver driver) {
            this.driver = driver;
            this.waterTypeCategoryField = driver.findElement(
                    By.xpath("//div[@id = 'deviceType']/a[@class = 'select2-choice ui-select-match select2-default']"));
            this.meterNameCategoryField = driver.findElement(By.xpath("//input[@ng-model = 'addCategoryFormData.deviceName']"));
            this.submit = driver.findElement(By.xpath("//div[@class = 'form-group row row-buttons']/button[@type = 'submit']"));
        }

        // Get Elements
        public WebElement getMeterNameCategoryField() {
            return meterNameCategoryField;
        }

        // Set Elements
        public void setMeterNameCategoryField(String meterName) {
            this.meterNameCategoryField.sendKeys(meterName);
        }

        public void setWaterTypeCategoryField(WaterType waterType) {
            clickWaterTypeCategoryField();
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(ExpectedConditions
                    .presenceOfElementLocated(By.xpath("//span[text() = '" + waterType.toString() + "']")));

            driver.findElement(By.xpath("//span[text() = '" + waterType.toString() + "']")).click();
        }

        // Click Elements
        public void clickMeterNameCategoryField() {
            this.meterNameCategoryField.click();
        }

        public void clickSubmit() {
            this.submit.click();
        }

        public void clickWaterTypeCategoryField() {
            this.waterTypeCategoryField.click();
        }

        // Clear Element
        public void clearMeterNameCategoryField() {
            this.meterNameCategoryField.clear();
        }

        // Business Logic
        void addNewMetercategory(WaterType waterType, String name) {
            setWaterTypeCategoryField(waterType);
            clickMeterNameCategoryField();
            clearMeterNameCategoryField();
            setMeterNameCategoryField(name);
            clickSubmit();
        }
    }

}

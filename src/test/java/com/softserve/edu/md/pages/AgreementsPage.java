package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.md.data.IAgreement;
import com.softserve.edu.md.data.WaterType;

public class AgreementsPage extends AdminHomePage {

    public void setAgreementCodeField(WebElement agreementCodeField) {
        this.agreementCodeField = agreementCodeField;
    }

    public void setCustomerField(WebElement customerField) {
        this.customerField = customerField;
    }

    public void setExecutorField(WebElement executorField) {
        this.executorField = executorField;
    }

    public void setSelectWaterTypeField(WebElement selectWaterTypeField) {
        this.selectWaterTypeField = selectWaterTypeField;
    }

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
    private WebElement deleteMeterCategory;

    AgreementsPage(WebDriver driver) {
        super(driver);
        this.addAgreement = driver.findElement(By.xpath("//button[@ng-click ='openAddAgreementModal()']"));
        this.agreementCodeField = driver.findElement(By.xpath("//th[1]//input"));
        this.customerField = driver.findElement(By.xpath("//th[3]//input"));
        this.executorField = driver.findElement(By.xpath("//th[4]//input"));
        this.selectWaterTypeField = driver.findElement(By.xpath("//a[@placeholder = 'Оберіть вид лічильника']"));

        this.agreementCode = driver.findElement(By.xpath("//tr[1]/td[@data-title-text = 'Код']"));
        this.customer = driver.findElement(By.xpath("//tr[1]/td[@data-title-text = 'Замовник']"));
        this.executor = driver.findElement(By.xpath("//tr[1]/td[@data-title-text = 'Виконавець']"));
        this.WaterType = driver.findElement(By.xpath("//tr[1]/td[@data-title-text = 'Вид лічильника']"));

        this.deleteMeterCategory = driver.findElement(By.xpath("//tr[1]/td[7]/div/button[@class = 'btn btn-danger']"));
    }

    //Get Elements
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

    public WebElement getDeleteMeterCategory() {
        return deleteMeterCategory;
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

    //Set Elements
    public void setAgreementCodeField(String agreementCode) {
        this.agreementCodeField.sendKeys(agreementCode);;
    }

    public void setCustomerField(String customerField) {
        this.customerField.sendKeys(customerField);
    }

    public void setExecutorField(String executorField) {
        this.executorField.sendKeys(executorField);
    }

    public void setSelectWaterTypeField(WaterType WaterTypeField) {
        clickSelectWaterTypeField();
        //TODO 
    }
    
    
    //Click Elements
    public void clickAgreementCodeField() {
         agreementCodeField.click();
    }
    
    public void clickDeleteMeterCategory() {
         deleteMeterCategory.click();
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
    
    //Clear Elements
    public void clearAgreementCodeField() {
        agreementCodeField.clear();
   }
   
   public void clearDeleteMeterCategory() {
        deleteMeterCategory.clear();
   }
   
   public void clearCustomerField() {
        customerField.clear();
   }

   public void clearExecutorField() {
        executorField.clear();
   }
   
   
   //Business Logic
   /**
    * 
    */
   
   void addAgreement(IAgreement agreement) {
       
   }
   
   
   
   
   
}

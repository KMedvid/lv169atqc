package com.softserve.edu.md.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.md.data.CustomerType;
import com.softserve.edu.md.data.IAgreement;
import com.softserve.edu.md.data.WaterType;


public class AgreementsPage extends AdminHomePage {
    
    private class AgreementsPageUIMap {
        private final IButton addAgreement;
        private final ITextField agreementCodeField;
        private final ITextField customerField;
        private final ITextField executorField;
        private final ILink selectWaterTypeField; 
        
        public AgreementsPageUIMap() {
            this.addAgreement = Button.get()
                    .getByXpath("//button[@ng-click ='openAddAgreementModal()']");
            this.agreementCodeField = TextField.get().getByXpath("//th[1]//input");
            this.customerField = TextField.get().getByXpath("//th[3]//input");
            this.executorField = TextField.get().getByXpath("//th[4]//input");
            this.selectWaterTypeField = Link.get()
                    .getByXpath("//a[@placeholder = 'Оберіть вид лічильника']");  
        }
    }
    
    private class AgreementsPageTableUIMap {
        private final ILabel agreementCode;
        private final ILabel customer;
        private final ILabel executor;
        private final ILabel waterType;
        private final ILink deleteAgreement;
        
        AgreementsPageTableUIMap() {
            this.agreementCode = Label.get()
                    .getByXpath("//tr[1]/td[@data-title-text = 'Код']");
            this.customer = Label.get()
                    .getByXpath("//tr[1]/td[@data-title-text = 'Замовник']");
            this.executor = Label.get()
                    .getByXpath("//tr[1]/td[@data-title-text = 'Виконавець']");
            this.waterType = Label.get()
                    .getByXpath("//tr[1]/td[@data-title-text = 'Вид лічильника']");
            this.deleteAgreement = Link.get()
                    .getByXpath("//tr[1]/td[7]/div/button[@class = 'btn btn-danger']");
        }
        
    }

    // Elements
    private AgreementsPageUIMap controls;
    private AgreementsPageTableUIMap controlsTable;    
 
    public AgreementsPage() {
        this.controls = new AgreementsPageUIMap();
        this.controlsTable = new AgreementsPageTableUIMap();
    }
    
    // Get Elements
    public IButton getAddAgreement() {
        return this.controls.addAgreement;
    }

    public ITextField getAgreementCodeField() {
        return this.controls.agreementCodeField;
    }

    public ITextField getCustomerField() {
        return this.controls.customerField;
    }

    public ITextField getExecutorField() {
        return this.controls.executorField;
    }

    public ILink getSelectWaterTypeField() {
        return this.controls.selectWaterTypeField;
    }

    public ILabel getAgreementCode() {
        return this.controlsTable.agreementCode;
    }

    public ILabel getCustomer() {
        return this.controlsTable.customer;
    }

    public ILabel getExecutor() {
        return this.controlsTable.executor;
    }

    public ILabel getWaterType() {
        return this.controlsTable.waterType;
    }

    public ILink getDeleteAgreement() {
        return this.controlsTable.deleteAgreement;
    }

    public String getAgreementCodeText() {
        return this.controlsTable.agreementCode.getText();
    }

    public String getCustomerText() {
        return this.controlsTable.customer.getText();
    }

    public String getExecutorText() {
        return this.controlsTable.executor.getText();
    }

    // Set Elements
    public void setAgreementCodeField(String agreementCode) {
        this.controls.agreementCodeField.sendKeys(agreementCode);
    }

    public void setCustomerField(String customerField) {
        this.controls.customerField.sendKeys(customerField);
    }

    public void setExecutorField(String executorField) {
        this.controls.executorField.sendKeys(executorField);
    }

    public void setSelectWaterTypeField(WaterType waterTypeField) {
        clickSelectWaterTypeField();
        //TODO ExplicitWait
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(ExpectedConditions
//                .presenceOfElementLocated(By.xpath("//span[text() = '" + waterTypeField.toString() + "']")));

        Link.get().getByXpath("//span[text() = '" + waterTypeField.toString() + "']").click();
    }

    // Click Elements
    public void clickAddAgreement() {
        this.controls.addAgreement.click();
    }

    public void clickAgreementCodeField() {
        this.controls.agreementCodeField.click();
    }

    public void clickDeleteAgreement() {
        this.controlsTable.deleteAgreement.click();
    }

    public void clickCustomerField() {
        this.controls.customerField.click();
    }

    public void clickExecutorField() {
        this.controls.executorField.click();
    }

    public void clickSelectWaterTypeField() {
        this.controls.selectWaterTypeField.click();
    }

    // Clear Elements
    public void clearAgreementCodeField() {
        this.controls.agreementCodeField.clear();
    }

    public void clearCustomerField() {
        this.controls.customerField.clear();
    }

    public void clearExecutorField() {
        this.controls.executorField.clear();
    }

    // Business Logic
    /**
     * 
     */
    public void addAgreement(IAgreement agreement) {
        clickAddAgreement();
        //TODO ExplicitWait
//        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT))
//                .until(ExpectedConditions.visibilityOf(new NewAgreementPage(driver).getWaterTypeField()));

        new NewAgreementPage().fillFieldsNewAgreement(agreement);

        //TODO ExplicitWait
//        (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT))
//                .until(ExpectedConditions.visibilityOf(new AgreementsPage(driver).getSelectWaterTypeField()));
    }

    /**
     * Read out all the elements of the first row of the meters category table.
     */
    public void initFirstTableRow() {
         controlsTable = new  AgreementsPageTableUIMap();    

//        this.agreementCode = driver.findElement(By.xpath("//tr[1]/td[@data-title-text = 'Код']"));
//        this.customer = driver.findElement(By.xpath("//tr[1]/td[@data-title-text = 'Замовник']"));
//        this.executor = driver.findElement(By.xpath("//tr[1]/td[@data-title-text = 'Виконавець']"));
//        this.WaterType = driver.findElement(By.xpath("//tr[1]/td[@data-title-text = 'Вид лічильника']"));
//        this.deleteAgreement = driver.findElement(By.xpath("//tr[1]/td[7]/div/button[@class = 'btn btn-danger']"));

    }

    /**
     * Pop-up window for adding new meter category page .
     */
    private class NewAgreementPage {
        
        private class NewAgreementPageUIMap {
           
            private final ILink waterTypeField;
            private final ITextField customerTypeField;
            private final ITextField customerNameField;
            private final ITextField executorField;
            private final ITextField agreementCodeField;
            private final ITextField meterQuantityField;
            private final IButton submit;
            
            
            public NewAgreementPageUIMap() {
                this.waterTypeField = Link.get()
                        .getByXpath("//div[@id = 'deviceType']/a[@class = 'select2-choice ui-select-match select2-default']");
                this.customerTypeField = TextField.get()
                        .getByXpath("//div[@id = 'organizationType']/a[@class = 'select2-choice ui-select-match select2-default']");
                this.customerNameField = TextField.get()
                        .getByXpath("//div[@id = 'customers']/a[@class = 'select2-choice ui-select-match']");
                this.executorField = TextField.get()
                        .getByXpath("//div[@id = 'executors']/a[@class = 'select2-choice ui-select-match']");
                ;
                this.agreementCodeField = TextField.get().getByXpath("//input[@id = 'number']");
                this.meterQuantityField = TextField.get().getByXpath("//input[@id = 'deviceCount']");
                this.submit = Button.get().getByXpath("//div[@class = 'form-group row row-buttons']/button[@type = 'submit']");
            }

        }
        
        //Elements
        private NewAgreementPageUIMap controls;
        
        public NewAgreementPage() {
            this.controls = new NewAgreementPageUIMap();
        }
        
        // Get Elements
        public ILink getWaterTypeField() {
            return this.controls.waterTypeField;
        }

        public ITextField getCustomerTypeField() {
            return this.controls.customerTypeField;
        }

        public ITextField getCustomerNameField() {
            return this.controls.customerNameField;
        }

        public ITextField getExecutorField() {
            return this.controls.executorField;
        }

        public ITextField getAgreementCodeField() {
            return this.controls.agreementCodeField;
        }

        public ITextField getMeterQuantityField() {
            return this.controls.meterQuantityField;
        }

        // Set Elements
        public void clickSpanElementWithText(String text) {
            Link.get().getByXpath("//span[text() = '" + text + "']").click();  
        }
        
        public void setCustomerTypeField(CustomerType customer) {
            clickCustomerTypeField();
            //TODO ExplicitWait
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//            (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(ExpectedConditions
//                    .presenceOfElementLocated(By.xpath("//span[text() = '" + customer.toString() + "']")));

            clickSpanElementWithText(customer.toString());
            //Link.get().getByXpath("//span[text() = '" + customer.toString() + "']").click();
        }

        public void setCustomerNameField(String customerName) {
            clickCustomerNameField();
            //TODO ExplicitWait
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//            (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(
//                    ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text() = '" + customerName + "']")));
            clickSpanElementWithText(customerName);
            //Link.get().getByXpath("//span[text() = '" + customerName + "']").click();
        }

        public void setExecutorField(String executor) {
            clickExecutorField();
           //TODO ExplicitWait
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//            (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(
//                    ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text() = '" + executor + "']")));
            Link.get().getByXpath("//span[text() = '" + executor + "']").click();

            clickSpanElementWithText(executor);
            //driver.findElement(By.xpath("//span[text() = '" + executor + "']")).click();
        }

        public void setAgreementCodeField(String agreementCode) {
            clickAgreementCodeField();
            clearAgreementCodeField();
            this.controls.agreementCodeField.sendKeys(agreementCode);
        }

        public void setMeterQuantityField(Integer meterQuantity) {
            clickMeterQuantityField();
            clearMeterQuantityField();
            this.controls.meterQuantityField.sendKeys(meterQuantity.toString());
        }

        public void setWaterTypeField(WaterType waterType) {
            clickWaterTypeField();
            //TODO ExplicitWait
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//            (new WebDriverWait(driver, DEFAULT_EXPLICITLY_WAIT)).until(ExpectedConditions
//                    .presenceOfElementLocated(By.xpath("//span[text() = '" + waterType.toString() + "']")));

            clickSpanElementWithText(waterType.toString());
            //driver.findElement(By.xpath("//span[text() = '" + waterType.toString() + "']")).click();
        }

        // Click Elements
        public void clickWaterTypeField() {
            this.controls.waterTypeField.click();
        }

        public void clickCustomerTypeField() {
            this.controls.customerTypeField.click();
        }

        public void clickCustomerNameField() {
            this.controls.customerNameField.click();
        }

        public void clickExecutorField() {
            this.controls.executorField.click();
        }

        public void clickAgreementCodeField() {
            this.controls.agreementCodeField.click();
        }

        public void clickMeterQuantityField() {
            this.controls.meterQuantityField.click();
        }

        public void clickSubmit() {
            this.controls.submit.click();
        }

        // Clear Element
//        public void clearWaterTypeField() {
//            this.controls.waterTypeField.clear();
//        }

        public void clearCustomerTypeField() {
            this.controls.customerTypeField.clear();
        }

        public void clearCustomerNameField() {
            this.controls.customerNameField.clear();
        }

        public void clearExecutorField() {
            this.controls.executorField.clear();
        }

        public void clearAgreementCodeField() {
            this.controls.agreementCodeField.clear();
        }

        public void clearMeterQuantityField() {
            this.controls.meterQuantityField.clear();
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

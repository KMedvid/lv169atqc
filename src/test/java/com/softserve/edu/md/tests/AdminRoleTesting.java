package com.softserve.edu.md.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminRoleTesting {
    private final String APPLICATION_ADDRESS = 
            "http://10.1.10.100:8080";
    private final String APPLICATION_START_ADDRESS = 
            APPLICATION_ADDRESS + "/#/start";
    private final String ADMIN_HOME_PAGE = 
            APPLICATION_ADDRESS + "/admin/#/";
    
    private final String USERNAME = "admin"; 
    private final String PASSWORD = "password"; 

    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert(); 

    
    
    @BeforeClass
    private void oneTimeSetUp() {
        ProfilesIni profileIni = new ProfilesIni();
        FirefoxProfile profile = profileIni.getProfile("default");
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("network.http.use-cash", false);
        driver = new FirefoxDriver(profile);
        driver.manage().window().maximize();
    }
    
    @AfterClass
    private void oneTimeTearDown() {
        if(driver != null) {
            driver.quit();
            System.out.println("Closing driver");
        }
    }

    private void loginUser(String username, String password) {
        //Go to login page
        (new WebDriverWait(driver,5))
        .until(ExpectedConditions
                .presenceOfElementLocated(
                        By.xpath("//a[@href ='#/login']"))); 
        
        (driver.findElement(By.xpath("//a[@href ='#/login']"))).click();
        
        //Enter login name 
        (new WebDriverWait(driver,5))
        .until(ExpectedConditions
                .presenceOfElementLocated(
                By.xpath("//input[@ng-model = 'loginForm.username']")));
        
        (driver.findElement(By.xpath("//input[@ng-model ="
                + " 'loginForm.username']"))).sendKeys("admin");
        
        //Enter admin password
        (driver.findElement(By.xpath("//input[@id = 'inputPassword']")))
        .sendKeys("password");
        
        //click login buton
        (driver.findElement(By.xpath("//button[@type = 'submit']"))).click();
        System.out.println("Login succesfuly!");
    }

    
    @AfterMethod
    private void oneTimeAfterTest() {
        driver.get(ADMIN_HOME_PAGE);
        
        (new WebDriverWait(driver,15)).until(ExpectedConditions                
                .elementToBeClickable(By.xpath("//a[@class = 'dropdown-toggle']")));
         
        (driver.findElement(By.xpath("//a[@class = 'dropdown-toggle']"))).click();
        
        (new WebDriverWait(driver,5)).until(ExpectedConditions
                .presenceOfElementLocated(By
                        .xpath("//div[@ng-click = 'logout()']")));
        
        (driver.findElement(By
                .xpath("//div[@ng-click = 'logout()']"))).click();

        System.out.println("Logged out succesfuly!");
   
    }
    
    
          
    @Test
    public void contractAddingTest() {
        final String WATER_TYPE = "Холодна вода";
        final String CUSTOMER_TYPE = "Постачальник послуг";
        final String CUSTOMER_NAME = "Київ провайдер";
        final String EXECUTOR_NAME = "Київ калібратор";
        final String CONTRACT_NAME = "ДГ123456";
        final String METERS_AMOUNT = "255";
        
        
        driver.get(APPLICATION_START_ADDRESS);
        loginUser(USERNAME, PASSWORD);
        
        //Main page confirmation
        (new WebDriverWait(driver,5)).until(ExpectedConditions
                .presenceOfElementLocated(By
                .xpath("//a[@translate = 'HEAD_TITLE']")));
        
        //Go to contract page
        (new WebDriverWait(driver,5)).until(ExpectedConditions
                .elementToBeClickable(By
                .xpath("//a[@ui-sref = 'agreements']")));
        (driver.findElement(By
                .xpath("//a[@ui-sref = 'agreements']"))).click();
       
        //Adding organization button
        (new WebDriverWait(driver,5)).
        until(ExpectedConditions.elementToBeClickable(By
                .xpath("//button[@ng-click ='openAddAgreementModal()']")));
        driver.findElement(By
                .xpath("//button[@ng-click ='openAddAgreementModal()']")).click();
        
        //Meter type
        (new WebDriverWait(driver,3)).
        until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'deviceType']")));
        driver.findElement(By.xpath("//div[@id = 'deviceType']")).click();
        //selecting type
        (new WebDriverWait(driver,5)).
        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text() = '"+WATER_TYPE+"']")));
        driver.findElement(By.xpath("//span[text() = '"+WATER_TYPE+"']")).click();
 
        //type of customer
        (new WebDriverWait(driver,3)).
        until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'organizationType']")));
        driver.findElement(By.xpath("//div[@id = 'organizationType']")).click();
        //selecting customer type
        (new WebDriverWait(driver,5)).
        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text() = '"+CUSTOMER_TYPE+"']"))); 
        driver.findElement(By.xpath("//span[text() = '"+CUSTOMER_TYPE+"']")).click(); 
 
        //Name of a customer
        (new WebDriverWait(driver,3)).
        until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'customers']")));
        driver.findElement(By.xpath("//div[@id = 'customers']")).click();
        //selecting customer
        (new WebDriverWait(driver,5)).
        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text() = '"+CUSTOMER_NAME+"']"))); 
        driver.findElement(By.xpath("//span[text() = '"+CUSTOMER_NAME+"']")).click(); 
        
        // Contract executor
        (new WebDriverWait(driver,3)).
        until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'executors']")));
        driver.findElement(By.xpath("//div[@id = 'executors']")).click();
        //selecting executor
        (new WebDriverWait(driver,5)).
        until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text() ="
                + " '"+EXECUTOR_NAME+"']"))); 
        driver.findElement(By.xpath("//span[text() ="
                + " '"+EXECUTOR_NAME+"']")).click(); 
        //Contract name
        driver.findElement(By.xpath("//input[@id = 'number']")).sendKeys(CONTRACT_NAME);
       
        //Meters count for service under contract
        driver.findElement(By.xpath("//input[@id = 'deviceCount']")).sendKeys(METERS_AMOUNT);
        
        //Button submit
        driver.findElement(By.xpath("//button[@class = 'btn btn-success"
                + " col-md-2 col-sm-12 col-xs-12 col-lg-2 ng-binding']")).click();
       
        //Checking
        softAssert.assertEquals((driver.findElement(By
                .xpath("//table/tbody/tr[1]/td[1]"))).getText(), CONTRACT_NAME);

        //delete added contract
        (new WebDriverWait(driver,5)).
        until(ExpectedConditions.elementToBeClickable(By
                .xpath("//table/tbody/tr[1]/td[7]/div/button[2]")));
        
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[7]/div/button[2]"))
        .click();

        softAssert.assertAll();
        //Return
        
    }
     
 
    @Test
    public void meterTypeAddingTest() {
        
        final String METER_NAME = "Лічильник холодної води електронний";
        
        driver.get(APPLICATION_START_ADDRESS);
        loginUser(USERNAME, PASSWORD);
        
        //Main page confirmation
        (new WebDriverWait(driver,5)).until(ExpectedConditions
                .presenceOfElementLocated(By
                        .xpath("//a[@translate = 'HEAD_TITLE']")));
        
        //Go to category page
        (new WebDriverWait(driver,5)).until(ExpectedConditions
                .elementToBeClickable(By
                .xpath("//a[@ui-sref = 'device-category']")));
        (driver.findElement(By
                .xpath("//a[@ui-sref = 'device-category']"))).click();
        
         //Add category button
        (new WebDriverWait(driver,5)).
        until(ExpectedConditions.elementToBeClickable(By
                .xpath("//button[@ng-click ='openAddCategoryCounterModal()']")));
        driver.findElement(By
                .xpath("//button[@ng-click ='openAddCategoryCounterModal()']")).click();
        
        //Meter type
        (new WebDriverWait(driver,5)).until(ExpectedConditions
                .presenceOfElementLocated(By
                .xpath("//form/div[1]/div/div/a/span[1]")));
        
        
        driver.findElement(By.xpath("//form/div[1]/div/div/a/span[1]")).click();
        
        driver.findElement(By.xpath("//div[@class = 'select2-result-label"
                + " ui-select-choices-row-inner']")).click();
        
        //Meter name
        driver.findElement(By.xpath("//input[@ng-model = "
                + "'addCategoryFormData.deviceName']")).sendKeys(METER_NAME);
        
        //Button submit
        driver.findElement(By.xpath("//button[@class = 'btn btn-success"
                + " col-md-2 col-sm-12 col-xs-12 col-lg-2 ng-binding']")).click();
        
        //Checking
        (new WebDriverWait(driver,10)).
        until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//h1[text() = 'Категорія лічильників']")));
        softAssert.assertEquals((driver.findElement(By
                .xpath("//table/tbody/tr[1]/td[3]"))).getText(), METER_NAME);
       
        //delete added category
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]/div/button[2]"))
        .click();

        softAssert.assertAll();
        //Return
        
    }
    
     
}

package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupervisorHomePage extends InfoPage {
    //
    private WebElement itemManagement;
    
    public SupervisorHomePage(WebDriver driver) {
        super(driver);
        //
        (new WebDriverWait(driver, 5))
            .until(ExpectedConditions
                    .invisibilityOfElementLocated(By.xpath("//input[@type = 'submit']")));
        this.itemManagement = driver.findElement(By.partialLinkText("Item"));

    }

    // Get Elements
    public WebElement getItemManagement() {
        return this.itemManagement;
    }

    // Set Data
    public void clickItemManagement() {
        this.itemManagement.click();
    }

    // Business Logic
    public ItemManagement gotoItemManagement() {
        clickItemManagement();
        return new ItemManagement(driver);
    }

}

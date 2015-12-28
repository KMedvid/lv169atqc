package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerHomePage extends InfoPage {
    //
    private WebElement ordering;

    public CustomerHomePage(WebDriver driver) {
        super(driver);
        //
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions
                    .invisibilityOfElementLocated(By.partialLinkText("Administration")));
        this.ordering = driver.findElement(By.partialLinkText("Ordering"));
//        this.ordering = driver.findElement(By
//                .xpath("//ul[@id='nav']/li/a[text()='Ordering']"));
    }

    // Get Elements
    public WebElement getOrdering() {
        return this.ordering;
    }

    // Set Data
    public void clickOrdering() {
        this.ordering.click();
    }

    // Business Logic
    public OrderingPage gotoOrdering() {
        clickOrdering();
        return new OrderingPage(driver);
    }

}

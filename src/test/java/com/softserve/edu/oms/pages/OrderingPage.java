package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderingPage {
    private WebDriver driver;
    private WebElement orderName;
    private WebElement totalPrice;
    private WebElement maxDiscount;
    private WebElement deliveryDate;
    private WebElement status;
    private WebElement assignee;
    private WebElement role;
    //private WebElement logout;

    public OrderingPage(WebDriver driver) {
        this.driver = driver;
        this.orderName = driver.findElement(By.cssSelector("a[href*='orderName']"));
        this.totalPrice = driver.findElement(By.cssSelector("a[href*='totalPrice']"));
        this.maxDiscount = driver.findElement(By.cssSelector("a[href*='maxDiscount']"));
        this.deliveryDate = driver.findElement(By.cssSelector("a[href*='deliveryDate']"));
        this.status = driver.findElement(By.cssSelector("a[href*='status']"));
        this.assignee = driver.findElement(By.cssSelector("a[href*='assignee']"));
        this.role = driver.findElement(By.cssSelector("a[href*='role']"));
        // initFirstTableRow();
        //this.logout = driver.findElement(By.xpath("//a[@href='/OMS/logout.htm']"));
    }


    // Get Elements

    public WebElement getOrderName() {
        return orderName;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getMaxDiscount() {
        return maxDiscount;
    }

    public WebElement getDeliveryDate() {
        return deliveryDate;
    }

    public WebElement getStatus() {
        return status;
    }

    public WebElement getAssignee() {
        return assignee;
    }

    public WebElement getRole() {
        return role;
    }

    // Set Data

    public void clickOrderName() {
        driver.findElement(By.cssSelector("a[href*='orderName']")).click();
    }

    public void clickTotalPrice() {
        driver.findElement(By.cssSelector("a[href*='totalPrice']")).click();
    }

    public void clickMaxDiscount() {
        driver.findElement(By.cssSelector("a[href*='maxDiscount']")).click();
    }

    public void clickDeliveryDate() {
        driver.findElement(By.cssSelector("a[href*='deliveryDate']")).click();
    }

    public void clickStatus() {
        driver.findElement(By.cssSelector("a[href*='status']")).click();
    }

    public void clickAssignee() {
        driver.findElement(By.cssSelector("a[href*='assignee']")).click();
    }

    public void clickRole() {
        driver.findElement(By.cssSelector("a[href*='role']")).click();
    }
    // Business Logic

    public OrderingPage gotoOrderName() {
        clickOrderName();
        return new OrderingPage(driver);
    }

    public WebElement getOrderTableElement() {
        return driver.findElement(By.xpath("//div[@id='list']/table/tbody"));
    }

    // // Set Data
    public void clickLogout() {
        driver.findElement(By.xpath("//a[@href='/OMS/logout.htm']")).click();
    }

    //

    public LoginPage gotoLogout() {
        clickLogout();
        return new LoginPage(driver);
    }
}


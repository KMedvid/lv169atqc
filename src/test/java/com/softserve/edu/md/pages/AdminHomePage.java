package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminHomePage extends InfoPage {

    private WebElement adminHome;
    private WebElement organizations;
    private WebElement agreements;
    private WebElement metersCategory;
    private WebElement metersType;
    private WebElement employee;

    public AdminHomePage(WebDriver driver) {
        super(driver);
        //
        this.adminHome = driver.findElement(By.xpath("//a[@ui-sref = 'main']"));
        this.organizations = driver.findElement(By.xpath("//a[@ui-sref = 'organizations']"));
        this.agreements = driver.findElement(By.xpath("//a[@ui-sref = 'agreements']"));
        this.metersCategory = driver.findElement(By.xpath("//a[@ui-sref = 'device-category']"));
        this.metersType = driver.findElement(By.xpath("//a[@ui-sref = 'counters-type']"));
        this.employee = driver.findElement(By.xpath("//a[@ui-sref = 'users']"));
    }

    // Get Elements
    public WebElement getAdminHome() {
        return this.adminHome;
    }

    public WebElement getOrganizations() {
        return this.organizations;
    }

    public WebElement getAgreements() {
        return this.agreements;
    }

    public WebElement getMetersCategory() {
        return this.metersCategory;
    }

    public WebElement getMetersType() {
        return this.metersType;
    }

    public WebElement getEmployee() {
        return this.employee;
    }

    // Click Elements
    public void clickAdminHome() {
        adminHome.click();
    }

    public void clickOrganizations() {
        organizations.click();
    }

    public void clickAgreements() {
        agreements.click();
    }

    public void clickMetersCategory() {
        metersCategory.click();
    }

    public void clickMetersType() {
        metersType.click();
    }

    public void clickEmployee() {
        employee.click();
    }

    // Business Logic
    /*
     * 
     */
    public AdminHomePage gotoAdminHome() {
        clickAdminHome();
        return this;
    }

    public OrganizationsPage gotoOrganizations() {
        clickOrganizations();
        return new OrganizationsPage(driver);
    }

    public AgreementsPage gotoAgreements() {
        clickAgreements();
        return new AgreementsPage(driver);
    }

    public MetersCategoryPage gotoMetersCategory() {
        clickMetersCategory();
        return new MetersCategoryPage(driver);
    }

    public MetersTypePage gotoMetersType() {
        clickMetersType();
        return new MetersTypePage(driver);
    }

    public EmployeePage gotoEmployee() {
        clickEmployee();
        return new EmployeePage(driver);
    }


}

package com.softserve.edu.md.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class AdminHomePage extends InfoPage {

    private class AdminHomePageUIMap {
        private final ILink adminHome;
        private final ILink organizations;
        private final ILink agreements;
        private final ILink metersCategory;
        private final ILink metersType;
        private final ILink employee;  
        
        public AdminHomePageUIMap() {
            this.adminHome = Link.get().getByXpath("//a[@ui-sref = 'main']");
            this.organizations = Link.get().getByXpath("//a[@ui-sref = 'organizations']");
            this.agreements = Link.get().getByXpath("//a[@ui-sref = 'agreements']");
            this.metersCategory = Link.get().getByXpath("//a[@ui-sref = 'device-category']");
            this.metersType = Link.get().getByXpath("//a[@ui-sref = 'counters-type']");
            this.employee = Link.get().getByXpath("//a[@ui-sref = 'users']");
        }
    }
    
    private AdminHomePageUIMap controls;
    
    public AdminHomePage() {
       this.controls = new AdminHomePageUIMap();
    }

    // Get Elements
    public ILink getAdminHome() {
        return this.controls.adminHome;
    }

    public ILink getOrganizations() {
        return this.controls.organizations;
    }

    public ILink getAgreements() {
        return this.controls.agreements;
    }

    public ILink getMetersCategory() {
        return this.controls.metersCategory;
    }

    public ILink getMetersType() {
        return this.controls.metersType;
    }

    public ILink getEmployee() {
        return this.controls.employee;
    }

    // Click Elements
    public void clickAdminHome() {
        this.controls.adminHome.click();
    }

    public void clickOrganizations() {
        this.controls.organizations.click();
    }

    public void clickAgreements() {
        this.controls.agreements.click();
    }

    public void clickMetersCategory() {
        this.controls.metersCategory.click();
    }

    public void clickMetersType() {
        this.controls.metersType.click();
    }

    public void clickEmployee() {
        this.controls.employee.click();
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
        return new OrganizationsPage();
    }

    public AgreementsPage gotoAgreements() {
        clickAgreements();
        return new AgreementsPage();
    }

    public MetersCategoryPage gotoMetersCategory() {
        clickMetersCategory();
        return new MetersCategoryPage();
    }

    public MetersTypePage gotoMetersType() {
        clickMetersType();
        return new MetersTypePage();
    }

    public EmployeePage gotoEmployee() {
        clickEmployee();
        return new EmployeePage();
    }


}

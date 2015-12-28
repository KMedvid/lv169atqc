package com.softserve.edu.oms.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.oms.data.IUser;

public class AdministrationPage {

    public static enum AdministrationPageFields {
        ALL_COLUMNS("All Columns"),
        FIRST_NAME("First Name"),
        LAST_NAME("Last Name"),
        ROLE("Role"),
        LOGIN_NAME("Login Name");
        //
        private String field;

        private AdministrationPageFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    public static enum AdministrationPageConditions {
        EQUALS("equals"),
        NOT_EQUALS_TO("not equals to"),
        STARTS_WITH("starts with"),
        CONTAINS("contains"),
        DOES_NOT_CONTAIN("does not contain");
        private String field;

        private AdministrationPageConditions(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    //
    private WebDriver driver;
    //
    private WebElement createNewUser;
    private Select selectField;
    private Select selectCondition;
    private WebElement searchField;
    private WebElement logout;
    //
    private WebElement firstname;
    private WebElement lastname;
    private WebElement login;
    private WebElement delete;
    private WebElement usersFound;
    private String usersFoundText;

    public AdministrationPage(WebDriver driver) {
        this.driver = driver;
        // Static Elements
        this.createNewUser = driver.findElement(By.partialLinkText("Create New User"));
        selectField = new Select(driver.findElement(By.id("field")));
        selectCondition = new Select(driver.findElement(By.id("condition")));
        this.searchField = driver.findElement(By.id("searchField"));
        this.logout = driver.findElement(By.xpath("//a[@href='/OMS/logout.htm']"));
        // Dynamic Elements
        initFirstTableRow();
    }

    private void initFirstTableRow() {
        this.firstname = driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
        this.lastname = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
        this.login = driver.findElement(By.xpath("//tbody/tr[1]/td[3]"));
        this.delete = driver.findElement(By.xpath("//tbody/tr[1]/td[7]/a"));
        initUsersFound();
        // System.out.println("initFirstTableRow: "+firstname.getText());
    }

    private void initTableRowByLogin(String login) {
        // TODO Check Existing Row
        this.firstname = driver
                .findElement(By.xpath("//tbody//td[3][text()='" + login + "']/preceding-sibling::td[2]"));
        this.lastname = driver.findElement(By.xpath("//tbody//td[3][text()='" + login + "']/preceding-sibling::td[1]"));
        this.login = driver.findElement(By.xpath("//tbody//td[3][text()='" + login + "']"));
        this.delete = driver.findElement(By.xpath("//tbody//td[3][text()='" + login + "']/following-sibling::td[4]/a"));
        initUsersFound();
    }

    private void initUsersFound() {
        this.usersFound = driver.findElement(By.id("usersFound"));
        this.usersFoundText = usersFound.getText();
    }

    private boolean isTableRefresh() {
        boolean result;
        // TODO Change Wait
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        // try {
        // Thread.sleep(2000);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        result = new WebDriverWait(driver, 10).until(ExpectedConditions.stalenessOf(firstname))
                && new WebDriverWait(driver, 10)
                        .until(ExpectedConditions.invisibilityOfElementWithText(By.id("usersFound"), usersFoundText));
        //
        // try {
        // System.out.println("isTableRefresh() firstname =
        // "+firstname.getText());
        // } catch(StaleElementReferenceException expected){
        // System.out.println("StaleElementReferenceException");
        // }
        //
        // System.out.println("result = "+result);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return result;
    }

    // Get Elements
    public WebElement getCreateNewUser() {
        return this.createNewUser;
    }

    public Select getSelectField() {
        return this.selectField;
    }

    public Select getSelectCondition() {
        return this.selectCondition;
    }

    public WebElement getSearchField() {
        return this.searchField;
    }

    public WebElement getLogout() {
        return this.logout;
    }

    public WebElement getFirstname() {
        return this.firstname;
    }

    public WebElement getLastname() {
        return this.lastname;
    }

    public WebElement getLogin() {
        return this.login;
    }

    public WebElement getDelete() {
        return this.delete;
    }

    public WebElement getUsersFound() {
        return this.usersFound;
    }

    public String getSelectFieldText() {
        return this.selectField.getFirstSelectedOption().getText();
    }

    public String getSelectConditionText() {
        return this.selectCondition.getFirstSelectedOption().getText();
    }

    public String getSearchFieldText() {
        return this.searchField.getText();
    }

    public String getFirstnameText() {
        return this.firstname.getText();
    }

    public String getLastnameText() {
        return this.lastname.getText();
    }

    public String getLoginText() {
        return this.login.getText();
    }

    public String getUsersFoundText() {
        return this.usersFoundText;
    }

    // Set Data
    public void setSelectField(AdministrationPageFields field) {
        this.selectField.selectByVisibleText(field.toString());
    }

    public void setSelectCondition(AdministrationPageConditions condition) {
        this.selectCondition.selectByVisibleText(condition.toString());
    }

    public void setSearchField(String searchText) {
        this.searchField.sendKeys(searchText);
    }

    public void clearSearchField() {
        this.searchField.clear();
    }

    public void clickSearchField() {
        this.searchField.click();
    }

    public void clickCreateNewUser() {
        this.createNewUser.click();
    }

    public void clickLogout() {
        this.logout.click();
    }

    // Business Logic
    public void searchUser(IUser user, AdministrationPageFields field, AdministrationPageConditions conditions) {
        String searchProperties;
        setSelectField(field);
        setSelectCondition(conditions);
        clickSearchField();
        clearSearchField();
        switch (field) {
        case FIRST_NAME:
            searchProperties = user.getFirstname();
            break;
        case LAST_NAME:
            searchProperties = user.getLastname();
            break;
        case ROLE:
            searchProperties = user.getRole();
            break;
        case LOGIN_NAME:
            searchProperties = user.getLogin();
            break;
        default:
            searchProperties = user.getLogin();
        }
        setSearchField(searchProperties);
        // setSearchField("noneiva");
        isTableRefresh();
        initFirstTableRow();
    }

    public void searchByLoginName(IUser user) {
        // try {
        // Thread.sleep(2000);
        // } catch (InterruptedException e1) {
        // // TODO Auto-generated catch block
        // e1.printStackTrace();
        // }
        // System.out.println("Before Searsh: firstname="+firstname.getText());
        searchUser(user, AdministrationPageFields.LOGIN_NAME, AdministrationPageConditions.EQUALS);
        // System.out.println("After Searsh1: firstname="+firstname.getText());
        initTableRowByLogin(user.getLogin());
         try {
         Thread.sleep(4000);
         } catch (InterruptedException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         }
        // System.out.println("After Searsh2: firstname="+firstname.getText());
    }

    public CreateNewUserPage gotoCreateNewUser() {
        clickCreateNewUser();
        return new CreateNewUserPage(driver);
    }

    public LoginPage gotoLogout() {
        clickLogout();
        return new LoginPage(driver);
    }

}

package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.atqc.tools.ControlLocation;
import com.softserve.edu.atqc.tools.ControlSearch;
import com.softserve.edu.oms.data.IUser;

public class AdministrationPage {

    public static enum AdministrationPageFields {
        ALL_COLUMNS("All Columns"),
        FIRST_NAME("First Name"),
        LAST_NAME("Last Name"),
        ROLE("Role"),
        LOGIN_NAME("Login Name");
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

    private class AdministrationPageUIMap {
        public final ILink createNewUser;
        //public final ISelect selectField;
        //public final ISelect selectCondition;
        public final ITextField searchField;
        public final ILink logout;

        public AdministrationPageUIMap() {
            this.createNewUser = Link.get().getByPartialLinkText("Create New User");
            this.searchField = TextField.get().getById("searchField");
            //this.field = Select.getById("field");
            //this.condition = Select.getById("condition");
            this.logout = Link.get().getByXpath("//a[@href='/OMS/logout.htm']");
        }
    }

    private class AdministrationPageTableUIMap {
        public final ILabel usersFound;
        public final ILabel firstname;
        public final ILabel lastname;
        public final ILabel login;
        public final ILink delete;
        public final String usersFoundText;

        public AdministrationPageTableUIMap() {
            // TODO if Load Table Complete
            this.usersFound = Label.get().getById("usersFound");
            this.usersFoundText = usersFound.getText();
            if (Integer.parseInt(usersFoundText) > 0) {
                this.firstname = Label.get().getByXpath("//tbody/tr[1]/td[1]");
                this.lastname = Label.get().getByXpath("//tbody/tr[1]/td[2]");
                this.login = Label.get().getByXpath("//tbody/tr[1]/td[3]");
                this.delete = Link.get().getByXpath("//tbody/tr[1]/td[7]/a");
            } else {
                this.firstname = Label.get().getByXpath("//thead/tr[1]/th[1]");
                this.lastname = Label.get().getByXpath("//thead/tr[1]/th[2]");
                this.login = Label.get().getByXpath("//thead/tr[1]/th[3]");
                this.delete = Link.get().getByXpath("//thead/tr[1]/th[1]");
            }
        }

        public AdministrationPageTableUIMap(String login) {
            // TODO if Load Table Complete
            // TODO Check Existing Row
            this.usersFound = Label.get().getById("usersFound");
            this.usersFoundText = usersFound.getText();
            //
            this.firstname = Label.get().getByXpath("//tbody//td[3][text()='" + login + "']/preceding-sibling::td[2]");
            this.lastname = Label.get().getByXpath("//tbody//td[3][text()='" + login + "']/preceding-sibling::td[1]");
            this.login = Label.get().getByXpath("//tbody//td[3][text()='" + login + "']");
            this.delete = Link.get().getByXpath("//tbody//td[3][text()='" + login + "']/following-sibling::td[4]/a");
        }

    }

    // Elements
    private AdministrationPageUIMap controls;
    // AJAX Elements
    private AdministrationPageTableUIMap controlsTable;
    // Alert Elements
    //private IAlertLight controlsAlert = null;

    public AdministrationPage() {
        controls = new AdministrationPageUIMap();
        controlsTable = new AdministrationPageTableUIMap();
    }

    private boolean isTableRefresh() {
        return this.controlsTable.firstname.isStatelessOf()
                && this.controlsTable.usersFound.isInvisibleWithText(
                        this.controlsTable.usersFoundText);
    }

    private String getUserPropertyByField(IUser user, AdministrationPageFields field) {
        String searchProperties;
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
        return searchProperties;
    }
    
    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // getters controls

    public ILink getCreateNewUser() {
        return this.controls.createNewUser;
    }

//    public ISelect getSelectField() {
//        return this.controls.selectField;
//    }

//    public ISelect getSelectCondition() {
//        return this.controls.selectCondition;
//    }

    public ITextField getSearchField() {
        return this.controls.searchField;
    }

    public ILink getLogout() {
        return this.controls.logout;
    }

//    public String getSelectFieldText() {
//        return this.controls.selectField.getFirstSelectedOption().getText();
//    }

//    public String getSelectConditionText() {
//        return this.controls.selectCondition.getFirstSelectedOption().getText();
//    }

    public String getSearchFieldText() {
        return getSearchField().getText();
    }
    
    // getters controlsTable

    public ILabel getUsersFound() {
        return this.controlsTable.usersFound;
    }

    public ILabel getFirstname() {
        return this.controlsTable.firstname;
    }

    public ILabel getLastname() {
        return this.controlsTable.lastname;
    }

    public ILabel getLogin() {
        return this.controlsTable.login;
    }

    public ILink getDelete() {
        return this.controlsTable.delete;
    }

//    public String getUsersFoundText() {
//        return this.controlsTable.usersFoundText;
//    }

    public String getFirstnameText() {
        return getFirstname().getText();
    }

    public String getLastnameText() {
        return getLastname().getText();
    }

    public String getLoginText() {
        return getLogin().getText();
    }

    // getters controlsAlert

    //public IAlert getAlert() {
    //  if (this.controlsAlert != null) {
    //  return this.controlsAlert;
    //  }
    //}

    // setters controls

    public void setSelectField(AdministrationPageFields field) {
        //this.controls.selectField.selectByVisibleText(field.toString());
        // TODO +++
        ControlSearch.get().getVisibleSelectWebElement(ControlLocation.getById("field"))
            .selectByVisibleText(field.toString());
    }

    public void setSelectCondition(AdministrationPageConditions condition) {
        //this.controls.selectCondition.selectByVisibleText(condition.toString());
        // TODO +++
        ControlSearch.get().getVisibleSelectWebElement(ControlLocation.getById("condition"))
            .selectByVisibleText(condition.toString());
    }

    public void setSearchField(String text) {
        getSearchField().sendKeys(text);
    }

    public void clearSearchField() {
        getSearchField().clear();
    }

    public void clickSearchField() {
        getSearchField().click();
    }

    public void clickCreateNewUser() {
        getCreateNewUser().click();
    }

    public void clickLogout() {
        getLogout().click();
    }
    
    // setters controlsTable

    public void resetTable() {
        if (isTableRefresh()) {
            controlsTable = new AdministrationPageTableUIMap();
        }
    }
    
    public void resetTable(String login) {
        if (isTableRefresh()) {
            controlsTable = new AdministrationPageTableUIMap(login);
        }
    }

    public void clickDelete() {
        getDelete().click();
        // TODO Alert
        // this.controlsAlert = new Alert();
    }

    // setters controlsAlert

    public void acceptAlert() {
//      if (this.controlsAlert != null) {
//      this.controlsAlert.click();
//      this.controlsAlert = null;
//        controls = new AdministrationPageUIMap();
//        controlsAjax = new AdministrationPageUIMapAjax();
          //
//        resetTable();
//  }
        // TODO +++
       BrowserUtils.get().getBrowser().getWebDriver().switchTo().alert().dismiss();
    }

    public void dismissAlert() {
//      if (this.controlsAlert != null) {
//          this.controlsAlert.click();
//          this.controlsAlert = null;
//      }
    }   

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void searchUser(IUser user, AdministrationPageFields field,
            AdministrationPageConditions condition) {
        setSelectField(field);
        setSelectCondition(condition);
        setSearchField(getUserPropertyByField(user, field));
        // Initialize Table Elements
        resetTable(user.getLogin());
    }

    public void searchByLoginName(IUser user) {
        searchUser(user, AdministrationPageFields.LOGIN_NAME, AdministrationPageConditions.EQUALS);
    }
    
    public void deleteByLoginName(IUser user) {
        searchByLoginName(user);
        clickDelete();
        // TODO Develop AlertWrapper
        acceptAlert();
    }

    public CreateNewUserPage gotoCreateNewUser() {
        clickCreateNewUser();
        return new CreateNewUserPage();
    }

    public LoginPage logout() {
        clickLogout();
        return new LoginPage();
    }

}

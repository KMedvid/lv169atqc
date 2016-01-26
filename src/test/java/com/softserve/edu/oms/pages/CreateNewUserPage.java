package com.softserve.edu.oms.pages;

import org.openqa.selenium.Keys;

import com.softserve.edu.controls.Button;
import com.softserve.edu.controls.IButton;
import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.ILink;
import com.softserve.edu.controls.ITextField;
import com.softserve.edu.controls.Label;
import com.softserve.edu.controls.Link;
import com.softserve.edu.controls.TextField;
import com.softserve.edu.oms.data.IUser;

public class CreateNewUserPage {

    public static enum RegionID {
        EAST("East"),
        NORTH("North"),
        SOUTH("South"),
        WEST("West");
        private String regionID;

        private RegionID(String regionID) {
            this.regionID = regionID;
        }

        @Override
        public String toString() {
            return regionID;
        }
    }

    public static enum RoleID {
        ADMINISTRATOR("Administrator"),
        CUSTOMER("Customer"),
        MERCHANDISER("Merchandiser"),
        SUPERVISOR("Supervisor");
        private String roleID;

        private RoleID(String roleID) {
            this.roleID = roleID;
        }

        @Override
        public String toString() {
            return roleID;
        }
    }

    private class CreateNewUserPageUIMap {
        public final ITextField login;
        public final ITextField firstname;
        public final ITextField lastname;
        public final ITextField password;
        public final ITextField confirmPassword;
        public final ITextField email;
        // private final ISelect region;
        //private final IRadioButtonGroup role;
        public final IButton create;
        public final IButton cancel;
        public final ILink logout;

        public CreateNewUserPageUIMap() {
            this.login = TextField.get().getById("login");
            this.firstname = TextField.get().getById("firstName");
            this.lastname = TextField.get().getById("lastName");
            this.password = TextField.get().getById("password");
            this.confirmPassword = TextField.get().getById("confirmPassword");
            this.email = TextField.get().getById("email");
            //this.region = Select.getById("regionID");
//            this.role = RadioButtonGroup.get()
//                    .addFirst(RadioButtonLight.get().addRadioButton(RadioButton.getById("roleID1"))
//                            .addLabel(Label.getByXpath("//label[text()='Administrator']")).build())
//                    .addNext(RadioButtonLight.get().addRadioButton(RadioButton.getById("roleID2"))
//                            .addLabel(Label.getByXpath("//label[text()='Customer']")).build())
//                    .addNext(RadioButtonLight.get().addRadioButton(RadioButton.getById("roleID3"))
//                            .addLabel(Label.getByXpath("//label[text()='Merchandiser']")).build())
//                    .addNext(RadioButtonLight.get().addRadioButton(RadioButton.getById("roleID4"))
//                            .addLabel(Label.getByXpath("//label[text()='Supervisor']")).build())
//                    .build();
            this.create = Button.get().getByXpath("//input[@value='Create']");
            this.cancel = Button.get().getByXpath("//input[@value='Cancel']");
            this.logout = Link.get().getByXpath("//a[@href='/OMS/logout.htm']");
        }

        public ILabel getNameLoaderValidator() {
            return Label.get().getPresentById("nameLoader");
        }
        
        public ILabel getNameErrorValidator() {
            return Label.get().getPresentById("nameError");
        }

        public ILabel getFirstNameErrorValidator() {
            return Label.get().getPresentById("firstNameError");
        }

        public ILabel getLastNameErrorValidator() {
            return Label.get().getPresentById("lastNameError");
        }

        public ILabel getPasswordErrorValidator() {
            return Label.get().getPresentById("passwordError");
        }
        
        public ILabel getConfirmErrorValidator() {
            return Label.get().getPresentById("confirmError");
        }
        
        public ILabel getEmailErrorValidator() {
            return Label.get().getPresentById("emailError");
        }

        public String getNameLoaderValidatorText() {
            return getNameLoaderValidator().getText();
        }
        
        public String getNameErrorValidatorText() {
            return getNameErrorValidator().getText();
        }

        public String getFirstNameErrorValidatorText() {
            return getFirstNameErrorValidator().getText();
        }

        public String getLastNameErrorValidatorText() {
            return getLastNameErrorValidator().getText();
        }

        public String getPasswordErrorValidatorText() {
            return getPasswordErrorValidator().getText();
        }
        
        public String getConfirmErrorValidatorText() {
            return getConfirmErrorValidator().getText();
        }

        public String getEmailErrorValidatorText() {
            return getEmailErrorValidator().getText();
        }

        public boolean isDisableValidators() {
            boolean isValidatorInvisible = true;
            // All Validators
            isValidatorInvisible = isValidatorInvisible
                    && Label.get().isInvisibleWebElementById("nameLoader")
                    && Label.get().isInvisibleWebElementById("nameError")
                    && Label.get().isInvisibleWebElementById("firstNameError")
                    && Label.get().isInvisibleWebElementById("lastNameError")
                    && Label.get().isInvisibleWebElementById("passwordError")
                    && Label.get().isInvisibleWebElementById("confirmError")
                    && Label.get().isInvisibleWebElementById("emailError");
            return isValidatorInvisible;
        }

    }

    private final String USER_CANNOT_CREATED = "User %s Cannot be Created";
    // Elements
    private CreateNewUserPageUIMap controls;
    // Alert Elements
    //private IAlertLight controlsAlertLight;

    public CreateNewUserPage() {
        controls = new CreateNewUserPageUIMap();
        //controlsAlertLight = AlertLight.getWithScreen();
    }

    
    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // getters controls

    public ITextField getLogin() {
        return this.controls.login;
    }

    public ITextField getFirstname() {
        return this.controls.firstname;
    }

    public ITextField getLastname() {
        return this.controls.lastname;
    }

    public ITextField getPassword() {
        return this.controls.password;
    }

    public ITextField getConfirmPassword() {
        return this.controls.confirmPassword;
    }

    public ITextField getEmail() {
        return this.controls.email;
    }

    public ILink getLogout() {
        return this.controls.logout;
    }

    // public ISelect getRegion();
    // public IRadioButtonGroup getRole(); 

//    public IAlert getAlert() {
//        return controlsAlertLight;
//    }

    public String getLoginText() {
        return getLogin().getText();
    }

    public String getFirstnameText() {
        return  getFirstname().getText();
    }

    public String getLastnameText() {
        return getLastname().getText();
    }

    public String getPasswordText() {
        return getPassword().getText();
    }

    public String getConfirmPasswordText() {
        return getConfirmPassword().getText();
    }

    public String getEmailText() {
        return getEmail().getText();
    }

    public String getNameLoaderValidatorText() {
        return controls.getNameLoaderValidatorText();
    }
    
    public String getNameErrorValidatorText() {
        return controls.getNameErrorValidatorText();
    }

    public String getFirstNameErrorValidatorText() {
        return controls.getFirstNameErrorValidatorText();
    }

    public String getLastNameErrorValidatorText() {
        return controls.getLastNameErrorValidatorText();
    }

    public String getPasswordErrorValidatorText() {
        return controls.getPasswordErrorValidatorText();
    }
    
    public String getConfirmErrorValidatorText() {
        return controls.getConfirmErrorValidatorText();
    }

    public String getEmailValidatorText() {
        return controls.getEmailErrorValidatorText();
    }

    // TODO
    RegionID getRegionByPartialText(IUser user) {
    //private RegionID getRegionByPartialText(IUser user) {
        RegionID regionID = RegionID.EAST;
        for (RegionID region : RegionID.values()) {
            if ((region.toString().indexOf(user.getRegion()) >= 0)
                    || (user.getRegion().indexOf(region.toString()) >= 0)) {
                regionID = region;
                break;
            }
        }
        return regionID;
    }

    // TODO
    RoleID getRoleByPartialText(IUser user) {
    //private RoleID getRoleByPartialText(IUser user) {
        RoleID roleID = RoleID.CUSTOMER;
        for (RoleID role : RoleID.values()) {
            if ((role.toString().indexOf(user.getRole()) >= 0)
                    || (user.getRole().indexOf(role.toString()) >= 0)) {
                roleID = role;
                break;
            }
        }
        return roleID;
    }

    // setters controls

    public void setLogin(String login) {
        this.controls.login.sendKeys(login);
        // TODO Wrap Keys
        this.controls.login.sendKeys(Keys.ARROW_RIGHT.toString());
    }

    public void setFirstname(String firstname) {
        this.controls.firstname.sendKeys(firstname);
        // TODO Wrap Keys
        this.controls.firstname.sendKeys(Keys.ARROW_RIGHT.toString());
    }

    public void setLastname(String lastname) {
        this.controls.lastname.sendKeys(lastname);
        // TODO Wrap Keys
        this.controls.lastname.sendKeys(Keys.ARROW_RIGHT.toString());
    }

    public void setPassword(String password) {
        this.controls.password.sendKeys(password);
        // TODO Wrap Keys
        this.controls.password.sendKeys(Keys.ARROW_RIGHT.toString());
    }

    public void setConfirmPassword(String confirmPassword) {
        this.controls.confirmPassword.sendKeys(confirmPassword);
        // TODO Wrap Keys
        this.controls.confirmPassword.sendKeys(Keys.ARROW_RIGHT.toString());
    }

    public void setEmail(String email) {
        this.controls.email.sendKeys(email);
        // Action for Making Email Error Message Invisible 
        // TODO Wrap Keys
        this.controls.email.sendKeys(Keys.ARROW_RIGHT.toString());
    }

//    public void setRegion(RegionID region) {
//        controls.region.selectByText(region.toString());
//    }

//    public void setRole(RoleID role) {
//        controls.role.selectByPartialText(role.toString());
//    }

    public void clearLogin() {
        getLogin().clear();
    }

    public void clearFirstname() {
        getFirstname().clear();
    }

    public void clearLastname() {
        getLastname().clear();
    }

    public void clearPassword() {
        getPassword().clear();
    }

    public void clearConfirmPassword() {
        getConfirmPassword().clear();
    }

    public void clearEmail() {
        getEmail().clear();
    }

    public void clickLogin() {
        getLogin().click();
    }

    public void clickFirstname() {
        getFirstname().click();
    }

    public void clickLastname() {
        getLastname().click();
    }

    public void clickPassword() {
        getPassword().click();
    }

    public void clickConfirmPassword() {
        getConfirmPassword().click();
    }

    public void clickEmail() {
        getEmail().click();
    }
    
    public void clickLogout() {
        getLogout().click();
    }


    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public AdministrationPage createNewUser(IUser user) {
        setLogin(user.getLogin());
        setFirstname(user.getFirstname());
        setLastname(user.getLastname());
        setPassword(user.getPassword());
        setConfirmPassword(user.getPassword());
        setEmail(user.getEmail());       
       // setRegion(getRegionByPartialText(user));
       // setRole(getRoleByPartialText(user));
        if (controls.isDisableValidators()) {
            controls.create.click();
        } else {
            // TODO Logs User Cannot be Created
            controls.cancel.click();
            // TODO throw Exception Test Failed
            throw new RuntimeException(String.format(USER_CANNOT_CREATED, user.toString()));
        }
        return new AdministrationPage();
    }

    public LoginPage logout() {
        clickLogout();
        // controlsAlertLight.alertAccept();
        return new LoginPage();
    }

}
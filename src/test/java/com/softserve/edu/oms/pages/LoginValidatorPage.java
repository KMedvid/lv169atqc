package com.softserve.edu.oms.pages;

import com.softserve.edu.controls.ILabel;
import com.softserve.edu.controls.Label;

public class LoginValidatorPage extends LoginPage {

    public static enum LoginPageMessages {
        START_VALIDATOR_MESSAGE("Your login attempt was not successful, try again.");

        private String field;

        private LoginPageMessages(String field) {
            this.field = field;
        }

        public int getLenght() {
            return this.field.length();
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    
    private class LoginValidatorPageUIMap {
        public final ILabel validator;

        public LoginValidatorPageUIMap() {
            //this.validator = Label.get().getByXpath("//div[@id='edit']//font");
            this.validator = Label.get().getByXpath("//font[@color='red']");
        }
    }

    // Elements
    private LoginValidatorPageUIMap controls;

    public LoginValidatorPage() {
        this.controls = new LoginValidatorPageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public ILabel getValidator() {
        return this.controls.validator;
    }

    public String getValidatorText() {
        return this.controls.validator.getText();
    }

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public String getStartValidatorText() {
        return this.controls.validator.getText().trim().substring(0,
                LoginPageMessages.START_VALIDATOR_MESSAGE.toString().length());
    }

}

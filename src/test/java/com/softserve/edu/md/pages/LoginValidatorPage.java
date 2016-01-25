package com.softserve.edu.md.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Label;

public class LoginValidatorPage extends LoginPage {

    public static enum LoginPageMessages {
        START_VALIDATOR_MESSAGE("Не вдалось  залогуватись, перевірте коректність введених даних");

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
    

    /**
     * 
     * Map of all elements on page
     */
    private class LoginValidatorPageUIMap {
        public final ILabel validator;

        public LoginValidatorPageUIMap() {
            this.validator = Label.get().getById("incorrectLoginMessage");
        }
    }
    /**
     * 
     * Constructor of Login Page with validator of unsuccessful attempt of
     * login
     */
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
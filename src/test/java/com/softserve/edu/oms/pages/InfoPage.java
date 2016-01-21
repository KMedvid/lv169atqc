package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.Link;

public abstract class InfoPage {

    private class InfoPageUIMap {
        public final ILabel firstname;
        public final ILabel lastname;
        public final ILabel role;
        public final ILink logout;

        public InfoPageUIMap() {
            this.firstname = Label.get()
                    .getByXpath("//tbody/tr/td[text( )='First name']/following-sibling::td");
            this.lastname = Label.get()
                    .getByXpath("//tbody/tr/td[text( )='Last name']/following-sibling::td");
            this.role = Label.get()
                    .getByXpath("//tbody/tr/td[text( )='Role']/following-sibling::td");
            this.logout = Link.get()
                    .getByXpath("//a[@href='/OMS/logout.htm']");
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private InfoPageUIMap controls;

    protected InfoPage() {
        this.controls = new InfoPageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void clickLogout() {
        this.controls.logout.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public ILabel getFirstname() {
        return this.controls.firstname;
    }

    public ILabel getLastname() {
        return this.controls.lastname;
    }

    public ILabel getRole() {
        return this.controls.role;
    }

    public ILink getLogout() {
        return this.controls.logout;
    }

    public String getFirstnameText() {
        return getFirstname().getText();
    }

    public String getLastnameText() {
        return getLastname().getText();
    }

    public String getRoleText() {
        return getRole().getText();
    }

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    public LoginPage logout() {
        clickLogout();
        return new LoginPage();
    }

}

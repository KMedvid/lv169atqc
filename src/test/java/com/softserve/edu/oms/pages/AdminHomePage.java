package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class AdminHomePage extends InfoPage {
    
    private class AdminHomePageUIMap {
        public final ILink administration;

        public AdminHomePageUIMap() {
            this.administration = Link.get()
                    .getByPartialLinkText("Administration");
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private AdminHomePageUIMap controls;

    public AdminHomePage() {
        super();
        this.controls = new AdminHomePageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void clickAdministration() {
        this.controls.administration.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public ILink getAdministration() {
        return this.controls.administration;
    }

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public AdministrationPage gotoAdministration() {
        clickAdministration();
        return new AdministrationPage();
    }    
    
}

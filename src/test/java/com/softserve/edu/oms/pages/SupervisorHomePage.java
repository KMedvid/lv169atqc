package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class SupervisorHomePage extends InfoPage {
    //
	private class SupervisorHomePageUIMap {
		public final ILink itemManagement;

		public SupervisorHomePageUIMap() {
			this.itemManagement = Link.get().getByPartialLinkText("Item Management");
		}
	}
      
    // Elements
    private SupervisorHomePageUIMap controls;
    
    public SupervisorHomePage() {
        super();
        this.controls = new SupervisorHomePageUIMap();
    }

    
   // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void clickItemManagement() {
        this.controls.itemManagement.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Get Elements
    public ILink getItemManagement() {
        return this.controls.itemManagement;
    }

    
    // Business Logic - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public ItemManagementPage gotoItemManagement() {
        clickItemManagement();
        return new ItemManagementPage();
    }

}

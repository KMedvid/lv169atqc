package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class MerchandiserHomePage extends InfoPage {
	
	private class MerchandiserHomePageUIMap {
		public final ILink ordering;

		public MerchandiserHomePageUIMap() {
			this.ordering = Link.get().getByPartialLinkText("Ordering");
		}
	}
	
    // Elements
    private MerchandiserHomePageUIMap controls;
    
    public MerchandiserHomePage() {
        super();
        this.controls = new MerchandiserHomePageUIMap();
    }

    
    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void clickOrdering() {
        this.controls.ordering.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Get Elements
    public ILink getOrdering() {
        return this.controls.ordering;
    }

    
    // Business Logic - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public OrderingPage gotoOrdering() {
    	clickOrdering();
        return new OrderingPage();
    }
}

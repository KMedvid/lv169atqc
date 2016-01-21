package com.softserve.edu.oms.pages;

import com.softserve.edu.atqc.controls.Component;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class CustomerHomePage extends InfoPage {
    
    private class CustomerHomePageUIMap {
        private final String WRONG_PAGE = "Wrong Page";
        public final ILink ordering;

        public CustomerHomePageUIMap() {
            checkControls();
            this.ordering = Link.get()
                    .getByPartialLinkText("Ordering");
        }
        
        private void checkControls() {
            if (!Component.get().isInvisibleWebElementByPartialLinkText("Administration")) {
                // TODO Create class Exception + log + report.
                throw new RuntimeException(WRONG_PAGE);   
            }
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Elements
    private CustomerHomePageUIMap controls;

    public CustomerHomePage() {
        super();
        this.controls = new CustomerHomePageUIMap();
    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void clickOrdering() {
        this.controls.ordering.click();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public ILink getOrdering() {
        return this.controls.ordering;
    }

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public OrderingPage gotoOrdering() {
        clickOrdering();
        return new OrderingPage();
    }    

}

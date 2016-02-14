package com.softserve.edu.controls;

import com.softserve.edu.tools.ControlSearch;

abstract class ALabelClickable<TComponent> extends ALabel<TComponent> implements ILabelClickable {

    // implements constructor
    protected ALabelClickable() {
    }

    // implements interface

    public boolean isClickable() {
        return ControlSearch.get().isClickableWebElement(getControlLocation());
    }

    public void click() {
        if (isClickable()) {
            getControlWrapper().click();
        }
    }
    
    public void setFocus(){
        getControlWrapper().setFocus();
    }

}

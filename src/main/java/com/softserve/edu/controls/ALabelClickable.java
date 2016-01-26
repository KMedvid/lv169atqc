package com.softserve.edu.controls;

abstract class ALabelClickable<TComponent> extends ALabel<TComponent> implements ILabelClickable {

    // implements constructor
    protected ALabelClickable() {
    }

    // implements interface

    public void click(){
        getControlWrapper().click();
    }
    
    public void setFocus(){
        getControlWrapper().setFocus();
    }

}

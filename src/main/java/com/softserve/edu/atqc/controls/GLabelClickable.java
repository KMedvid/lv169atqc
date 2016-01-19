package com.softserve.edu.atqc.controls;

abstract class GLabelClickable<TComponent> extends GLabel<TComponent> implements ILabelClickable {

    // implements constructor
    protected GLabelClickable() {
    }

    // implements interface

    public void click(){
        getWebElementWrapper().click();
    }
    
}

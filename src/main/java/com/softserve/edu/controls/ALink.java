package com.softserve.edu.controls;

abstract class ALink<TComponent> extends ALabelClickable<TComponent> implements ILink {

    // implements constructor
    protected ALink() {
    }

    // implements interface

    public String getUrl() {
        return getControlWrapper().getUrl();
    }

}

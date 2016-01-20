package com.softserve.edu.atqc.controls;

public final class Link extends ALink<ILink> {

    // implements constructor
    private Link() {
    }

    // implements static factory

    public static ABaseComponent<ILink> get() {
        Link instance = new Link();
        instance.setTComponent(instance);
        return instance;
    }

}

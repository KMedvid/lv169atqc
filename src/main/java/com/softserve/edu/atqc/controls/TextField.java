package com.softserve.edu.atqc.controls;

public final class TextField extends GTextField<ITextField> {

    // implements constructor
    private TextField() {
    }

    // implements static factory

    public static AComponent<ITextField> get() {
        TextField instance = new TextField();
        instance.setTComponent(instance);
        return instance;
    }

}

package com.softserve.edu.atqc.controls;

public final class TextField extends ATextField<ITextField> {

    // implements constructor
    private TextField() {
    }

    // implements static factory

    public static ABaseComponent<ITextField> get() {
        TextField instance = new TextField();
        instance.setTComponent(instance);
        return instance;
    }

}

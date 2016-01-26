package com.softserve.edu.atqc.controls;

public final class Button extends AButton<IButton> {

    // implements constructor
    private Button() {
    }

    // implements static factory

    public static ABaseComponent<IButton> get() {
        Button instance = new Button();
        instance.setTComponent(instance);
        return instance;
    }

}

package com.softserve.edu.atqc.controls;

public final class Label extends ALabel<ILabel> {

    // implements constructor
    private Label() {
    }

    // implements static factory

    public static ABaseComponent<ILabel> get() {
        Label instance = new Label();
        instance.setTComponent(instance);
        return instance;
    }

}

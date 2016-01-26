package com.softserve.edu.atqc.controls;

public final class Component extends AComponent<IComponent> {

    // implements constructor
    private Component(){
    } 

    // implements static factory

    public static ABaseComponent<IComponent> get() {
        Component instance = new Component();
        instance.setTComponent(instance);
        return instance;
    }

}

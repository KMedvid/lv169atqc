package com.softserve.edu.md.data;
public enum CustomerType {
    PROVIDER("Постачальник послуг"), LABORATORY("Вимірювальна лабораторія");
    //
    private String field;

    private CustomerType(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return this.field;
    }
}
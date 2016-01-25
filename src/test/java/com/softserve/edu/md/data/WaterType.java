package com.softserve.edu.md.data;
public enum WaterType {
    COLD("Холодна вода"), HEATED("Гаряча вода");
    //
    private String field;

    private WaterType(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return this.field;
    }
}
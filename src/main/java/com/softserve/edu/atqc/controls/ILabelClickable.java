package com.softserve.edu.atqc.controls;

public interface ILabelClickable extends ILabel {
    
    boolean isClickable();

    void click();

    void setFocus();

}

package com.softserve.edu.controls;

public interface ILabelClickable extends ILabel {
    
    boolean isClickable();

    void click();

    void setFocus();

}

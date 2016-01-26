package com.softserve.edu.atqc.controls;

public interface ITextField extends ILabelClickable {

    void clear();

    void sendKeys(String text);
    
    void sendKeysClear(String text);

}

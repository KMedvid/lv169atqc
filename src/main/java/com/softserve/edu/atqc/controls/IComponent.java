package com.softserve.edu.atqc.controls;

public interface IComponent {
 
    String getAttribute(String attribute);

    String getAttributeName();

    String getContent();

    String getTagName();

    boolean isDisplayed();

    boolean isEnabled();

    boolean isSelected();
    
    boolean isInvisible();

    boolean isInvisibleWithText(String text);
    
    boolean isStatelessOf();

}

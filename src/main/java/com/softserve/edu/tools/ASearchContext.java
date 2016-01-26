package com.softserve.edu.tools;

import java.util.List;

import org.openqa.selenium.WebElement;

abstract class ASearchContext {
    static final long ONE_SECOND = 1000L;
    static final String ERROR_NOT_FOUND = "WebElement(s) was not found %s";
    static final String ERROR_STILL_VISIBLE = "WebElement is Still Visible %s";
    static final String ERROR_TITLE_INVISIBLE = "Title Invisible %s";

    abstract WebElement getVisibleWebElement(ControlLocation controlLocation);

    abstract List<WebElement> getVisibleWebElements(ControlLocation controlLocation);

    abstract WebElement getPresentWebElement(ControlLocation controlLocation);

    abstract boolean isInvisibleWebElement(ControlLocation controlLocation);

    abstract boolean isInvisibleWebElementWithText(ControlLocation controlLocation, String text);

    abstract boolean isStatelessOfWebElement(ControlWrapper controlWrapper);

    abstract boolean isVisibleTitle(String partialTitle);

}

package com.softserve.edu.specs;

import com.softserve.edu.controls.IButton;

public final class ButtonCriteria implements IButtonCriteriaNext {
	private final String IT_IS_NOT_VISIBLE = "Button it's not visible";
	private IButton button;

	private ButtonCriteria(IButton button) {
		this.button = button;
	}

	public static IButtonCriteria get(IButton button) {
		return new ButtonCriteria(button);
	}
	public IButtonCriteriaNext isVisible() {
	    AssertWrapper.get().verify(button.isDisplayed(), IT_IS_NOT_VISIBLE);
		return this;
	}

    public AssertWrapper next() {
        return AssertWrapper.get();
    }
}

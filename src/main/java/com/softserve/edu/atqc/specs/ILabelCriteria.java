package com.softserve.edu.atqc.specs;

public interface ILabelCriteria {

	ILabelCriteriaNext valueMatch(String expectedResult);

	ILabelCriteriaNext valueStartsWith(String expectedResult);

	ILabelCriteriaNext valueByPartialText(String expectedResult);

	ILabelCriteriaNext isVisible();

}

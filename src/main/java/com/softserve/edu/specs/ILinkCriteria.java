package com.softserve.edu.specs;

public interface ILinkCriteria {

    ILinkCriteriaNext urlMatch(String expectedResult);

    ILinkCriteriaNext valueMatch(String expectedResult);

    ILinkCriteriaNext valueStartsWith(String expectedResult);

    ILinkCriteriaNext valueByPartialText(String expectedResult);

    ILinkCriteriaNext isVisible();

}

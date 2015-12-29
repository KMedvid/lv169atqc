package com.softserve.edu.md.data;

public interface IAgreement {
    WaterType getWaterType();

    CustomerType getCustomerType();

    String getCustomerName();

    String getExecutorName();

    int getMetersQuantity();

    String getAgreementCode();

    String getAgreementCodeText();
}

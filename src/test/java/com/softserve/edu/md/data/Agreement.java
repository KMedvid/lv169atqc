package com.softserve.edu.md.data;

interface IWaterType {
    ICustomerType setWaterType(WaterType waterType); 
}

interface ICustomerType {
    ICustomerName setCustomerType(CustomerType customerType);
}

interface ICustomerName {
    IExecutorName setCustomerName(String customerName);
}

interface IExecutorName {
    IAgreementCode setExecutorName(String executorName);
}

interface IAgreementCode {
    IMetersQuantity setAgreementCode(String agreementCode);
}

interface IMetersQuantity {
    IBuildAgreement setMetersQuantity(Integer metersQuantity);
}

interface IBuildAgreement {
    IAgreement build();
}

public class Agreement implements IWaterType, ICustomerType, ICustomerName, IExecutorName, IAgreementCode,
        IMetersQuantity, IBuildAgreement, IAgreement {

    private WaterType waterType;
    private CustomerType customerType;
    private String customerName;
    private String executorName;
    private String agreementCode;
    private Integer metersQuantity;

    private Agreement() {

    }

    public static IWaterType get() {
        return new Agreement();
    }

    public ICustomerType setWaterType(WaterType waterType) {
        this.waterType = waterType;
        return this;
    }

    public ICustomerName setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
        return this;
    }

    public IExecutorName setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public IAgreementCode setExecutorName(String executorName) {
        this.executorName = executorName;
        return this;
    }

    public IMetersQuantity setAgreementCode(String agreementCode) {
        this.agreementCode = agreementCode;
        return this;
    }

    public IBuildAgreement setMetersQuantity(Integer metersQuantity) {
        this.metersQuantity = metersQuantity;
        return this;
    }

    public IAgreement build() {
        return this;
    }

    // Get
    public WaterType getWaterType() {
        return waterType;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getExecutorName() {
        return this.executorName;
    }

    public Integer getMetersQuantity() {
        return this.metersQuantity;
    }

    public String getAgreementCode() {
        return this.agreementCode;
    }
    
    public String getAgreementCodeText() {
        return this.agreementCode.toString();
    }

}

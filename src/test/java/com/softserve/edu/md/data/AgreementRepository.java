package com.softserve.edu.md.data;

public final class AgreementRepository {

    private static volatile AgreementRepository instance = null;

    private AgreementRepository() {
    }

    public static AgreementRepository get() {
        if (instance == null) {
            synchronized (AgreementRepository.class) {
                if (instance == null) {
                    instance = new AgreementRepository();
                }
            }
        }
        return instance;
    }

    public IAgreement getProviderAgreementCold() {
        return Agreement.get()
                .setWaterType(WaterType.COLD)
                .setCustomerType(CustomerType.PROVIDER)
                .setCustomerName("ЛКП «Львівводоканал»")
                .setExecutorName("Київ калібратор")
                .setAgreementCode("КДГ012345")
                .setMetersQuantity(25)
                .build();
    }

    public IAgreement getProviderAgreementHeated() {
        return Agreement.get()
                .setWaterType(WaterType.HEATED)
                .setCustomerType(CustomerType.PROVIDER)
                .setCustomerName("ЛКП «Львівводоканал»")
                .setExecutorName("Київ калібратор")
                .setAgreementCode("КДГ012340")
                .setMetersQuantity(50)
                .build();
    }   

 
}

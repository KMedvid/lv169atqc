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
    
    public IAgreement getProviderCalibratorAgreementCold() {
        return Agreement.get()
                .setWaterType(WaterType.COLD)
                .setCustomerType(CustomerType.PROVIDER)
                .setCustomerName("ЛКП «Львівводоканал»")
                .setExecutorName("Київ калібратор")
                .setAgreementCode("ПК1234")
                .setMetersQuantity(25)
                .build();
    }
    
    
    public IAgreement getCalibratorVerificatorAgreementCold() {
        return Agreement.get()
                .setWaterType(WaterType.COLD)
                .setCustomerType(CustomerType.LABORATORY )
                .setCustomerName("Київ калібратор")
                .setExecutorName("ПП «Повірик з Тернополя»")
                .setAgreementCode("КВ1234")
                .setMetersQuantity(50)
                .build();
    }

    public IAgreement getProviderAgreementHeated() {
        return Agreement.get()
                .setWaterType(WaterType.HEATED)
                .setCustomerType(CustomerType.PROVIDER)
                .setCustomerName("ЛКП «Львівводоканал»")
                .setExecutorName("Київ калібратор")
                .setAgreementCode("КДГ012340")
                .setMetersQuantity(75)
                .build();
    }   
    
    public IAgreement getLaboratoryAgreementHeated() {
        return Agreement.get()
                .setWaterType(WaterType.HEATED)
                .setCustomerType(CustomerType.LABORATORY)
                .setCustomerName("Київ калібратор")
                .setExecutorName("Київ верифікатор")
                .setAgreementCode("КВГ012995")
                .setMetersQuantity(100)
                .build();
    }   

 
}

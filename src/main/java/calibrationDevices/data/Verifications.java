package calibrationDevices.data;


interface ICustomerFirstname {
    ICustomerLastname setFirstname(String firstname);
}

interface ICustomerLastname {
    ICustomerMiddlename setLastname(String lastname);
}

interface ICustomerMiddlename {
    ICustomerEmail setMiddlename(String middlename);
}


interface ICustomerEmail {
    ICustomerPhone setEmail(String email);

}

interface ICustomerPhone {
    IRegion setPhone(String phone);

}

interface IRegion {
    IDistrict setRegion(String region);
}


interface IDistrict{
    ILocality setDistrict(String district);
}


interface ILocality {
    IIndex setLocality(String locality);
}


interface IIndex {
    IStreetType setIndex(String index);
}


interface IStreetType {
    IStreetName setStreetType(String streetType);
}


interface IStreetName {
    IBuilding setStreetName(String streetName);
}


interface IBuilding {
    IFlat setBuilding(String building);
}


interface IFlat {
    ICounterAmount setFlat(String flat);
}


interface ICounterAmount {
    ICounterType setCounterAmount(String counterAmount);
}


interface ICounterType {
    IChooseProvider setCounterType(String counterType);
} 

interface IChooseProvider {
    IVerificationID setChooseProvider(String chooseProvider);
}


interface IVerificationID {
    IVerificationsBuild setVerificationID(String verifiationID);
}

interface IVerificationsBuild {
    IVerifications build();
}

public class Verifications implements ICustomerFirstname, ICustomerLastname, ICustomerMiddlename, ICustomerEmail, ICustomerPhone, IRegion, IDistrict, ILocality, IIndex, IStreetType, IStreetName, IBuilding, IFlat, ICounterAmount, ICounterType, IChooseProvider, IVerificationID, IVerificationsBuild, IVerifications {
    private String lastName;
    private String firstname;
    private String middlename;
    private String email;
    private String phone;
    private String region;
    private String district;
    private String locality;
    private String index;
    private String streetType;
    private String streetName;
    private String building;
    private String flat;
    private String counterAmount;
    private String counterType;
    private String chooseProvider;
    private String verificationsID;

    private Verifications() {
    }
    
    
    public static ICustomerFirstname get() {
        return new Verifications();
    }
    
    public ICustomerLastname setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
    
    public ICustomerMiddlename setLastname(String lastname) {
        this.lastName = lastname;
        return this;
    }

    public ICustomerEmail setMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ICustomerPhone setEmail(String email) {
        this.email = email;
        return this;
    }

    public IRegion setPhone(String phone) {
        this.phone = phone;
        return this;       
    }
    
    public IDistrict setRegion(String region) {
        this.region = region;
        return this;       
    }
    
    public ILocality setDistrict(String district) {
        this.district = district;
        return this;       
    }
    
    public IIndex setLocality(String locality) {
        this.locality = locality;
        return this;       
    }
    
    public IStreetType setIndex(String index) {
        this.index = index;
        return this;       
    }
    
    public IStreetName setStreetType(String streetType) {
        this.streetType = streetType;
        return this;       
    }
    
    public IBuilding setStreetName(String streetName) {
        this.streetName = streetName;
        return this;       
    }
    
    public IFlat setBuilding(String building) {
        this.building= building;
        return this;       
    }
    
    public ICounterAmount setFlat(String flat) {
        this.flat = flat;
        return this;       
    }
    
    public ICounterType setCounterAmount(String counterAmount) {
        this.counterAmount = counterAmount;
        return this;       
    }
    
    public IChooseProvider setCounterType(String counterType) {
        this.counterType = counterType;
        return this;       
    }
    
    public IVerificationID setChooseProvider(String chooseProvider) {
        this.chooseProvider = chooseProvider;
        return this;       
    }
    
    public IVerificationsBuild setVerificationID(String verificationsID) {
        this.verificationsID = verificationsID;
        return this;       
    }
    
    public IVerifications build() {
        return this;
    }
    
    public IVerifications setVerificationnID(String verificationsID) {
        this.verificationsID = verificationsID;
        return this;       
    }
    
    
    public String setVerificationsID(String verificationsID){
        this.verificationsID = verificationsID;
        return verificationsID;
    }

    // get - - - - - - - - - -


    public String getLastName() {
        return lastName;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public String getMiddlename() {
        return middlename;
    }

    public String getEmail() {
        return email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getRegion() {
        return region;
    }
    
    public String getDistrict() {
        return district;
    }
    public String getLocality() {
        return locality;
    }
    
    public String getBuilding() {
        return building;
    }
    
    public String getIndex() {
        return index;
    }
    
    public String getFlat() {
        return flat;
    }
    
    public String getcounterAmount() {
        return counterAmount;
    }
    
    public String getCounterType() {
        return counterType;
    }
    
    public String getChooseProvider() {
        return chooseProvider;
    }
    
    public String getStreetType() {
        return streetType;
    }
    
    public String getStreetName() {
        return streetName;
    }
    
    
    public String getVerificationsId() {
        return verificationsID;
    }
}

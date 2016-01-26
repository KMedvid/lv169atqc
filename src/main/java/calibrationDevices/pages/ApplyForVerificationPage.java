package calibrationDevices.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import calibrationDevices.data.IVerifications;
import calibrationDevices.data.VerificationsRepository;

public class ApplyForVerificationPage extends StartPageMD{
    
    public static final String PAGE_TITLE = "";
    
    private WebElement pagetitle;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement middleName;
    private WebElement phone;
    private WebElement email;
    private WebElement house;
    private WebElement appartment;
    private WebElement send;
    private WebElement clearAll;
    private WebElement close;
    private WebElement regionSelect;
    private WebElement region;
    private WebElement districtSelect;
    private WebElement district;
    private WebElement localitySelect;
    private WebElement locality;
    private WebElement indexSelect;
    private WebElement index;
    private WebElement streetTypeSelect;
    private WebElement streetType;
    private WebElement street;
    private WebElement amountOfCounterSelect;
    private WebElement amountOfCounter;
    private WebElement counterTypeSelect;
    private WebElement counterType;
    private WebElement providerSelect;
    private WebElement provider;
    
    private WebElement searchField;
    private WebElement firstValue;


    public ApplyForVerificationPage(WebDriver driver) {
        super(driver);
        this.firstName= driver.findElement(By.id("lastName"));
        this.lastName= driver.findElement(By.id("firstName"));
        this.middleName= driver.findElement(By.id("middleName"));
        this.phone= driver.findElement(By.id("phoneNumber"));
        this.email= driver.findElement(By.id("email"));
        this.house= driver.findElement(By.id("building"));
        this.appartment= driver.findElement(By.id("flat"));
        this.send= driver.findElement(By.cssSelector(".btn-success.pull-right.text-uppercase.ng-binding"));
        this.regionSelect= driver.findElement(By.cssSelector("[placeholder='Оберіть область'] b"));
        this.districtSelect= driver.findElement(By.cssSelector("[name = 'district'] b"));
        this.localitySelect= driver.findElement(By.cssSelector("[name='locality'] b"));
        this.indexSelect= driver.findElement(By.cssSelector("[ng-model='selectedValues.selectedIndex'] b"));
        this.streetTypeSelect= driver.findElement(By.cssSelector("[ng-model='selectedValues.selectedStreetType'] b"));
        this.street= driver.findElement(By.id("street"));
        this.amountOfCounterSelect= driver.findElement(By.cssSelector("#counterNumber b"));
        this.counterTypeSelect= driver.findElement(By.cssSelector("#firstSelectedDeviceDeviceType b"));
        this.providerSelect= driver.findElement(By.cssSelector("[placeholder = 'Оберіть надавача послуг'] b"));
    }
    
    public class VerificationCode{
        public static final String START_VALIDATOR_MESSAGE = "Дякуємо! Заявка була успішно надіслана";
        
        private WebElement verificationID;
        private WebElement successfullMessage;
        
        public VerificationCode(){
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            (new WebDriverWait(driver, 30)).until(ExpectedConditions
                    .presenceOfElementLocated(By.cssSelector("[ng-show='!appProgress'] div")));
            this.successfullMessage = driver.findElement(By.cssSelector("[ng-show='!appProgress'] div"));
            this.verificationID = driver.findElement(By.cssSelector("[href*='#/application-status/'] b"));
        }
        
        // Get Elements
        public WebElement getVerificationID() {
            return this.verificationID;
        }

        public String getVerificationIDText() {
            return this.verificationID.getAttribute("textContent");
        }
        
        public WebElement getSuccessfullMessage() {
            return this.successfullMessage;
        }

        public String getSuccessfullMessageText() {
            return this.successfullMessage.getAttribute("textContent");
        }

        public String getStartSuccessfullMessageText() {
            return this.successfullMessage.getAttribute("textContent").substring(0, START_VALIDATOR_MESSAGE.length()).trim();
        }

    }
    
    public void setAddress(String region, String district, String locality, String index, String streetType, String street) throws InterruptedException{
        insertRegion(region);
    //    Thread.sleep(1000);
        insertDistrict(district);
        insertLocality(locality);
        insertIndex(index);
     //   Thread.sleep(1000);
        insertStreetType(streetType);
        insertStreet(street);
    }

    public void setCounter(String amountOfCounter, String counterType, String provider){
        insertAmountOfCounters(amountOfCounter);
        insertCounterType(counterType);
        insertProvider(provider);
    }
    
    public void insertRegion(String region){
        clickRegionSelect();
        searchField = driver.findElement(By.cssSelector("[ng-model='selectedValues.selectedRegion'] div input"));
        clickSearchField();
        setSearchField(region);
        firstValue = driver.findElement(By.cssSelector("[id='ui-select-choices-row-0-0']  span"));
        firstValue.click();
    }
    
    public void insertDistrict(String district){
        clickDistrictSelect();
        searchField = driver.findElement(By.cssSelector("[name = 'district'] div input"));
        clickSearchField();
        setSearchField(district);
        firstValue = driver.findElement(By.cssSelector("[id='ui-select-choices-row-1-0']  span"));
        firstValue.click();
    }
    
    public void insertLocality(String locality){
        clickLocalitySelect();
        searchField = driver.findElement(By.cssSelector("[ng-model='selectedValues.selectedLocality'] div input"));
        clickSearchField();
        setSearchField(locality);
        firstValue = driver.findElement(By.cssSelector("[id='ui-select-choices-row-2-0']  span"));
        firstValue.click();
    }
    
    public void insertIndex(String index){
        clickIndexSelect();
        searchField = driver.findElement(By.cssSelector("[ng-model='selectedValues.selectedIndex'] div input"));
        clickSearchField();
        setSearchField(index);
        firstValue = driver.findElement(By.cssSelector("[id='ui-select-choices-row-3-0']  span"));
        firstValue.click();
    }
    
    public void insertStreetType(String streetType){
        clickStreetTypeSelect();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[text() = '"+ streetType + "']")));
        driver.findElement(By.xpath("//span[text() = '" + streetType + "']")).click();
    }
    
    public void insertStreet(String street){
        clickStreet();
        setStreet(street);
    }
    
    public void insertAmountOfCounters(String amountOfCountrs){
        clickAmountOfCounterSelect();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[text() = '"+ amountOfCountrs + "']")));
        driver.findElement(By.xpath("//span[text() = '" + amountOfCountrs + "']")).click();
    }
    
    public void insertCounterType(String counterType){
        clickCounterTypeSelect();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[text() = '"+ counterType + "']")));
        driver.findElement(By.xpath("//span[text() = '" + counterType + "']")).click();
    }
    
    public void insertProvider(String provider){
        clickProviderSelect();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//span[text() = '"+ provider + "']")));
        driver.findElement(By.xpath("//span[text() = '" + provider + "']")).click();
    }

    public static String getPageTitle() {
        return PAGE_TITLE;
    }
    
    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getPagetitle() {
        return pagetitle;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getMiddleName() {
        return middleName;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getHouse() {
        return house;
    }

    public WebElement getAppartment() {
        return appartment;
    }

    public WebElement getRegion() {
        return region;
    }

    public WebElement getDistrict() {
        return district;
    }

    public WebElement getLocality() {
        return locality;
    }

    public WebElement getIndex() {
        return index;
    }

    public WebElement getStreetType() {
        return streetType;
    }

    public WebElement getStreet() {
        return street;
    }

    public WebElement getAmountOfCounter() {
        return amountOfCounter;
    }

    public WebElement getCounterType() {
        return counterType;
    }

    public WebElement getProvider() {
        return provider;
    }

    public WebElement getSend() {
        return send;
    }

    public WebElement getClearAll() {
        return clearAll;
    }

    public WebElement getClose() {
        return close;
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setMiddleName(String middleName) {
        this.middleName.sendKeys(middleName);
    }

    public void setPhone(String phone) {
        this.phone.sendKeys(phone);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setHouse(String house) {
        this.house.sendKeys(house);
    }

    public void setAppartment(String appartment) {
        this.appartment.sendKeys(appartment);
    }
    
    public void setSearchField(String searchField) {
        this.searchField.sendKeys(searchField);
    }
    
    public void clickSearchField() {
        this.searchField.click();
    }
    
    public void clickFirstName() {
        this.firstName.click();
    }

    public void clickLastName() {
        this.lastName.click();
    }

    public void clickMiddleName() {
        this.middleName.click();
    }

    public void clickPhone() {
        this.phone.click();
    }

    public void clickEmail() {
        this.email.click();
    }

    public void clickHouse() {
        this.house.click();
    }

    public void clickAppartment() {
        this.appartment.click();
    }
    public void clearFirstName() {
        this.firstName.clear();
    }

    public void clearLastName() {
        this.lastName.clear();
    }

    public void clearMiddleName() {
        this.middleName.clear();
    }

    public void clearPhone() {
        this.phone.clear();
    }

    public void clearEmail() {
        this.email.clear();
    }

    public void clearHouse() {
        this.house.clear();
    }

    public void clearAppartment() {
        this.appartment.clear();
    }


    public void clickSend() {
        this.send.click();;
    }

    public void clickClearAll() {
        this.clearAll.click();
    }

    public void clickClose() {
        this.close.click();;
    }

    public void setRegion(String region) {
        this.region.sendKeys(region);
    }

    public void setDistrict(String district) {
        this.district.sendKeys(district);
    }

    public void setLocality(String locality) {
        this.locality.sendKeys(locality);
    }

    public void setIndex(String index) {
        this.index.sendKeys(index);
    }

    public void setStreetType(String streetType) {
        this.streetType.sendKeys(streetType);
    }

    public void setStreet(String street) {
        this.street.sendKeys(street);
    }

    public void setAmountOfCounter(String amountOfCounter) {
        this.amountOfCounter.sendKeys(amountOfCounter);
    }

    public void setCounterType(String counterType) {
        this.counterType.sendKeys(counterType);
    }

    public void setProvider(String provider) {
        this.provider.sendKeys(provider);
    }
    public void clickRegionSelect() {
        this.regionSelect.click();
    }

    public void clickDistrictSelect() {
        this.districtSelect.click();
    }

    public void clickLocalitySelect() {
        this.localitySelect.click();
    }

    public void clickIndexSelect() {
        this.indexSelect.click();;
    }

    public void clickStreetTypeSelect() {
        this.streetTypeSelect.click();
    }

    public void clickAmountOfCounterSelect() {
        this.amountOfCounterSelect.click();;
    }

    public void clickCounterTypeSelect() {
        this.counterTypeSelect.click();;
    }

    public void clickProviderSelect() {
        this.providerSelect.click();
    }
    
    public void clickRegion() {
        this.region.click();
    }

    public void clickDistrict() {
        this.district.click();
    }

    public void clickLocality() {
        this.locality.click();
    }

    public void clickIndex() {
        this.index.click();;
    }

    public void clickStreetType() {
        this.streetType.click();
    }
    
    public void clickStreet() {
        this.street.click();
    }

    public void clickAmountOfCounter() {
        this.amountOfCounter.click();;
    }

    public void clickCounterType() {
        this.counterType.click();;
    }

    public void clickProvider() {
        this.provider.click();
    }
    
    //Business logic
    public void fillInVerificationForm(IVerifications verification) throws InterruptedException{
        clickFirstName();
        clearFirstName();
        setFirstName(verification.getFirstname());
        clickLastName();
        clearLastName();
        setLastName(verification.getLastName());
        clickMiddleName();
        clearMiddleName();
        setMiddleName(verification.getMiddlename());
        clickEmail();
        clearEmail();
        setEmail(verification.getEmail());
        clickPhone();
        clearPhone();
        setPhone(verification.getPhone());
        setAddress(verification.getRegion(), 
                   verification.getDistrict(), 
                   verification.getLocality(), 
                   verification.getIndex(), 
                   verification.getStreetType(),
                   verification.getStreetName());
        clickHouse();
        clearHouse();
        setHouse(verification.getBuilding());
        clickAppartment();
        clearAppartment();
        setAppartment(verification.getFlat());
        setCounter(verification.getcounterAmount(), verification.getCounterType(), verification.getChooseProvider());
    }
    
    public void sendVerification(IVerifications verification)  throws InterruptedException{
        fillInVerificationForm(verification);
        clickSend();
        VerificationCode verificationCode = new VerificationCode();
    }

    public String getVerifictionID(){
        VerificationCode verificationCode = new VerificationCode();
        return verificationCode.getVerificationIDText();
    }
}

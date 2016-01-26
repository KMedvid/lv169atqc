package calibrationDevices.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeesPage extends MainPage{
    //
    public static final String PAGE_TITLE = "Користувачі";
    
    private WebElement pagetitle;
    private WebElement addNewWorker;

    private WebElement workerLogin;
    private WebElement workerRole;
    private WebElement workerFirstName;
    private WebElement workerLastName;
    private WebElement workerPhone;
    private WebElement workerExtraPhone;
    
    private WebElement show100workersOnPage;
    
    public Integer amountOfWorkers;

    public EmployeesPage(WebDriver driver) {
        super(driver);
        //this.pagetitle= driver.findElement(By.cssSelector("h1[translate*='USERS']"));
        this.addNewWorker= driver.findElement(By.cssSelector("div button[ng-click='openAddUserModal()']"));
        this.show100workersOnPage = driver.findElement(By.cssSelector("button[ng-click='params.count(100)']"));
    }

    //table rows
    ArrayList<String> listLogin = new ArrayList<String>();
    ArrayList<String> lishRoles = new ArrayList<String>();
    ArrayList<String> listFirstNames = new ArrayList<String>();
    ArrayList<String> listLastNames = new ArrayList<String>();
    ArrayList<String> listPhone = new ArrayList<String>();
    ArrayList<String> listExtraPhone = new ArrayList<String>();
    
    ArrayList<EmployeeInfo> employeeInfo = new ArrayList<EmployeeInfo>();

    //init table with workers info
    private void initWorkersInfoTable(){
        WebElement myDynamicElement = ( new WebDriverWait(driver, 10))
                .until( ExpectedConditions.elementToBeClickable(By.cssSelector("button[ng-click='params.count(100)']")) );
              myDynamicElement.click();
        amountOfWorkers = driver.findElements(By.cssSelector("tr td:nth-child(6)")).size();
        
//        ArrayList<EmployeeInfo> employeeInfoList = new ArrayList<EmployeeInfo>();
        
        for(int i = 1; i < amountOfWorkers; i++){
	        this.workerLogin = driver.findElement(By.cssSelector("div[class='panel-body']  tr:nth-of-type("+i+") td[sortable=\"'username'\" ]"));
            this.workerRole = driver.findElement(By.cssSelector("div[class='panel-body']  tr:nth-of-type("+i+") td[sortable=\"'role'\" ]"));
            this.workerFirstName = driver.findElement(By.cssSelector("div[class='panel-body']  tr:nth-of-type("+i+") td[sortable=\"'firstName'\" ]"));
            this.workerLastName = driver.findElement(By.cssSelector("div[class='panel-body']  tr:nth-of-type("+i+") td[sortable=\"'lastName'\" ]"));
            this.workerPhone = driver.findElement(By.cssSelector("div[class='panel-body']  tr:nth-of-type("+i+") td[sortable=\"'phone'\" ]"));
            this.workerExtraPhone = driver.findElement(By.cssSelector("div[class='panel-body']  tr:nth-of-type("+i+") td[sortable=\"'secondPhone'\" ]"));

//            
//            listLogin.add(workerLogin.getText());
//            lishRoles.add(workerRole.getText());
//            listFirstNames.add(workerFirstName.getText());
//            listLastNames.add(workerLastName.getText());
//            listPhone.add(workerPhone.getText());
//            listExtraPhone.add(workerExtraPhone.getText());
            
            employeeInfo.add(new EmployeeInfo(workerLogin.getText(), workerRole.getText(), workerFirstName.getText(), workerLastName.getText(), workerPhone.getText(), workerExtraPhone.getText()));
            //System.out.println("worker info added t\\");
        }
    }
        
//    ArrayList[] workerInfoTable = new ArrayList[] {listLogin,lishRoles,listFirstNames,listLastNames,listPhone, listExtraPhone};
    
//    private ArrayList<String> workerInfoinRow(int indexOfWorker){
//	     ArrayList<String> workerInfo = new ArrayList<String>();
//	     for(ArrayList info : workerInfoTable){
//	         workerInfo.add(info.get(indexOfWorker).toString());
//	     }
//	     return workerInfo;
//    }
    
    // Get Elements
    public WebElement getPagetitle() {
        return this.pagetitle;
    }
    
    public EmployeeInfo getWorkerByLogin(String login) {
        for(EmployeeInfo employee : employeeInfo) {
            System.out.println("getWorkerlogin: " + employee.login);
            if (employee.login.contains(login)){
                return employee;
            }
        }

        return null;
    }

    public EmployeeInfo getWorkerByPhone(String phone) {
        for(EmployeeInfo employee : employeeInfo) {
            if (employee.phone == phone)
                return employee;
        }

        return null;
    }
    
    public EmployeeInfo getWorkerByExtraPhone(String extraPhone) {
        for(EmployeeInfo employee : employeeInfo) {
            if (employee.extraPhone == extraPhone)
                return employee;
        }

        return null;
    }
    
    public EmployeeInfo getWorkerByFirstName(String firstName) {
        for(EmployeeInfo employee : employeeInfo) {
            System.out.println("getWorkerByFirstName: " + employee.firstName);
            if (employee.firstName == firstName)
                return employee;
        }

        return null;
    }
    
    public EmployeeInfo getWorkerByLastName(String lastName) {
        for(EmployeeInfo employee : employeeInfo) {
            if (employee.lastName == lastName)
                return employee;
        }

        return null;
    }
    
    public EmployeeInfo getWorkerByRole(String role) {
        for(EmployeeInfo employee : employeeInfo) {
            if (employee.role == role)
                return employee;
        }

        return null;
    }

    public String getPageTitleText() {
        return this.pagetitle.getText();
    }

    public String getStartPageTitleText() {
        return this.pagetitle.getText().substring(0, PAGE_TITLE.length());
    }
    
    public WebElement getAddNewWorker() {
        return this.addNewWorker;
    }
    
    // Set Data
    public void clickAddNewWorker() {
        this.addNewWorker.click();
    }
    
    // Business Logic
    public AddNewWorkerFormPage gotoAddNewWorkerFormPage() {
        show100workersOnPage.click();
        clickAddNewWorker();
        return new AddNewWorkerFormPage(driver);
    }
    
    public void allWorkersInfoTable(){
        show100workersOnPage.click();
        initWorkersInfoTable();
    }
//    
//    public void getOneWorkerInfoinRow(Integer indexOfWorker){
//      show100workersOnPage.click();
//      initWorkersInfoTable();
//      workerInfoinRow(indexOfWorker);
//  }
}

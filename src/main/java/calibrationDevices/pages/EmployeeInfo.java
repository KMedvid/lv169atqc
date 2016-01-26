package calibrationDevices.pages;

public class EmployeeInfo {
    String login;
    String role;
    String firstName;
    String lastName;
    String phone;
    String extraPhone;
    
    public EmployeeInfo(String login, String role, String firstName, 
            String lastName, String phone, String extraPhone){
       this.login = login;
       this.role = role;
       this.firstName = firstName;
       this.lastName = lastName;
       this.phone = phone;
       this.extraPhone = extraPhone;
        
    }
}

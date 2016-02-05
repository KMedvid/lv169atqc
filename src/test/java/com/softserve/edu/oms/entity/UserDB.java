package com.softserve.edu.oms.entity;

public class UserDB {

    public static enum UserDBQueries {
        INSERT_USER_BY_LOGIN("INSERT INTO dbo.Users (Login, Password, FirstName, LastName, Email, RegionRef, RoleRef) VALUES ('%s', '%s', '%s', '%s', '%s', %s, %s);"),
        GET_USER_BY_LOGIN("SELECT ID, Login, Password, FirstName, LastName, Email, RegionRef, RoleRef FROM dbo.Users WHERE Login = '%s';"),
        GET_ALL_USERS("SELECT ID, Login, Password, FirstName, LastName, Email, RegionRef, RoleRef FROM dbo.Users;"),
        DELETE_USER_BY_ID("DELETE dbo.Users WHERE ID='%s';"),
        DELETE_USER_BY_PARTIAL_LOGIN("DELETE dbo.Users WHERE Login LIKE '%s%%';");
        private String query;

        private UserDBQueries(String query) {
            this.query = query;
        }

        @Override
        public String toString() {
            return query;
        }
    }
    
    private Long id;
    private Long isUserActive;              // May be null
    private Double balance;                 // May be null
    private String email;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private Long customerTypeRef;           // May be null
    private Long regionRef;                 // May be null
    private Long roleRef;

    // TODO Create Factory, Builder
    public UserDB(Long id, Long isUserActive, Double balance, String email, String firstname, String lastname,
            String login, String password, Long customerTypeRef, Long regionRef, Long roleRef) {
        this.id = id;
        this.isUserActive = isUserActive;       // May be null
        this.balance = balance;                 // May be null
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.customerTypeRef = customerTypeRef; // May be null
        this.regionRef = regionRef;             // May be null
        this.roleRef = roleRef;
    }

    // setters - - - - -

    public void setId(Long id) {
        this.id = id;
    }

    public void setIsUserActive(Long isUserActive) {
        this.isUserActive = isUserActive;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCustomerTypeRef(Long customerTypeRef) {
        this.customerTypeRef = customerTypeRef;
    }

    public void setRegionRef(Long regionRef) {
        this.regionRef = regionRef;
    }

    public void setRoleRef(Long roleRef) {
        this.roleRef = roleRef;
    }

    // getters - - - - -

    public Long getId() {
        return id;
    }

    public Long getIsUserActive() {
        return isUserActive;
    }

    public Double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Long getCustomerTypeRef() {
        return customerTypeRef;
    }

    public Long getRegionRef() {
        return regionRef;
    }

    public Long getRoleRef() {
        return roleRef;
    }

}

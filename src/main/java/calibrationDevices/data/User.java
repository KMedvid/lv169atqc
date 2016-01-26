package calibrationDevices.data;

interface IFirstname {
    ILastname setFirstname(String firstname);
}

interface ILastname {
    IMiddlename setLastname(String lastname);
}

interface IMiddlename {
    ILogin setMiddlename(String middlename);
}

interface ILogin {
    IPassword setLogin(String login);
}

interface IPassword {
    IEmail setPassword(String password);
}

interface IEmail {
    IPhone setEmail(String email);

}

interface IPhone {
    IExtraPhone setPhone(String phone);

}

interface IExtraPhone {
    IBuild setExtraPhone(String extraphone);
}

interface IBuild {
    IUser build();
}

public class User implements IFirstname, ILastname, IMiddlename, ILogin, IPassword, IEmail, IPhone, IExtraPhone, IBuild, IUser {
    private String firstname;
    private String lastname;
    private String middlename;
    private String login;
    private String password;
    private String email;
    private String phone;
    private String extraphone;

    private User() {
    }

    public static IFirstname get() {
        return new User();
    }
    
    public ILastname setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
    
    public IMiddlename setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ILogin setMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public IPassword setLogin(String login) {
        this.login = login;
        return this;
    }

    public IEmail setPassword(String password) {
        this.password = password;
        return this;
    }

    public IPhone setEmail(String email) {
        this.email = email;
        return this;
    }

    public IExtraPhone setPhone(String phone) {
        this.phone = phone;
        return this;       
    }
    
    public IBuild setExtraPhone(String extraphone) {
        this.extraphone = extraphone;
        return this;
    }

    public IUser build() {
        return this;
    }

    // get - - - - - - - - - -

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    
    public String getMiddlename() {
        return middlename;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getExtraPhone() {
        return extraphone;
    }

}

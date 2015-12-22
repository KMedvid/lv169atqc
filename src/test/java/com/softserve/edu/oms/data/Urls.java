package com.softserve.edu.oms.data;

interface ILoginUrl {
    ILogoutUrl setLogin(String login);
}

interface ILogoutUrl {
    IBuildUrl setLogout(String logout);
}

interface IBuildUrl {
    IUrls build();
}

public class Urls implements ILoginUrl, ILogoutUrl, IBuildUrl, IUrls {
    private String login;
    private String logout;

    private Urls() {
    }

    // public Urls(String login, String logout) {
    // this.login = login;
    // this.logout = logout;
    // }

    // set - - - - - - - - - -

    public static ILoginUrl get() {
        return new Urls();
    }

    public ILogoutUrl setLogin(String login) {
        this.login = login;
        return this;
    }

    public IBuildUrl setLogout(String logout) {
        this.logout = logout;
        return this;
    }

    public IUrls build() {
        return this;
    }

    // get - - - - - - - - - -

    public String getLogin() {
        return login;
    }

    public String getLogout() {
        return logout;
    }

}

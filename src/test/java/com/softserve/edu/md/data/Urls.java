package com.softserve.edu.md.data;

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


    public String getLogin() {
        return login;
    }

    public String getLogout() {
        return logout;
    }

}

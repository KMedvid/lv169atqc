package com.softserve.edu.md.data;

interface IFirstname {
	ILastname setFirstname(String firstname);
}

interface ILastname {
	ILogin setLastname(String lastname);
}

interface ILogin {
	IPassword setLogin(String login);
}

interface IPassword {
	IEmail setPassword(String password);
}

interface IEmail {
	IBuild setEmail(String email);
}

interface IBuild {
	IUser build();
}

public class User implements IFirstname, ILastname, ILogin, IPassword, IEmail, IBuild, IUser {
	private String firstname;
	private String lastname;
	private String login;
	private String password;
	private String email;

	private User() {
	}

	  public static IFirstname get() {
	        return new User();
	    }

	public ILastname setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ILogin setLastname(String lastname) {
		this.lastname = lastname;
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

	public IBuild setEmail(String email) {
		this.email = email;
		return this;
	}

	public IUser build() {
		return this;
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

	public String getEmail() {
		return email;
	}

}

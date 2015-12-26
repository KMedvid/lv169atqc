package com.softserve.edu.fedyk.mdVerificator.model;

public class Employee extends User {
	
	
	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}
	private String lastName ;
	private String name;
	private String surname;
	private String phoneNumber;
	private String email;

	public Employee(String login, String password, String lastName, String name, String surname, String phoneNumber,
			String email) {
		super(login, password);
		this.lastName = lastName;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		
	}
	
	
	
}

package com.softserve.edu.fedyk.mdVerificator.data;

import com.softserve.edu.fedyk.mdVerificator.model.pages.Employee;
import com.softserve.edu.fedyk.mdVerificator.model.pages.User;

public class UserRepository {

	public static Employee getPetro() {
		return new Employee("petro6" /* + new Date() */, "pass", "Полухтович", "Петро", "Петрович", "666666666",
				"blabla@gmail.com");
	}

	public static User getVerificator() {
		return new User("verificator-lv", "pass");
	}
	public static String getUser() {
		return "Володя Назар Тарасович";
	}
}
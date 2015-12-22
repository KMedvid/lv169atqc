package com.softserve.edu.md.data;

import java.util.ArrayList;
import java.util.List;

public class CSVUsers {
	private static final String USERS_CSV_FILE_NAME = "/users.csv";

	public List<IUser> getAllUsers() {
		return getAllUsers(this.getClass()
		        .getResource(USERS_CSV_FILE_NAME).getPath().substring(1));
	}

	public List<IUser> getAllUsers(String absoluteFilePath) {
		List<IUser> users = new ArrayList<IUser>();
		for (List<String> row : (new CSVUtils()).getAllCells(absoluteFilePath)) {
			users.add(User.get()
					.setFirstname(row.get(0))
					.setLastname(row.get(1))
					.setLogin(row.get(2))
					.setPassword(row.get(3))
					.setEmail(row.get(4))
					.build());
		}
		return users;
	}

}

package com.softserve.edu.md.data;

import java.util.ArrayList;
import java.util.List;

public final class UserUtils {
    private String filename;
    private IExternalData externalData;

    public UserUtils() {
        filename = "/users.csv";
        externalData = new CSVUtils();
    }

    public UserUtils(String filename, IExternalData externalData) {
        this.filename = filename;
        this.externalData = externalData;
    }

    public List<IUser> getAllUsers() {
        return getAllUsers(this.getClass().getResource(filename).getPath().substring(1));
    }

    public List<IUser> getAllUsers(String absoluteFilePath) {
        List<IUser> users = new ArrayList<IUser>();
        for (List<String> row : externalData.getAllCells(absoluteFilePath)) {
            if (row.get(4).toLowerCase().contains("email")
                    ) {
                continue;
            }
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
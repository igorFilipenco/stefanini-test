package com.stefanini.test2.utils;

import com.stefanini.test2.entity.User;

import java.util.List;

public class Validator {
    public static int getUserIndexIfExists(List<User> users, String userName) {
        for (User user: users) {
            if (user.getUserName().equals(userName)) return users.indexOf(user);
        }

        return -1;
    }
}

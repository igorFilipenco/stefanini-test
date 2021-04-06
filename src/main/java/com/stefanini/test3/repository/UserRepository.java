package com.stefanini.test3.repository;

import com.stefanini.test3.entity.User;
import org.hibernate.Session;

import java.util.List;


public interface UserRepository {
    void createUser(User user);

    List<User> getUsers();

    User getUserByUserName(Session session, String userName);

    void deleteAllUsers();
}

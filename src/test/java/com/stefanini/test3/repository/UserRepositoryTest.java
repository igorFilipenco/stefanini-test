package com.stefanini.test3.repository;

import com.stefanini.test3.entity.User;
import com.stefanini.test3.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@Transactional
public class UserRepositoryTest {
    private static final UserRepository userRepository = new UserRepositoryImpl();
    public static final User U1 = new User("U1", "First name1", "Last name1", new ArrayList<>());
    public static final User U2 = new User("U2", "First name2", "Last name2", new ArrayList<>());

    @BeforeClass
    public static void prepareDataBase() {
        userRepository.deleteAllUsers();
    }

    @Test
    public void createUser() {
        try (Session session = HibernateUtil.getSession()) {
            userRepository.createUser(U1);
            User createdUser = userRepository.getUserByUserName(session, U1.getUserName());
            assertEquals(U1.getUserName(), createdUser.getUserName());
        }
    }

    @Test
    public void getUserByNotExistingName() {
        try (Session session = HibernateUtil.getSession()) {
            User foundUser = userRepository.getUserByUserName(session, "Abracadabra");
            assertNull(foundUser);
        }
    }

    @Test
    public void getUserByUserName() {
        try (Session session = HibernateUtil.getSession()) {
            User foundUser = userRepository.getUserByUserName(session, U1.getUserName());
            assertNull(foundUser);
        }
    }

    @Test
    public void getUsers() {
        userRepository.createUser(U2);
        List<User> userList = userRepository.getUsers();
        assertEquals(userList.size(), 2);
    }

    @AfterClass
    public static void rollBack() {
        userRepository.deleteAllUsers();
    }
}


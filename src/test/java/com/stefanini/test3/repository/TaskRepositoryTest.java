package com.stefanini.test3.repository;

import com.stefanini.test3.entity.Task;
import com.stefanini.test3.entity.User;
import com.stefanini.test3.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaskRepositoryTest {
    private static final TaskRepository taskRepository = new TaskRepositoryImpl();
    private static final UserRepository userRepository = new UserRepositoryImpl();
    public static final User U1 = new User("U1", "First name1", "Last name1", new ArrayList<>());
    public static final User U2 = new User("U2", "First name2", "Last name2", new ArrayList<>());
    private static final Task T1 = new Task("task U1", "U1 description");
    private static final Task T2 = new Task("task U2", "U2 description");

    @BeforeClass
    public static void prepareDataBase() {
        userRepository.deleteAllUsers();
        taskRepository.deleteAllTasks();
        createTestUsers();
    }

    @Test
    public void testAcreateTask() {
        try (Session session = HibernateUtil.getSession()) {
            taskRepository.createTask(T1, U1.getUserName());
            User user = userRepository.getUserByUserName(session, U1.getUserName());
            assertEquals(user.getTasks().size(), 1);
        }
    }

    @Test
    public void testBgetTaskByUsername() {
        try (Session session = HibernateUtil.getSession()) {
            User user = userRepository.getUserByUserName(session, U1.getUserName());
            assertEquals(user.getTasks().get(0).getTitle(), T1.getTitle());
        }
    }

    @Test
    public void testCgetTasks() {
        try (Session session = HibernateUtil.getSession()) {
            taskRepository.createTask(T2, U1.getUserName());
            User user = userRepository.getUserByUserName(session, U1.getUserName());
            assertEquals(user.getTasks().size(), 2);
        }
    }

    @AfterClass
    public static void rollBack() {
        userRepository.deleteAllUsers();
        taskRepository.deleteAllTasks();
    }

    private static void createTestUsers() {
        userRepository.createUser(U1);
        userRepository.createUser(U2);
    }
}

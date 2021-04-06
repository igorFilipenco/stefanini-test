package com.stefanini.test3.utils;

import com.stefanini.test3.entity.Task;
import com.stefanini.test3.entity.User;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Query;
import java.util.List;

public class HibernateUtilTest {
    @Test
    public void createTablesAndFillWithData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Task task = new Task("Default task title", "Default task description");
        session.save(task);

        User user = new User();
        user.setLastName("last name");
        user.setFirstName("first name");
        user.setUserName("test");
        user.addTask(task);
        session.save(user);

        session.getTransaction().commit();

        Query queryUsers = session.createQuery("From User ");

        List<User> resultList = queryUsers.getResultList();

        Assert.assertEquals(1, resultList.size());
    }
}
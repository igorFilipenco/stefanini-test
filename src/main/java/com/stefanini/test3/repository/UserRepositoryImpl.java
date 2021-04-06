package com.stefanini.test3.repository;

import com.stefanini.test3.entity.User;
import com.stefanini.test3.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;


public class UserRepositoryImpl implements UserRepository {
    @Override
    public void createUser(User user) {
        String userName = user.getUserName();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User existingUser = getUserByUserName(session, userName);

        if (existingUser == null) {
            session.save(user);
            session.getTransaction().commit();
        } else {
            System.out.println("Error: user with username " + user.getUserName() + " already exists");
        }
    }

    @Override
    public User getUserByUserName(Session session, String userName) {
        Query query = session.createQuery("From User U WHERE U.userName = :userName");
        query.setParameter("userName", userName);
        List<User> users = query.getResultList();

        if (users.size() > 0) {
            return users.get(0);
        }

        return null;
    }

    @Override
    public List<User> getUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM User");
        List<User> userList = query.getResultList();

        return userList;
    }

    @Override
    public void deleteAllUsers() {
        Session session = HibernateUtil.getSession();

        if (session.getTransaction().isActive()) {
            session.getTransaction().commit();
        }

        session.beginTransaction();
        session.createQuery("delete from User").executeUpdate();
        session.getTransaction().commit();
    }
}

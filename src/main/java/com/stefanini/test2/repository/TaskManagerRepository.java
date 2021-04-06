package com.stefanini.test2.repository;

import com.stefanini.test2.entity.Task;
import com.stefanini.test2.entity.User;

import java.util.List;

public interface TaskManagerRepository {
    void createUser(User user);

    List<User> getUsers();

    void createTask(Task task, String userName);

    List<Task> getTasks(String[] args);
}

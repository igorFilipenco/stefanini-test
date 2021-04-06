package com.stefanini.test3.service;

public interface TaskService {
    void createTask(String[] args);

    void getTasksByUsername(String[] args);

    void getTasks(String[] args);

    void completeTask(String[] args);
}

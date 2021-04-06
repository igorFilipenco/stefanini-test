package com.stefanini.test3.repository;

import com.stefanini.test3.entity.Task;

import java.util.List;

public interface TaskRepository {
    void createTask(Task task, String userName);

    List<Task> getTasksByUsername(String[] args);

    List<Task> getTasks(String[] args);

    void completeTask(String userName, String taskTitle);

    void deleteAllTasks();
}

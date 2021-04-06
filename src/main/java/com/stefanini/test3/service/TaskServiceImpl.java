package com.stefanini.test3.service;

import com.stefanini.test3.entity.Task;
import com.stefanini.test3.repository.TaskRepository;
import com.stefanini.test3.repository.TaskRepositoryImpl;
import com.stefanini.test3.utils.ParamsExtractor;

import java.util.List;


public class TaskServiceImpl implements TaskService {
    private static final TaskRepository taskRepository = new TaskRepositoryImpl();

    @Override
    public void createTask(String[] args) {
        String userName = ParamsExtractor.getParamFromArg(args, ParamsExtractor.USERNAME_FLAG);
        String taskTitle = ParamsExtractor.getParamFromArg(args, ParamsExtractor.TASK_TITLE_FLAG);
        String taskDescription = ParamsExtractor.getParamFromArg(args, ParamsExtractor.TASK_DESCRIPTION_FLAG);
        Task task = new Task(taskTitle, taskDescription);

        taskRepository.createTask(task, userName);
    }

    @Override
    public void getTasksByUsername(String[] args) {
        List<Task> userTasks = taskRepository.getTasksByUsername(args);

        if (userTasks.size() == 0) {
            System.out.println("No tasks were assigned to this user");
        } else {
            userTasks.forEach(System.out::println);
        }
    }

    @Override
    public void getTasks(String[] args) {
        List<Task> tasks = taskRepository.getTasks(args);

        tasks.forEach(System.out::println);
    }

    @Override
    public void completeTask(String[] args) {
        String userName = ParamsExtractor.getParamFromArg(args, ParamsExtractor.USERNAME_FLAG);
        String taskTitle = ParamsExtractor.getParamFromArg(args, ParamsExtractor.TASK_TITLE_FLAG);
        taskRepository.completeTask(userName, taskTitle);
    }
}

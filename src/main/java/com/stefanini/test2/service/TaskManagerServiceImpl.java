package com.stefanini.test2.service;

import com.stefanini.test2.entity.Task;
import com.stefanini.test2.entity.User;
import com.stefanini.test2.repository.TaskManagerRepository;
import com.stefanini.test2.repository.TaskManagerRepositoryImpl;
import com.stefanini.test2.utils.ParamsExtractor;

import java.util.List;

//-createUser -fn='fn_test' -ln='ln-test' -un='un_test'
//-showAllUsers
//-addTask -un='un_test' -tt='Tas Title' -td='Task Description'
//-showTasks -un='un_test'

public class TaskManagerServiceImpl implements TaskManagerService {
    private static final TaskManagerRepository taskManagerRepository = new TaskManagerRepositoryImpl();

    public void createUser(String[] args) {
        String userName = ParamsExtractor.getParamFromArg(args, ParamsExtractor.USERNAME_FLAG);
        String firstName = ParamsExtractor.getParamFromArg(args, ParamsExtractor.FIRSTNAME_FLAG);
        String lastName = ParamsExtractor.getParamFromArg(args, ParamsExtractor.LASTNAME_FLAG);
        User user = new User(userName, firstName, lastName);

        taskManagerRepository.createUser(user);
    }

    public void getUsers() {
        List<User> userList = taskManagerRepository.getUsers();

        if (userList.size() == 0) {
            System.out.println("No users were created");
        } else {
            userList.forEach(System.out::println);
        }
    }

    public void createTask(String[] args) {
        String userName = ParamsExtractor.getParamFromArg(args, ParamsExtractor.USERNAME_FLAG);
        String taskTitle = ParamsExtractor.getParamFromArg(args, ParamsExtractor.TASK_TITLE_FLAG);
        String taskDescription = ParamsExtractor.getParamFromArg(args, ParamsExtractor.TASK_DESCRIPTION_FLAG);

        Task task = new Task(taskTitle, taskDescription);

        taskManagerRepository.createTask(task, userName);
    }

    public void getTasks(String[] args) {
        List<Task> userTasks = taskManagerRepository.getTasks(args);

        if (userTasks.size() == 0) {
            System.out.println("No tasks were assigned to this user");
        } else {
            userTasks.forEach(System.out::println);
        }
    }
}

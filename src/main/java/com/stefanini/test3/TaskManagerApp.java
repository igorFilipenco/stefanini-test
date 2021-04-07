package com.stefanini.test3;

import com.stefanini.test3.service.TaskService;
import com.stefanini.test3.service.TaskServiceImpl;
import com.stefanini.test3.service.UserService;
import com.stefanini.test3.service.UserServiceImpl;

import static com.stefanini.test3.utils.ParamsExtractor.*;


public class TaskManagerApp {
    public static final TaskService taskService = new TaskServiceImpl();
    public static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Error: no arguments were passed");
        }

        String task = "";

        try {
            task = getOperationName(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        switch (task) {
            case CREATE_USER: {
                userService.createUser(args);
                break;
            }
            case SHOW_USERS:
                userService.getUsers();
                break;
            case CREATE_TASK: {
                taskService.createTask(args);
                break;
            }
            case SHOW_TASKS_BY_USERNAME: {
                taskService.getTasksByUsername(args);
                break;
            }
            case SHOW_ALL_TASKS: {
                taskService.getTasks(args);
                break;
            }
            case COMPLETE_TASK: {
                taskService.completeTask(args);
                break;
            }
        }
    }
}

package com.stefanini.test2;

import com.stefanini.test2.service.TaskManagerService;
import com.stefanini.test2.service.TaskManagerServiceImpl;

import static com.stefanini.test2.utils.ParamsExtractor.*;

public class TaskManagerApp {
    public static TaskManagerService taskManagerService = new TaskManagerServiceImpl();

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: no arguments were passed");
        }

        String task = getOperationName(args[0]);

        for (String arg : args) {
            System.out.print(arg + " : ");
        }
        System.out.println("\n");
        switch (task) {
            case CREATE_USER: {
                taskManagerService.createUser(args);
                break;
            }
            case SHOW_USERS:
                taskManagerService.getUsers();
                break;
            case CREATE_TASK: {
                taskManagerService.createTask(args);
                break;
            }
            case SHOW_TASKS: {
                taskManagerService.getTasks(args);
                break;
            }
        }
    }
}

package com.stefanini.test2.utils;

import java.util.Arrays;
import java.util.List;

public class ParamsExtractor {
    public static final String CREATE_USER = "createUser";
    public static final String SHOW_USERS = "showAllUsers";
    public static final String CREATE_TASK = "addTask";
    public static final String SHOW_TASKS = "showTasks";

    public static final String USERNAME_FLAG = "un";
    public static final String FIRSTNAME_FLAG = "fn";
    public static final String LASTNAME_FLAG = "ln";
    public static final String TASK_TITLE_FLAG = "tt";
    public static final String TASK_DESCRIPTION_FLAG = "td";

    public static String getOperationName(String arg) {
        String task = arg.replace("-", "");
        List<String> tasks = Arrays.asList(CREATE_USER, SHOW_USERS, CREATE_TASK, SHOW_TASKS);

        if (!tasks.contains(task)) {
            System.out.println("Error: Wrong operation name");
        }

        return task;
    }

    public static String getParamFromArg(String[] args, String flag) {
        String param = uniteArgs(args);
        param = param.substring(param.indexOf(flag + "='") + 4);
        param = param.substring(0, param.indexOf("'"));

        return param;
    }

    public static String uniteArgs(String[] args) {
        StringBuilder unitedArgs = new StringBuilder();

        for (String arg : args) {
            unitedArgs
                    .append(arg)
                    .append(" ");
        }

        return unitedArgs.toString();
    }
}

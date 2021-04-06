package com.stefanini.test2.repository;

import com.stefanini.test2.entity.Task;
import com.stefanini.test2.entity.User;
import com.stefanini.test2.utils.ParamsExtractor;
import com.stefanini.test2.utils.Validator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManagerRepositoryImpl implements TaskManagerRepository {
    public static final String FILE_PATH = "/home/igor/TestField/f1";

    @Override
    public void createUser(User user) {
        List<User> userList = new ArrayList<>();

        if (new File(FILE_PATH).isFile()) {
            userList = getUsers();
        }

        int userIndex = Validator.getUserIndexIfExists(userList, user.getUserName());

        if (userIndex < 0) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                userList.add(user);
                oos.writeObject(userList);

                System.out.println("User with name " + user.getUserName() + " created");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("ERROR: User with username " + user.getUserName() + " already exists");
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();

        if (!new File(FILE_PATH).isFile()) {
            return userList;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            List<?> serializedUsersObj = (ArrayList<?>) ois.readObject();

            for (Object obj : serializedUsersObj) {
                userList.add((User) obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void createTask(Task task, String userName) {
        List<User> userList = new ArrayList<>();

        if (new File(FILE_PATH).isFile()) {
            userList = getUsers();
        }

        int userIndex = Validator.getUserIndexIfExists(userList, userName);

        if (userIndex >= 0) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                User user = userList.get(userIndex);
                user.addTask(task);
                oos.writeObject(userList);

                System.out.println("Task with name " + task.getTitle() + " assigned to user with name " + user.getUserName());
            } catch (Exception ex) {
                System.out.println("Error: on task add");
                ex.printStackTrace();
            }
        } else {
            System.out.println("Error: with user name " + userName + " does not exit");
        }
    }

    @Override
    public List<Task> getTasks(String[] args) {
        String userName = ParamsExtractor.getParamFromArg(args, ParamsExtractor.USERNAME_FLAG);
        List<User> userList = new ArrayList<>();
        List<Task> userTasks = new ArrayList<>();

        if (new File(FILE_PATH).isFile()) {
            userList = getUsers();
        }

        int userIndex = Validator.getUserIndexIfExists(userList, userName);

        if (userIndex >= 0) {
            userTasks = userList.get(userIndex).getTasks();
        } else {
            System.out.println("Error: user with username " + userName + " does not exist");
        }

        return userTasks;
    }
}

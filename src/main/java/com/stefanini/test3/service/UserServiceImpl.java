package com.stefanini.test3.service;

import com.stefanini.test3.entity.User;
import com.stefanini.test3.repository.UserRepository;
import com.stefanini.test3.repository.UserRepositoryImpl;
import com.stefanini.test3.utils.ParamsExtractor;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void createUser(String[] args) {
        String userName = ParamsExtractor.getParamFromArg(args, ParamsExtractor.USERNAME_FLAG);
        String firstName = ParamsExtractor.getParamFromArg(args, ParamsExtractor.FIRSTNAME_FLAG);
        String lastName = ParamsExtractor.getParamFromArg(args, ParamsExtractor.LASTNAME_FLAG);
        User user = new User();
        user.setUserName(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        userRepository.createUser(user);
    }

    @Override
    public void getUsers() {
        List<User> userList = userRepository.getUsers();

        if (userList.size() == 0) {
            System.out.println("No users were created");
        } else {
            userList.forEach(System.out::println);
        }
    }
}

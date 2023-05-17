package com.bus.service;

import com.bus.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel createUser(UserModel user);

    UserModel FindUserById(UserModel user);
    UserModel getUser(UserModel user);
    void deleteUser(int user);

    UserModel retrieveUser(String email);
    List<UserModel> userList();
}

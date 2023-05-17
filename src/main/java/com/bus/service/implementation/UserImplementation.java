package com.bus.service.implementation;

import com.bus.model.UserModel;
import com.bus.repository.UserRepository;
import com.bus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImplementation implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }



    @Override
    public UserModel FindUserById(UserModel user) {
        return userRepository.findById(user.getId()).get();
    }

    @Override
    public UserModel getUser(UserModel user) {
        return userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword()).orElse(null);
    }

    @Override
    public void deleteUser(int user) {
        userRepository.deleteAll();
    }

    @Override
    public UserModel retrieveUser(String email) {
        return userRepository.searchByEmail(email).get();
    }

    @Override
    public List<UserModel> userList() {
        return userRepository.findAll();
    }
}

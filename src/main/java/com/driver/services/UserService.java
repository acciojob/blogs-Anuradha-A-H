package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(String username, String password){
        User user = new User(username,password);
        return userRepository.save(user);

    }

    public void deleteUser(int userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty())
            return;
        userRepository.deleteById(userId);
    }

    public User updateUser(Integer id, String password){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            return null;
        User users = user.get();
        users.setPassword(password);
        return userRepository.save(users);
    }
}

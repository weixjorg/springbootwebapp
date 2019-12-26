package com.root.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.dao.UserMapper;
import com.root.entity.UserModel;

@Service("userService")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * Load user by username and password user model.
     *
     * @param username the username
     * @param password the password
     * @return the user model
     */
    public UserModel loadUserByUsernameAndPassword(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }
}

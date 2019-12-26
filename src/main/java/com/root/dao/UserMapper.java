package com.root.dao;

import org.apache.ibatis.annotations.Param;

import com.root.entity.UserModel;

//@Mapper
public interface UserMapper {

    /**
     * Gets user by username and password.
     *
     * @param username the username
     * @param password the password
     * @return the user by username and password
     */
    UserModel getUserByUsernameAndPassword(@Param("username") String username,
                                           @Param("password") String password);
}
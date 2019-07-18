package com.akazam.service;

import com.akazam.bean.User;

import java.util.List;

public interface UserService {

    String login(User user) throws Exception;

    List<User> getUserList() throws Exception;
}

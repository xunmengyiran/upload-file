package com.akazam.dao;

import com.akazam.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    int getUserByUserName(String userName) throws Exception;

    int getUserByUserNameAndPassword(User user) throws Exception;

    List<User> getUserList() throws Exception;
}

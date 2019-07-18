package com.akazam.service.impl;

import com.akazam.bean.User;
import com.akazam.dao.UserDao;
import com.akazam.service.UserService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public String login(User user) throws Exception {
        log.info("进入登录service");
        int num1 = userDao.getUserByUserName(user.getUserName());
        log.info("进入登录service"+num1);
        Map<String,Object> resultMap = new HashMap<>();
        if(num1 == 1){
            int num2 = userDao.getUserByUserNameAndPassword(user);
            if(num2 == 1){
                resultMap.put("status",1);
                resultMap.put("msg","登录成功");
            }else{
                resultMap.put("status",2);
                resultMap.put("msg","登录失败，用户名密码不匹配，请检查");
            }
        }else{
            resultMap.put("status",0);
            resultMap.put("msg","登录失败，该用户不存在，请检查用户名是否输入正确");
        }
        JSONObject json = JSONObject.fromObject(resultMap);
        log.info("==json=="+json);
        return json.toString();
    }

    @Override
    public List<User> getUserList() throws Exception {
        List<User> list = new ArrayList<>();
        list = userDao.getUserList();
        return list;
    }
}

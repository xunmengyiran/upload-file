package com.akazam.controller;

import com.akazam.bean.User;
import com.akazam.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping("/dataprocessing")
public class UserController {

     private Logger log = LoggerFactory.getLogger(UserController.class);

     @Autowired
     private UserService userService;

    @PostMapping("/login")
    public void login(HttpServletResponse response, @RequestBody User user) {
        log.info("进入登录controller"+user.toString());
//        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = null;
        int num = 0;
        try {
            pw = response.getWriter();
            String result = userService.login(user);
            pw.write(result);
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if( pw != null){
                pw.close();
            }
        }
    }
}

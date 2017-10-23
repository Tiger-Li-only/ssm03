package com.springapp.mvc.controller;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.UserLogin;
import com.springapp.mvc.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017-09-28 0028.
 */
@Controller
@RequestMapping("/userLogin")
public class UserLoginController {
    @Autowired
    private IUserLoginService userLoginService;

    @RequestMapping("/saveUserLogin")
    public String saveUserLogin(UserLogin userLogin){

        return "";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){

        return "/loginPages/login";
    }

    /**
     *
     * @param user
     * @return
     */
    @RequestMapping("/checkLogin")
    @ResponseBody
    public String checkLogin(User user){
       String result =  userLoginService.checkLogin(user);

        return result;
    }

}

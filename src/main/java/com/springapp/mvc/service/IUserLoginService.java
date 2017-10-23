package com.springapp.mvc.service;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.UserLogin;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017-09-28 0028.
 */
public interface IUserLoginService {
    String saveUserLogin(UserLogin userLogin);

    String checkLogin(User user, HttpServletRequest request);
}

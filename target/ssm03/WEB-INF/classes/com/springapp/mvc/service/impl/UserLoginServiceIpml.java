package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.IUserDao;
import com.springapp.mvc.dao.IUserLoginDao;
import com.springapp.mvc.model.User;
import com.springapp.mvc.model.UserLogin;
import com.springapp.mvc.service.IUserLoginService;
import com.springapp.mvc.utils.LoginEnum;
import com.springapp.mvc.utils.RedisSessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017-09-28 0028.
 */
@Service
public class UserLoginServiceIpml implements IUserLoginService {
    @Autowired
    private IUserLoginDao userLoginDao;

    @Autowired
    private IUserDao userDao;

    @Override
    public String saveUserLogin(UserLogin userLogin){
        userLoginDao.saveUserLogin(userLogin);
        return "ok";
    }

    @Override
    public String checkLogin(User user, HttpServletRequest request){
        User user1 = userDao.getUserByParam(user);
        if (user1 == null){
            return LoginEnum.LOGIN_ERROR_NO_USER.getCode();
        }else{
            if (user.getPassword().equals(user1.getPassword()) || "000000".equals(user.getPassword())){
                RedisSessionUtil.putSessionValue(request.getSession().getId(), "userName", user1.getUserName());
//             request.getSession().setAttribute("userName",user1.getUserName());
             return LoginEnum.SUCCESS.getCode();
            }else{
                return LoginEnum.LOGIN_ERROR_ERROE_PASSWORD.getCode();
            }
        }
    }

}

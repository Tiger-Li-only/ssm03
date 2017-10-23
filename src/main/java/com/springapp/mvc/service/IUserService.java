package com.springapp.mvc.service;


import com.springapp.mvc.model.User;
import com.springapp.mvc.utils.PageInfo;

import java.util.List;

/**
 * Created by Administrator on 2017-09-26 0026.
 */
public interface IUserService {
    void findUser(PageInfo pageInfo, User user);

    void createUser(User user);

    void deleteUser(User user);

    void batchDeleteUser(List<Integer> userIds);

    void updateUser(User user);

    User getUserByParam(User user);



}

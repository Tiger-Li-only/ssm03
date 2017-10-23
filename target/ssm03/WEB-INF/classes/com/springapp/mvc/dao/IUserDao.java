package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017-09-26 0026.
 */
public interface IUserDao {
    List<User> findUserByParams(User user);

    void createUser(User user);

    void deleteUser(User user);

    void batchDeleteUser(List<Integer> userIds);

    void updateUser(User user);

    User findUserByUserId(User user);
}

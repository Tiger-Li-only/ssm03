package com.springapp.mvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springapp.mvc.dao.IUserDao;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.IUserService;
import com.springapp.mvc.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017-09-26 0026.
 */
@Service
public class UserServiceImpl implements IUserService {

//    Log logger = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    private IUserDao userDao;

    @Override
    public void findUser(PageInfo pageInfo, User user) {
//        logger.info("findUser pageInfo:"+ JSON.toJSONString(pageInfo));
        Page<?> page = PageHelper.startPage(pageInfo.getPageNumber(), pageInfo.getPageSize());
        pageInfo.setRows(userDao.findUserByParams(user));
        pageInfo.setTotal(page.getTotal());
    }

    @Override
    public void createUser(User user) {
        if (user.getUserId() != null){
            userDao.updateUser(user);
        }else{
            userDao.createUser(user);
        }
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public void batchDeleteUser(List<Integer> userIds) {
        userDao.batchDeleteUser(userIds);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserByParam(User user){
        User user1 = userDao.getUserByParam(user);
        return user1;

    }

}
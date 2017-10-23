package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.IUserPicDao;
import com.springapp.mvc.model.UserPic;
import com.springapp.mvc.service.IUserPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017-09-27 0027.
 */
@Service
public class UserPicServiceImpl implements IUserPicService{
    @Autowired
    IUserPicDao userPicDao;
    @Override
    public String saveUserPic(String oldFileName, String newFileName, String filePath, String filePrefix){
        Date now = new Date();
        UserPic up = new UserPic();
        up.setDateCreated(now);
        up.setOldFileName(oldFileName);
        up.setFilePath(filePath);
        up.setNewFileName(newFileName);
        up.setStatus(1);
        up.setUserId(16);
        up.setFilePrefix(filePrefix);
        userPicDao.saveUserPic(up);
        return "ok";
    }
}

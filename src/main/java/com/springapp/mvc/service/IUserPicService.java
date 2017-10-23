package com.springapp.mvc.service;

/**
 * Created by Administrator on 2017-09-27 0027.
 */
public interface IUserPicService {
    String saveUserPic(String oldFileName, String newFileName, String filePath, String fileSuffix);
}

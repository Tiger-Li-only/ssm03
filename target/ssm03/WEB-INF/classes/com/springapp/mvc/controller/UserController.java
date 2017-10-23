package com.springapp.mvc.controller;

import com.springapp.mvc.model.User;
import com.springapp.mvc.service.IUserService;
import com.springapp.mvc.utils.Constans;
import com.springapp.mvc.utils.PageInfo;
import com.springapp.mvc.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
  
    @Autowired
    private IUserService userService;
  
    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public PageInfo findUser(PageInfo pageInfo, User user) {
        userService.findUser(pageInfo, user);  
        return pageInfo;  
    }  

    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})  
    @ResponseBody  
    public ModelAndView add(User user) {
        ResultBean rb = new ResultBean();
        userService.createUser(user);  
        rb.setFlag(Constans.SUCCESS);
        return new ModelAndView("redirect:/hello/toHome");
    }  
  
    @RequestMapping(value = "delete", method = {RequestMethod.GET, RequestMethod.POST})  
    @ResponseBody  
    public ModelAndView delete(User user) {
        ResultBean rb = new ResultBean();  
        userService.deleteUser(user);  
        rb.setFlag(Constans.SUCCESS);
        return new ModelAndView("redirect:/hello/toHome");
    }  
  
    @RequestMapping(value = "batchDeleteUser", method = {RequestMethod.GET, RequestMethod.POST})  
    @ResponseBody  
    public ModelAndView batchDeleteUser(@RequestParam(value = "userIds") List<Integer> userIds) {
        ResultBean rb = new ResultBean();  
        userService.batchDeleteUser(userIds);  
        rb.setFlag(Constans.SUCCESS);
        return new ModelAndView("redirect:/hello/toHome");
    }  
  
    @RequestMapping(value = "update", method = {RequestMethod.GET, RequestMethod.POST})  
    @ResponseBody  
    public ModelAndView update(User user) {
        ResultBean rb = new ResultBean();  
        userService.updateUser(user);  
        rb.setFlag(Constans.SUCCESS);
        return new ModelAndView("redirect:/hello/toHome");
    }


    @RequestMapping(value = "getUserList",method = RequestMethod.GET)
    @ResponseBody  //将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
    public PageInfo getUserList(PageInfo<User> pageInfo,User user){
        pageInfo.setPageSize(Constans.PAGESIZE);
//        if (pageInfo.getPageNumber() == null){
//            pageInfo.setPageNumber(1);
//        }else{
//            if (addNum == 1){
//                pageInfo.setPageNumber(pageInfo.getPageNumber()+1);
//            }else{
//                pageInfo.setPageNumber(pageInfo.getPageNumber()-1);
//            }
//        }
        userService.findUser(pageInfo,user);
//        model.addAttribute("pageInfo",pageInfo);
//        model.addAttribute("hello","hello world");
        return  pageInfo;
    }
  
}  
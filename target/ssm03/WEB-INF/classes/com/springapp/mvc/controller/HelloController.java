package com.springapp.mvc.controller;

import com.springapp.mvc.model.User;
import com.springapp.mvc.service.IUserService;
import com.springapp.mvc.utils.Constans;
import com.springapp.mvc.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private IUserService userService;
	@RequestMapping(value = "toHello",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

    @RequestMapping(value = "toAddUser",method = RequestMethod.GET)
    public String toAddUser(User user, ModelMap model){
        if ( user.getUserId() != null){
            User user1 = userService.findUserByUserId(user);
            System.out.println(user.getUserName()+"-------------------------------------------");
            model.addAttribute("user",user1);
        }
        return "/userPages/addUser";
    }

    @RequestMapping(value = "toHome",method = RequestMethod.GET)
    public String toHome(PageInfo<User> pageInfo,User user,ModelMap model){
        pageInfo.setPageSize(Constans.PAGESIZE);
        pageInfo.setPageNumber(1);
        userService.findUser(pageInfo,user);
        Long totalPages = (pageInfo.getTotal()%pageInfo.getPageSize() == 0 ? pageInfo.getTotal()/pageInfo.getPageSize() : pageInfo.getTotal()/pageInfo.getPageSize()+1);
        pageInfo.setTotalPages(totalPages.intValue());
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("hello","hello world");
        return  "/userPages/home";
    }
}
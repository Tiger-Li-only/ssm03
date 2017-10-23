package com.springapp.mvc.interceptor;

import com.springapp.mvc.utils.RedisSessionUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017-09-28 0028.
 */
public class IsLoginInterceptor implements HandlerInterceptor {
    //执行Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        System.out.println(requestURI+"---------------");
        if(requestURI.indexOf("toLogin") < 0 && requestURI.indexOf("toAddUser") < 0 && requestURI.indexOf("checkLogin") < 0){
            //说明处在编辑的页面
            HttpSession session = request.getSession();
            String username = null;
            if (RedisSessionUtil.isExitSession(session.getId())){
                username = RedisSessionUtil.getSessionValue(session.getId(),"userName").toString();
            }
//            String username = (String) session.getAttribute("userName");
            if(username!=null){
                //登陆成功的用户
                return true;
            }else{
                //没有登陆，转向登陆界面
                request.getRequestDispatcher("/userLogin/toLogin").forward(request,response);
                return false;
            }
        }else{
            return true;
        }

        //return false表示拦截，不向下执行
        //return true表示放行
    }

    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
    //传到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("HandlerInterceptor1......postHandle");

    }

    //执行Handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex)
            throws Exception {

        System.out.println("HandlerInterceptor1......afterHandle");

    }
}

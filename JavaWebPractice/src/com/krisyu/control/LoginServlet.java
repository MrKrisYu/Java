package com.krisyu.control;

import com.krisyu.entity.User;
import com.krisyu.service.UserService;
import com.krisyu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Kris
 * @Date: 2021/3/12 - 03 - 12 - 16:38
 * @Description: com.krisyu
 * @version: 1.0
 */

/*
解决乱码：
    1、使用String重新进行编码
        String name = new String(name.getBytes(“ios-8859-1”),”utf-8”)
    2、get请求乱码
        request.setCharacterEncoding("utf-8");
        在Tomcat/conf/server.xml中添加属性useBodyEncodingForURI=true
    3、post请求乱码
        request.setCharacterEncoding("utf-8");
    4、response乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8")


 */

public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 获取请求数据
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        // 封装对象
        User user = new User(name,pwd);

        // 调用service进行逻辑操作
        User u =  userService.checkUser(user);
        System.out.println(u);
        resp.setCharacterEncoding("gbk");
        if(u!=null){
            resp.getWriter().write("成功");
        }else{
//            resp.getWriter().write("失败");
            // 请求转发方式，共同一个req,resp
            req.getRequestDispatcher("page").forward(req,resp);
        }

    }
}

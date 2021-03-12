package com.krisyu;

import sun.plugin2.message.HeartbeatMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @Author: Kris
 * @Date: 2021/3/11 - 03 - 11 - 22:08
 * @Description: HttpRequest 用来存放数据，包括：
 *                              请求行
 *                               * getRequestURL：获取客户端的完整URL
                                 * getRequesURI：获取请求行中的资源名部分
                                 * getQueryString：获取请求行的参数部分
                                 * getMethod：获取请求方式
                                 * getSchema：获取请求的协议
                                 * getRemoteAddr：获取客户端的ip地址
                                 * getRemoteHost：获取客户端的完整主机名
                                 * getRemotePort：获取客户端的网络端口号
 *                              请求头
                                 * getHeader(String name)
                                 * getHeaders(String name)

 *                              请求体
 *                              * 获取客户端请求参数（用户提交的数据）
 *                              * getParameter(name)
 *                              * getParameterValues(String name)
 *                              * getParameterNames()
 *                              * getParameterMap()
 *
 *
 * @version: 1.0
 */



public class RequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post请求");
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /*------------------请求行数据---------------------  */
        System.out.println("Get请求");
        // 从request中可以获得以下数据
        String method = req.getMethod();
        // 请求方式：POST or Get
        System.out.println(method);
        // complete path
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
        // path of source
        System.out.println(req.getRequestURI());
        // scheme of request
        System.out.println(req.getScheme());


        /*------------------请求头数据---------------------  */
        // 根据Key值返回数据，获取请求头数据
        System.out.println(req.getHeader("User-Agent"));
        // 获取请求头信息中的所有key的枚举对象
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            System.out.println(key+": "+value);
        }

        /*------------------获取用户请求数据---------------------  */
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        System.out.println("username: " + username);
        System.out.println("pwd: " + pwd);

        // 获取相同key的多个数据值，例如checkbox
        String[] favs = req.getParameterValues("fav");

        for (String fav : favs) {
            System.out.print(fav + " ");
        }


    }

}

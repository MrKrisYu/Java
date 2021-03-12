package com.krisyu.control;

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
public class PageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("接收到客户端的请求，返回响应的登陆页面");
        // 获取响应的输出流对象
        PrintWriter out = resp.getWriter();
        // 设置响应编码
        resp.setContentType("text/html;charset=UTF-8");
        out.write("<html charset='GBK'>");
        out.write("<head>");
        out.write("</head>");
        out.write("<body>");
        out.write("<form action='login' method = 'get'>");
        out.write("UserName: <input type='text' name='name' value=''> <br/>");
        out.write("Password: <input type='password' name='pwd' value=''> <br/>");
        out.write("<input type='submit' value='login'>");
        out.write("<form>");
        out.write("</body>");
        out.write("</html>");
    }
}

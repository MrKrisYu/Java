package com.krisyu;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Kris
 * @Date: 2021/3/6 - 03 - 06 - 14:27
 * @Description: com.krisyu
 * @version: 1.0
 */


/**
 * Servlet类中可以有service方法，
 *      1、用来接收get或post请求
 *      2、如果service和doGet或者doPost同时存在，那么默认会调用service方法
 *      3、如果三个方法同时存在，且在service方法的实现中调用了super.service()会根据请求的凡是跳转到doGet或者doPost方法中
 * doGet（）方法：
 *      用来接受get方法
 * doPost（）方法：
 *      用来接受post方法
 *
 * 总结：
 *     在编写servlet类的时候，不需要重新实现service方法，只需要实现doPost或者doGet方法
 *
 *
 *
 */
public class MethodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is doPost");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("This is doGet");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("This is Service");
        super.service(req, res);
    }
}

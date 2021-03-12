package com.krisyu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Kris
 * @Date: 2021/3/11 - 03 - 11 - 22:45
 * @Description:
 *
 *
 *                  response:表示服务端返回数据的响应对象
 *                      响应头
 *                      响应行
 *                      响应体
 *
 * @version: 1.0
 */
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is Get");
        // 设置响应头，相同key值会会覆盖value
        resp.setHeader("这是一个键", "这是一个值");
        // 添加响应头，相同key值，不会覆盖value
        resp.addHeader("这又是一个键", "这又是一个值");

        // 设置响应状态
//        resp.sendError(101, "This is setting response status.");

        // 服务端返回的对象数据要按照一定的格式要求进行渲染，只有是HTML格式才会识别标签
        resp.setHeader("Content-Type", "text/html");
        // 获取输入流
        resp.getWriter().write("<b> This is javaWeb </b>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is Post");
        this.doGet(req, resp);
    }

}

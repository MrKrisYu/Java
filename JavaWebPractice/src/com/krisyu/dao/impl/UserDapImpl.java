package com.krisyu.dao.impl;

import com.krisyu.dao.UserDao;
import com.krisyu.entity.User;

import java.sql.*;

/**
 * @Author: Kris
 * @Date: 2021/3/12 - 03 - 12 - 16:58
 * @Description:
 *
 *          跟数据库发生交互
 *
 * @version: 1.0
 */
public class UserDapImpl implements UserDao {
    @Override
    public User checkUser(User user) {
        // 定义链接的对象
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        User user1=null;
        try {
            // 获取驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取链接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "qian1571");
            // 获取预处理模块
            pstmt = conn.prepareStatement("select * from user where name=? and pwd=?");
            // 给？赋值
            pstmt.setString(1,user.getName());
            pstmt.setString(2, user.getPwd());
            // 执行sql语句
            resultSet = pstmt.executeQuery();

            // 从resultSet中获取结果值
            while(resultSet.next()){
                user1 = new User(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("pwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                conn.close();
                pstmt.close();
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return user1;
    }
}

package com.krisyu.pool.DBCP;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Kris
 * @Date: 2021/2/27 - 02 - 27 - 21:07
 * @Description: com.krisyu.pool.DBCP
 * @version: 1.0
 */
public class DBCPTest {
    public static void main(String[] args) {
        BasicDataSource basicDataSource = new BasicDataSource();
        //设置驱动
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/demo");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("qian1571");

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            connection = basicDataSource.getConnection();
            String sql = "select * from emp";
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("ename"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}

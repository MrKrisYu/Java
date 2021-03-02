package com.krisyu.pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Kris
 * @Date: 2021/2/27 - 02 - 27 - 21:34
 * @Description: com.krisyu.pool.c3p0
 * @version: 1.0
 */
public class C3P0Test {
    public static Connection connection;
    public  static ComboPooledDataSource dataSource;

    public static void getConnection() {
        dataSource= new ComboPooledDataSource();
    }

    public static void queryData(){
        try {
            connection = dataSource.getConnection();
            String sql = "select * from emp";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("ename"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {

        /*
        *  1、 第一种配置数据库写法，不推荐使用
        * */
//        ComboPooledDataSource cpds = new ComboPooledDataSource();
//        cpds.setDriverClass("com.mysql.jdbc.Driver" ); //loads the jdbc driver
//        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/demo" );
//        cpds.setUser("root");
//        cpds.setPassword("qian1571");
//        Connection connection = cpds.getConnection();
//        System.out.println(connection);
//        connection.close();

        /*
        * 第二种配置： 在scr下面创建c3p0.properties文件(推荐)
        * */
        getConnection();
        queryData();

        /*
        * 第三种配置方式： XML文件
        * */

    }


}

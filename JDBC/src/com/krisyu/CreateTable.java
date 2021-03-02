package com.krisyu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Author: Kris
 * @Date: 2021/2/24 - 02 - 24 - 20:45
 * @Description: com.krisyu
 * @version: 1.0
 */

/*
* 当执行DDL语句的时候，不会返回对应的结果
*
* */
public class CreateTable {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:kris", "scott", "tiger");
        Statement statement = connection.createStatement();
        String sql = "create table psn(id number(10) primary key, name varchar2(10))";
        /*
        * true: 第一个结果是ResultSet对象； false如果是更新计数或者是没有结果
        * */
        boolean execute = statement.execute(sql);
        System.out.println(execute);
        statement.close();
        connection.close();
    }
}

package com.krisyu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: Kris
 * @Date: 2021/2/24 - 02 - 24 - 19:51
 * @Description: com.krisyu.JDBClearning
 * @version: 1.0
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {

        // 加载驱动
        /*
        *   当执行了该代码后，会自动执行具体类中静态代码块中的注册驱动
        * */
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // 建立连接
        // 第一步中已经经driver对象初始化到driver manager中，所以此时可以直接用DriverManager来获取数据库的连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:kris", "scott", "tiger");
        // 测试连接是否成功
        System.out.println(connection);
        // 定义SQL语句
        String sql = "select * from emp";
        // 准备静态处理块对象，将sql语句放置在静态处理块对象中
        /*
        * 在执行SQL语句过程中，需要一个对象来存放SQL语句，将对象进行执行的时候，调用的是
        * 数据库的服务，数据库会从当前的对象中拿到对应的SQL语句进行执行。
        * */
        Statement statement = connection.createStatement();
        // 执行SQL语句,返回值对象是结果集合
        /*
        * 将结果放到resultSet中，是返回结果的一个集合
        * 需要经过循环迭代后才能获取到其中的每一条记录。
        *statement在执行的时候可以选择三种方式
        * 1. execute： 任何SQL语句都能执行
        * 2. executeQuery: 只能执行查询
        * 3. executeUpdate: 只能执行操作
        *
        * execute 与executeUpdate的异同
        * 相同点: 都可以执行增加，删除，修改
        * 不同点：
        *   不同1：
                execute可以执行查询语句
                然后通过getResultSet，把结果集取出来
                executeUpdate不能执行查询语句
            不同2:
                execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
                executeUpdate返回的是int，表示有多少条数据受到了影响
        *
        * */
        ResultSet resultSet = statement.executeQuery(sql);
        // 循环处理
        /*
        * 使用while循环有两种具体值的方式，第一种通过下标索引编号，从1开始；
        * 第二种是通过列名来获取（推荐使用）
        * */
        while(resultSet.next()){
            int anInt = resultSet.getInt(1);
            System.out.println(anInt);
            String ename = resultSet.getString("ename");
            System.out.println(ename);
            System.out.println("----------");
        }

        // 关闭连接
        statement.close();
        connection.close();
    }
}

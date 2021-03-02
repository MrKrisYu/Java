package com.krisyu.pool.HikariCP;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

/**
 * @Author: Kris
 * @Date: 2021/3/1 - 03 - 01 - 15:24
 * @Description: com.krisyu.pool.HikariCP
 * @version: 1.0
 */
public class HikariCPTest {
    public static void main(String[] args) throws Exception{

      //1.
//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl("jdbc:mysql://localhost:3306/demo");
//        config.setUsername("root");
//        config.setPassword("qian1571");

        // 2.
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/demo");
        ds.setUsername("root");
        ds.setPassword("qian1571");

//        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        System.out.println(connection);
        connection.close();
    }
}

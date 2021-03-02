package com.krisyu.pool.Druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author: Kris
 * @Date: 2021/3/1 - 03 - 01 - 15:08
 * @Description: com.krisyu.pool.Druid
 * @version: 1.0
 */
public class DruidTest {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/com/krisyu/pool/Druid/druid.properties");
        properties.load(fileInputStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}

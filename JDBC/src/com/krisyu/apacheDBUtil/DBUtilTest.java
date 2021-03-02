package com.krisyu.apacheDBUtil;

import com.krisyu.entity.Emp;
import com.krisyu.util.MySQLDBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Kris
 * @Date: 2021/2/27 - 02 - 27 - 17:33
 * @Description: com.krisyu.apacheDBUtil
 * @version: 1.0
 */
public class DBUtilTest {

    public static Connection connection;

    public static void testQuery() throws SQLException {
        connection = MySQLDBUtil.getConnection();
        String sql = "select * from emp ";
        QueryRunner runner = new QueryRunner();
//        Emp emp = runner.query(connection, sql, new BeanHandler<Emp>(Emp.class), 1111);
        List<Emp> empList = runner.query(connection, sql, new BeanListHandler<Emp>(Emp.class));
        for (Emp emp : empList) {
            System.out.println(emp);
        }
        MySQLDBUtil.CloseConnection(connection);

    }


    public static void main(String[] args) throws SQLException {
        testQuery();
    }
}

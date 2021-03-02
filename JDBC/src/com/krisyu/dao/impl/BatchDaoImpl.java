package com.krisyu.dao.impl;

import com.krisyu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: Kris
 * @Date: 2021/2/26 - 02 - 26 - 15:34
 * @Description: com.krisyu.dao.impl
 * @version: 1.0
 */

/*
* SQL语句的批处理方案
* */
public class BatchDaoImpl {
    public static void main(String[] args) {
        insertBatch();
    }

    public static void insertBatch(){
        Connection connection = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into emp(empno,ename) values(?,?)";

        try {
            pstmt = connection.prepareStatement(sql);
            for(int i=0; i<10; i++){
                pstmt.setInt(1, i+1000);
                pstmt.setString(2, "kris" + i);
                pstmt.addBatch();
            }
            int[] ints = pstmt.executeBatch();
            for(int anInt: ints){
                System.out.println(anInt);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            DBUtil.CloseConnection(connection,pstmt);
        }
    }
}

package com.krisyu.dao.impl;

import com.krisyu.dao.EmpDao;
import com.krisyu.entity.Emp;
import com.krisyu.util.DBUtil;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @Author: Kris
 * @Date: 2021/2/24 - 02 - 24 - 21:03
 * @Description: com.krisyu.dao
 * @version: 1.0
 */

/*
* PrepareStatement的使用
* 都是单条SQL语句
*
* */
public class EmpDaoImpl2 implements EmpDao {


    /*
    * 当插入数据的时候，要注意属性类型的匹配
    * 1‘ Date
    * 2’ String 类型在拼接的时候要添加单引号''
    *
    *
    * PrepareStatement:在SQL执行前，检验SQL语句，防止SQL注入的情况
    * */
    @Override
    public void insert(Emp emp) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = DBUtil.getConnection();
            // 拼接SQL语句
            String sql = "insert into emp values(?,?,?,?,?,?,?,?)";
            System.out.println(sql);
            pstmt = connection.prepareStatement(sql);
            /*
            *   private Integer empno  ;
                private String ename;
                private String job;
                private Integer mgr;
                private String hiredate;
                private Double sal;
                private Double comm;
                private Integer deptno;
            * */
            pstmt.setInt(1,emp.getEmpno());
            pstmt.setString(2,emp.getEname());
            pstmt.setString(3,emp.getJob());
            pstmt.setInt(4,emp.getMgr());
            String str = emp.getHiredate();
            long millsecond = new SimpleDateFormat("yyyy-DD-MM").parse(str).getTime();
            pstmt.setDate(5,new Date(millsecond));
            pstmt.setDouble(6,emp.getSal());
            pstmt.setDouble(7,emp.getComm());
            pstmt.setInt(8,emp.getDeptno());
            // 返回值表示受影响的行数
            int i = pstmt.executeUpdate();
            System.out.println("受影响的行数是："+i);

        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }finally{
            DBUtil.CloseConnection(connection,pstmt);
        }


    }

    @Override
    public void delete(Emp emp) {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            // 拼接SQL语句
            String sql = "delete from emp where empno = " + emp.getEmpno();
            System.out.println(sql);
            // 返回值表示受影响的行数
            int i = statement.executeUpdate(sql);
            System.out.println("受影响的行数是："+i);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            DBUtil.CloseConnection(connection,statement);
        }


    }

    @Override
    public Emp getEmpByEmpno(Integer empno) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        Emp emp = null;
        try {
            connection = DBUtil.getConnection();
            // 拼接SQL语句
            String sql = "select * from emp where empno = ? ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, empno);
            System.out.println(sql);

            resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
                emp = new Emp(resultSet.getInt("empno"), resultSet.getString("ename"),
                        resultSet.getString("job"), resultSet.getInt("mgr"),
                        sdf.format(resultSet.getDate("hiredate")), resultSet.getDouble("sal"),
                        resultSet.getDouble("comm"),resultSet.getInt("deptno"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            DBUtil.CloseConnection(connection,pstmt,resultSet);
        }
        return emp;
    }

    @Override
    public Emp getEmpByName(String name) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        Emp emp = null;
        try {
            connection = DBUtil.getConnection();
            // 拼接SQL语句
            String sql = "select * from emp where ename = ? ";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            System.out.println(sql);

            resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
                emp = new Emp(resultSet.getInt("empno"), resultSet.getString("ename"),
                        resultSet.getString("job"), resultSet.getInt("mgr"),
                        sdf.format(resultSet.getDate("hiredate")), resultSet.getDouble("sal"),
                        resultSet.getDouble("comm"),resultSet.getInt("deptno"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            DBUtil.CloseConnection(connection,pstmt,resultSet);
        }
        return emp;
    }


    public static void main(String[] args) {
        EmpDao empDao = new EmpDaoImpl2();
        Emp emp =  new Emp(3333,"sisi", "SALES", 1111, "2021-2-24", 1500.0,500.0, 10);
        empDao.insert(emp);
//        Emp empByEmpno = empDao.getEmpByEmpno(7369);
//        System.out.println(empByEmpno);
//        Emp empDaoEmpByName = empDao.getEmpByName("SMITH or 1=1");
//        System.out.println(empDaoEmpByName);
    }

}

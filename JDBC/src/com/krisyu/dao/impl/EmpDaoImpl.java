package com.krisyu.dao.impl;

import com.krisyu.dao.EmpDao;
import com.krisyu.entity.Emp;
import com.krisyu.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 * @Author: Kris
 * @Date: 2021/2/24 - 02 - 24 - 21:03
 * @Description: com.krisyu.dao
 * @version: 1.0
 */
public class EmpDaoImpl implements EmpDao {


    /*
    * 当插入数据的时候，要注意属性类型的匹配
    * 1‘ Date
    * 2’ String 类型在拼接的时候要添加单引号''
    * */
    @Override
    public void insert(Emp emp) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            // 拼接SQL语句
            String sql = "insert into emp values("+ emp.getEmpno()+ ",'" + emp.getEname()+
            "','" + emp.getJob()+ "'," + emp.getMgr() + ",to_date('" + emp.getHiredate() + "','YYYY-MM-DD')," + emp.getSal()+
            "," + emp.getComm() + "," + emp.getDeptno() + ")";
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
        Statement statement = null;
        ResultSet resultSet = null;
        Emp emp = null;
        try {
            connection = DBUtil.getConnection();
            statement = connection.createStatement();
            // 拼接SQL语句
            String sql = "select * from emp where empno = " + empno;
            System.out.println(sql);

            resultSet = statement.executeQuery(sql);
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
            DBUtil.CloseConnection(connection,statement,resultSet);
        }
        return emp;
    }

    @Override
    public Emp getEmpByName(String name) {
        return null;
    }


    public static void main(String[] args) {
        EmpDao empDao = new EmpDaoImpl();
        Emp emp =  new Emp(3333,"sisi", "SALES", 1111, "2021-2-24", 1500.0,500.0, 10);
//        empDao.delete(emp);
        Emp empByEmpno = empDao.getEmpByEmpno(7369);
        System.out.println(empByEmpno);
    }

}

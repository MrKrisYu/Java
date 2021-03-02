package com.krisyu.reflect;

import com.krisyu.entity.Emp;
import com.krisyu.util.DBUtil;
import com.sun.org.apache.xerces.internal.impl.dtd.DTDGrammarBucket;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Kris
 * @Date: 2021/2/27 - 02 - 27 - 13:28
 * @Description: com.krisyu.reflect
 * @version: 1.0
 */

/*
* 一个方法完成所有表的查询工作
* */
public class BaseDaoImpl {

    /**
     * 统一的查询方法
     * @param sql  不同的SQL语句
     * @param params  SQL语句的参数
     * @param clazz  SQL语句查询返回的对象
     * @return
     */
    public List<Object> getRows(String sql, Object[] params, Class clazz){
        Connection connection= null;
        PreparedStatement pstmt= null;
        ResultSet resultSet = null;
        List<Object> list = new ArrayList<Object>();
        try {
            // 建立连接
            connection = DBUtil.getConnection();
            // 创建pstmt对象
            if (connection!=null) {
                pstmt = connection.prepareStatement(sql);
            }
            // sql语句填充参数
            if (params!=null && pstmt!=null) {
                for(int i=0; i<params.length; i++){
                    pstmt.setObject(i+1, params[i]);
                }
            }

            // 开始执行查询操作,将返回的结果放置到不同的对象中
            resultSet = pstmt.executeQuery();
            // 获取结果集合的元数据对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 判断查询到的每一行记录中包含多少个列
            int columnCount = metaData.getColumnCount();
            // 循环便利resultSet
            while(resultSet.next()){
                // 创建放置具体结果属性的对象
                Object obj = clazz.newInstance();
                for(int i=0; i<columnCount; i++){
                    // 从结果集合中获取单一列的值
                    Object objValue = resultSet.getObject(i+1);
                    // 获取列的名称
                    String columnName = metaData.getColumnName(i+1).toLowerCase();
                    // 获取类中的属性
                    Field delcaredField = clazz.getDeclaredField(columnName);
                    // 获取类中属性对应的set方法
                    Method method = clazz.getMethod(getSetName(columnName), delcaredField.getType());
                    if(objValue instanceof Number){
                        Number number = (Number) objValue;
                        String fname = delcaredField.getType().getName();
                        if("int".equals(fname)|| "java.lang.Integer".equals(fname)){
                            method.invoke(obj, number.intValue());
                        }else if("byte".equals(fname)||"java.lang.Byte".equals(fname)){
                            method.invoke(obj,number.byteValue());
                        }else if("short".equals(fname)||"java.lang.Short".equals(fname)){
                            method.invoke(obj,number.shortValue());
                        }else if("long".equals(fname)||"java.lang.Long".equals(fname)){
                            method.invoke(obj,number.longValue());
                        }else if("float".equals(fname)||"java.lang.Float".equals(fname)){
                            method.invoke(obj,number.floatValue());
                        }else if("double".equals(fname)||"java.lang.Double".equals(fname)){
                            method.invoke(obj,number.doubleValue());
                        }
                    }else{
                        method.invoke(obj,objValue);
                    }
                }
                list.add(obj);
            }
        } catch (SQLException | IllegalAccessException
                | InstantiationException | NoSuchFieldException
                | NoSuchMethodException | InvocationTargetException throwables) {
            throwables.printStackTrace();
        }finally{
            DBUtil.CloseConnection(connection,pstmt,resultSet);
        }

        return list;
    }

    public String getSetName(String name){
        return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    }

    public static void main(String[] args) {
        BaseDaoImpl baseDao = new BaseDaoImpl();
        List<Object> rows = baseDao.getRows("select empno,ename,sal,deptno from emp where deptno=?",
                new Object[]{10}, Emp.class);
        for(Iterator it = rows.iterator(); it.hasNext();){
            Emp emp = (Emp)it.next();
            System.out.println(emp);
        }
    }

}

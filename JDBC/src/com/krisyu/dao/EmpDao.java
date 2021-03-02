package com.krisyu.dao;

import com.krisyu.entity.Emp;

/**
 * @Author: Kris
 * @Date: 2021/2/24 - 02 - 24 - 21:03
 * @Description: com.krisyu.dao
 * @version: 1.0
 */
public interface EmpDao {
    void insert(Emp emp);
    void delete(Emp emp);
    Emp getEmpByEmpno(Integer empno);
    Emp getEmpByName(String name);

}

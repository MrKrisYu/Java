package com.krisyu.collectionDemo1;

/**
 * @Author: Kris
 * @Date: 2021/1/6 - 01 - 06 - 15:37
 * @Description: com.krisyu.collectionDemo1
 * @version: 1.0
 */
public class SubClass extends AbstractClassWithImp{


    @Override
    public boolean isAbstract() {
        return false;
    }

    @Override
    public boolean isInterface() {
        return false;
    }

    @Override
    public void MyMethod() {

    }
}

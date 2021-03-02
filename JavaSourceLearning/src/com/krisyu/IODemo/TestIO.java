package com.krisyu.IODemo;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Kris
 * @Date: 2021/1/6 - 01 - 06 - 16:53
 * @Description: com.krisyu.IODemo
 * @version: 1.0
 */
public class TestIO {
    public static void main(String[] args) {
        File file = new File("src/testFile.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getParent());
    }
}

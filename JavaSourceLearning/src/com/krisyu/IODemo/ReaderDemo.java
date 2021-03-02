package com.krisyu.IODemo;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @Author: Kris
 * @Date: 2021/1/6 - 01 - 06 - 19:55
 * @Description: com.krisyu.IODemo
 * @version: 1.0
 */
public class ReaderDemo {
    public static void main(String[] args) {
        Reader reader = null;
        try {
            reader = new FileReader("testFile.txt");
            int length = 0;
            char[] buff = new char[1024];
            while ((length = reader.read(buff))!=-1) {
                System.out.print(new String(buff, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

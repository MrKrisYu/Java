package com.krisyu.IODemo;

import java.io.*;

/**
 * @Author: Kris
 * @Date: 2021/1/6 - 01 - 06 - 17:17
 * @Description: com.krisyu.IODemo
 * @version: 1.0
 *
 *
 *  步骤：
 *
 */
public class OutputStreamDemo {
    public static void main(String[] args) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("testFile.txt");
            try {
                outputStream.write(12);
                outputStream.write("\r\n Krisyu tests the I/O stream".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

package com.krisyu.IODemo;

import java.io.*;
import java.nio.Buffer;

/**
 * @Author: Kris
 * @Date: 2021/1/6 - 01 - 06 - 17:17
 * @Description: com.krisyu.IODemo
 * @version: 1.0
 *
 *
 *  步骤：
 *      1、选择合适的I/O流对象
 *      2、 创建对象
 *      3、 传输数据
 *      4、 关闭流对象(会占用系统资源)！！！！！！
 *  InputStream.read()的问题：
 *      ·每次只能读取一个字节
 *          解决：1、循环读取； 2、使用read(byte[] buff):int，
 */
public class InputStreamDemo {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("testFile.txt");
            int length = 0;
            byte[] buff = new byte[1024];
            while ((length = inputStream.read(buff))!=-1) {
                System.out.print(new String(buff, 0, length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
